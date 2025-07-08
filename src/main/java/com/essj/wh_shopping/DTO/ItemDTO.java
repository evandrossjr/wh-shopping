package com.essj.wh_shopping.DTO;

import com.essj.wh_shopping.entities.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemDTO {

    @NotBlank
    private String productIdentifier;
    @NotNull
    private float price;

    public ItemDTO() {
    }

    public ItemDTO(String productIdentifier, float price) {
        this.productIdentifier = productIdentifier;
        this.price = price;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static ItemDTO toDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }
}
