package io.trpspringmicroservices.ratingdataservice.recources;

import io.trpspringmicroservices.ratingdataservice.models.Rating;
import io.trpspringmicroservices.ratingdataservice.models.User;
import io.trpspringmicroservices.ratingdataservice.models.UserRating;
import io.trpspringmicroservices.ratingdataservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataController {

    @Autowired
    private RatingRepository ratingRepository;

    // Method to POST list of movies and their rating for a particular user
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return ratingRepository.save(user);
    }

    // Method to GET list of movies and their rating for a particular user
    @GetMapping("/users/{userId}")
    public UserRating getRatingOfUser(@PathVariable("userId") Integer userId) {
        Optional<User> resp = ratingRepository.findById(userId);
        User user = resp.get();
        Rating[] movieRatings = user.getMovieRatings();
        List<Rating> list = Arrays.asList(movieRatings);

        UserRating userRating = new UserRating();
        userRating.setUserRating(list);
        return userRating;
    }

    // Hardcoded
    /*@RequestMapping("users/{userId}")
    public UserRating getUser(@PathVariable("userId") String userId) {
        List<Rating> ratings =  Arrays.asList(
                new Rating(1234, 4),
                new Rating(1235, 3)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }*/

}
