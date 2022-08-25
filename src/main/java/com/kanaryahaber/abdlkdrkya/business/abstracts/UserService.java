package com.kanaryahaber.abdlkdrkya.business.abstracts;


import java.util.List;

import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Users;

public interface UserService {
	
	DataResult<Users> getByEmail(String userEmail);
	
	Result addUser(String email, String password, String passwordRep, String firstName, String lastName, String userName);
	
	Result deleteUser(String userName, String password, String passwordRep);
	
	Result changePassword(String userName, String password, String passwordRep,
			String changedPassword,String changedPasswordRep);
	
	DataResult<Users> logIn(String email, String password);
	
	Result logOut(String userName, String password);
	
	DataResult<List<Users>> getByRoleId(int roleId);
	
	DataResult<Users> getById(int userId);
	
	Result changeImage(String userName,String image);
	
	Result userBanla(int userId);
	
	Result userBanAc(int userId);

}
