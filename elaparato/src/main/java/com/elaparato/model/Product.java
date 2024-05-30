package com.elaparato.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "producto_seq")
    @SequenceGenerator(name = "producto_seq", sequenceName = "producto_seq", allocationSize = 1, initialValue = 6)
    private int id;
    @Column(name ="nombre")
    private String name;
    @Column(name ="descripcion")
    private String description;
    @Column(name ="precio")
    private double price;
    @Column(name ="cantidad")
    private int quantity;

    //@JoinColumn (name="id_venta")
    @ManyToMany
    @JsonIgnore //importante agregar para evitar errores de formato en la response
    private List<Sale> salesList;

}
