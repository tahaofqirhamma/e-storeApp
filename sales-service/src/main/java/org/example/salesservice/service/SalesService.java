package org.example.salesservice.service;

import jakarta.transaction.Transactional;
import org.example.salesservice.Model.Client;
import org.example.salesservice.Model.Product;
import org.example.salesservice.client.ClientController;
import org.example.salesservice.entities.Sale;
import org.example.salesservice.event.SaleEvent;
import org.example.salesservice.product.ProdcutController;
import org.example.salesservice.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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

    @Autowired
    KafkaTemplate<String, SaleEvent> template;



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
        return salesRepository.findById(id).get();
    }

    @Override
    public void addSale(Sale sale) {
        Sale sale1 = new Sale();
        Client client = clientController.getClient(sale.getClientId());
        Product product = prodcutController.getProduct(sale.getProductId());
        sale1.setStatus("pending");
        sale1.setSaleDate(sale.getSaleDate());
        sale1.setSaleQuantity(sale.getSaleQuantity());
        sale1.setClientId(sale.getClientId());
        sale1.setProductId(sale.getProductId());
        sale1.setClient(client);
        sale1.setProduct(product);
        salesRepository.save(sale1);
        template.send("notificationTopic", new SaleEvent(sale1.getSaleId(),sale1.getClientId(), sale1.getProductId() ));
    }

    @Override
    public void updateSale(Integer id, Sale sale) {
        Sale sale1 = salesRepository.findById(id).get();
        if(sale.getStatus() != null) sale1.setStatus(sale.getStatus());
        if(sale.getSaleQuantity() !=null) sale1.setSaleQuantity(sale.getSaleQuantity());
    }

    @Override
    public void deleteSale(Integer id) {
        salesRepository.deleteById(id);

    }

    @Override
    public void updateStatus(Integer id, String status) {
        Sale sale1 = salesRepository.findById(id).get();
        sale1.setStatus(status);
    }

    @Override
    public List<Sale> getMySales(String clientID) {
       List<Sale> sales = salesRepository.findAll();
        List<Sale> clientSale = sales.stream()
                .filter(sale -> sale.getClientId().equals(clientID))
                .toList();

        return clientSale;
    }


}
