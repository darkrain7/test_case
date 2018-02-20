package com.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "products", schema = "public")
public class Product {

    @Id
    @GeneratedValue(generator = "sqn_product", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sqn_product", sequenceName = "SQN_PRODUCT", allocationSize = 1)
    private Long id;

    @Column
    private String name;

    @Column
    private String brand_name;

    @Column
    private Long count;

    @Column
    private Long price;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private Set<AttributeValue> attributeValues = new HashSet<>();

}
