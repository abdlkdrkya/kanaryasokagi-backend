package com.kanaryahaber.abdlkdrkya.business.abstracts;

import java.util.List;

import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserDisliked;
import com.kanaryahaber.abdlkdrkya.entities.concretes.CommentsUserLiked;

public interface CommentsUserLikedService {
	
	DataResult<List<CommentsUserDisliked>> dislikedGetByUserId(int userId); 
	DataResult<List<CommentsUserLiked>> getByUserId(int userId); 
	Result kullaniciYorumBegen(int userId, int yorumId);
	Result kullaniciYorumBegenme(int userId, int yorumId);
	Result kullaniciBegendigiYorum(int userId,int yorumId);

}
