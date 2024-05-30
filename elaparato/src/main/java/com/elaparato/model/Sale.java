package com.elaparato.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "venta")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "venta_seq")
    @SequenceGenerator(name = "venta_seq", sequenceName = "venta_seq", allocationSize = 1, initialValue = 6)
    private int id_venta;
    @Column(name = "fecha")
    private LocalDate date;
    @ManyToMany (mappedBy = "salesList", cascade = CascadeType.MERGE)
    private List<Product> productList;

    public void addProducto(Product product) {
        productList.add(product);
        product.getSalesList().add(this);
    }
}
