package ds.com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ds.com.model.Board;
import ds.com.model.Member;
import ds.com.model.Reply;
import ds.com.repository.BoardRepository;
import ds.com.repository.MemberRepository;
import ds.com.repository.ReplyRepository;

@SpringBootTest
public class AppDesignShjTest {
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	BoardRepository boardRepository;

	@Autowired
	ReplyRepository replyRepository;
	
	@Test
	void save() {
        Member member = new Member();
        member.setEmail("test1@test.com");
        member.setName("test1 user");
        member.setPassword("test1");

        Board board = new Board();
        board.setEmail(member);
        board.setTitle("test1 title");
        board.setContent("test1 content");

        Reply reply = new Reply();
        reply.setText("test1 reply");
        reply.setReplyer("test1 replyer");
        reply.setBno(board);
        
        memberRepository.save(member);
        boardRepository.save(board);
        replyRepository.save(reply);
	}
}
