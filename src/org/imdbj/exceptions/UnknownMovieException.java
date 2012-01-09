/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
