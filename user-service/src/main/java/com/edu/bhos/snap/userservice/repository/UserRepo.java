package com.edu.bhos.snap.userservice.repository;

import com.edu.bhos.snap.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findById(Integer id);

    @Query("SELECT u FROM User u WHERE u.email=?1 and u.state=true")
    Optional<User> findUserByEmail(String email);

}
