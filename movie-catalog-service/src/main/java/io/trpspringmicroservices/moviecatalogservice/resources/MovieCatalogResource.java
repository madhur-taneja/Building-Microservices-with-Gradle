package io.trpspringmicroservices.moviecatalogservice.resources;

import io.trpspringmicroservices.moviecatalogservice.models.CatalogItem;
import io.trpspringmicroservices.moviecatalogservice.models.Movie;
import io.trpspringmicroservices.moviecatalogservice.models.Rating;
import io.trpspringmicroservices.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        // Hardcoded data for rating, now shifted to RatingsDataResource in rating-data-service
        /* List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("1235", 3)
        ); */

        UserRating ratings = restTemplate.getForObject(
                "http://localhost:8083/ratingsdata/users/" + userId,
                UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {


            // For each movie  Id, call movie info service and get details
            // If RestTemplate is used
            Movie m = restTemplate.getForObject("htttp://localhost:8082/movies/"  + rating.getMovieId(), Movie.class);

            // If WebClient is used
            /* Movie m = webClientBuilder.build()
                    .get()
                    .uri("htttp://localhost:8082/movies/"  + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block(); */

            // Put them all together
            return new CatalogItem(m.getName(), "I know you're watching", rating.getRating());
        }).collect(Collectors.toList());

        //  HardCoded
        // return Collections.singletonList(
        //         new CatalogItem("Snowden", "I know you're watching", 5)
        // );
    }


}
