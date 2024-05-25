package jdbc_crud.database.service;

import jdbc_crud.database.dao.CustomerDao;
import jdbc_crud.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public Long createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    public Customer findById(Long id) {
        return customerDao.findById(id);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }

    public void remove(Long id) {
        customerDao.remove(id);
    }
}
