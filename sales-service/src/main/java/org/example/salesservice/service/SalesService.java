package org.example.salesservice.service;

import jakarta.transaction.Transactional;
import org.example.salesservice.Model.Client;
import org.example.salesservice.Model.Product;
import org.example.salesservice.client.ClientController;
import org.example.salesservice.entities.Sale;
import org.example.salesservice.product.ProdcutController;
import org.example.salesservice.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class SalesService implements SalesServiceInterface{
    @Autowired
    SalesRepository salesRepository;
    @Autowired
    ClientController clientController;
    @Autowired
    ProdcutController prodcutController;
    @Override
    public List<Sale> getAllSales() {
        List<Sale> sales = salesRepository.findAll();
        Client client;
        Product product;
        for (Sale sale:sales){
            client = clientController.getClient(sale.getClientId());
            sale.setClient(client);
            product = prodcutController.getProduct(sale.getProductId());
            sale.setProduct(product);
        }

        return salesRepository.findAll();
    }

    @Override
    public Sale getSale(Integer id) {
        return null;
    }

    @Override
    public void addSale(Sale sale) {

    }

    @Override
    public void updateSale(Integer id, Sale sale) {

    }

    @Override
    public void deleteSale(Integer id) {

    }
}
