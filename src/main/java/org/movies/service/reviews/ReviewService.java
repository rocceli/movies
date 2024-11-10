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
package org.movies.service.reviews;

import org.movies.domain.movies.Movie;
import org.movies.domain.reviews.Review;
import org.movies.repository.reviews.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author EN - Nov 10, 2024
 */
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview( String reviewBody, String imdbId ) {

        Review review = reviewRepository.insert( new Review( reviewBody ) );

        mongoTemplate.update( Movie.class )
                .matching( Criteria.where( "imdbId" ).is( imdbId ) )
                .apply( new Update().push( "reviewIds" ).value( review ) )
                .first();
        return review;
    }
}
