package neebal.com.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import neebal.com.DTO.ActorDTO;
import neebal.com.DTO.MovieActorDTO;
import neebal.com.DTO.MovieDTO;
import neebal.com.DTO.MovieRatingDTO;
import neebal.com.DTO.UserDTO;
import neebal.com.DTO.UserFavMovieDTO;
import neebal.com.entity.Actor;
import neebal.com.entity.Movie;
import neebal.com.entity.MovieRating;
import neebal.com.entity.User;
import neebal.com.entity.UserFavMovie;
import neebal.com.repository.ActorRepo;
import neebal.com.repository.MovieRatingRepo;
import neebal.com.repository.MovieRepo;
import neebal.com.repository.RegisterRepo;
import neebal.com.repository.UserFavMovieRepo;

@Service
public class MovieService {
	@Autowired
	private MovieRepo movieRepo;// we inject this object when we create the object of Postserviceclass
	@Autowired
	private UserFavMovieRepo userFavMovieRepo;
	@Autowired
	private RegisterRepo userRepo;
	@Autowired
	private ActorRepo actorRepo;
	@Autowired
	private MovieRatingRepo movieRatingRepo;
	@Autowired
	private RegisterService registerService;

	public List<MovieDTO> getMovie(int limit, int offset, String title) {
		Page<Movie> page;
		Pageable pageable = PageRequest.of(offset, limit);
		List<MovieDTO> list = new ArrayList<>();
		if (title == null) {
			page = movieRepo.findAllByOrderByTitleAsc(pageable);
		} else {

			page = movieRepo.findBytitleContainingOrderByTitleAsc(title, pageable);

		}
		for (Movie movie : page) {
			list.add(new MovieDTO(movie.getMovieid(), movie.getTitle(), movie.getDescription(), movie.getImageurl(),
					movie.getReleasedate(), movie.getLength(), movie.getRating(), getAverageRating(movie.getMovieid()),
					movie.getGenre(),movie.getActor()));
			
		}

		return list;
	}

	public List<MovieDTO> getGenre(String genre) {
		List<MovieDTO> list = new ArrayList<>();
		List<Movie> movies = this.movieRepo.findBygenreLike(genre);
		
		for (Movie movie : movies) {

			list.add(new MovieDTO(movie.getMovieid(), movie.getTitle(), movie.getDescription(), movie.getImageurl(),
					movie.getReleasedate(), movie.getLength(), movie.getRating(),getAverageRating(movie.getMovieid()),
					movie.getGenre(), movie.getActor()));
		}
		return list;

	}

	public Optional<MovieDTO> getMovieId(int id) {
		Optional<Movie> movie1 = movieRepo.findById(id);
		Movie movie = movie1.get();
		return Optional.of(new MovieDTO(movie.getMovieid(), movie.getTitle(), movie.getDescription(),
				movie.getImageurl(), movie.getReleasedate(), movie.getLength(), movie.getRating(),getAverageRating(movie.getMovieid()),
				movie.getGenre(), movie.getActor()));
	}
	

	public List<UserFavMovieDTO> getUserFavMovie(int id) {
		List<UserFavMovieDTO> list = new ArrayList<>();
		List<UserFavMovie> userfavmovie1 = userFavMovieRepo.findByUserUserid(id);
		for (UserFavMovie userfavmovie : userfavmovie1) {
			MovieDTO movieDTO = getMovieId(userfavmovie.getMovie().getMovieid()).get();
			UserDTO userDTO = registerService.getUserId(userfavmovie.getUser().getUserid()).get();
			list.add(new UserFavMovieDTO(userfavmovie.getId(), movieDTO, userDTO));
		}
		return list;

	}

	public UserFavMovie userFavMovie(UserFavMovieDTO userFavMovieDTO) throws Exception {
		Optional<Movie> movie = movieRepo.findById(userFavMovieDTO.getMovie().getMovieid());
		Optional<User> user = userRepo.findById(userFavMovieDTO.getUser().getUserid());
		return userFavMovieRepo.save(new UserFavMovie(userFavMovieDTO.getId(), movie.get(), user.get()));
	}

	public void removeFavMovie(UserFavMovieDTO userFavMovieDTO) throws Exception {
		userFavMovieRepo.deleteById(userFavMovieDTO.getId());
	}

	public List<MovieRatingDTO> getMovieRatingMovie(int id) {

		List<MovieRatingDTO> list = new ArrayList<>();
		List<MovieRating> movierating1 = movieRatingRepo.findByMovieMovieid(id);
		for (MovieRating movierating : movierating1) {
			MovieDTO movieDTO = getMovieId(movierating.getMovie().getMovieid()).get();
			UserDTO userDTO = registerService.getUserId(movierating.getUser().getUserid()).get();
			list.add(new MovieRatingDTO(movierating.getId(), movieDTO, userDTO, movierating.getRating(),
					movierating.getComment(), movierating.getTimestamp()));
		}
		return list;

	}

	public List<MovieRatingDTO> getMovieRatingUser(int id) {

		List<MovieRatingDTO> list = new ArrayList<>();
		List<MovieRating> movies = movieRatingRepo.findByUserUserid(id);
		for (MovieRating movie : movies) {
			MovieDTO movieDTO = getMovieId(movie.getMovie().getMovieid()).get();
			UserDTO userDTO = registerService.getUserId(movie.getUser().getUserid()).get();
			list.add(new MovieRatingDTO(movie.getId(), movieDTO, userDTO, movie.getRating(), movie.getComment(),
					movie.getTimestamp()));
		}
		return list;

	}

	public MovieRating addMovieRating(MovieRatingDTO movieRatingDTO) throws Exception {
		Optional<Movie> movie = movieRepo.findById(movieRatingDTO.getMovie().getMovieid());
		Optional<User> user = userRepo.findById(movieRatingDTO.getUser().getUserid());
		if(movieRatingDTO.getComment().isEmpty())
		{
		return movieRatingRepo.save(new MovieRating(movie.get(), user.get(), movieRatingDTO.getRating(),
				movieRatingDTO.getComment(), movieRatingDTO.getTimestamp()));
		}else if(movieRatingDTO.getComment().length()>=5)
		{
			return movieRatingRepo.save(new MovieRating(movie.get(), user.get(), movieRatingDTO.getRating(),
					movieRatingDTO.getComment(), movieRatingDTO.getTimestamp()));
		}else
		{
			throw new Exception("Review Length Must be Greater Than 5 ");
		}
	}

	public MovieRating updateMovieRating(MovieRatingDTO movieRatingDTO) throws Exception {

		Optional<Movie> movie = movieRepo.findById(movieRatingDTO.getMovie().getMovieid());
		Optional<User> user = userRepo.findById(movieRatingDTO.getUser().getUserid());
		return movieRatingRepo.save(new MovieRating(movieRatingDTO.getId(), movie.get(), user.get(),
				movieRatingDTO.getRating(), movieRatingDTO.getComment(), movieRatingDTO.getTimestamp()));
	}
	
	public Integer getAverageRating(int id)
	{
		return movieRatingRepo.getAverageRating(id);
	}
	
	
	public Actor saveActor(ActorDTO actorDTO) throws Exception {

		return actorRepo.save(new Actor(actorDTO.getActorid(), actorDTO.getFirstname(), actorDTO.getLastname(),
				actorDTO.getImageurl(), actorDTO.getMovies()));
	}

	public void movie(Movie movie) {
		movieRepo.save(movie);
	}

}
