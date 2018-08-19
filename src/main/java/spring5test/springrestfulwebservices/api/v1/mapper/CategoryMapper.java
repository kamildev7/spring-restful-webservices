package spring5test.springrestfulwebservices.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import spring5test.springrestfulwebservices.api.v1.model.CategoryDTO;
import spring5test.springrestfulwebservices.domain.Category;

/**
 * @author kamildev7 on 2018-08-19.
 */
@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
