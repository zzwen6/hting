/**
 * File Name: top.hting.entity.slave.Teacher.java

 * @Date:2018年8月28日下午10:43:18
 */
package top.hting.entity.slave;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * File Name: top.hting.entity.slave.Teacher.java
 * 
 * @Date:2018年8月28日下午10:43:18
 */
@Entity
@Table(name = "teacher")
@Getter
@Setter
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "t_id")
	private Long id;
	
	private String name;
	
}
