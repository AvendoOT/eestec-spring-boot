package hr.eestec.movielibrary.service;

import hr.eestec.movielibrary.dto.CreateMovieDTO;
import hr.eestec.movielibrary.dto.MovieDTO;

import java.util.List;

public interface MovieLibraryService {

    void createMovie(CreateMovieDTO createMovieDTO);
    List<MovieDTO> getAll();
    void updateMovie(Long id, CreateMovieDTO updateMovieDTO);
}
