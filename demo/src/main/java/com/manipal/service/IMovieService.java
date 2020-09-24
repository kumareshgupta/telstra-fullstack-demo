package com.manipal.service;

import java.util.List;

import com.manipal.model.Movie;

public interface IMovieService {

	Movie getMovieById(int movieId);
	void addOrUpdateMovie(Movie movie);
	List<Movie> getAllMovies();
	Movie getMovieByTitle(String title);
	Movie getMovieByLeadRoleAndTitle(String leadRole, String title);
	List<Movie> getAllActiveMovies();
	
	
}
