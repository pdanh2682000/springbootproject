package com.danhuy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user", uniqueConstraints = {
		@UniqueConstraint(columnNames = {
				"username"
		}),
		@UniqueConstraint(columnNames = {
				"email"
		})
})
public class UserEntity extends BaseEntity {

	@Column
	@NotBlank
	@Size(min = 3, max = 50)
	private String username;
	
	@Column
	@NotBlank
	@Size(min = 3, max = 100)
	private String password;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column
	private Integer status;
	
	@Column
	@NotBlank
	@Size(min = 6, max = 100)
	@Email
	private String email;
	
	@Column
	private String phone;
	
	@Column
	@Lob /*
			BLOB - dành cho dữ liệu nhị phân (video, hình ảnh, âm thanh,...)
			CLOB - dành cho dữ liệu văn bản lớn
	 	*/
	private String avatar;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"),
									inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<RoleEntity> roles = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<UserCommentFilmEntity> comments = new ArrayList<>();
}
