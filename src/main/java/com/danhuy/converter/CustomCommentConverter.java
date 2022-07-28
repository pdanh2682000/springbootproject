package com.danhuy.converter;

import org.springframework.stereotype.Component;

import com.danhuy.dto.UserCommentFilmDTO;
import com.danhuy.entity.UserCommentFilmEntity;

@Component
public class CustomCommentConverter {

	public UserCommentFilmDTO toDTO(UserCommentFilmDTO dto, UserCommentFilmEntity entity) {
		if(entity.getUser().getAvatar() != null)
			dto.setAvatarUser(entity.getUser().getAvatar());
		else
			dto.setAvatarUser("/avatar/avatar_default.png");
		if(entity.getUser().getFullName() != null)
			dto.setUserName(entity.getUser().getFullName());
		else
			dto.setUserName("Unknown");
		dto.setContent(entity.getContent());
		return dto;
	}
}
