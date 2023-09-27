package dev.soma.productserviceproject.services;

import dev.soma.productserviceproject.dtos.GenericProductDto;
import dev.soma.productserviceproject.models.Product;
import org.springframework.stereotype.Service;


@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductServices{
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

}
