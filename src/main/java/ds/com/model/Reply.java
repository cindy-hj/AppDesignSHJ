package ds.com.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "k_reply")
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Long rno;
	
	private LocalDateTime moddate;
	
	private LocalDateTime regdate = LocalDateTime.now();
	
	private String replyer;
	
	private String text;
	
	// 외래키
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_bno")
	@JsonBackReference
	private Board bno;
}
