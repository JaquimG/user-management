package usersmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import usersmanagement.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
