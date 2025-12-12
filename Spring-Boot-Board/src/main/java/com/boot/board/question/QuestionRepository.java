package com.boot.board.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

	//save,update(save),delete,findById,findAll method가 기본으로 QuestionRepository에 들어가있다.
	//pstmt와 같다
	
	//사용자 정의 메소드
	//findBySubject,findBySubjectAndContent
	
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject,String content);
	List<Question> findBySubjectLike(String subject);
	
	Page<Question> findAll(Pageable pageable);
	
}
