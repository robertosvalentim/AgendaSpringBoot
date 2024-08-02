package com.agenda.Agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.Agenda.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(Long id);
}
