/*
 * Copyright (C) 2012 Enrico Bianchi (enrico.bianchi@gmail.com)
 * Project       IMDBj
 * Description   IMDBj - A java library for fetch and manage IMDB Movie data
 * License       LGPLv2.1 (see lgpl-2.1.txt for details)
 */

package org.imdbj.exceptions;

/**
 *
 * @author enrico
 */
public class UnknownMovieException extends Exception {
    public UnknownMovieException() {
    }
    
    @Override
    public String toString() {
        return "Movie not found";
    }
}
