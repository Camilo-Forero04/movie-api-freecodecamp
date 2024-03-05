
package dev.camilo.movieapi.controllers;

import dev.camilo.movieapi.entities.Review;
import dev.camilo.movieapi.services.ReviewService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    
    @PostMapping //Since this is going to be an HTTP POST REQUEST this means this will send data to the server, we need to use this annotation
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),HttpStatus.CREATED);//201 code
    }
}
