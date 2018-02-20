package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "attribute_value", schema = "public")
public class AttributeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "sqn_attribute_value", sequenceName = "SQN_ATTRIBUTE_VALUE")
    private Long id;

    @Column
    private String value;

    @ManyToOne
    @JoinColumn(name = "attributes_id")
    private Attribute attribute;

    @ManyToOne
    @JoinColumn(name = "products_id")
    @JsonIgnore
    private Product product;

}
