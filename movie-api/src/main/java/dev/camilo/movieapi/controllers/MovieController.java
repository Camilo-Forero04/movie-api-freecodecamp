package dev.camilo.movieapi.controllers;

import dev.camilo.movieapi.entities.Movie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.camilo.movieapi.services.MovieService;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    //Any rest API should return proper Status Codes so, insted returning an String, it should return a ResponseEntity
    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);//HttpStatus.OK would send the code 200 which means that everything is OK
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(imdbId),HttpStatus.OK);
    }
}
