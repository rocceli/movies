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
package org.movies.repository.reviews;

import org.bson.types.ObjectId;
import org.movies.domain.reviews.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author EN - Nov 10, 2024
 */
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {


}
