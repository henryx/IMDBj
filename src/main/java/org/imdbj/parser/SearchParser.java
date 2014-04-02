/*
 * Copyright (C) 2012 Enrico Bianchi (enrico.bianchi@gmail.com)
 * Project       IMDBj
 * Description   IMDBj - A java library for fetch and manage IMDB Movie data
 * License       LGPLv2.1 (see lgpl-2.1.txt for details)
 */

package org.imdbj.parser;

import java.util.HashMap;

/**
 *
 * @author enrico
 */
public class SearchParser {
    private StringBuffer page;
    
    public SearchParser() {
    }

    public void setPage(StringBuffer page) {
        this.page = page;
    }

    public HashMap<String, String> getData() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
