package com.kanaryahaber.abdlkdrkya.entities.concretes;

import java.time.LocalDate;
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
@Table(name = "user_yorumlari")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "kullaniciBegendigiYorum" })
public class UserComments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "yorum_id")
	private int yorumId;

	@Column(name = "yorum_icerik")
	private String yorumIcerik;

	@Column(name = "yorum_tarihi")
	private LocalDate yorumTarihi;

	@Column(name = "yorum_likes")
	private int yorumLikes;

	@Column(name = "yorum_dislikes")
	private int yorumDislikes;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "haber_id")
	private Haberler haber;

	@OneToMany(mappedBy = "userComment")
	Set<CommentsUserLiked> kullaniciBegendigiYorum;

	@OneToMany(mappedBy = "userCommentDisliked")
	@JsonIgnore
	Set<CommentsUserDisliked> kullaniciBegenmedigiYorum;

}
