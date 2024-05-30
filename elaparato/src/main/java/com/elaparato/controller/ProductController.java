package com.elaparato.controller;
import com.elaparato.model.Product;
import com.elaparato.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductController {

    private final IProductService prodServ;

    //crear un nuevo producto
    @PostMapping("/create")
    public ResponseEntity<Product> createProducto(@RequestBody Product prod) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prodServ.saveProducto(prod));
    }

    //obtener todos los productos
    @GetMapping("/getall")
    @PreAuthorize("hasAnyRole('admin','repositor')")
    public List<Product> getProductos () {
        return prodServ.getProductos();
    }

   //Modificar los datos de un producto
    @PutMapping("/edit")
    public String editProducto(@RequestBody Product prod) {
        prodServ.editProducto(prod);
        return "Product editado correctamente";
    }
}
