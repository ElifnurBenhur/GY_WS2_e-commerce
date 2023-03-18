package kodlama.io.ecommerce.buisness.abstracts;
import kodlama.io.ecommerce.entities.concretes.Product;

import java.util.List;
public interface ProductService {

    boolean create(Product product);
    boolean delete(int id);
    List<Product> getAll();
    Product getById(int id);
    boolean update(Product product);


}
