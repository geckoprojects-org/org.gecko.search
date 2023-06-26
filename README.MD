[![CI Build](https://github.com/geckoprojects-org/org.gecko.search/actions/workflows/build.yml/badge.svg)](https://github.com/geckoprojects-org/org.gecko.search/actions/workflows/build.yml)[![License](https://github.com/geckoprojects-org/org.gecko.search/actions/workflows/license.yml/badge.svg)](https://github.com/geckoprojects-org/org.gecko.search/actions/workflows/license.yml )[![Sonar](https://github.com/geckoprojects-org/org.gecko.search/actions/workflows/sonar.yml/badge.svg)](https://github.com/geckoprojects-org/org.gecko.search/actions/workflows/sonar.yml )[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=geckoprojects-org_org.gecko.search&metric=bugs)](https://sonarcloud.io/dashboard?id=geckoprojects-org_org.gecko.search)[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=geckoprojects-org_org.gecko.search&metric=code_smells)](https://sonarcloud.io/dashboard?id=geckoprojects-org_org.gecko.search)[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=geckoprojects-org_org.gecko.search&metric=coverage)](https://sonarcloud.io/dashboard?id=geckoprojects-org_org.gecko.search)[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=geckoprojects-org_org.gecko.search&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=geckoprojects-org_org.gecko.search)[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=geckoprojects-org_org.gecko.search&metric=alert_status)](https://sonarcloud.io/dashboard?id=geckoprojects-org_org.gecko.search)[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=geckoprojects-org_org.gecko.search&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=geckoprojects-org_org.gecko.search)[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=geckoprojects-org_org.gecko.search&metric=security_rating)](https://sonarcloud.io/dashboard?id=geckoprojects-org_org.gecko.search)[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=geckoprojects-org_org.gecko.search&metric=sqale_index)](https://sonarcloud.io/dashboard?id=geckoprojects-org_org.gecko.search)[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=geckoprojects-org_org.gecko.search&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=geckoprojects-org_org.gecko.search)

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

Finally the Lucene dependencies are needed as well. 

The implementation is based on Lucene 9.7.0 dependencies. The latest version is 1.3.x

## Lucene and OSGi

Because the Lucene jars are not OSGi compatible, we added this support.

You can find the releases at Maven Central:

```
<dependency>
    <groupId>org.geckoprojects.search</groupId>
    <artifactId>org.apache.lucene.core</artifactId>
    <version>9.6.0</version>
</dependency>
```

We also provide:

* org.apache.lucene.analysis.icu
* org.apache.lucene.analysis.morfologik
* org.apache.lucene.analysis.opennlp
* org.apache.lucene.analysis.phonetic
* org.apache.lucene.backward.codecs
* org.apache.lucene.benchmark
* org.apache.lucene.classification
* org.apache.lucene.codecs
* org.apache.lucene.core (core - analysis-common)
* org.apache.lucene.expressions
* org.apache.lucene.facet
* org.apache.lucene.grouping
* org.apache.lucene.highlighter
* org.apache.lucene.join
* org.apache.lucene.memory
* org.apache.lucene.misc
* org.apache.lucene.monitor
* org.apache.lucene.queries
* org.apache.lucene.queryparser
* org.apache.lucene.spatial (spatial3d + spatial-extras)
* org.apache.lucene.suggest

## Gecko Search Bnd Libraries

For improved handling in bndtools, we provide as set of bnd libraries and project templates.

To enable library support for Gecko Search you need:

```
<dependency>
    <groupId>org.geckoprojects.search</groupId>
    <artifactId>org.gecko.search.bnd.library</artifactId>
    <version>1.3.0</version>
</dependency>
```
In the *build.bnd* you can enable the library using the instruction:

`-library: geckoSearch`

You will find a new *Gecko Search* repository now, with all the dependencies, that are needed.

On project level, you may need some dependencies for the Gecko Search. To ease this use, you can enable the build path addition by using:

`-library: enableSearch`

in the project *bnd.bnd*.

Once the *geckoSearch* library is enabled, you also get somme project templates for *bndtools*, that show the usage of the *Gecko Search*:

* Indexing
* Suggest
* Indexing with EMF
* Indexing with EMF and the Gecko Mongo Repository framework

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
		"directory.type": "MMap",
		"base.path": "/tmp/testIndex"
	}
}
```

This creates a search component with a Lucene Index *MMAP* directory at location */tmp/testIndex*.

With that two services will get available:

1. *LuceneIndexService* - Service to index business objects
2. *IndexSearcher* - Service to search in the defined index

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

### IndexListener

The index listener is an interface, that is used by the indexer per default. If one registers an implementation of this interface as service. This listener will be informed about new *IndexContext* objects that have been indexed.

To enable a selective target binding of a listener to a *LuceneIndexService* you can define the service/configuration property *indexListener.target=(my=listenerImpl)* in the *LuceneIndexService* configuration.

There is an already existing implementation for the suggester to by-pass all indexed contexts to this listener an forward them to the suggestion component.

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

You now need to register a *PushStream<YOURTYPE>* as service, that contains the service property *name=FooStream*. In addition to that you need the mapping information from the SuggestionDescriptor*. In the configuration it is wired using the target binding *descriptor.target=(name=FooDesc)

So you can put you business objects into the PushEventSource and the mapping into `SuggestionContext`happens in the implemenation.

### IndexListener Based Suggest

There is an simple implementation of a *IndexListener*, that gets all *IndexContext* objects from the *LuceneIndexService*. The implementation creates a *PushStream*, that can be linked to the *StreamSuggestionService*

A configuration can look like this:

```
{
  ":configurator:resource-version": 1,
  	"DefaultLuceneIndex~demo": 
	{
		"id": "demo",
		"directory.type": "ByteBuffer",
		"indexListener.target": "(slName=demo)"
	},
	"SuggestionIndexListener~demo":
	{
		"slName": "demo"
	}
    "ObjectSuggestionDescriptor~demo": 
	{
		"name": "FooDesc"
	},
	"ObjectStreamSuggestionService~demo": 
	{
		"directory.type": "ByteBuffer",
		"descriptor.target": "(name=FooDesc)",
		"contextStream.target": "(sl.name=demo)",
		"suggestionName": "testSuggest",
		"suggestNumberResults": 5
	}
}
```
* **DefaultLuceneIndex~demo** is the configuration for in memory index
* **SuggestionIndexListener~demo** is the IndexListener that is bound to the *DefaultLuceneIndex* via *"indexListener.target": "(slName=demo)"*.
* **ObjectSuggestionDescriptor~demo** is the index descriptor for the suggestion, that defines, which field of the business objects are indexed for suggestion.
* **ObjectStreamSuggestionService~demo** is the suggestion service configured as in-memeory. It is linked to its object descriptor using *"descriptor.target": "(name=FooDesc)"*. In addition to that the *PushStream* that was registered from *SuggestionIndexListner* is bound via *"contextStream.target": "(sl.name=demo)"*

So,s all elements that are indexed in *DefaultLuceneIndex* are forwarded to the *SuggestionIndexListener*, who registered a *PushStream* service, that is bound to the *ObjectStreamSuggestionService*

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

## Links

* [Documentation](https://github.com/geckoprojects-org/org.gecko.search)
* [Source Code](https://github.com/geckoprojects-org/org.gecko.search) (clone with `scm:git:git@github.com:geckoprojects-org/org.gecko.search.git`)