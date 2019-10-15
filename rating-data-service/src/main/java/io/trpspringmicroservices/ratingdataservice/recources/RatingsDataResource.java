package io.trpspringmicroservices.ratingdataservice.recources;

import io.trpspringmicroservices.ratingdataservice.models.Rating;
import io.trpspringmicroservices.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUser(@PathVariable("userId") String userId) {
        List<Rating> ratings =  Arrays.asList(
                new Rating("1234", 4),
                new Rating("1235", 3)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }

}
