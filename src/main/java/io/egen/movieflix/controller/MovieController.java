package io.egen.movieflix.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.service.MovieService;





@RestController
@RequestMapping(path = "movies")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	
	//movie details......DONE
	@RequestMapping(method = RequestMethod.GET,path="/m/details/{movie_name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findMovieDetails(@PathVariable("movie_name") String name) {
		return service.findMovieDetails(name);
	}
	
	
	
	//top rated movies
	@RequestMapping(method = RequestMethod.GET,path="/m/genre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findTopRatedMovies() {
		return service.findTopRatedMovies();
	}
	
	
	//top rated series using imdbratings
	@RequestMapping(method = RequestMethod.GET,path="/s/toprated", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findTopRatedSeries() {
		return service.findTopRatedSeries();
	}
	
	
	//filter movies by year......DONE
	@RequestMapping(method = RequestMethod.GET,path="/m/year/{year}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> filterMoviesByYear(@PathVariable("year") String y) {
		return service.filterMoviesByYear(y);
	}
	
	//filter movies by genre parameterized.............DONE
		@RequestMapping(method = RequestMethod.GET,path="/m/genre/{pgenre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> filterMoviesByGenre(@PathVariable("pgenre") String g) {
			return service.filterMoviesByGenre(g);
		}
		
		
	//filter series by genre parameterized
		@RequestMapping(method = RequestMethod.GET,path="/s/genre/{pgenre}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> filterSeriesByGenre(@PathVariable("pgenre") String g) {
			return service.filterSeriesByGenre(g);
		}	
	
	
		
	//sort movies by imdbratings........DONE
		@RequestMapping(method = RequestMethod.GET,path="/m/sort/imdbratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortMovieByImdbRatings() {
			return service.sortMovieByImdbRatings();
		}
		
	//sort series by imdbratings
		@RequestMapping(method = RequestMethod.GET,path="/s/imdbratings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortSeriesByImdbRatings() {
			return service.sortSeriesByImdbRatings();
		}
		
		
	//sort movies by year......DONE
		@RequestMapping(method = RequestMethod.GET,path="/m/sort/year", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortMovieByYear() {
			return service.sortMovieByYear();
		}
		
	//sort series by year
		@RequestMapping(method = RequestMethod.GET,path="/s/year", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortSeriesByYear() {
			return service.sortSeriesByYear();
		}
		
		
	//sort movies by imdb votes...........DONE
		@RequestMapping(method = RequestMethod.GET,path="/m/sort/imdbvotes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<Movie> sortMoviesByvotes() {
			return service.sortMoviesByvotes();
		}
		
		
		//sort series by imdb votes
				@RequestMapping(method = RequestMethod.GET,path="/s/votes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
				public List<Movie> sortSeriesByvotes() {
					return service.sortSeriesByvotes();
				}	
		
		
			
		
	
	

	
	
	
	
	
	
	
	
	

}
