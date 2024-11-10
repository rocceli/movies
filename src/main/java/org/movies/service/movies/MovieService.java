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
package org.movies.service.movies;

import java.util.List;
import java.util.Optional;

import org.movies.domain.movies.Movie;
import org.movies.repository.movies.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author EN - Nov 10, 2024
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> AllMovies() {

        return movieRepository.findAll();
    }


    public Optional<Movie> singleMovie( String imdbId ) {

        return movieRepository.findMovieByImdbId( imdbId );
    }

}
