package dev.soma.productserviceproject.services;

import dev.soma.productserviceproject.Repositories.CategoryRepo;
import dev.soma.productserviceproject.models.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class FakeStoreCategoryService implements CategoryService{
     private CategoryRepo categoryRepo;
    @Override
    public List<String> getAllcategory() {
        List<Category> categories = categoryRepo.findAll();

        List<String> categorynames = new ArrayList<>();
        categories.forEach(category -> categorynames.add(category.getName()));
        return categorynames;
    }

}
