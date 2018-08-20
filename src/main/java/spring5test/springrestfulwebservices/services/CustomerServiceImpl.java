package spring5test.springrestfulwebservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring5test.springrestfulwebservices.api.v1.mapper.CustomerMapper;
import spring5test.springrestfulwebservices.api.v1.model.CustomerDTO;
import spring5test.springrestfulwebservices.domain.Customer;
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

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
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
                    customerDTO.setCustomerUrl("/api/v1/customers/" + customer.getId());
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

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        return saveAndReturnDTO(customerMapper.customerDtoToCustomer(customerDTO));
    }

    @Override
    public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(id);
        return saveAndReturnDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {

            if(customerDTO.getFirstName() != null){
                customer.setFirstName(customerDTO.getFirstName());
            }

            if(customerDTO.getLastName() != null){
                customer.setLastName(customerDTO.getLastName());
            }

            CustomerDTO returnDto = customerMapper.customerToCustomerDTO(customerRepository.save(customer));

            returnDto.setCustomerUrl("/api/v1/customers/" + id);

            return returnDto;

        }).orElseThrow(RuntimeException::new); //todo implement better exception handling;
    }

    private CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);

        returnDto.setCustomerUrl("/api/v1/customers/" + savedCustomer.getId());

        return returnDto;
    }
}
