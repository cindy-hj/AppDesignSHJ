package ds.com.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ds.com.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findByTitle(String title);

	Page<Board> findByTitle(String title, Pageable pageable);

}
