package io.egen.movieflix.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entity.Genre;
import io.egen.movieflix.entity.Movie;
import io.egen.movieflix.entity.Type;


@Repository
public class MovieRepositoryImp implements MovieRepository {
	
	
	@PersistenceContext
	public EntityManager em;
	
	
	

	@Override
	/*public List<Movie> findTopRatedMovies() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRatedMovies", Movie.class);
		
		return query.getResultList();

	}*/
	
	public List<Movie> findTopRatedMovies() {
		// TODO Auto-generated method stub
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findSPecificGenre", Genre.class);
		query.setParameter("pgenre", "action");
		Genre movieGenre = query.getResultList().get(0);
		System.out.println(">>>>>>>>>>"+movieGenre.getType());
		return movieGenre.getMovies();
	}
	

	@Override
	public List<Movie> findTopRatedSeries() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopRatedSeries", Movie.class);
		return query.getResultList();  
	}

	@Override
	public List<Movie> filterMoviesByYear(String y) {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.filterMoviesByYear", Movie.class);
		query.setParameter("pyear", y);
		return query.getResultList();
	}

	@Override
	public List<Movie> filterMoviesByGenre(String g) {
		// TODO Auto-generated method stub
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findSPecificGenre", Genre.class);
		query.setParameter("pgenre", g);
		Genre movieGenre = query.getResultList().get(0);
		System.out.println(">>>>>>>>>>"+movieGenre.getType());
		return movieGenre.getMovies();
	}

	@Override
	public List<Movie> filterSeriesByGenre(String g) {
		// TODO Auto-generated method stub
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findSPecificGenre", Genre.class);
		query.setParameter("pgenre", g);
		Genre movieGenre = query.getResultList().get(0);
		System.out.println(">>>>>>>>>>"+movieGenre.getType());
		return movieGenre.getMovies();
	}

	@Override
	public List<Movie> sortSeriesByImdbRatings() {
		// TODO Auto-generated method stub
		TypedQuery<Type> query = em.createNamedQuery("Type.findSeries", Type.class);
		Type type=query.getResultList().get(0);
		return type.getMovies();
	}

	@Override
	public List<Movie> sortMovieByYear() { 
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortMoviesByYear", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortSeriesByYear() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortSeriesByYear", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortSeriesByvotes() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortSeriesByimdbvotes", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortMoviesByvotes() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortMoviesByimdbVotes", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortMovieByImdbRatings() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortMoviesByImdbRatings", Movie.class);
		return query.getResultList();
	}


	@Override
	public Movie findMovieDetails(String name) {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findMovieDetails", Movie.class);
		query.setParameter("ptitle", name);
		Movie movie = query.getResultList().get(0);
		return movie;
	
	}

}
