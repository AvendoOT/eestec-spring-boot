package hr.eestec.movielibrary.controller;

import hr.eestec.movielibrary.dto.CreateMovieDTO;
import hr.eestec.movielibrary.dto.MovieDTO;
import hr.eestec.movielibrary.service.MovieLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/movie-library")
public class MovieLibraryController {

    private final MovieLibraryService movieLibraryService;

    @Autowired
    public MovieLibraryController(MovieLibraryService movieLibraryService) {
        this.movieLibraryService = movieLibraryService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll() {
        return ResponseEntity.ok(movieLibraryService.getAll());
    }
    @PostMapping("/create")
    public ResponseEntity<String> createMovie(@RequestBody CreateMovieDTO createMovieDTO) {
        try {
            movieLibraryService.createMovie(createMovieDTO);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable Long id, @RequestBody CreateMovieDTO updateMovieDTO) {
        try {
            movieLibraryService.updateMovie(id, updateMovieDTO);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
