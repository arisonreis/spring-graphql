package com.arisonreis.springgraphql.modules.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository repository;

    public record ProductInput(String name, UUID categoryId, Integer price) {}

    @MutationMapping()
    ProductEntity addProducts(@Argument ProductInput productInput) {
        var products = this.repository.save(new ProductEntity(productInput.name(), productInput.categoryId(), productInput.price()));
        //cria o produto e retorna-o
        return products;
    }

    // retorna uma lista de produtos
    @QueryMapping()
   Iterable<ProductEntity>  products(){
       var products =  this.repository.findAll();
       return products;
    }
}
