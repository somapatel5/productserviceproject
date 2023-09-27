package dev.soma.productserviceproject.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel{

    private String titlel;
    private  String description;
    private String image;
    private Category category;
    private double price;


}
