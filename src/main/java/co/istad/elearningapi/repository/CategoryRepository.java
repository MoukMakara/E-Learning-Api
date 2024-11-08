package co.istad.elearningapi.repository;

import co.istad.elearningapi.domain.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class CategoryRepository {
    private List<Category> categories;


    public CategoryRepository() {
        categories = new ArrayList<>();
        categories.add(Category.builder()
                        .id(1)
                        .name("Back-End")
                .build());
        categories.add(Category.builder()
                .id(1)
                .name("Mobile")
                .build());
        categories.add(Category.builder()
                .id(1)
                .name("Front-End")
                .build());
    }
}
