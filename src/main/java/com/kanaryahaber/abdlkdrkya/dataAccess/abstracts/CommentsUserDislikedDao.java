package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserDisliked;

public interface CommentsUserDislikedDao extends JpaRepository<CommentsUserDisliked, Integer> {
	
	List<CommentsUserDisliked> getByKullaniciDisliked_UserId(int userId);

	CommentsUserDisliked getByKullaniciDisliked_UserIdAndUserCommentDislikedYorumId(int userId, int yorumId);
	
	List<CommentsUserDisliked> getByUserCommentDislikedYorumId(int yorumId);
}
