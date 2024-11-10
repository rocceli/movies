/*
    ================================================================================================
    This code is part of movies software.

    the-pledge is a closed source software of EN (Eliah Ngugi) which is owned by EN.
    
        Elijah Ngugi Gachuki
    
    This software is private closed source software.
    
    For further details look at or request the-pledge-license.txt for further details.

    Copyright (C) 2024 

    Email:  elijah.ngugi.gachuki@gmail.com
    Domain: N/A

    ================================================================================================
    Author : EN
    ================================================================================================
 */
package org.movies.controller.movies;

import java.util.List;
import java.util.Optional;

import org.movies.domain.movies.Movie;
import org.movies.service.movies.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EN - Nov 10, 2024
 */
@RestController
@RequestMapping( "/api/v1/movies" )
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping( )
    private ResponseEntity<List<Movie>> getAllMovies() {

        return new ResponseEntity<List<Movie>>( movieService.AllMovies(), HttpStatus.OK );
    }


    @GetMapping( "/{imdbId}" )
    private ResponseEntity<Optional<Movie>> getSingeMovie( @PathVariable String imdbId ) {

        Optional<Movie> movie = movieService.singleMovie( imdbId );
        return movie.isPresent() ? new ResponseEntity<>( movie, HttpStatus.OK )
                : new ResponseEntity<>( HttpStatus.NOT_FOUND );
    }

}
