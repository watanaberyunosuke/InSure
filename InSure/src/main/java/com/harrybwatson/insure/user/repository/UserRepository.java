package com.harrybwatson.insure.user.repository;

import com.harrybwatson.insure.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);

    User findByUserEmail(String userEmail);
}
