
package dev.camilo.movieapi.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection="movies")
@Data//The annotation uses the loombook dependency, and it is in charged of creating all necessary getters, setters and to string methods
@AllArgsConstructor // The annotation useses the lombok dependency and it is in charged of creating a constructor with all the arguments
@NoArgsConstructor// The annotation useses the lombok dependency and it is in charged of creating a constructor with no arguments
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String relaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference // the annotation will store just the id reviews, reviews will be in a different collection
    //This is called manually reference relationship
    private List<Review> reviewIds;
}
