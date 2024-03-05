
package dev.camilo.movieapi.services;

import dev.camilo.movieapi.repositories.MovieRepository;
import dev.camilo.movieapi.entities.Movie;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService{
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public Optional<Movie> getMovieById(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
