package main.java.com.inventorymgt.factory;

import com.inventorymgt.form.CategoryForm;
import com.inventorymgt.form.ProductForm;
import com.inventorymgt.form.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;


public class BaseFactory {

    public static CategoryForm createCategoryForm() {
        return new CategoryForm();
    }

    public static ProductForm createProductForm() {
        return new ProductForm();
    }

    public static OrderForm createOrderForm() {
        return new OrderForm(); 
    }
}
