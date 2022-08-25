
package com.kanaryahaber.abdlkdrkya.entities.concretes;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "userComments"})

public class Users{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_password")
	private String password;

	@Column(name = "user_firstname")
	private String firstName;

	@Column(name = "user_lastname")
	private String lastName;

	@Column(name = "user_username")
	private String userName;

	@Column(name = "user_password_rep")
	private String passwordRep;

	@Column(name = "user_kayit_tarihi")
	private LocalDate userKayitTarihi;
	
	@Column(name = "user_banned")
	private boolean userBanned;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Roles role;
	
	@Column(name = "user_profile")
	private String profile;
	
	@OneToMany(mappedBy = "user")
    Set<UserComments> userComments;
	
	@OneToMany(mappedBy = "kullanici")
	@JsonIgnore
    Set<CommentsUserLiked> kullaniciBegendigiYorum;
	
	@OneToMany(mappedBy = "kullaniciDisliked")
	@JsonIgnore
    Set<CommentsUserDisliked> kullaniciBegenmedigiYorum;
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Users))
			return false;
		Users user = (Users) o;
		return Objects.equals(userName, user.userName) || Objects.equals(email, user.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, password, email);
	}

	@Override
	public String toString() {
		return "Users{" + "userId=" + userId + ", username='" + userName + '\'' + ", email='" + email + '\'' + ", password='"
				+ password + '\'' +  '}';
	}

}
