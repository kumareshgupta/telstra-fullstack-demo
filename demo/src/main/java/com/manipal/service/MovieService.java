package com.manipal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.model.Movie;
import com.manipal.repository.IMovieRepository;
import com.manipal.service.utility.MovieValidationCheck;
@Service
public class MovieService implements IMovieService {
	@Autowired
	private IMovieRepository repository;
	
	
	@Override
	public void addOrUpdateMovie(Movie movie) {
		
		repository.save(movie);
		
		//leadRole should not contain any special character / number
		
		/*String validationStatus ="Not Validated";
		
		if(MovieValidationCheck.validateMovie(movie)) {		
			repository.save(movie);
			validationStatus ="Validated";
		}else {
			validationStatus ="Not Validated";
		}
		
		return validationStatus;	*/	
		
	}
	
	

	@Override
	public Movie getMovieById(int movieId) {
		return repository.findById(movieId).orElse(null);
	}



	@Override
	public List<Movie> getAllMovies() {
		return repository.findAll();
	}



	@Override
	public Movie getMovieByTitle(String title) {
		return repository.findByTitle(title);
	}



	@Override
	public Movie getMovieByLeadRoleAndTitle(String leadRole, String title) {		
		return repository.findByLeadRoleAndTitle(leadRole, title);
	}



	@Override
	public List<Movie> getAllActiveMovies() {
		// TODO Auto-generated method stub
		return repository.findByAllActiveMovies();
	}

}
