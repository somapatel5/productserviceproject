package dev.soma.productserviceproject.controllers;

import dev.soma.productserviceproject.dtos.CategoryDto;
import dev.soma.productserviceproject.services.CategoryService;
import dev.soma.productserviceproject.services.ProductServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private  CategoryService categoryService;
    //private ProductServices productServices;


    @GetMapping("")
    public List<String> getAllcategory(){
         return categoryService.getAllcategory();
    }

}
