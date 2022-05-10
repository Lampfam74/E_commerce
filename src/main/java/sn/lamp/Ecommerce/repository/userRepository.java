package sn.lamp.Ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.lamp.Ecommerce.model.User;
@Repository
public interface userRepository extends JpaRepository<User , Long>{
	@Query("SELECT DISTINCT U FROM User U where U.email=:email")
	 Optional<User> findByEmail(@Param("email")String email);
}
