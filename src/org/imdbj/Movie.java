/*
 * Copyright (C) 2012 Enrico Bianchi (enrico.bianchi@gmail.com)
 * Project       IMDBj
 * Description   IMDBj - A java library for fetch and manage IMDB Movie data
 * License       LGPLv2.1 (see lgpl-2.1.txt for details)
 */

package org.imdbj;

import org.imdbj.exceptions.UnknownMovieException;
import org.imdbj.net.Search;

/**
 *
 * @author enrico
 */
public class Movie {
    
    public Movie(String title) throws UnknownMovieException {
        StringBuffer data;
        data = this.search(title);
        this.parse(data);
    }
    
    private void parse(StringBuffer data) {
        
    }
    
    private StringBuffer search(String title) throws UnknownMovieException {
        Search search;
        StringBuffer data;
        
        search = new Search();
        search.setQuery(title);
        
        data = search.find();
        
        if (data.indexOf("<b>No Matches.</b>") == -1) {
            throw new UnknownMovieException();
        }
        
        return data;
    }
}
