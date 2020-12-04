package neebal.com.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import neebal.com.entity.Movie;

public interface MovieRepo extends PagingAndSortingRepository<Movie,Integer> {
	
	public List<Movie> findBygenreLike(String genre);
	public Page<Movie> findBytitleContaining(String title,Pageable pageable );
	
	public Page<Movie> findBytitleContainingOrderByTitleAsc(String title,Pageable pageable );
	public Page<Movie> findAllByOrderByTitleAsc(Pageable pageable );
	
	
	
}
