package com.kanaryahaber.abdlkdrkya.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import com.kanaryahaber.abdlkdrkya.business.abstracts.UserService;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.DataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.ErrorResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.Result;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessDataResult;
import com.kanaryahaber.abdlkdrkya.core.utilities.results.SuccessResult;
import com.kanaryahaber.abdlkdrkya.dataAccess.abstracts.UserDao;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Roles;
import com.kanaryahaber.abdlkdrkya.entities.concretes.Users;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result addUser(String email, String password, String passwordRep, String firstName, String lastName,
			String userName) {
		Users user = userDao.getByUserNameOrEmail(userName, email);
		if (user != null) {
			return new ErrorResult(false, "Kullanıcı adı veya mail kayıtlı");
		}
		Users newUser = new Users();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		String encodedPasswordRep = passwordEncoder.encode(passwordRep);
		Roles role = new Roles();
		role.setRoleId(2);
		newUser.setRole(role);
		newUser.setEmail(email);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setUserName(userName);
		newUser.setProfile("/images/futbolcular/noimage.png");
		newUser.setPasswordRep(encodedPasswordRep);
		newUser.setPassword(encodedPassword);
		newUser.setUserKayitTarihi(LocalDate.now());
		userDao.save(newUser);
		return new SuccessResult(true, "Kayıt başarılı");

	}

	@Override
	public Result deleteUser(String userName, String password, String passwordRep) {
		Users uye = userDao.getByUserName(userName);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		boolean isPasswordMatch = passwordEncoder.matches(password, uye.getPassword());
		if (!isPasswordMatch) {
			return new ErrorResult(false, "Girdiğiniz şifre yanlış!");
		}

		userDao.delete(uye);
		return new SuccessResult(true, "Kullanıcı silindi");

	}

	@Override
	public Result changePassword(String userName, String password, String passwordRep, String changedPassword,
			String changedPasswordRep) {
		Users uye = userDao.getByUserName(userName);

		if (uye == null) {
			return new ErrorResult(false, "Kullanıcı bulunamadı");

		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isPasswordMatch = passwordEncoder.matches(password, uye.getPassword());
		if (!isPasswordMatch) {
			return new ErrorResult(false, "Girdiğiniz şifre yanlış");
		}

		String encodedPassword = passwordEncoder.encode(changedPassword);
		String encodedPasswordRep = passwordEncoder.encode(changedPasswordRep);

		uye.setPassword(encodedPassword);
		uye.setPasswordRep(encodedPasswordRep);
		userDao.save(uye);
		return new SuccessResult(true, "Şifre değiştirildi");
	}

	@Override
	public DataResult<Users> logIn(String email, String password) {
		Users uye = userDao.getByUserNameOrEmail("", email);

		if (uye == null) {
			return new ErrorDataResult<Users>(false, "Kullanıcı bulunamadı");
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isPasswordMatch = passwordEncoder.matches(password, uye.getPassword());
		if (!isPasswordMatch) {
			return new ErrorDataResult<Users>(false, "Şifre yanlış");
		}
		if (uye.isUserBanned()) {
			return new ErrorDataResult<Users>(false, "Üyeliğiniz askıya alınmıştır");
		}
		userDao.save(uye);
		return new SuccessDataResult<Users>(uye, true, "Giriş başarılı");

	}

	@Override
	public Result logOut(String userName, String password) {
		Users uye = userDao.getByUserName(userName);
		if (uye == null) {
			return new ErrorResult(false, "Kullanıcı bulunamadı");
		}
		userDao.save(uye);
		return new ErrorResult(false, "Çıkış başarılı");
	}

	@Override
	public DataResult<Users> getByEmail(String userEmail) {
		Users uye = userDao.getByUserNameOrEmail("", userEmail);
		if (uye == null) {
			return new ErrorDataResult<>(false, "Kullanıcı bulunamadı!");
		}
		return new SuccessDataResult<Users>(uye);
	}

	@Override
	public DataResult<List<Users>> getByRoleId(int roleId) {
		return new SuccessDataResult<List<Users>>(this.userDao.getByRole_RoleId(roleId));
	}

	@Override
	public DataResult<Users> getById(int userId) {
		return new SuccessDataResult<Users>(this.userDao.getByUserId(userId));
	}

	@Override
	public Result changeImage(String userName, String image) {
		Users user = this.userDao.getByUserName(userName);
		if (user == null) {
			return new ErrorResult(false, "Resim değiştirilemedi");
		}
		user.setProfile(image);
		this.userDao.saveAndFlush(user);
		return new SuccessResult(true, "Resim değiştir");
	}

	@Override
	public Result userBanla(int userId) {
		Users user = this.userDao.getByUserId(userId);
		if(user == null) {
			return new ErrorResult(false,"Banlanamadı");
		}
		user.setUserBanned(true);
		this.userDao.save(user);
		return new SuccessResult(true,"Kullanıcı banlandı!");
	}

	@Override
	public Result userBanAc(int userId) {
		Users user = this.userDao.getByUserId(userId);
		if(user == null) {
			return new ErrorResult(false,"Ban açılamadı");
		}
		user.setUserBanned(false);
		this.userDao.save(user);
		return new SuccessResult(true,"Kullanıcı banı açıldı!");
	}
}
