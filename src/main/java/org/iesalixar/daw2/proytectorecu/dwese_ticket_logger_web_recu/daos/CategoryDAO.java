package org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.daos;

import org.iesalixar.daw2.proytectorecu.dwese_ticket_logger_web_recu.entities.Category;

import java.util.List;

public interface CategoryDAO {


    List<Category> listAllCategories();

    void insertCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(int id);

    Category getCategoryById(int id);

    boolean existsCategoryByName(String name);

    boolean existsCategoryByNameAndNotId(String name, int id);
}