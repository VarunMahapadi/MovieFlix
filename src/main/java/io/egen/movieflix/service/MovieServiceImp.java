package io.egen.movieflix.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;





import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.repository.MovieRepository;




@Service
public class MovieServiceImp implements MovieService{
	
	
	@Autowired
	MovieRepository repository;
	
	
	
	
	

	@Override
	public List<Movie> findTopRatedMovies() {
		// TODO Auto-generated method stub
		return repository.findTopRatedMovies();
	}

	@Override
	public List<Movie> findTopRatedSeries() {
		// TODO Auto-generated method stub
		return repository.findTopRatedSeries();
	}

	@Override
	public List<Movie> filterMoviesByYear(String y) {
		// TODO Auto-generated method stub
		return repository.filterMoviesByYear(y);
	}

	@Override
	public List<Movie> filterMoviesByGenre(String g) {
		// TODO Auto-generated method stub
		return repository.filterMoviesByGenre(g);
	}

	@Override
	public List<Movie> filterSeriesByGenre(String g) {
		// TODO Auto-generated method stub
		return repository.filterSeriesByGenre(g);
	}

	@Override
	public List<Movie> sortSeriesByImdbRatings() {
		// TODO Auto-generated method stub
		return repository.sortSeriesByImdbRatings();
	}

	@Override
	public List<Movie> sortMovieByYear() {
		// TODO Auto-generated method stub
		return repository.sortMovieByYear();
	}

	@Override
	public List<Movie> sortSeriesByYear() {
		// TODO Auto-generated method stub
		return repository.sortSeriesByYear();
	}

	@Override
	public List<Movie> sortSeriesByvotes() {
		// TODO Auto-generated method stub
		return repository.sortSeriesByvotes();
	}

	@Override
	public List<Movie> sortMoviesByvotes() {
		// TODO Auto-generated method stub
		return repository.sortMoviesByvotes();
	}

	@Override
	public List<Movie> sortMovieByImdbRatings() {
		// TODO Auto-generated method stub
		return repository.sortMovieByImdbRatings();
	}

	@Override
	public Movie findMovieDetails(String name) {
		// TODO Auto-generated method stub
		return repository.findMovieDetails(name);
	}
//	
//	
	

}
