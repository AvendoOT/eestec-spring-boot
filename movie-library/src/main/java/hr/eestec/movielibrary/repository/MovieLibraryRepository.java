package hr.eestec.movielibrary.repository;

import hr.eestec.movielibrary.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieLibraryRepository extends JpaRepository<Movie, Long> {
}
