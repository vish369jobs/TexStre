package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Long>{
    UserDetails findById(long id);
}
