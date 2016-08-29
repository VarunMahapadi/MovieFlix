package io.egen.movieflix.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table
@NamedQueries({
	//@NamedQuery(name = "Type.findSeries", query ="Select t from Type t join t.Movie m where  t.type='series' order by m.imdbRatings "),
	@NamedQuery(name = "Type.findMovies", query ="Select t from Type t where t.type='movie' "),
	@NamedQuery(name = "Type.findSeries", query ="Select t from Type t where t.type='series' ")
})
public class Type {
	
	
	
		
		@GenericGenerator(name = "customUUID", strategy = "uuid2")
		@GeneratedValue(generator = "customUUID")
		@Id
		private String typeId;
		
		


		public String getTypeId() {
			return typeId;
		}


		public void setTypeId(String typeId) {
			this.typeId = typeId;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}


		public List<Movie> getMovies() {
			return movies;
		}


		public void setMovies(List<Movie> movies) {
			this.movies = movies;
		}


		private String type;
		
		
		@OneToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER )
	    @JoinTable(name="Movie_Type",
	        joinColumns = @JoinColumn(name="typeId"),
	        inverseJoinColumns = @JoinColumn(name="movieId")
	              )
		private List<Movie> movies;



		

}
