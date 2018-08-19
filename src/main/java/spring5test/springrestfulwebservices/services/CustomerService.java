package spring5test.springrestfulwebservices.services;

import spring5test.springrestfulwebservices.api.v1.model.CustomerDTO;

import java.util.List;

/**
 * @author kamildev7 on 2018-08-19.
 */
public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);
}
