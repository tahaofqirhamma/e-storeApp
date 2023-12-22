package org.example.salesservice.repositories;

import org.example.salesservice.Model.Client;
import org.example.salesservice.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Integer> {

}
