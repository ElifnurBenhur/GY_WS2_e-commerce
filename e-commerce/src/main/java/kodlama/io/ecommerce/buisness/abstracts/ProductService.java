package kodlama.io.ecommerce.buisness.abstracts;
import kodlama.io.ecommerce.entities.Product;

import java.util.List;
public interface ProductService {

    Product create(Product product);
    void delete(int id);
    List<Product> getAll();
    Product getById(int id);
    Product update(Product product,int id);


}
