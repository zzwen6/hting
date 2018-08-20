package top.hting.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sys_user")
@Getter
@Setter
@ApiModel(description = "用户信息", value = "用户对象")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "t_id")
	@ApiModelProperty(value = "用户id",name = "id", notes = "用户id")
	private Long id;
	
	
	@Column(name = "t_name")
	@ApiModelProperty(value = "用户名", required = true, name = "name")
	private String name;
	
	@Column(name = "t_age")
	@ApiModelProperty(value = "用户年龄",name = "age")
	private Integer age;
	
	@Column(name = "t_address")
	@ApiModelProperty(value = "地址")
	private String address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<RoleEntity> roles;
	
}
