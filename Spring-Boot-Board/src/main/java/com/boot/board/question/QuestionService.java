package com.boot.board.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.boot.board.DataNotFoundException;
import com.boot.board.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public Page<Question> getLists(Pageable pageable){
		
		/*
		PageRequest : 정렬 매개 변수가 적용된 새 항목을 생성
		getPageNumer() : 반환할 페이지(객체가 0보다 작으면 0으로 초기화)
		getPageSize() : 반환할 항목 수
		pageable : 페이징 된 데이터(10개)
		 */
		
		List<Sort.Order> sorts = new ArrayList<Sort.Order>();
		sorts.add(Sort.Order.desc("createdDate"));
		
		pageable = PageRequest.of(
				pageable.getPageNumber() <= 0 ? 0
						: pageable.getPageNumber() - 1,
							pageable.getPageSize(),Sort.by(sorts)
				);
		
		return questionRepository.findAll(pageable);
	}
	
	public Question getQuestion(Integer id) {
		
		Optional<Question> op = questionRepository.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}else {
			throw new DataNotFoundException("데이터가 없어요!");
		}
	}
	
	public void create(String subject,String content,SiteUser author) {
		
		Question question = new Question();
		
		question.setSubject(subject);
		question.setContent(content);
		question.setCreatedDate(LocalDateTime.now());
		question.setAuthor(author);
		
		
		questionRepository.save(question);
	}
	
	public void modify(Question question,String subject,String content) {
		
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now());
		
		questionRepository.save(question);
	}
	
	public void delete(Question question) {
		
		questionRepository.delete(question);
	}
	
	public void vote(Question question, SiteUser siteUser) {
		
		question.getVoter().add(siteUser);
		
		questionRepository.save(question);
	}

}
