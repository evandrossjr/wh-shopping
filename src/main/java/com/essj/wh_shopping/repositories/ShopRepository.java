package com.essj.wh_shopping.repositories;

import com.essj.wh_shopping.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long>{

    public List<Shop> findByUserIdentifier(String userIdentifier);

    public List<Shop> findAllByTotalGreaterThan(Float total);

    List<Shop> findAllByDateGreaterThanEqual(Date date);
}
