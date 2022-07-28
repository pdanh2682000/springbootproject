package com.danhuy.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danhuy.dto.MyUser;
import com.danhuy.dto.UserCommentFilmDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.request.PostCommentRequest;
import com.danhuy.service.impl.UserCommentFilmService;
import com.danhuy.utils.SecurityUtils;

@RestController(value = "commentAPIOfWeb")
public class CommentAPI {

	@Autowired
	private UserCommentFilmService userCommentFilmService;
	
	@PostMapping("/web/api/comment")
	public String postComment(@RequestBody PostCommentRequest request) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if(null != authentication && ("anonymousUser").equals(authentication.getName())) {
	    	return "Not authenticated";
	    }
		else {
			MyUser user = SecurityUtils.getPrincipal();
			if(user != null) {
				request.setUserId(user.getId().toString());
			}
			userCommentFilmService.save(request);
			return "success";
		}
	}
	
	@GetMapping("/web/api/comment")
	public OutputResponse<UserCommentFilmDTO> getAllComment(	@RequestParam("filmId") String filmId,
													@RequestParam(value = "pageComment", required = false) String pageComment,
													@RequestParam(value = "limitComment", required = false) String limitComment) {
		OutputResponse<UserCommentFilmDTO> out = new OutputResponse<>();
		List<UserCommentFilmDTO> results = new ArrayList<>();
		if(pageComment == null)
			results = userCommentFilmService.findAllByFilmId(filmId);
		else {
			Pageable pageable = PageRequest.of(Integer.parseInt(pageComment) - 1, Integer.parseInt(limitComment), Sort.by("createdDate").descending());
			results = userCommentFilmService.findAllByFilmId(filmId, pageable);
		}
		out.setResults(results);
		out.setTotalItem(userCommentFilmService.countByFilmId(filmId));
		return out;
	}
}
