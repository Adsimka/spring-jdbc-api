package jdbc_crud.controller;

import jdbc_crud.database.service.CustomerService;
import jdbc_crud.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public Long createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping
    public Customer findById(@RequestParam Long id) {
        return customerService.findById(id);
    }

    @PutMapping
    public void update(@RequestBody Customer customer) {
        customerService.update(customer);
    }
}
