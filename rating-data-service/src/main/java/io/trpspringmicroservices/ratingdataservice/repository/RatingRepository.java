package io.trpspringmicroservices.ratingdataservice.repository;

import io.trpspringmicroservices.ratingdataservice.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<User, Integer> {
}
