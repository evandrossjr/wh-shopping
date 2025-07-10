package com.essj.wh_shopping.DTO;

import com.essj.wh_shopping.entities.Item;
import com.essj.wh_shopping.entities.Shop;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ShopDTO {

    @NotBlank(message = "userIdentifier não deve estar em branco")
    private String userIdentifier;
    @NotNull
    private float total;

    private Date date;
    @NotNull
    private List<ItemDTO> items;

    public ShopDTO(String userIdentifier, float total, Date date, List<ItemDTO> items) {
        this.userIdentifier = userIdentifier;
        this.total = total;
        this.date = date;
        this.items = items;
    }

    public ShopDTO() {

    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public static ShopDTO toDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());

        shopDTO.setDate(shop.getDate());

        if (shop.getItems() != null) {
            shopDTO.setItems(
                    shop.getItems()
                            .stream()
                            .map(ItemDTO::toDTO)
                            .collect(Collectors.toList())
            );
        }
        return shopDTO;

    }
}