package org.example.salesservice.admin;

import org.example.salesservice.event.SaleEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientFeign {
    @PostMapping("/notify-sale")
    void notifySale(SaleEvent saleEvent);
}
