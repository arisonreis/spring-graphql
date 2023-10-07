package com.arisonreis.springgraphql.modules.product;

import com.arisonreis.springgraphql.modules.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "product")
@Table(schema = "public", name = "product")
@EqualsAndHashCode(of = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private UUID id;
    private String name;
    private Integer price;

    @ManyToOne()
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;
    @Column(name = "category_id")
    private UUID categoryId;

    public ProductEntity(String name, UUID categoryId, Integer price){
        this.name =  name;
        this.price = price;
        this.categoryId=categoryId;
    }
}
