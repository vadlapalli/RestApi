package in.blogapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.blogapplication.entities.UserDtls;

public interface UserRepo extends JpaRepository<UserDtls, Integer>{
	
	public UserDtls findByEmail(String email);
	
	public UserDtls findByEmailAndPwd(String email,String pwd);

}
