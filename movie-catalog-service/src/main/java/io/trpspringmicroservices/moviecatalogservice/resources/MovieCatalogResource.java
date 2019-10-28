package io.trpspringmicroservices.moviecatalogservice.resources;

import io.trpspringmicroservices.moviecatalogservice.models.CatalogItem;
import io.trpspringmicroservices.moviecatalogservice.models.Movie;
import io.trpspringmicroservices.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    // If WebClient is used
    /*@Autowired
    private WebClient.Builder webClientBuilder;*/

    // Id RestTemplate is used
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        // For userId, call rating data service and get rating details
        UserRating ratings = restTemplate.getForObject(
                "http://rating-data-service/ratingsdata/users/" + userId,
                UserRating.class);

        assert ratings != null;
        return ratings.getUserRating().stream().map(rating -> {

        // For each movie  Id, call movie info service and get movie details
        // If RestTemplate is used
        Movie m = restTemplate.getForObject("http://movie-info-service/movies/"  + rating.getMovieId(), Movie.class);

        // If WebClient is used
        /* Movie m = webClientBuilder.build()
                .get()
                .uri("htttp://localhost:8082/movies/"  + rating.getMovieId())
                .retrieve()
                .bodyToMono(Movie.class)
                .block(); */

        // Put them all together
            assert m != null;
            return new CatalogItem(m.getName(), m.getDesc(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
