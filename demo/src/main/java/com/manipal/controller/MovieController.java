package com.manipal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.exception.MovieNotFoundException;
import com.manipal.model.Movie;
import com.manipal.service.IMovieService;

@CrossOrigin("http://localhost:3006")
@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private IMovieService movieService;
	
	@PostMapping
	public String addMovieDetails(@RequestBody Movie movie) {
		System.out.println(movie);		
		movieService.addOrUpdateMovie(movie);
		return "Movie added successfully";
	}
	
	@PostMapping("update")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movieDetails) {		
		Movie movie = movieService.getMovieById(movieDetails.getMovieId());
		if(movie!=null) {
			movie.setTitle(movieDetails.getTitle());
			movie.setBudget(movieDetails.getBudget());
			movieService.addOrUpdateMovie(movie);
		} else {
			movieService.addOrUpdateMovie(movieDetails);		
			}		
		ResponseEntity<Movie> responseEntity = new ResponseEntity<>(movie, HttpStatus.OK);		
		return responseEntity;
	}
	
	@DeleteMapping("{movieId}")
	public ResponseEntity<Movie> deleteMovie(@PathVariable int movieId) {	
		Movie movie  = movieService.getMovieById(movieId);
		if(movie!=null) {
			movie.setFlag("Not Active");
			
			movieService.addOrUpdateMovie(movie);
		} 		
		ResponseEntity<Movie> responseEntity = new ResponseEntity<>(movie, HttpStatus.OK);		
		return responseEntity;
	}
	
	@GetMapping("{movieId}")
	public Movie getMovieById(@PathVariable int movieId) {	
		Movie movie  = movieService.getMovieById(movieId);		
		if(movie==null)			
			throw new MovieNotFoundException("Movie ID is invalid. Please enter correct ID.");
		return movie;
	}	
	
	@GetMapping
	public List<Movie> getAllMovies(){
		return movieService.getAllActiveMovies();
		//return movieService.getAllMovies();
	}
	
	
	@GetMapping("leadrole/{leadRole}/title/{title}")
	public Movie getMovieByLeadRoleAndTitle(@PathVariable String leadRole,@PathVariable String title) {	
		Movie movie  = movieService.getMovieByLeadRoleAndTitle(leadRole, title);
		if(movie==null)			
			throw new MovieNotFoundException("Movie Title/LeadRole is invalid. Please enter correct Title.");
		return movie;
	}	
	
	@GetMapping("title/{title}")
	public Movie getMovieByTitle(@PathVariable String title) {	
		Movie movie  = movieService.getMovieByTitle(title);
		if(movie==null)			
			throw new MovieNotFoundException("Movie Title is invalid. Please enter correct Title.");
		return movie;
	}
	
	
	
}
