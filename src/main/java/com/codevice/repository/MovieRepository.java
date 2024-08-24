package com.codevice.repository;

import com.codevice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // No implementation needed, Spring Data JPA will generate the implementation at runtime
}
