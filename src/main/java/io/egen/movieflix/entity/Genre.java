package io.egen.movieflix.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQueries({
	@NamedQuery(name = "Genre.findSPecificGenre", query ="Select g from Genre g where g.type=:pgenre"),
})

@Entity
@Table
public class Genre {
	
		
		@GenericGenerator(name = "customUUID", strategy = "uuid2")
		@GeneratedValue(generator = "customUUID")
		@Id
		private String genreId;
		
		

		public String getGenreId() { 
			return genreId;
		}

		public void setGenreId(String genreId) {
			this.genreId = genreId;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		private String type;
		
		@JsonIgnore
		@ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
	    @JoinTable(name="Movie_Genre",
	        joinColumns = @JoinColumn(name="genreId"),
	        inverseJoinColumns = @JoinColumn(name="movieId")
	              )
		private List<Movie> movies;



		public List<Movie> getMovies() {
			return movies;
		}

		public void setMovies(List<Movie> movies) {
			this.movies = movies;
		}

}
