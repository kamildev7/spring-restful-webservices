package spring5test.springrestfulwebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring5test.springrestfulwebservices.domain.Category;

/**
 * @author kamildev7 on 2018-08-19.
 */
public interface CategoryRepository  extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
