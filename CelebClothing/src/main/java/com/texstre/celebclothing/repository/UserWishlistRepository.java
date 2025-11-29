package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.BotiqFollowers;
import com.texstre.celebclothing.entity.UserWishlists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWishlistRepository extends JpaRepository<UserWishlists, Long> {

}
