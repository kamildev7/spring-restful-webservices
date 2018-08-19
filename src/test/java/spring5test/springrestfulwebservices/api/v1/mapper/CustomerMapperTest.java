package spring5test.springrestfulwebservices.api.v1.mapper;

import org.junit.Test;
import spring5test.springrestfulwebservices.api.v1.model.CustomerDTO;
import spring5test.springrestfulwebservices.domain.Customer;

import static org.junit.Assert.*;

/**
 * @author kamildev7 on 2018-08-19.
 */
public class CustomerMapperTest {

    public static final String FIRSTNAME = "Jimmy";
    public static final String LASTNAME = "Fallon";
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception {
        //given
        Customer customer = new Customer();
        customer.setFirstName(FIRSTNAME);
        customer.setLastName(LASTNAME);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(FIRSTNAME, customerDTO.getFirstName());
        assertEquals(LASTNAME, customerDTO.getLastName());
    }
}