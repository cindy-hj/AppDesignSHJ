package ds.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ds.com.model.Board;
import ds.com.service.BoardService;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// create
	@PostMapping("/api/board/create")
	public ResponseEntity<Board> createBoard(@RequestBody Board board) {
		Board post = boardService.createBoard(board);
		return new ResponseEntity<>(post, HttpStatus.CREATED); 
	}
	
	// read 
	// 전체
	@GetMapping("/api/board/read")
	public ResponseEntity<List<Board>> getBoard() {
		List<Board> boards = boardService.getBoard();
		return new ResponseEntity<List<Board>>(boards, HttpStatus.OK);
	}
	
	// 제목&pageable
	@GetMapping("/api/board/read/{title}")
	public ResponseEntity<Page<Board>> getBoardByTitle(@PathVariable String title, @RequestParam(defaultValue = "0") int pageNo) {
	    Page<Board> boards = boardService.getBoardByTitle(title, pageNo);
	    return new ResponseEntity<Page<Board>>(boards, HttpStatus.OK);
	}
	
	
	// update
	@PutMapping("/api/board/update/{bno}")
	public ResponseEntity<Board> updateBoard(@PathVariable Long bno, @RequestBody Board board) {
		Board updateBoard = boardService.updateBoard(bno, board);
		return new ResponseEntity<>(updateBoard, HttpStatus.ACCEPTED);
	}
	
	// delete
	@DeleteMapping("/api/board/delete/{bno}")
	public ResponseEntity<Board> deleteBoard(@PathVariable Long bno) {
		Board deleteBoard = boardService.delete(bno);
		return new ResponseEntity<>(deleteBoard, HttpStatus.OK);
	}
	
}
