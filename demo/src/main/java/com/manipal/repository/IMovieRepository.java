package com.manipal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manipal.model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
	Movie findByTitle(String title);
	Movie findByLeadRoleAndTitle(String leadRole, String title);
	
	@Query("SELECT m FROM Movie m WHERE m.flag ='Active'")
	List<Movie> findByAllActiveMovies();
}
