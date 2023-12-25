package org.example.salesservice.service;

import org.example.salesservice.entities.Sale;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SalesServiceInterface {
    public List<Sale> getAllSales();
    public Sale getSale(Integer id);
    public void addSale(Sale sale);
    public void updateSale(Integer id, Sale sale);
    public void deleteSale(Integer id);
    public void updateStatus(Integer id, String status);
    public List<Sale> getMySales(String clientID);
}
