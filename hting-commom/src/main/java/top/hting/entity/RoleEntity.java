/**
 * File Name: top.hting.entity.RoleEntity.java

 * @Date:2018年8月20日下午10:20:01
 */
package top.hting.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * File Name: top.hting.entity.RoleEntity.java
 * 
 * @Date:2018年8月20日下午10:20:01
 */
@Entity
@Table(name = "sys_role")
@Getter
@Setter
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "t_role_id")
	private Long roleId;
	
	@Column(name = "t_role_name")
	private String name;
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
//	private List<UserEntity> user;
	
}
