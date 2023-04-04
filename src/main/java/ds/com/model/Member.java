package ds.com.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "k_member")
public class Member {
	@Id
	@Column(length = 255)
	private String email;

	@Column(length = 6)
	private LocalDateTime moddate;
	
	@Column(length = 6)
	private LocalDateTime regdate = LocalDateTime.now();
	
	@Column(length = 255)
	private String name;
	
	@Column(length = 255)
	private String password;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "email", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Board> boardItem = new ArrayList<>();
}
