package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserLiked;

public interface CommentsUserLikedDao extends JpaRepository<CommentsUserLiked, Integer>{

	List<CommentsUserLiked> getByKullanici_UserId(int userId);
	
	CommentsUserLiked getByKullanici_UserIdAndUserCommentYorumId(int userId, int yorumId);
	
	List<CommentsUserLiked> getByUserCommentYorumId(int yorumId);
}
