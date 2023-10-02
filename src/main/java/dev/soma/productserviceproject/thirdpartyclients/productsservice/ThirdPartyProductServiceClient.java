package dev.soma.productserviceproject.thirdpartyclients.productsservice;

import dev.soma.productserviceproject.dtos.GenericProductDto;
import dev.soma.productserviceproject.exceptions.NotFoundException;

import java.util.List;

public interface ThirdPartyProductServiceClient {

    List<GenericProductDto> getAllProducts();

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto deleteProduct(Long id);
}
