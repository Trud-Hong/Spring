package com.boot.board.dto;

import java.time.LocalTime;
import java.util.List;

import com.boot.board.answer.Answer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	
	private Integer id;
	private String subject;
	private String content;
	private LocalTime createdDate;
	private List<Answer> answerList;
}
