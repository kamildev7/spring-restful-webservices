package spring5test.springrestfulwebservices.services;

import spring5test.springrestfulwebservices.api.v1.model.CategoryDTO;

import java.util.List;

/**
 * @author kamildev7 on 2018-08-19.
 */
public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
