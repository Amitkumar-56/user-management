package in.ashokit.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
	   UserEntity findByEmail(String email);

	   UserEntity findByEmailAndPwd(String email, String pwd);
	}
