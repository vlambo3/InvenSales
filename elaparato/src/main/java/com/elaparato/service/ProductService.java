package com.elaparato.service;
import com.elaparato.model.Product;
import com.elaparato.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository prodRepo;

    @Override
    public List<Product> getProductos() {
        return prodRepo.findAll();
    }

    @Override
    public Product saveProducto(Product prod) {
        return prodRepo.save(prod);
    }

    @Override
    public void deleteProducto(int id) {
        prodRepo.deleteById(id);
    }

    @Override
    public Product findProducto(int id) {

        return prodRepo.findById(id).orElse(null);
    }

    @Override
    public void editProducto(Product prod) {
        this.saveProducto(prod);
    }

}
