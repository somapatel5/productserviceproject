package dev.soma.productserviceproject.services;

import dev.soma.productserviceproject.dtos.GenericProductDto;
import dev.soma.productserviceproject.models.Product;

public interface ProductServices {

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id);
}
