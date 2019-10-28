package io.trpspringmicroservices.movieinfoservice.resources;

import io.trpspringmicroservices.movieinfoservice.models.Movie;
import io.trpspringmicroservices.movieinfoservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private MovieRepository movieRepository;

    // Method to POST details of a particular movie
    @PostMapping("/addMovie")
    public Movie addMovieInfo(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // Method to GET details of a particular movie
    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Integer movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        Movie movie = optionalMovie.get();
        return movie;
    }

}
