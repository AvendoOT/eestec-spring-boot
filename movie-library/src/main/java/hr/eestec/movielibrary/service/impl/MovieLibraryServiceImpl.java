package hr.eestec.movielibrary.service.impl;

import hr.eestec.movielibrary.dto.CreateMovieDTO;
import hr.eestec.movielibrary.dto.MovieDTO;
import hr.eestec.movielibrary.model.Movie;
import hr.eestec.movielibrary.repository.MovieLibraryRepository;
import hr.eestec.movielibrary.service.MovieLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieLibraryServiceImpl implements MovieLibraryService {

    private final MovieLibraryRepository movieLibraryRepository;

    @Autowired
    public MovieLibraryServiceImpl(MovieLibraryRepository movieLibraryRepository) {
        this.movieLibraryRepository = movieLibraryRepository;
    }

    @Override
    public void createMovie(CreateMovieDTO createMovieDTO) {
        if (createMovieDTO.getReview() > 5) {
            throw new IllegalArgumentException();
        }
        final Movie movie = CreateMovieDTO.mapToMovie(createMovieDTO);
        movieLibraryRepository.save(movie);
    }

    @Override
    public List<MovieDTO> getAll() {
        final List<Movie> movies = movieLibraryRepository.findAll();
        return movies.stream().map(MovieDTO::mapToMovieDTO).collect(Collectors.toList());
    }

    @Override
    public void updateMovie(Long id, CreateMovieDTO updateMovieDTO) {
        final Movie movie = movieLibraryRepository.getById(id);
        movie.setName(updateMovieDTO.getName());
        movie.setReview(updateMovieDTO.getReview());
        movieLibraryRepository.save(movie);
    }
}
