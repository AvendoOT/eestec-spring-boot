package hr.eestec.movielibrary.dto;

import hr.eestec.movielibrary.model.Movie;

public class CreateMovieDTO {

    private String name;
    private Integer review;

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

    public static Movie mapToMovie(CreateMovieDTO createMovieDTO) {
        final Movie movie = new Movie();
        movie.setName(createMovieDTO.getName());
        movie.setReview(createMovieDTO.getReview());
        return movie;
    }
}
