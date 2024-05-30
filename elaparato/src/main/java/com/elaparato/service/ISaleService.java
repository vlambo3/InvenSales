package com.elaparato.service;

import com.elaparato.model.Sale;

import java.util.List;

public interface ISaleService {

    public List<Sale> getVentas();


    public void saveVenta(Sale vent);


    //acá en la implementación se puede hacer por ejemplo borrado lógico
    public void deleteVenta(int id);


    public Sale findVenta(int id);

    public void editVenta(Sale vent);

}
