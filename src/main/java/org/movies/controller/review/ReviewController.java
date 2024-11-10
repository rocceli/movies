/*
    ================================================================================================
    This code is part of movies software.

    the-pledge is a closed source software of EN (Eliah Ngugi) which is owned by EN.
    
        Elijah Ngugi Gachuki
    
    This software is private closed source software.
    
    For further details look at or request movies-license.txt for further details.

    Copyright (C) 2024 

    Email:  elijah.ngugi.gachuki@gmail.com
    Domain: N/A

    ================================================================================================
    Author : EN
    ================================================================================================
 */
package org.movies.controller.review;

import java.util.Map;

import org.movies.domain.reviews.Review;
import org.movies.service.reviews.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EN - Nov 10, 2024
 */
@RestController
@RequestMapping( "/api/v1/reviews" )
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview( @RequestBody Map<String, String> payload ) {

        return new ResponseEntity<Review>( reviewService.createReview( payload.get( "reviewBody" ),
                payload.get( "imdbId" ) ), HttpStatus.CREATED );
    }

}
