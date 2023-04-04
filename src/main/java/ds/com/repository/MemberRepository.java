package ds.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ds.com.model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
