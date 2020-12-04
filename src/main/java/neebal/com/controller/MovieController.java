package neebal.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import neebal.com.DTO.ActorDTO;
import neebal.com.DTO.MovieDTO;
import neebal.com.DTO.MovieRatingDTO;
import neebal.com.DTO.UserDTO;
import neebal.com.DTO.UserFavMovieDTO;
import neebal.com.entity.Actor;
import neebal.com.entity.Movie;
import neebal.com.entity.MovieRating;
import neebal.com.entity.User;
import neebal.com.service.MovieService;

@RestController

public class MovieController {
	@Autowired
	private MovieService service;

	// list of movies
	@RequestMapping(method = RequestMethod.GET, value = "/movies")
	public List<MovieDTO> getMoviesList(@RequestParam("offset") int offset, @RequestParam("limit") int limit,
			@RequestParam(name = "title", required = false) String title) {

		return service.getMovie(limit, offset, title);
	}

	// get single movie by movie id
	@RequestMapping(method = RequestMethod.GET, value = "/movie_id", params = "id")
	public ResponseEntity<MovieDTO> getMovieById(@RequestParam int id) {
		return ResponseEntity.ok().body(service.getMovieId(id).get());
	}

	// filter movie based on genre
	@RequestMapping(method = RequestMethod.GET, value = "/movies_genre", params = "genre")
	public List<MovieDTO> getMovieByGenre(@RequestParam String genre) {
		return service.getGenre(genre);
	}

	// get user fav movie based on user id
	@RequestMapping(method = RequestMethod.GET, value = "/favourite_movies", params = "id") // based on user id
	public List<UserFavMovieDTO> getFavouriteMovies(@RequestParam int id) {
		return service.getUserFavMovie(id);
	}

	// add movie to fav
	@PostMapping(value = "/favorite_movie")
	public void addUserFavMovie(@RequestBody UserFavMovieDTO listelement) throws Exception {
		service.userFavMovie(listelement);
	}

	// remove movie from fav based on id of useFavMovie
	@RequestMapping(method = RequestMethod.DELETE, value = "/favourite_movie", params = "id")
	public void removeFavMovie(@RequestBody UserFavMovieDTO id) throws Exception {
		service.removeFavMovie(id);
	}

	// get rating of movie based on movieid
	@RequestMapping(method = RequestMethod.GET, value = "/rating_movieId", params = "movieid")
	public List<MovieRatingDTO> movieRatingBasedOnMovie(@RequestParam int movieid) throws Exception {
		return service.getMovieRatingMovie(movieid);
	}

	// get rating of movie based on user
	@RequestMapping(method = RequestMethod.GET, value = "/rating_userId", params = "userid")
	public List<MovieRatingDTO> movieRatingBasedOnUser(@RequestParam int userid) throws Exception {
		return service.getMovieRatingUser(userid);
	}

	// post movie rating in table
	@RequestMapping(method = RequestMethod.POST, value = "/movie_rating")
	public void addMovieRating(@RequestBody MovieRatingDTO listelement) throws Exception {
		service.addMovieRating(listelement);
	}

	// update movie rating
	@RequestMapping(method = RequestMethod.PUT, value = "/movie_rating", params = "id")
	public void updateMovieRating(@RequestBody MovieRatingDTO listelement, @RequestParam int id) throws Exception {
		service.updateMovieRating(listelement);
	}

	/*
	 * //Actor creation
	 * 
	 * @PostMapping("/actor") public Actor Actor(@Validated @RequestBody ActorDTO
	 * listelement) throws Exception// annotation is used for converting the
	 * information in proper // format // and associating and initializing value {
	 * return service.saveActor(listelement); }
	 */

}
