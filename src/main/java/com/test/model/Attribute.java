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
@Table(name = "attributes", schema = "public")
public class Attribute {

    @Id
    @GeneratedValue(generator = "sqn_attribute", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sqn_attribute", sequenceName = "SQN_ATTRIBUTE", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    @JsonIgnore
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<AttributeValue> attributeValues = new HashSet<>();

}
