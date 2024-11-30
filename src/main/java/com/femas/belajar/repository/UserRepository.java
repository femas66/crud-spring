package com.femas.belajar.repository;

import com.femas.belajar.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
