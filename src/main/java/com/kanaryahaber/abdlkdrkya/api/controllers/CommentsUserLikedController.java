package com.kanaryahaber.abdlkdrkya.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanaryahaber.abdlkdrkya.business.abstracts.CommentsUserLikedService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserDisliked;
import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserLiked;

@RestController
@RequestMapping("/api/kullanici-begendigi-yorumlar")
@CrossOrigin
public class CommentsUserLikedController {

	private CommentsUserLikedService commentsUserLikedService;
	
	public CommentsUserLikedController(CommentsUserLikedService commentsUserLikedService) {
		super();
		this.commentsUserLikedService = commentsUserLikedService;
	}
	
	@GetMapping("/kullaniciya-gore-begeni-getir")
	public DataResult<List<CommentsUserLiked>> getByUserId(int userId){
		return this.commentsUserLikedService.getByUserId(userId);
	}
	
	@GetMapping("/kullaniciya-gore-begenmeme-getir")
	public DataResult<List<CommentsUserDisliked>> dislikedGetByUserId(int userId){
		return this.commentsUserLikedService.dislikedGetByUserId(userId);
	}
	
	@GetMapping("/kullanici-yorum-begeni-info")
	public Result kullaniciBegendigiYorum(int userId, int yorumId) {
		return this.commentsUserLikedService.kullaniciBegendigiYorum(userId, yorumId);
	}
}
