package dev.soma.productserviceproject.controllers;

import dev.soma.productserviceproject.dtos.GenericProductDto;
import dev.soma.productserviceproject.exceptions.NotFoundException;
import dev.soma.productserviceproject.services.ProductServices;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@AllArgsConstructor
@RequestMapping("/products"  )
public class  ProductController {


    private ProductServices productServices;

    public ProductController(@Qualifier("fakeStoreProductService") ProductServices productServices){
        this.productServices = productServices;
    }

    @GetMapping
     public List<GenericProductDto> getAllProduct(){
        return productServices.getAllProducts();
    }

    @GetMapping("/category/")
    public List<GenericProductDto> getProductSpecificCategory() {
        return productServices.getSpecificCategories();

    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException{
        return productServices.getProductById(id) ;

    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathParam("id") Long id){
        return new ResponseEntity<>(
                productServices.deleteProduct(id),
                HttpStatus.NOT_FOUND

        );

    }


   @PostMapping
    public GenericProductDto createaProduct(@RequestBody GenericProductDto product){

          return productServices.createProduct(product);
    }

    @PutMapping("{id}")
    public GenericProductDto updateProductById(@PathVariable("id")Long id){

        return productServices.updateProductById(id);

    }

}
