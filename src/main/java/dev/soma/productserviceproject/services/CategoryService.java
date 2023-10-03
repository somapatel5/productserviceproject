package dev.soma.productserviceproject.services;

import dev.soma.productserviceproject.dtos.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
     List<String> getAllcategory();

}
