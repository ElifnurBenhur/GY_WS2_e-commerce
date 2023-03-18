package kodlama.io.ecommerce.repository.abstracts;

import kodlama.io.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductRepository {

    boolean create(Product product);
    boolean delete(int id);
    List<Product> getAll();
    Product getById(int id);
    boolean update(Product product);
}
