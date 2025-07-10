package com.essj.wh_shopping.services;


import com.essj.wh_shopping.DTO.ShopDTO;
import com.essj.wh_shopping.entities.Shop;
import com.essj.wh_shopping.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<ShopDTO> findAll(){
        List<Shop> shops = shopRepository.findAll();
        return shops.stream().map(ShopDTO::toDTO).collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier){
        List<Shop> shops=shopRepository.findByUserIdentifier(userIdentifier);
        return shops.stream().map(ShopDTO::toDTO).collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO){
        List<Shop> shops=shopRepository.findAllByDateGreaterThanEqual(shopDTO.getDate());
        return shops.stream().map(ShopDTO::toDTO).collect(Collectors.toList());
    }

    public ShopDTO findById(Long productId){
        Optional<Shop> shop = shopRepository.findById(productId);
        if (shop.isPresent()){
            return ShopDTO.toDTO(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO){

        shopDTO.setTotal(shopDTO.getItems().stream().map(x->x.getPrice()).reduce((float) 0, Float::sum));


        Shop shop = Shop.fromDTO(shopDTO);
        shop.setDate(new Date());

        shop = shopRepository.save(shop);
        return ShopDTO.toDTO(shop);

    }
}
