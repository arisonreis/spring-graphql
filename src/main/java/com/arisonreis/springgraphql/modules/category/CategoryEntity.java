package com.arisonreis.springgraphql.modules.category;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "category")
@Table(name = "category", schema = "public")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private UUID id;
    private String name;

    public CategoryEntity(String name){
        this.name = name;
    }

}
