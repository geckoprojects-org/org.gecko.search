# Gecko Search

This is a simple search implementation that uses Apache Lucene [https://lucene.apache.org/](https://lucene.apache.org/).

The Github project is located here:
[https://github.com/geckoprojects-org/org.gecko.search](https://github.com/geckoprojects-org/org.gecko.search)

Artifacts are for default implemenation:

* org.gecko.search
* org.gecko.search.document
* org.gecko.search.suggest - *optional* for suggest support

for EMF additionally:

* org.gecko.emf.search
* org.gecko.emf.search.suggest -  - *optional* for EMF suggest support

Finally the Lucene dependencies are needed as well

## Lucene and OSGi

Because the Lucene jars are not OSGi compatible, we added this support.

You can find the releases at Maven Central:

```
<dependency>
    <groupId>org.geckoprojects.saerch</groupId>
    <artifactId>org.apache.lucene.core</artifactId>
    <version>9.5.0</version>
</dependency>
```

We also provide:

* org.apache.lucene.codecs
* org.apache.lucene.core
* org.apache.lucene.facet
* org.apache.lucene.grouping
* org.apache.lucene.memory
* org.apache.lucene.queries
* org.apache.lucene.queryparser
* org.apache.lucene.suggest

## Gecko Search Framework

The framework is capable to handle multiple types of business objects that should be indexed. 

For EMF there is an own implementation in the own chapter.

To see how it runs, just take a look at the *org.gecko.search.document.test*. You need to configure the framework like this:

```
{
  ":configurator:resource-version": 1,
	"DefaultLuceneIndex~demo": 
	{
		"id": "Test",
		"directory.type": "MMAP",
		"base.path": "/tmp/testIndex"
	}
}
```

This creates a search component with a Lucene Index MMAP directory at location */tmp/testIndex*.

With that two services will get available:

1. LuceneIndexService - Service to index business objects
2. IndexSearcher - Service to search in the defined index

### LuceneIndexService

To index something you need to create Lucene Documents out of your own business objects. Please refer to the Lucene Documentation for that.

Our framework leaves this mapping in your hand. We try to submit a context object, that contains a list of Lucene Documents and an indexing type (add, update, remove index data) or an additional commit callback, that is called then the context was committed to the index.

There is the `org.gecko.search.document.context.AbstractContextObjectBuilder` that can be extended to create  a custom context builder. Currently there is the `org.gecko.search.document.context.ObjectContextBuilder` that can be used to create corresponding context objects for indexing.

The `LuceneIndexService#handleContexts` takes the documents mapped from your business objects and indexes everything. It automatically commits the changes.

**NOTE! Indexed documents are only available for searching, if they have been committed in the index. Further you need to re-open an IndexSearcher based on the committed index.**

### IndexSearcher

The index searcher is a prototype scoped service. It is backed by the Lucene *SearcherManager*, that handles NearRealTime (NRT) search. Our implementation tracks commits and refreshed the searcher manager. 

So it is best to retrieve the IndexSearcher, when you really need it, so that it contains the latests indexed data. 

If you have no such scenario, with a given or nearly static index, you can keep the IndexSearcher instance.

It does not automatically refresh, when the index updates in the background. To get this latest state, you should retrieve a new IndexSearcher. This behavior should be known to users who already dealt with Lucene.

The IndexSearcher is a service instance from the vanilla Lucene. So all searcher handling is the same like in Lucene.

## Gecko EMF Search Framework

This implementation works like the ordinary Gecko Search, but with EMF EObjects.

So there is a special configuration like this:

```
{
  ":configurator:resource-version": 1,
	"EMFLuceneIndex~demo": 
	{
		"id": "TestEMF",
		"directory.type": "MMAP",
		"base.path": "/tmp/testEMFIndex"
	}
}
```

To create the index context you can use `org.gecko.emf.search.document.EObjectContextObjectBuilder`.

You have to map you EObjects into Lucene Documentation on your own and create the IndexContext out of it. This can then be submitted to the *LuceneIndexService*

## Gecko Search Suggest

Lucene supports an own index to create fast suggestions like you know it from auto-completion.

The bundle `org.gecko.search.suggest` contains a service based OSGi ready implementation. The EMF variant is located in `org.gecko.emf.search.suggest` .

Please also refer to the corresponding tests in `org.gecko.search.suggest.test` and `org.gecko.emf.search.suggest.test`

### Static Suggest Index

To create a Lucene suggest model out of you business objects you need to create a `org.gecko.search.suggest.api.SuggestionDescriptor`. This descriptor is the controller to the data and suggest structure.

After that you need the *SuggestionService* to query against the Lucene suggest index. The *SuggestionDescriptor* can be linked to the service via configuration:

```
{
  ":configurator:resource-version": 1,
	"ObjectSuggestionDescriptor~demo": 
	{
		"suggestion.index": true,
		"name": "Foo"
	},
	"ObjectSuggestionService~demo": 
	{
		"base.path": "/tmp/suggestIndex",
		"descriptor.target": "(name=Foo)",
		"suggestionName": "testSuggest",
		"suggestNumberResults": 5
	},
}
```

In this example the descriptor service with name *Foo* is linked to the service using the *descriptor.target="(name=Foo)"* property.

To query result, you need to call `SuggestionService#getAutocompletion`.

All the data are 

### Stream Based Suggest

If  you need a continuous data stream that need to be indexed there is a service, that consumes an OSGi *PushStream*. You can configure it as usual:

```
{
  ":configurator:resource-version": 1,
    "ObjectSuggestionDescriptor~demo": 
	{
		"suggestion.index": true,
		"name": "FooDesc"
	},
	"ObjectStreamSuggestionService~demo": 
	{
		"base.path": "/tmp/suggestIndex",
		"descriptor.target": "(name=FooDesc)",
		"contextStream.target": "(name=FooStream)",
		"suggestionName": "testSuggest",
		"suggestNumberResults": 5
	},
}
```

*You now need to register a *PushStream<YOURTYPE>* as service, that contains the service property *name=FooStream*. In addition to that you need the mapping information from the SuggestionDescriptor*. In the configuration it is wired using the target binding *descriptor.target=(name=FooDesc)*

So you can put you business objects into the PushEventSource and the mapping into `SuggestionContext`happens in the implemenation.

## Gecko EMF Search Suggest

This works in the same way like the default implementation. You only have to provide a *PushStream<EObject>*

```
{
  ":configurator:resource-version": 1,
    "EMFSuggestionDescriptor~demo": 
	{
		"suggestion.index": true,
		"name": "FooEMFDesc"
	},
	"EMFStreamSuggestionService~demo": 
	{
		"base.path": "/tmp/suggestEMFIndex",
		"descriptor.target": "(name=FooEMFDesc)",
		"contextStream.target": "(name=FooEMFStream)",
		"suggestionName": "testEMFSuggest",
		"suggestNumberResults": 5
	},
}
```