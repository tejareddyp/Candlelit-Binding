package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<User, Long> {
}
