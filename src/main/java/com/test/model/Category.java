package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "categories", schema = "public")
public class Category {

    @Id
    @GeneratedValue(generator = "sqn_category", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sqn_category", sequenceName = "SQN_CATEGORY", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Attribute> attributes = new HashSet<>();


}
