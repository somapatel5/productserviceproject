package dev.soma.productserviceproject.services;

import dev.soma.productserviceproject.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductServices{
    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id) {
        return null;
    }


    @Override
    public List<GenericProductDto> getSpecificCategories() {
        return null;
    }


    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }


    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

}
