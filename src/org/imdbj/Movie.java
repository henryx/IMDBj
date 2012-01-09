/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
