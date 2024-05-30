package com.elaparato.service;

import com.elaparato.exception.NotFoundException;
import com.elaparato.model.Product;
import com.elaparato.model.Sale;
import com.elaparato.repository.IProductRepository;
import com.elaparato.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private ISaleRepository ventaRepository;

    @Autowired
    private IProductRepository productoRepository;


    @Override
    public List<Sale> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void saveVenta(Sale sale) {

        List<Product> products = new ArrayList<>(sale.getProductList());
        for (Product product : products) {
            Product productPersisted = productoRepository.findById(product.getId()).orElseThrow(
                    () -> new NotFoundException("No se encontró el artículo solicitado")
            );
            if (productPersisted != null) {
                // Asocia el product persistido con la nueva sale
                sale.addProducto(productPersisted);
            }
        }
        ventaRepository.save(sale);
    }

    @Override
    public void deleteVenta(int id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public Sale findVenta(int id) {
       return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void editVenta(Sale vent) {
        this.saveVenta(vent);
    }

    }
