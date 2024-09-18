package com.example.ecommerce.services;

import com.example.ecommerce.dtos.FakeProductServiceDTO;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product converrtDtoToProduct(FakeProductServiceDTO fakeProductServiceDTO) {
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
        return converrtDtoToProduct(fakeProductServiceDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
