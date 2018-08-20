package top.hting.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sys_user")
@Getter
@Setter
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "t_id")
	private Long id;
	
	@Column(name = "t_name")
	private String name;
	
	@Column(name = "t_age")
	private Integer age;
	
	@Column(name = "t_address")
	private String address;

}
