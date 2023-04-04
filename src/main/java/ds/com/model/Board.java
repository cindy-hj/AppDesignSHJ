package ds.com.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "k_board")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Long bno;
	
	@Column(length = 6)
	private LocalDateTime moddate;

	@Column(length = 6)
	private LocalDateTime regdate = LocalDateTime.now();
	
	@Column(length = 255)
	private String content;
	
	@Column(length = 255)
	private String title;
	
	// 외래키 writer_email
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "writer_email")
	@JsonBackReference
	private Member email;

	@JsonManagedReference
	@OneToMany(mappedBy = "bno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Reply> replyItem = new ArrayList<>();

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
}
