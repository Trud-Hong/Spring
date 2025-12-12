package com.boot.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.boot.board.answer.Answer;
import com.boot.board.answer.AnswerRepository;
import com.boot.board.question.Question;
import com.boot.board.question.QuestionRepository;
import com.boot.board.question.QuestionService;

@SpringBootTest
class SpringBootBoardApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionService questionService;
	
	@Test
	void contextLoads() {
	}
	/*
	@Test
	void save() {
		
		Question q1 = new Question();
		q1.setSubject("스프링 부트가 뭔가요?");
		q1.setContent("알고 싶어요");
		q1.setCreatedDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("JPA가 뭔가요?");
		q2.setContent("JPA알고 싶어요");
		q2.setCreatedDate(LocalDateTime.now());
		this.questionRepository.save(q2);
		
		Question q3 = new Question();
		q3.setSubject("junit가 뭔가요?");
		q3.setContent("junit알고 싶어요");
		q3.setCreatedDate(LocalDateTime.now());
		this.questionRepository.save(q3);
	}
	
	@Test
	void findAll() {
		
		//모든 데이터 출력
		List<Question> lists = questionRepository.findAll();
		
		assertEquals(2, lists.size());
		
		Question q = lists.get(0);
		assertEquals("스프링 부트가 뭔가요?", q.getSubject());
	}
	
	
	@Test
	void findBySubject() {
		
		Question q = questionRepository.findBySubject("JPA가 뭔가요?");
		assertEquals(2, q.getId());
	}
	
	@Test
	void findBySubjectAndContent() {
		
		Question q = 
				questionRepository
				.findBySubjectAndContent("JPA가 뭔가요?","JPA알고 싶어요");
		assertEquals(2, q.getId());
	}
	
	@Test
	void findBySubjectLike() {
		
		List<Question> lists = questionRepository.findBySubjectLike("스프링%");
		
		Question q = lists.get(0);
		
		assertEquals("알고 싶어요", q.getContent());
	}
	
	@Test
	void update() {
		
		Optional<Question> op = questionRepository.findById(1);
		
		assertTrue(op.isPresent());
		
		Question q = op.get();
		q.setSubject("스프링");
		q.setContent("스프링 부트");
		
		questionRepository.save(q);
	}
	
	
	@Test
	void replySave() {
		
		Optional<Question> op = questionRepository.findById(2);
		
		assertTrue(op.isPresent());
		
		Question q = op.get();
		
		Answer answer = new Answer();
		
		answer.setContent("JPA는 ORM입니다.");
		answer.setQuestion(q);
		answer.setCreatedDate(LocalDateTime.now());
		
		answerRepository.save(answer);
	}
	
	
	@Test
	void replyFind() {
		
		Optional<Answer> op = answerRepository.findById(1);
		
		assertTrue(op.isPresent());
		
		Answer answer = op.get();
		
		assertEquals(2, answer.getQuestion().getId());
		assertEquals("JPA가 뭔가요?", answer.getQuestion().getSubject());
		
	}
	
	
	@Test
	void replyConnectQuestion() {
		
		Optional<Question> op = questionRepository.findById(2);
		
		assertTrue(op.isPresent());
		
		Question q = op.get();
		
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("JPA는 ORM입니다.", answerList.get(0).getContent());
	}
	
	
	@Test
	void save300() {
		
		for(int i = 1;i<=300;i++) {
			
			String subject = 
					String.format("테스트 데이터입니다:[%03d]", i);
			String content = 
					String.format("스프링 부트는 재미있다:[%03d]", i);
			questionService.create(subject, content, null);
		}
	}
	*/
}
