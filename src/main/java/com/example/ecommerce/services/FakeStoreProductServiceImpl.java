package com.example.ecommerce.services;

import com.example.ecommerce.dtos.FakeProductServiceDTO;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertDtoToProduct(FakeProductServiceDTO fakeProductServiceDTO) {
        Product product = new Product();
        product.setId(fakeProductServiceDTO.getId());
        product.setDescription(fakeProductServiceDTO.getDescription());
        product.setImage(fakeProductServiceDTO.getImage());
        product.setPrice(fakeProductServiceDTO.getPrice());
        Category category = new Category();
        category.setName(fakeProductServiceDTO.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductById(long id) {
        FakeProductServiceDTO fakeProductServiceDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeProductServiceDTO.class);
        return convertDtoToProduct(fakeProductServiceDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        ResponseEntity<List<FakeProductServiceDTO>> response = restTemplate.exchange(
                "https://fakestoreapi.com/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FakeProductServiceDTO>>() {}
        );
        List<FakeProductServiceDTO> fakeProductServiceDTOS = response.getBody();
        for(FakeProductServiceDTO fakeProductServiceDTO : fakeProductServiceDTOS) {
            System.out.println(fakeProductServiceDTO.getId());
            products.add(convertDtoToProduct(fakeProductServiceDTO));
        }
        return products;
    }
}
