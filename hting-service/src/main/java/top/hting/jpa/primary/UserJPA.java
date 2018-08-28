package top.hting.jpa.primary;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import top.hting.entity.primary.UserEntity;

public interface UserJPA extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>, Serializable{
	
	@Query(value = "select * from sys_user where t_id = ?1", nativeQuery = true)
	UserEntity selectUser(Long id);
	
	
}
