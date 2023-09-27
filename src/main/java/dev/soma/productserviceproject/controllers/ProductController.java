package dev.soma.productserviceproject.controllers;

import dev.soma.productserviceproject.dtos.GenericProductDto;
import dev.soma.productserviceproject.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products"  )
public class  ProductController {

  //  @Autowired   // not good practice
    //field injection
    private ProductServices productServices;



    // Dependency injeting by contoller.
    //constructer injection(best one to use )
    public ProductController(@Qualifier("fakeStoreProductService") ProductServices productServices){
        this.productServices = productServices;
    }


    //setter injection
//    @Autowired
//    public  void setProductServices(ProductServices productServices){
//        this.productServices = productServices;
//    }


    @GetMapping
     public  void getAllProducct(){

    }
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        System.out.println("here it is");
        return productServices.getProductById(id) ;

    }

    @DeleteMapping("{id}")
    public void deleteProductById(){

    }


   @PostMapping
    public GenericProductDto createaProduct(@RequestBody GenericProductDto product){

         return productServices.createProduct(product);
    }

    @PutMapping("{id}")
    public void updateProductById(){

    }

}
