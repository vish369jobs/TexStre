package com.texstre.celebclothing.repository;

import com.texstre.celebclothing.entity.ProductDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductDetailsRepository extends CrudRepository<ProductDetails, Long>{
    Optional<List<ProductDetails>> findByFabric(String searchFabric);
}
