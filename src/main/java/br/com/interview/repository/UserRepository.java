package br.com.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.interview.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
