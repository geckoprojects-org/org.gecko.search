/**
 * Copyright (c) 2014 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.search.result.core.queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Helper class that helps to create a Lucene query using the query parser
 * @author Mark Hoffmann
 * @since 07.09.2014
 */
public class QueryBuilder {

	private final String defaultField;
	private final String[] fields;
	private boolean andQuery;
	private boolean andQueryForDefaultField = false;
	private String[] tokens;
	private float termBoost = 2.0f;
	private boolean quoteFuzzy = true;
	private boolean appendConcatenatedTokens = false;
	private int maxAppendConcatenatedTokens = 3;
	private boolean appendConcatenatedTokenAndQuery = false;
	private List<String> concatinationFields;
	private List<String> fuzzyFields = Collections.emptyList();
	private List<String> wildCardFields = Collections.emptyList();;

	/**
	 * Creates a new instance.
	 * @param defaultField the default field name
	 * @param fields the names of all fields to search in
	 */
	public QueryBuilder(String defaultField, String... fields) {
		this(defaultField, false, fields);
	}

	/**
	 * Creates a new instance.
	 * @param defaultField the default field name
	 * @param andQuery <code>true</code>, if each token is AND'ed no each other token, otherwise OR will be used
	 * @param fields the names of all fields to search in
	 */
	public QueryBuilder(String defaultField, boolean andQuery, String... fields) {
		this.defaultField = defaultField;
		this.andQuery  = andQuery;
		this.fields = fields;
		concatinationFields = Collections.singletonList(defaultField);
	}

	/**
	 * Creates a query string for the given parameters
	 * @param searchText the text to get the query from
	 * @return a query string for the given parameters
	 */
	public String createQueryString(String searchText) {
		return createQueryFromString(searchText);
	}

	/**
	 * Creates a query string for the given parameters
	 * @param tokens the tokens to get the query from
	 * @return a query string for the given parameters
	 */
	public String createQueryString(String[] tokens) {
		setTokens(tokens);
		return createQueryFromTokens(tokens);
	}
	
	/**
	 * Creates a query string for the given parameters
	 * @param tokens the tokens to get the query from
	 * @return a query string for the given parameters
	 */
	public String createQueryString() {
		if (tokens != null) {
			return createQueryFromTokens(tokens);
		}
		return null;
	}

	/**
	 * Creates a query for the given search tokens
	 * @param tokens the search tokens to create the query from
	 * @return the query strings
	 */
	private String createQueryFromTokens(final String[] tokens) {
		TokenHolder[] quoted = quoteTokens(tokens);
		StringBuilder queryString = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			String currentField = fields[i];
			String fieldQuery = createFieldQueryFromTokens(currentField, 1.0f, quoted);
			if (i > 0) {
				queryString.append(" OR ");
			}
			queryString.append(fieldQuery);
		}
		return queryString.toString();
	}

	/**
	 * Creates a query for the given search text
	 * @param searchString the search string to create the query from
	 * @return the query strings
	 */
	private String createQueryFromString(String searchString) {
		String queryString = "";
		for (int i = 0; i < fields.length; i++) {
			String currentField = fields[i];
			String fieldQuery = createFieldQueryFromString(currentField, searchString);
			if (i > 0) {
				queryString += " OR ";
			}
			queryString += fieldQuery;
		}
		return queryString;
	}

	/**
	 * Creates a query for the given field and a search string
	 * @param currentField the current field to create the query for
	 * @param searchString the search string
	 * @return the query string
	 */
	private String createFieldQueryFromString(String currentField, String searchString) {
		String[] tokens = searchString.toLowerCase().split(" ");
		setTokens(tokens);
		TokenHolder[] quoteTokens = quoteTokens(tokens);
		return createFieldQueryFromTokens(currentField, 1.0f, quoteTokens);
	}

	/**
	 * Creates a query 
	 * @param currentField the name of the field to create a query for
	 * @param boost the boost factory
	 * @param tokens the array of tokens 
	 * @return the query string
	 */
	private String createFieldQueryFromTokens(String currentField, float boost, TokenHolder[] tokens) {
			String queryPrefix = getDefaultField().equals(currentField) ? "" : (currentField + ":");
			StringBuilder queryString = new StringBuilder();
//			if (isAppendConcatenatedTokens() && 
//					defaultField != null && 
//					defaultField.equals(currentField) && tokens.length > 1) {
//				String[] createConcatenateTokenCache = createConcatenateTokenCache(tokens);
//				if(createConcatenateTokenCache != null && createConcatenateTokenCache.length > 0){
//					tokensToUse = Arrays.copyOf(tokensToUse, tokensToUse.length + createConcatenateTokenCache.length);
//					for (int i = 0; i < createConcatenateTokenCache.length; i++) {
//						tokensToUse[tokens.length + i] = createConcatenateTokenCache[i];
//					}
//				}
//			}
			for (int i = 0; i <  tokens.length; i++) {
				TokenHolder tokenHolder = tokens[i];
				String token = tokenHolder.getToken();
				StringBuilder tokenQuery = new StringBuilder("(\"");
				tokenQuery.append(token);
				tokenQuery.append('\"');
				tokenQuery.append(addBoost(getTermBoost()));
				// quoted tokens will not be added to the wildcard search, because this could result in invalid regexes
				if(wildCardFields.contains(currentField) && !tokenHolder.isQuoted()){
					tokenQuery.append(" OR ");
					tokenQuery.append("*");
					tokenQuery.append(token);
					tokenQuery.append("*");
//					tokenQuery.append(addBoost(boost));
				}
				if(fuzzyFields.contains(currentField)){
					tokenQuery.append(" OR ");
					if (this.quoteFuzzy) {
						tokenQuery.append('\"');
					}
					tokenQuery.append(token);
					if (this.quoteFuzzy) {
						tokenQuery.append('\"');
					}
					tokenQuery.append("~2");
					tokenQuery.append(addBoost(boost));
				}
				tokenQuery.append(")");
				if (i > 0) {
					queryString.append(andQuery ? " AND " : " OR ");
				}
				queryString.append(queryPrefix);
				queryString.append(tokenQuery.toString());
			}
			if (andQueryForDefaultField && 
					defaultField != null && 
					defaultField.equals(currentField)) {
				String defaultAndQuery = appendAndQuery(queryPrefix, tokens);
				queryString.append(" OR ");
				queryString.append(defaultAndQuery);
			}
			if (isAppendConcatenatedTokens() && 
					concatinationFields.contains(currentField) && 
					tokens.length > 1) {
				String concatenateQuery = appendAndConcatenateQuery(tokens);
				queryString.append(" OR ");
				queryString.append(concatenateQuery);
				queryString.append(addBoost(getTermBoost()));
//				queryString.append(addBoost(6f));
			}
			return queryString.toString();
		}

		/**
		 * Quotes the special chraracters in the tokens 
		 * @param tokens the tokens to quote
		 * @return an Array of {@link TokenHolder}s, that hold the quoted token and the information, if a token contains quoted characters
		 */
		private TokenHolder[] quoteTokens(String[] tokens) {
			TokenHolder[] holders = new TokenHolder[tokens.length];
			for (int i = 0; i < tokens.length; i++) {
				StringBuilder quotedToken = new StringBuilder();
				TokenHolder holder = new TokenHolder();
				char[] token = tokens[i].toCharArray();
				for (int j = 0; j < token.length; j++) {
					char c = token[j];
					switch (c) {
					case '\\':
						quotedToken.append('\\');
						quotedToken.append('\\');
						holder.setQuoted(Boolean.TRUE);
						break;
					case '&':
						if(j + 1 != token.length && token[j+1] == '&'){
							quotedToken.append('\\');
							quotedToken.append('&');
							quotedToken.append('&');
							j++;
							holder.setQuoted(Boolean.TRUE);
							break;
						}
					case '|':
						if(j + 1 != token.length && token[j+1] == '|'){
							quotedToken.append('\\');
							quotedToken.append('|');
							quotedToken.append('|');
							j++;
							holder.setQuoted(Boolean.TRUE);
							break;
						}
					case '/':
					case '+':
					case '-':
					case '!':
					case '(':
					case ')':
					case '{':
					case '}':
					case '[':
					case ']':
					case '^':
					case '~':
					case '*':
					case '?':
					case ':':
						holder.setQuoted(Boolean.TRUE);
						quotedToken.append('\\');
					default:
						quotedToken.append(c);
					}
				}
				holder.setToken(quotedToken.toString());
				holders[i] = holder;
			}
			return holders;
		}

	/**
	 * Appends a and query for the given field prefix parameter and the given tokens 
	 * @param fieldPrefix the field prefix
	 * @param tokens the tokens
	 * @return the query part
	 */
	private String appendAndQuery(String fieldPrefix, TokenHolder[] tokens) {
		StringBuilder queryString = new StringBuilder("(");
		for (int i = 0; i <  tokens.length; i++) {
			String token = tokens[i].getToken();
			if (i > 0) {
				queryString.append(" AND ");
			}
			queryString.append(token);
		}
		queryString.append(')');
		return queryString.toString();
	}
	
	/**
	 * Appends a and query for the given token combinations where following token will be concatenated 
	 * @param tokens the query tokens
	 * @return the query string
	 */
	private String appendAndConcatenateQuery(TokenHolder[] tokens) {
		String[] possibleTokenCache = createConcatenateTokenCache(tokens);
		if (possibleTokenCache.length == 0 || !isAppendConcatenatedTokens()) {
			return "";
		}
		if (possibleTokenCache.length == 1) {
			return possibleTokenCache[0];
		}
		StringBuilder queryString = new StringBuilder("(");
		for (int i = 0; i < possibleTokenCache.length; i++) {
			String value = possibleTokenCache[i];
			if (i > 0) {
				queryString.append(isAppendConcatenatedTokenAndQuery() ? " AND " : " OR ");
			}
			queryString.append(value);
			
		}
		queryString.append(')');
		return queryString.toString();
	}
	
	/**
	 * Creates a array with all possibilities of combinations
	 * @param tokens the source tokens
	 * @return the array with all possible combinations or an empty array
	 */
	private String[] createConcatenateTokenCache(TokenHolder[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return new String[0];
		}
		// only one token, we dont need to do anything
		if (tokens.length == 1) {
			return new String[]{tokens[0].getToken()};
		}
		// calculated how many tokens should be appended
		int maxTokens = tokens.length > getMaxAppendConcatenatedTokens() ? getMaxAppendConcatenatedTokens() : tokens.length;
		// calculate the number of possibilities 
		int possibleTokens = getTokenConcatenationPossibilities(maxTokens);
		// create token cache
		String[] possibleTokenCache = new String[possibleTokens];
		int cacheIndex = 0;
		for (int i = 0; i < maxTokens; i++) {
			String value = tokens[i].getToken();
			for (int j = i + 1; j < maxTokens; j++) {
				possibleTokenCache[cacheIndex] = value + tokens[j].getToken();
				cacheIndex++;
			}
		}
		
		return possibleTokenCache;
	}
	
	/**
	 * Returns the number of possible values
	 * @param numberOfTokens the number of tokens to concatenate
	 * @return the numer of possibilities for all concatenations
	 */
	private int getTokenConcatenationPossibilities(int numberOfTokens) {
		if (numberOfTokens < 0) {
			return 0;
		}
		if (numberOfTokens == 0 || numberOfTokens == 1) {
			return numberOfTokens;
		} else {
			return numberOfTokens * (numberOfTokens - 1) / 2;
		}
	}

	/**
	 * Adds a boost to the query of it isn't default
	 * @param boost the boost factor
	 * @return the string for the boost addition
	 */
	private String addBoost(float boost) {
		if (boost > 1.0f) {
			return "^" + boost;
		}
		return "";
	}

	/**
	 * Returns the defaultField.
	 * @return the defaultField
	 */
	public String getDefaultField() {
		return defaultField;
	}

	/**
	 * Sets the tokens
	 * @param tokens the search tokens
	 */
	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}
	
	/**
	 * Returns the search tokens
	 * @return the search tokens
	 */
	public String[] getTokens() {
		return tokens;
	}

	public boolean isAndQueryForDefaultField() {
		return andQueryForDefaultField;
	}

	public void setAndQueryForDefaultField(boolean andQueryForDefaultField) {
		this.andQueryForDefaultField = andQueryForDefaultField;
	}

	/**
	 * Returns the termBoost.
	 * @return the termBoost
	 */
	public float getTermBoost() {
		return termBoost;
	}

	/**
	 * Sets the termBoost.
	 * @param termBoost the termBoost to set
	 */
	public void setTermBoost(float termBoost) {
		this.termBoost = termBoost;
	}

	/**
	 * Returns the if the given tokens should be appended as concatenated string.
	 * @return the appendConcatenatedTokens
	 */
	public boolean isAppendConcatenatedTokens() {
		return appendConcatenatedTokens;
	}

	/**
	 * Sets to <code>true</code>, if the given tokens should be concatenated appended to the query.
	 * @param appendConcatenatedTokens the appendConcatenatedTokens to set
	 */
	public void setAppendConcatenatedTokens(boolean appendConcatenatedTokens) {
		this.appendConcatenatedTokens = appendConcatenatedTokens;
	}

	/**
	 * Returns the number of tokens that will be appended.
	 * @return the maxAppendConcatenatedTokens
	 */
	public int getMaxAppendConcatenatedTokens() {
		return maxAppendConcatenatedTokens;
	}

	/**
	 * Sets the number of tokens that will be appended.
	 * @param maxAppendConcatenatedTokens the maxAppendConcatenatedTokens to set
	 */
	public void setMaxAppendConcatenatedTokens(int maxAppendConcatenatedTokens) {
		this.maxAppendConcatenatedTokens = maxAppendConcatenatedTokens;
	}

	/**
	 * Returns <code>true</code>, if the concatenated tokens are appended as AND query.
	 * @return the appendConcatenatedTokenAndQuery
	 */
	public boolean isAppendConcatenatedTokenAndQuery() {
		return appendConcatenatedTokenAndQuery;
	}

	/**
	 * Sets the appendConcatenatedTokenAndQuery.
	 * @param appendConcatenatedTokenAndQuery the appendConcatenatedTokenAndQuery to set
	 */
	public void setAppendConcatenatedTokenAndQuery(boolean appendConcatenatedTokenAndQuery) {
		this.appendConcatenatedTokenAndQuery = appendConcatenatedTokenAndQuery;
	}

	/**
	 * @return the concatinationFields
	 */
	public List<String> getConcatinationFields() {
		return concatinationFields;
	}

	/**
	 * @param concatinationFields the concatinationFields to set
	 */
	public void setConcatinationFields(List<String> concatinationFields) {
		this.concatinationFields = new ArrayList<String>(concatinationFields.size() + 1);
		this.concatinationFields.add(defaultField);
		this.concatinationFields.addAll(concatinationFields);
	}

	/**
	 * @return the fuzzyFields
	 */
	public List<String> getFuzzyFields() {
		return fuzzyFields;
	}

	/**
	 * @param fuzzyFields the fuzzyFields to set
	 */
	public void setFuzzyFields(List<String> fuzzyFields) {
		this.fuzzyFields = fuzzyFields;
	}

	/**
	 * @return the wildCardFields
	 */
	public List<String> getWildCardFields() {
		return wildCardFields;
	}

	/**
	 * @param wildCardFields the wildCardFields to set
	 */
	public void setWildCardFields(List<String> wildCardFields) {
		this.wildCardFields = wildCardFields;
	}

	
	private static class TokenHolder {
		private String token = null;
		private boolean quoted = false;
		/**
		 * @return the token
		 */
		public String getToken() {
			return token;
		}
		/**
		 * @param token the token to set
		 */
		public void setToken(final String token) {
			this.token = token;
		}
		/**
		 * @return the quoted
		 */
		public boolean isQuoted() {
			return quoted;
		}
		/**
		 * @param quoted the quoted to set
		 */
		public void setQuoted(final boolean quoted) {
			this.quoted = quoted;
		}
	}
	
	/**
	 * @param quoteFuzzy
	 */
	public void setQuoteFuzzy(boolean quoteFuzzy) {
		this.quoteFuzzy = quoteFuzzy;
	}
	
}
