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

public class ShopDTO {

    @NotBlank
    private String userIdentifier;
    @NotNull
    private float total;
    @NotNull
    private Date date;
    @NotNull
    private List<Item> items;

    public ShopDTO(String userIdentifier, float total, Date date, List<Item> items) {
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static ShopDTO toDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;

    }
}