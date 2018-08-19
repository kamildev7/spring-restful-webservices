package spring5test.springrestfulwebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring5test.springrestfulwebservices.domain.Customer;

/**
 * @author kamildev7 on 2018-08-19.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
