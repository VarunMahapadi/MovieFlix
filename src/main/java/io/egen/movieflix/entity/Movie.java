package io.egen.movieflix.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity; 
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity 
@SqlResultSetMapping(name="abc" ,entities=@EntityResult(entityClass=Movie.class))
@Table 
//@NamedQueries({
//	@NamedQuery(name = "Movie.findMovieDetails", query ="Select m from Movie m where m.title=:ptitle"),
//	@NamedQuery(name = "Movie.filterMoviesByYear", query ="Select m from Movie m where m.year=:pyear"),
//	@NamedQuery(name = "Movie.sortMoviesByImdbRatings", query ="Select m from Movie m order by m.imdbRatings desc"),
//	@NamedQuery(name = "Movie.sortMovieByYear", query ="Select m from Movie m order by m.year desc"),
//	@NamedQuery(name = "Movie.sortMovieByimdbVotes", query ="Select m from Movie m order by m.imdbVotes desc"),
//})

@NamedQueries({
	@NamedQuery(name = "Movie.findMovieDetails", query ="Select m from Movie m where m.title=:ptitle"),
	@NamedQuery(name = "Movie.filterMoviesByYear", query ="Select m from Movie m where m.year=:pyear"),
	@NamedQuery(name = "Movie.sortMoviesByImdbRatings", query ="Select m from Movie m order by m.imdbRatings desc"),
	@NamedQuery(name = "Movie.sortMoviesByYear", query ="Select m from Movie m join Type t1 with t1.type='movie' order by m.year desc"),
	@NamedQuery(name = "Movie.sortSeriesByYear", query ="Select m from Movie m join Type t1 with t1.type='series' order by m.year desc"),
	@NamedQuery(name = "Movie.sortMoviesByimdbVotes", query ="Select m from Movie m join Type t1 with t1.type='movie' order by m.imdbVotes desc"),
	@NamedQuery(name = "Movie.sortSeriesByimdbVotes", query ="Select m from Movie m join Type t1 with t1.type='series' order by m.imdbVotes desc"),
	@NamedQuery(name = "Movie.findTopRatedMovies", query ="Select m from Movie m join Type t1 with t1.type='movie' order by m.imdbRatings desc"),
	@NamedQuery(name = "Movie.findTopRatedSeries",query ="Select m from Movie m join Type t1 with t1.type='series' order by m.imdbRatings desc"), 
})

//@NamedNativeQueries({
//	@NamedNativeQuery(name = "Movie.findTopRatedMovies", query = "select m.* from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='movie' order by m.imdbRatings desc ",resultSetMapping="sexy"),
//	@NamedNativeQuery(name = "Movie.findTopRatedSeries", query = "select m from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='series' order by m.imdbRatings desc "),
//	@NamedNativeQuery(name = "Movie.filterMoviesByYear", query = "select m from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='movie' and m.year=:pyear"),
//	@NamedNativeQuery(name = "Movie.filterMoviesByGenre", query = "select m from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='movie' and t.type=:pgenre"),
//	@NamedNativeQuery(name = "Movie.filterSeriesByGenre", query = "select m from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='series' and t.type=:pgenre"),
//	@NamedNativeQuery(name = "Movie.sortMoviesByImdbRatings", query = "select m.title   from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='movie' order by m.imdbRatings desc"),
//	@NamedNativeQuery(name = "Movie.sortSeriesByImdbRatings", query = "select m.title   from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='series' order by m.imdbRatings desc"),
//	@NamedNativeQuery(name = "Movie.sortMovieByYear", query = "select m.title   from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='movie' order by m.year desc"),
//	@NamedNativeQuery(name = "Movie.sortSeriesByYear", query = "select m.title   from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='series' order by m.year desc"),
//	@NamedNativeQuery(name = "Movie.sortMoviesByvotes", query = "select m.title   from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='movie' order by m.imdbVotes desc"),
//	@NamedNativeQuery(name = "Movie.sortSeriesByvotes", query = "select m.title   from Movie m,Type t,Movie_Type mt where m.movieId =mt.movieId and mt.typeId=t.typeId and t.type ='series' order by m.imdbVotes desc") 
//})


public class Movie {
	
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	@Id
	private String movieId;
	
	private String year;
	
	private String language;
	 
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	private String country;
	
	private String awards;
	
	private String poster;
	
	private String plot;
	
	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	private float imdbRatings;
	
	private String director;
	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	private String writer;
	
	private String actors;
	
	public float getImdbRatings() {
		return imdbRatings;
	}

	public void setImdbRatings(float imdbRatings) {
		this.imdbRatings = imdbRatings;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	private int imdbVotes;
	
	

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String title;
	
//	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
//    @JoinTable(name="Movie_Type",
//      joinColumns = @JoinColumn(name="movieId"),
//      inverseJoinColumns = @JoinColumn(name="typeId")
//            )
//	private Type type;
	
	
	
	
	
	
	@ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
    @JoinTable(name="Movie_Genre",
        joinColumns = @JoinColumn(name="movieId"),
        inverseJoinColumns = @JoinColumn(name="genreId")
              )
	private List<Genre> genres;

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
//	
	
    
}	
