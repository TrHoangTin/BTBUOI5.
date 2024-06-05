package com.example.BTBUOI5.Model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Product {
    private int id;
    @NotBlank(message = "ten san pham khong duoc bo trong")
    private String name;
    @Length(min = 0, max = 50, message ="ten hinh anh khong qua 50 ki tu ")
    private String image;
    @NotNull(message = "gia san pham khong bor trong")
    @Min(value = 1, message = "gia san pham khong duoc nho hon 1")
    @Max(value = 999999,message = "gia san pham khong duoc lon hon 999999")
    private long price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

}