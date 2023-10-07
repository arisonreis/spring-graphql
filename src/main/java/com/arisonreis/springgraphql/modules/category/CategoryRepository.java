package com.arisonreis.springgraphql.modules.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
     List<CategoryEntity> findByName(String name);
}
