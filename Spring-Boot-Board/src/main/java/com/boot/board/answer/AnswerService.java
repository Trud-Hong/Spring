package com.boot.board.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boot.board.DataNotFoundException;
import com.boot.board.question.Question;
import com.boot.board.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
	
	private final AnswerRepository answerRepository;
	
	public Answer create(Question question,String content,SiteUser author) {
		
		Answer answer = new Answer();
		
		answer.setContent(content);
		answer.setCreatedDate(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setAuthor(author);
		
		answerRepository.save(answer);
		
		return answer;
	}
	
	public Answer getAnswer(Integer id) {
		
		Optional<Answer> answer = answerRepository.findById(id);
		
		if(answer.isPresent()) {
			return answer.get();
		}else {
			throw new DataNotFoundException("Answer Not Found");
		}
	}
	
	public void modify(Answer answer,String content) {
		
		answer.setContent(content);
		answer.setModifyDate(LocalDateTime.now());
		
		answerRepository.save(answer);
	}
	
	//¥Ò±€ªË¡¶
	public void delete(Answer answer) {
		
		answerRepository.delete(answer);
		
	}
	
	public void vote(Answer answer, SiteUser siteUser) {
		
		answer.getVoter().add(siteUser);
		
		answerRepository.save(answer);
	}

}
