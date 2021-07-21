package usersmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import usersmanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
