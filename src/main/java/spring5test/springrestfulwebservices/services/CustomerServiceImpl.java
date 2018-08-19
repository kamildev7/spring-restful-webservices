package spring5test.springrestfulwebservices.services;

import org.springframework.stereotype.Service;
import spring5test.springrestfulwebservices.api.v1.mapper.CustomerMapper;
import spring5test.springrestfulwebservices.api.v1.model.CustomerDTO;
import spring5test.springrestfulwebservices.repositories.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kamildev7 on 2018-08-19.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("/api/v1/customer/" + customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDTO)
                .orElseThrow(RuntimeException::new); //todo implement better exception handling
    }
}
