package com.shubham.springboot.productcatalog.controllers;

import com.shubham.springboot.productcatalog.dtos.CategoryDto;
import com.shubham.springboot.productcatalog.dtos.ProductDto;
import com.shubham.springboot.productcatalog.models.Category;
import com.shubham.springboot.productcatalog.models.Product;
import com.shubham.springboot.productcatalog.services.IProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")

public class ProductController {

    @Autowired
    @Qualifier("productCatalog")
    IProductService productService;

    

    //ResponseEntity is used to add customers http status codes and headers

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(value="id") Long id) {
            if(id<=0)
                throw new IllegalArgumentException("Invalid ProductId");

            ProductDto productDto = getProductDto(productService.getProductById(id));
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Requested By", "Shubham Ahir");
            return new ResponseEntity<>(productDto, headers, HttpStatus.OK);
    }

    @PostMapping()
    public ProductDto addProduct(@RequestBody ProductDto productDto) {

        Product product = getProduct(productDto);

        product = productService.createProduct(product);

        return getProductDto(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> replaceProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        Product product = getProduct(productDto);
        product=productService.replaceProduct(id, product);
        productDto = getProductDto(product);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDtos = products.stream().map(this::getProductDto).toList();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    private ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setDescription(product.getDescription());
        if(product.getCategory() != null) {
            CategoryDto category = new CategoryDto();
            category.setId(product.getCategory().getId());
            category.setName(product.getCategory().getName());
            productDto.setCategory(category);
        }
        return productDto;
    }

    private Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            product.setCategory(category);
        }
        return product;
    }
}
