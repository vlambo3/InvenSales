package com.elaparato.controller;

import com.elaparato.model.Sale;
import com.elaparato.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class SaleController {

    private final ISaleService ventServ;

    //crear una nueva sale
    @PostMapping("/create")
    public String createVentao(@RequestBody Sale sale) {
        ventServ.saveVenta(sale);
        return "Sale creada correctamente";
    }

    //obtener todas las ventas
    @GetMapping("/getall")
    public List<Sale> getVentas () {
        return ventServ.getVentas();
    }

    //Modificar los datos de una venta
    @PutMapping("/edit")
    public String editVenta(@RequestBody Sale vent) {
        ventServ.editVenta(vent);
        return "Sale editada correctamente";
    }


}
