package com.kanaryahaber.abdlkdrkya.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "kullanicinin_begenmedigi_yorumlar")
public class CommentsUserDisliked {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "begenmedigi_yorum_id")
	private int dislikedCommentId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users kullaniciDisliked;

	@ManyToOne
	@JoinColumn(name = "yorum_id")
	private UserComments userCommentDisliked;
}
