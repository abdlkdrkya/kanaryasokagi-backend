package com.kanaryahaber.abdlkdrkya.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanaryahaber.abdlkdrkya.business.abstracts.CommentsUserLikedService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessResult;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.CommentsUserDislikedDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.CommentsUserLikedDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.UserCommentsDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.UserDao;
import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserDisliked;
import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserLiked;
import com.kanaryahaber.abdlkdrkya.entities.concretes.UserComments;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Users;

@Service
public class CommentsUserLikedManager implements CommentsUserLikedService{

	private CommentsUserLikedDao commentsUserLikedDao;
	private CommentsUserDislikedDao commentsUserDislikedDao;
	private UserDao userDao;
	private UserCommentsDao userCommentsDao;
	
	@Autowired
	public CommentsUserLikedManager(CommentsUserLikedDao commentsUserLikedDao, UserDao userDao,UserCommentsDao userCommentsDao,CommentsUserDislikedDao commentsUserDislikedDao) {
		super();
		this.commentsUserLikedDao = commentsUserLikedDao;
		this.userDao = userDao;
		this.userCommentsDao = userCommentsDao;
		this.commentsUserDislikedDao = commentsUserDislikedDao;
	}
	
	@Override
	public DataResult<List<CommentsUserLiked>> getByUserId(int userId) {
		Users kullanici = this.userDao.getByUserId(userId);
		if(kullanici == null) {
			return new ErrorDataResult<>(false, "Kullanıcı bulunamadı");
		}
		return new SuccessDataResult<List<CommentsUserLiked>>(this.commentsUserLikedDao.getByKullanici_UserId(userId));
	}

	
	@Override
	public Result kullaniciYorumBegen(int userId, int yorumId) {		
		UserComments yorum = this.userCommentsDao.getByYorumId(yorumId);
		if(yorum == null) {
			return new ErrorResult(false,"Yorum bulunamadı!");
		}
		int like = yorum.getYorumLikes();
		Users kullanici = this.userDao.getByUserId(userId);
		if(kullanici == null) {
			return new ErrorResult(false,"Kullanıcı bulunamadı!");
		}
		CommentsUserLiked begendigiYorumTest = this.commentsUserLikedDao.getByKullanici_UserIdAndUserCommentYorumId(userId, yorumId);
		if(begendigiYorumTest != null) {
			this.commentsUserLikedDao.delete(begendigiYorumTest);
			like -= 1;
			yorum.setYorumLikes(like);
			this.userCommentsDao.save(yorum);
			return new ErrorResult(false,"Kullanıcı beğenisi kaldırıldı!");
		}
		int dislike = yorum.getYorumDislikes();
		CommentsUserDisliked begenmedigiYorumTest = this.commentsUserDislikedDao.getByKullaniciDisliked_UserIdAndUserCommentDislikedYorumId(userId, yorumId);
		if(begenmedigiYorumTest != null) {
			this.commentsUserDislikedDao.delete(begenmedigiYorumTest);
			dislike -= 1;
		}
		CommentsUserLiked begendigiYorum = new CommentsUserLiked();
		like += 1;
		yorum.setYorumDislikes(dislike);
		yorum.setYorumLikes(like);
		this.userCommentsDao.save(yorum);
		begendigiYorum.setKullanici(kullanici);
		begendigiYorum.setUserComment(yorum);
		this.commentsUserLikedDao.save(begendigiYorum);
		return new SuccessResult(true,"Yorum beğenisi eklendi!");
	}

	@Override
	public Result kullaniciYorumBegenme(int userId, int yorumId) {		
		UserComments yorum = this.userCommentsDao.getByYorumId(yorumId);
		if(yorum == null) {
			return new ErrorResult(false,"Yorum bulunamadı!");
		}
		int dislike = yorum.getYorumDislikes();
		Users kullanici = this.userDao.getByUserId(userId);
		if(kullanici == null) {
			return new ErrorResult(false,"Kullanıcı bulunamadı!");
		}
		CommentsUserDisliked begenmedigiYorumTest = this.commentsUserDislikedDao.getByKullaniciDisliked_UserIdAndUserCommentDislikedYorumId(userId, yorumId);
		if(begenmedigiYorumTest != null) {
			dislike -= 1;
			yorum.setYorumDislikes(dislike);
			this.userCommentsDao.save(yorum);
			this.commentsUserDislikedDao.delete(begenmedigiYorumTest);
			return new ErrorResult(false,"Kullanıcı bu yorumu daha önce beğenmemiş");
		}
		int like = yorum.getYorumLikes();
		CommentsUserLiked begendigiYorumTest = this.commentsUserLikedDao.getByKullanici_UserIdAndUserCommentYorumId(userId, yorumId);
		if(begendigiYorumTest != null) {
			this.commentsUserLikedDao.delete(begendigiYorumTest);
			like -= 1;
		}
		CommentsUserDisliked begenmedigiYorum = new CommentsUserDisliked();
		dislike += 1;
		yorum.setYorumLikes(like);
		yorum.setYorumDislikes(dislike);
		this.userCommentsDao.save(yorum);
		begenmedigiYorum.setKullaniciDisliked(kullanici);
		begenmedigiYorum.setUserCommentDisliked(yorum);
		this.commentsUserDislikedDao.save(begenmedigiYorum);
		return new SuccessResult(true,"Yorum dislike eklendi!");
	}

	@Override
	public DataResult<List<CommentsUserDisliked>> dislikedGetByUserId(int userId) {
		Users kullanici = this.userDao.getByUserId(userId);
		if(kullanici == null) {
			return new ErrorDataResult<>(false, "Kullanıcı bulunamadı");
		}
		return new SuccessDataResult<List<CommentsUserDisliked>>(this.commentsUserDislikedDao.getByKullaniciDisliked_UserId(userId));
	}

	@Override
	public Result kullaniciBegendigiYorum(int userId, int yorumId) {
		Users kullanici = this.userDao.getByUserId(userId);
		if(kullanici == null) {
			return new ErrorResult(false,"Kullanıcı bulunamadı");
		}
		UserComments yorum = this.userCommentsDao.getByYorumId(yorumId);
		if(yorum == null) {
			return new ErrorResult(false,"Yorum bulunamadı");
		}
		return new SuccessResult(true);
	}



}
