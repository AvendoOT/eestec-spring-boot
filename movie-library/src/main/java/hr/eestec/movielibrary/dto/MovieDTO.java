package hr.eestec.movielibrary.dto;

import hr.eestec.movielibrary.model.Movie;

public class MovieDTO {

    private Long id;
    private String name;
    private Integer review;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public static MovieDTO mapToMovieDTO(Movie movie) {
        final MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());
        movieDTO.setReview(movie.getReview());
        return movieDTO;
    }

    public static MovieDTO mapToMovieDTO(CreateMovieDTO movie) {
        final MovieDTO movieDTO = new MovieDTO();
        movieDTO.setName(movie.getName());
        movieDTO.setReview(movie.getReview());
        return movieDTO;
    }
}
