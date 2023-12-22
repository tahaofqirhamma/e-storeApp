package org.example.salesservice.web;

import org.example.salesservice.Model.Client;
import org.example.salesservice.Model.Product;
import org.example.salesservice.entities.Sale;
import org.example.salesservice.repositories.SalesRepository;
import org.example.salesservice.service.SalesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SalesWebController {
    @Autowired
    SalesServiceInterface salesServiceInterface;

    @Autowired
    SalesRepository salesRepository;


    @GetMapping("/sales")
    public List<Sale> getAllSales(){
        return salesServiceInterface.getAllSales();

    }

    @PostMapping("/sales")
    public void addSale(@RequestBody Sale saleReq){
        Sale sale = new Sale();
        sale.setClientId(saleReq.getClientId());
        sale.setProductId(saleReq.getProductId());
        sale.setSaleDate(saleReq.getSaleDate());
        salesRepository.save(sale);

    }
}
