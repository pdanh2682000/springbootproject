package com.danhuy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCommentFilmDTO extends AbstractDTO<UserCommentFilmDTO>{

	private String avatarUser;
	private String userName;
	private String content;
}
