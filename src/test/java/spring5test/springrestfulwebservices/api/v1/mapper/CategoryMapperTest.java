package spring5test.springrestfulwebservices.api.v1.mapper;

import org.junit.Test;
import spring5test.springrestfulwebservices.api.v1.model.CategoryDTO;
import spring5test.springrestfulwebservices.domain.Category;

import static org.junit.Assert.*;

/**
 * @author kamildev7 on 2018-08-19.
 */
public class CategoryMapperTest {

    public static final String JOE = "Joe";
    public static final long ID = 1L;
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {
        //given
        Category category = new Category();
        category.setName(JOE);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(JOE, categoryDTO.getName());
    }
}