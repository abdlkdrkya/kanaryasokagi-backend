package com.kanaryahaber.abdlkdrkya.business.abstracts;

import java.util.List;

import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.UserComments;

public interface UserCommentsService {
	DataResult<List<UserComments>> yorumlariGetirByUserId(int userId);
	
	DataResult<List<UserComments>> begenilenYorumlariGetirByUserId(int userId);
	
	DataResult<List<UserComments>> begenilmeyenYorumlariGetirByUserId(int userId);

	DataResult<List<UserComments>> yorumlariGetirByHaberId(int haberId);

	Result yorumEkle(int userId, int haberId, String yorumIcerik);
	
	Result yorumSil(int yorumId);
	
	Result yorumLike(int yorumId,int userId);
	
	Result yorumDislike(int yorumId, int userId);
}
