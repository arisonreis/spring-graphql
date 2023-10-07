package com.arisonreis.springgraphql.modules.category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class CategoryController {
    //TODO Para visualização e query's basta abrir localhost:8080/graphiql
    @Autowired
    private CategoryRepository repository;

    // Criando o record para tipar a entrada de dados no método AddCategory
    record CategoryInput(String name) {
    }

    // Método que recebe o name e adiciona uma category
    @MutationMapping()
    CategoryEntity addCategory(@Argument CategoryInput category) {
        var categoryCreated = this.repository.save(new CategoryEntity(category.name));
        return categoryCreated;
    }

    // "@Argument" -> sinaliza que receberá um argumento do tipo UUID na variável id
    // Optional <CategoryEntity> CategoryById -> Retorno (opicional) do tipo <CategoryEntity> cujo método é CategoryById
    // @QueryMapping -> anota a classe como uma query graphql
    @QueryMapping()
    Optional<CategoryEntity> categoryById(@Argument UUID id) {
        var category = this.repository.findById(id);
        return category;
        //TODO verificar se o nome dos métodos estão de acordo com o schema.graphiql
    }

    @QueryMapping
    Iterable <CategoryEntity> categories(){
        var categories =  repository.findAll();
        return categories;
    }
}
