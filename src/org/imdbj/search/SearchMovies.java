/*
 * Copyright (C) 2012 Enrico Bianchi (enrico.bianchi@gmail.com)
 * Project       IMDBj
 * Description   IMDBj - A java library for fetch and manage IMDB Movie data
 * License       LGPLv2.1 (see lgpl-2.1.txt for details)
 */

package org.imdbj.search;

import org.imdbj.exceptions.UnknownMovieException;
import org.imdbj.pages.SearchPage;
import org.imdbj.parser.SearchParser;

/**
 *
 * @author enrico
 */
public class SearchMovies {
    private final String SEARCH_BY_TITLE = "&s=tt";
    
    private String title;
    
    public SearchMovies() {
        
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void getData()  throws UnknownMovieException {
        SearchPage search;
        SearchParser parse;
        StringBuffer page;

        search = new SearchPage();
        parse = new SearchParser();

        search.setQuery(title);
        search.setByType(this.SEARCH_BY_TITLE);
        
        page = search.find();
        
        parse.setPage(page);
        
        parse.getData();
    }
}
