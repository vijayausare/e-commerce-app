package com.vijay.ecommerce.category;

import com.vijay.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Category {
    @Id
    private Integer id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
