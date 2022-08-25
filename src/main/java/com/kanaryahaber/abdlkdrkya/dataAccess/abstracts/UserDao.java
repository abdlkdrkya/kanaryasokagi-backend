package com.kanaryahaber.abdlkdrkya.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanaryahaber.abdlkdrkya.entities.concretes.Users;

public interface UserDao extends JpaRepository<Users, Integer>{

	List<Users> getByRole_RoleId(int roleId);
	Users getByUserId(int userId);
	Users getByUserName(String userName);
	Users getByUserNameOrEmail(String userName,String email);
	Users getByUserNameAndPassword(String userName,String password);
	Users getByUserNameAndPasswordAndPasswordRep(String userName,String password,
			String passwordRep);
	List<Users> getByEmail(String email);
}
