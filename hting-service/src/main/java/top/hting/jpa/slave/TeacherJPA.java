/**
 * File Name: top.hting.jpa.slave.TeacherJpa.java

 * @Date:2018年8月28日下午10:52:28
 */
package top.hting.jpa.slave;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import top.hting.entity.primary.UserEntity;
import top.hting.entity.slave.Teacher;

/**
 * File Name: top.hting.jpa.slave.TeacherJpa.java
 * 
 * @Date:2018年8月28日下午10:52:28
 */
public interface TeacherJPA extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher>, Serializable{

}
