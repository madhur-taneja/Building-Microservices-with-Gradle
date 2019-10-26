package io.trpspringmicroservices.movieinfoservice.repository;

import io.trpspringmicroservices.movieinfoservice.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, Integer> {
}
