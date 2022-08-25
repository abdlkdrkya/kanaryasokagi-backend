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
@Table(name = "kullanicinin_begendigi_yorumlar")
public class CommentsUserLiked {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "begendigi_yorum_id")
	private int likedCommentId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users kullanici;

	@ManyToOne
	@JoinColumn(name = "yorum_id")
	private UserComments userComment;

}
