package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.UserDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Long>{
    Optional<UserDetails> findOneByContactNum(Integer contactNum);
}
