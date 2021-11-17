package com.example.demofan;

public class Food {
    private Integer id;
    private String name;
    private Integer price;
    private String imageUrl;
    private Integer restaurantId;

    public Food() {

    }

    public Food(Integer id, String name, Integer price, String imageUrl, Integer restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.restaurantId = restaurantId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
