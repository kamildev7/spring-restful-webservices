package spring5test.springrestfulwebservices.services;

import org.springframework.stereotype.Service;
import spring5test.springrestfulwebservices.api.v1.mapper.CategoryMapper;
import spring5test.springrestfulwebservices.api.v1.model.CategoryDTO;
import spring5test.springrestfulwebservices.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kamildev7 on 2018-08-19.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
    }
}
