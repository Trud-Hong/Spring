package com.boot.board.answer;

import java.security.Principal;

import javax.validation.Valid;
import javax.xml.bind.helpers.PrintConversionEventImpl;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.boot.board.question.Question;
import com.boot.board.question.QuestionService;
import com.boot.board.user.SiteUser;
import com.boot.board.user.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final UserService userService;
	
	@PreAuthorize("isAuthenticated")
	@PostMapping("/create/{id}")
	public String createAnswer(Model model,
			@PathVariable("id") Integer id,
			//BoardDTO dto,
			@Valid AnswerForm answerForm,
			BindingResult bindingResult,
			Principal principal) {
		
		Question question = questionService.getQuestion(id);
		SiteUser siteUser = userService.getUser(principal.getName());
		
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("question",question);
			return "question_detail";
		}
		
		Answer answer = answerService.create(question, 
				answerForm.getContent(),siteUser);//answerService.create(question, dto.getcontent());
		
		return String.format("redirect:/question/detail/%s#answer_%s",
				answer.getQuestion().getId(),answer.getId());
	}
	
	@PreAuthorize("isAuthenticated")
	@GetMapping("/modify/{id}")
	public String answerModify(AnswerForm answerForm,
			@PathVariable("id") Integer id, Principal principal) {
		
		Answer answer = answerService.getAnswer(id);
		
		if(!answer.getAuthor().getUserName()
				.equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"수정권한이 없습니다");
		}
		
		answerForm.setContent(answer.getContent());
		
		return "answer_form";
	}
	
	@PreAuthorize("isAuthenticated")
	@PostMapping("/modify/{id}")
	public String answerModify(@Valid AnswerForm answerForm,
			BindingResult bindingResult,
			@PathVariable("id") Integer id, Principal principal) {
		
		if(bindingResult.hasErrors()) {
			return "answer_from";
		}
		
		Answer answer = answerService.getAnswer(id);
		
		if(!answer.getAuthor().getUserName()
				.equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"수정권한이 없습니다");
		}
		
		answerService.modify(answer, answerForm.getContent());
		
		return String.format("redirect:/question/detail/%s#answer_%s",
				answer.getQuestion().getId(),answer.getId());
	}
	
	@PreAuthorize("isAuthenticated")
	@GetMapping("/delete/{id}")
	public String answerDelete(@PathVariable("id") Integer id,
			Principal principal) {
		
		Answer answer = answerService.getAnswer(id);
		
		if(!answer.getAuthor().getUserName()
				.equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"삭제권한이 없습니다");
		}
		
		answerService.delete(answer);
		
		return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
	}
	
	@PreAuthorize("isAuthenticated")
	@GetMapping("/vote/{id}")
	public String answerVote(@PathVariable("id") Integer id,
			Principal principal) {
		
		Answer answer = answerService.getAnswer(id);
		SiteUser siteUser = userService.getUser(principal.getName());
		
		answerService.vote(answer, siteUser);
		
		return String.format("redirect:/question/detail/%s#answer_%s", 
				answer.getQuestion().getId(),answer.getId());
	}
}

