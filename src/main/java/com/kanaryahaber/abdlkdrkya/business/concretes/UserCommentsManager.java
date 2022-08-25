package com.kanaryahaber.abdlkdrkya.business.concretes;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kanaryahaber.abdlkdrkya.business.abstracts.UserCommentsService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessResult;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.CommentsUserDislikedDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.CommentsUserLikedDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.HaberlerDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.UserCommentsDao;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.UserDao;
import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserDisliked;
import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserLiked;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Haberler;
import com.kanaryahaber.abdlkdrkya.entities.concretes.UserComments;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Users;

@Service
public class UserCommentsManager implements UserCommentsService {

	private UserCommentsDao userCommentsDao;
	private UserDao userDao;
	private HaberlerDao haberlerDao;
	private CommentsUserLikedDao commentsUserLikedDao;
	private CommentsUserDislikedDao commentsUserDislikedDao;

	@Autowired
	public UserCommentsManager(UserCommentsDao userCommentsDao, UserDao userDao, HaberlerDao haberlerDao, CommentsUserLikedDao commentsUserLikedDao,
			CommentsUserDislikedDao commentsUserDislikedDao) {
		super();
		this.userCommentsDao = userCommentsDao;
		this.userDao = userDao;
		this.haberlerDao = haberlerDao;
		this.commentsUserLikedDao = commentsUserLikedDao;
		this.commentsUserDislikedDao = commentsUserDislikedDao;
	}

	@Override
	public DataResult<List<UserComments>> yorumlariGetirByUserId(int userId) {
		Users user = this.userDao.getByUserId(userId);
		if (user == null) {
			return new ErrorDataResult<>(false, "Kullanıcı bulunamadı");
		}
		Sort sort = Sort.by(Sort.Direction.DESC, "yorumTarihi");
		return new SuccessDataResult<List<UserComments>>(this.userCommentsDao.getByUser_UserId(userId, sort));
	}

	@Override
	public DataResult<List<UserComments>> begenilenYorumlariGetirByUserId(int userId) {
		Users user = this.userDao.getByUserId(userId);
		if (user == null) {
			return new ErrorDataResult<>(false, "Kullanıcı bulunamadı");
		}
		Sort sort = Sort.by(Sort.Direction.DESC, "yorumLikes");
		return new SuccessDataResult<List<UserComments>>(this.userCommentsDao.getByUser_UserId(userId, sort));
	}

	@Override
	public DataResult<List<UserComments>> begenilmeyenYorumlariGetirByUserId(int userId) {
		Users user = this.userDao.getByUserId(userId);
		if (user == null) {
			return new ErrorDataResult<>(false, "Kullanıcı bulunamadı");
		}
		Sort sort = Sort.by(Sort.Direction.DESC, "yorumDislikes");
		return new SuccessDataResult<List<UserComments>>(this.userCommentsDao.getByUser_UserId(userId, sort));
	}

	@Override
	public DataResult<List<UserComments>> yorumlariGetirByHaberId(int haberId) {
		Haberler haber = this.haberlerDao.getByHaberId(haberId);
		if (haber == null) {
			return new ErrorDataResult<>(false, "Haber bulunamadı");
		}
		Sort sort = Sort.by(Sort.Direction.DESC, "yorumTarihi");
		return new SuccessDataResult<List<UserComments>>(this.userCommentsDao.getByHaber_HaberId(haberId, sort));
	}

	@Override
	public Result yorumEkle(int userId, int haberId, String yorumIcerik) {
		Users user = this.userDao.getByUserId(userId);
		Haberler haber = this.haberlerDao.getByHaberId(haberId);
		if (user == null || haber == null) {
			return new ErrorResult(false, "Haber veya kullanıcı bulunamadı");
		}
		String[] bol = yorumIcerik.split(" ");
		for (String string : bol) {
			if (string.contentEquals("sik") || string.contentEquals("am") || string.contentEquals("yarrak")
					|| string.contentEquals("göt") || string.contentEquals("yarak") || string.contentEquals("yarrrak")
					|| string.contentEquals("sikik")) {
				return new ErrorResult(false, "Uygunsuz içerik");
			}
		}
		UserComments yorum = new UserComments();
		yorum.setHaber(haber);
		yorum.setUser(user);
		yorum.setYorumDislikes(0);
		yorum.setYorumLikes(0);
		yorum.setYorumIcerik(yorumIcerik);
		yorum.setYorumTarihi(LocalDate.now());
		this.userCommentsDao.save(yorum);
		return new SuccessResult(true, "Yorum eklendi");
	}

	@Override
	public Result yorumSil(int yorumId) {
		UserComments yorum = this.userCommentsDao.getByYorumId(yorumId);
		if (yorum == null) {
			return new ErrorResult(false, "Yorum bulunamadı");
		}
		List<CommentsUserDisliked> as = this.commentsUserDislikedDao.getByUserCommentDislikedYorumId(yorumId);
		List<CommentsUserLiked> ad = this.commentsUserLikedDao.getByUserCommentYorumId(yorumId);
		if(as != null) {
			for (CommentsUserDisliked commentsUserDisliked : as) {
				commentsUserDisliked.setKullaniciDisliked(null);
				commentsUserDisliked.setUserCommentDisliked(null);
				this.commentsUserDislikedDao.delete(commentsUserDisliked);
			}
		}
		if(ad != null) {
			for (CommentsUserLiked commentsUserLiked : ad) {
				commentsUserLiked.setKullanici(null);
				commentsUserLiked.setUserComment(null);
				this.commentsUserLikedDao.delete(commentsUserLiked);
			}
		}
		this.userCommentsDao.delete(yorum);
		return new SuccessResult(true, "Yorum silindi");
	}

	@Override
	public Result yorumLike(int yorumId, int userId) {
		UserComments yorum = this.userCommentsDao.getByYorumId(yorumId);
		Users kullanici = this.userDao.getByUserId(userId);
		if (yorum == null) {
			return new ErrorResult(false, "Yorum bulunamadı");
		}
		int like = yorum.getYorumLikes();
		like += 1;
		yorum.setYorumLikes(like);
		this.userDao.save(kullanici);
		this.userCommentsDao.save(yorum);
		return new SuccessResult(true, "Yorum beğenildi");
	}

	@Override
	public Result yorumDislike(int yorumId, int userId) {
		UserComments yorum = this.userCommentsDao.getByYorumId(yorumId);
		if (yorum == null) {
			return new ErrorResult(false, "Yorum bulunamadı");
		}
		int dislike = yorum.getYorumDislikes();
		dislike += 1;
		yorum.setYorumDislikes(dislike);
		this.userCommentsDao.save(yorum);
		return new SuccessResult(true, "Yorum beğenilmedi");
	}

}
