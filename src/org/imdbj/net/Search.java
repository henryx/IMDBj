/*
 * Copyright (C) 2012 Enrico Bianchi (enrico.bianchi@gmail.com)
 * Project       IMDBj
 * Description   IMDBj - A java library for fetch and manage IMDB Movie data
 * License       LGPLv2.1 (see lgpl-2.1.txt for details)
 */

package org.imdbj.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author enrico
 */
public class Search {
    private final String SEARCH_URL = "http://www.imdb.com/find?q=";
    private String term;
    private String searchType;
    
    private URLConnection createUrl(String uri) throws MalformedURLException, IOException {
        URL url;
        URLConnection conn;
        
        url = new URL(uri);
        
        conn = url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

        return conn;
    }
    
    public StringBuffer find() {
        InputStream stream;
        String query;
        StringBuffer data;
        int buffer;
        
        data = new StringBuffer();
        
        if (this.term.contains(" ")) {
            query = this.SEARCH_URL + this.term.replace(" ", "+") + this.searchType;
        } else {
            query = this.SEARCH_URL + this.term + this.searchType;
        }
        
        try {
            stream = this.createUrl(query).getInputStream();
            
            while (Boolean.TRUE) {
                buffer = stream.read();
                
                if (buffer == -1) {
                    break;
                }
                data.append((char) buffer);
            }
            stream.close();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.term = query;
    }
    
    public void setByType(String type) {
        this.searchType = type;
    }
}
