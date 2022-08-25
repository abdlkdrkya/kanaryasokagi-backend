package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kanaryahaber.abdlkdrkya.entities.concretes.UserComments;

public interface UserCommentsDao extends JpaRepository<UserComments, Integer> {
	List<UserComments> getByUser_UserId(int userId,Sort sort);
	List<UserComments> getByHaber_HaberId(int haberId,Sort sort);
	UserComments getByYorumId(int yorumId);
}
