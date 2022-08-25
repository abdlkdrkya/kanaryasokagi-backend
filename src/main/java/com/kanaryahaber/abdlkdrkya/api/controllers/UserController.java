package com.kanaryahaber.abdlkdrkya.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kanaryahaber.abdlkdrkya.business.abstracts.UserService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Users;


@RestController
@RequestMapping("api/kullanicilar")
@CrossOrigin 
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	
	@PostMapping("/kullaniciekle")
	public Result addUser(@RequestParam String email,@RequestParam String password,@RequestParam String passwordRep,@RequestParam String firstName,@RequestParam String lastName, @RequestParam String userName) {
		return this.userService.addUser(email, password, passwordRep, firstName, lastName, userName);
	}
	
	@PostMapping("/kullanicisil")
	public Result deleteUser(String userName, String password,
			String passwordRep) {
		return this.userService.deleteUser(userName,password,passwordRep);
	}
  
	@PostMapping("/giris")
	public Result logIn(String email, String password) {
		return this.userService.logIn(email,password);
	}
	
	@PostMapping("/cikis")
	public Result logOut(@RequestParam String userName,@RequestParam String password) {
		return this.userService.logOut(userName,password);
	}
	
	@PatchMapping("/sifre-guncelleme")
	public Result changePassword(String userName, String password, String passwordRep,
			String changedPassword,String changedPasswordRep) {
		return this.userService.changePassword(userName,password,passwordRep,changedPassword,
				changedPasswordRep);
	}
	
	@GetMapping("/kullanici")
	public DataResult<Users> getByEmail(String userEmail){
		return this.userService.getByEmail(userEmail);
	}
	
	@GetMapping("/role-gore-getir")
	public DataResult<List<Users>> getByRoleId(int roleId){
		return this.userService.getByRoleId(roleId);
	}
	
	@GetMapping("id-getir")
	public DataResult<Users> getById(int userId){
		return this.userService.getById(userId);
	}
	
	@PatchMapping("resim-degistir")
	public Result changeImage(String userName, String image) {
		return this.userService.changeImage(userName, image);
	}
	
	@PatchMapping("kullanici_banla")
	public Result userBanla(int userId) {
		return this.userService.userBanla(userId);
	}
	
	@PatchMapping("kullanici_ban-ac")
	public Result userBanAc(int userId) {
		return this.userService.userBanAc(userId);
	}
}
