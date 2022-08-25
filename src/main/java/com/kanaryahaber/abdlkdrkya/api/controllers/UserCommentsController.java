package com.kanaryahaber.abdlkdrkya.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kanaryahaber.abdlkdrkya.business.abstracts.CommentsUserLikedService;
import com.kanaryahaber.abdlkdrkya.business.abstracts.UserCommentsService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.UserComments;

@RestController
@RequestMapping("/api/user-comments")
@CrossOrigin
public class UserCommentsController {

	private UserCommentsService userCommentsService;
	private CommentsUserLikedService commentsUserLikedService;
	
	public UserCommentsController(UserCommentsService userCommentsService,CommentsUserLikedService commentsUserLikedService) {
		super();
		this.userCommentsService = userCommentsService;
		this.commentsUserLikedService = commentsUserLikedService;
	}
	
	
	@GetMapping("/kullanici-yorumlari-getir")
	public DataResult<List<UserComments>> yorumlariGetirByUserId(@RequestParam int userId) {
		return this.userCommentsService.yorumlariGetirByUserId(userId);
	}
	
	@GetMapping("/haber-yorumlari-getir")
	public DataResult<List<UserComments>> yorumlariGetirByHaberId(@RequestParam int haberId){
		return this.userCommentsService.yorumlariGetirByHaberId(haberId);
	}

	@PostMapping("/yorum-ekle")
	public Result yorumEkle(@RequestParam int userId,@RequestParam int haberId,@RequestParam String yorumIcerik) {
		return this.userCommentsService.yorumEkle(userId, haberId, yorumIcerik);
	}
	
	@GetMapping("/kullanici-begenilen-yorumlar")
	public DataResult<List<UserComments>> begenilenYorumlariGetirByUserId(int userId){
		return this.userCommentsService.begenilenYorumlariGetirByUserId(userId);
	}
	
	@GetMapping("/kullanici-begenilmeyen-yorumlar")
	public DataResult<List<UserComments>> begenilmeyenYorumlariGetirByUserId(int userId){
		return this.userCommentsService.begenilmeyenYorumlariGetirByUserId(userId);
	}
	
	@PostMapping("/yorum-sil")
	public Result yorumSil(int yorumId) {
		return this.userCommentsService.yorumSil(yorumId);
	}
	@PostMapping("/yorum-like")
	public Result yorumLike(int yorumId,int userId) {
		return this.commentsUserLikedService.kullaniciYorumBegen(userId, yorumId);
	}
	
	@PostMapping("/yorum-dislike")
	public Result yorumDislike(int yorumId,int userId) {
		return this.commentsUserLikedService.kullaniciYorumBegenme(userId, yorumId);
	}
	
	
}
