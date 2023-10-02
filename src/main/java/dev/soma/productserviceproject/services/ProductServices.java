package dev.soma.productserviceproject.services;

import dev.soma.productserviceproject.dtos.GenericProductDto;
import dev.soma.productserviceproject.exceptions.NotFoundException;
import java.util.List;
import java.util.UUID;

public interface ProductServices {

     List<GenericProductDto> getAllProducts();
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;

     GenericProductDto deleteProduct(Long id);

    GenericProductDto updateProductById(Long id);

    List <GenericProductDto> getSpecificCategories();

}
