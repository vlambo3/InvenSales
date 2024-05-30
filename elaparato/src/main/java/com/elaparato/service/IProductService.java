package com.elaparato.service;

import com.elaparato.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getProductos();

    public Product saveProducto(Product prod);

    public void deleteProducto(int id);

    public Product findProducto(int id);

    public void editProducto(Product prod);

}
