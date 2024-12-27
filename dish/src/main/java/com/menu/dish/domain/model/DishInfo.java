package com.menu.dish.domain.model;

public class DishInfo {
    private String name;
    private int price;
    private String description;
    private String urlImage;
    private String category;

    public DishInfo(String name, int price, String description, String urlImage, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.urlImage = urlImage;
        this.category = category;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUrlImage() { return urlImage; }
    public void setUrlImage(String urlImage) { this.urlImage = urlImage; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
