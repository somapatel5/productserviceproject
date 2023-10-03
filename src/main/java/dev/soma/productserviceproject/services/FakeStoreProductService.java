package dev.soma.productserviceproject.services;

import dev.soma.productserviceproject.dtos.FakeStoreProductDto;
import dev.soma.productserviceproject.dtos.GenericProductDto;
import dev.soma.productserviceproject.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service("fakeStoreProductService")
public  class FakeStoreProductService implements ProductServices{
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";

    private String productRequesBasetUrl = "https://fakestoreapi.com/products";
    private String categoryType = "men's clothing";
    //List<GenericProductDto> categoryType = getProductSpecificCategory("/category/men's clothing");
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
    this.restTemplateBuilder = restTemplateBuilder;

}

private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto){
    GenericProductDto product = new GenericProductDto();
    product.setId(fakeStoreProductDto.getId());
    product.setImage(fakeStoreProductDto.getImage());
    product.setDescription(fakeStoreProductDto.getDescription());
    product.setTitle(fakeStoreProductDto.getTitle());
    product.setPrice(fakeStoreProductDto.getPrice());
    product.setCategory(fakeStoreProductDto.getCategory());

    return product;
}


//Delete a deleteProduct
    @Override
    public GenericProductDto deleteProduct(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(GenericProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE,requestCallback ,responseExtractor,id);


        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
    }





    //Get all product
    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(productRequesBasetUrl,FakeStoreProductDto[].class);

        List<GenericProductDto> answar = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto: Arrays.stream(response.getBody()).toList()) {


            answar.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));

        }
        return answar;
    }




// post a new product

    @Override
    public  GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response =
                restTemplate.postForEntity(productRequesBasetUrl,product,GenericProductDto.class);

        return response.getBody();
    }


//GET a getProductById
    public GenericProductDto getProductById(Long id) throws NotFoundException {
       // FakeStoreProductService fakeStoreProductService = new FakeStoreProductService();

        RestTemplate restTemplate = restTemplateBuilder.build();
       ResponseEntity<FakeStoreProductDto> response =
               restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class,id);
       //response.getStatusCode();

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if(fakeStoreProductDto == null){
            throw new NotFoundException("product with id : "+ id + " does't exist.");
        }
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
    }


    //UPDATE A PRODUCT
    public GenericProductDto updateProductById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl,
                FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto);
    }



    @Override
    public List<GenericProductDto> getSpecificCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity< FakeStoreProductDto[] > response =
                restTemplate.getForEntity(productRequesBasetUrl,FakeStoreProductDto[].class,categoryType);
        List<GenericProductDto> answar = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto: Arrays.stream(response.getBody()).toList()) {

            if (fakeStoreProductDto.getCategory().equals(categoryType)) {

                answar.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));

            }

        }
        return answar;

    }

}
