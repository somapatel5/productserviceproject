package dev.soma.productserviceproject.thirdpartyclients.productsservice.fakestore;

import dev.soma.productserviceproject.dtos.GenericProductDto;
import dev.soma.productserviceproject.exceptions.NotFoundException;
import dev.soma.productserviceproject.thirdpartyclients.productsservice.ThirdPartyProductServiceClient;

import java.util.List;

public class FakeStoreProductServiceClient   implements ThirdPartyProductServiceClient {
    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
