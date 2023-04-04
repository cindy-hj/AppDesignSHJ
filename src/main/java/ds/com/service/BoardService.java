package ds.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ds.com.model.Board;
import ds.com.repository.BoardRepository;
import jakarta.transaction.Transactional;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	// create
	@Transactional
	public Board createBoard (Board board) {
		return boardRepository.save(board);
	}
	
	// read
	// 전체
	public List<Board> getBoard() {
		return boardRepository.findAll();
	}

	// 제목&pageable
    public Page<Board> getBoardByTitle(String title, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.by("bno").descending());
        return boardRepository.findByTitle(title, pageable);
    }
	
	// update
	@Transactional
	public Board updateBoard(Long bno, Board board) {
		Board boards = boardRepository.findById(bno).get();
		boards.update(board.getTitle(), board.getContent());
		
		return boards;
	}
	
	// delete
	@Transactional
	public Board delete(Long bno) {
		Board deleteBoard = boardRepository.findById(bno).get();
		boardRepository.deleteById(bno);
		return deleteBoard;
	}

}
