package kodlama.io.ecommerce.buisness.concretes;

import kodlama.io.ecommerce.buisness.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {
    ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(Product product) {
        if(product.getPrice()<0) throw new RuntimeException("Price must be greater than zero!");
        if(product.getQuantity()<0) throw new RuntimeException("Quantity must be greater than zero!");
        if(product.getDescription().length()<10||product.getDescription().length()>50)throw new RuntimeException("Description could be minimum 10 characters and maximum 50 characters!");
        return repository.create(product);
    }

    @Override
    public boolean delete(int id) {
        if (repository.delete(id)==false) throw new RuntimeException("Product with id:"+id+" could not be found!");
        return repository.delete(id);
    }

    @Override
    public List<Product> getAll() {
        if (repository.getAll().size()==0) throw new RuntimeException("There is no product in the system!");
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        if(repository.getById(id)==null) throw new RuntimeException("Product with id:"+id+" could not be found!");
        return repository.getById(id);
    }

    @Override
    public boolean update(Product product) {
        if (repository.update(product)==false) throw new RuntimeException("Product with id:"+product.getId()+" could not be found!");
        if(product.getPrice()<0) throw new RuntimeException("Price must be greater than zero!");
        if(product.getQuantity()<0) throw new RuntimeException("Quantity must be greater than zero!");
        if(product.getDescription().length()<10||product.getDescription().length()>50)throw new RuntimeException("Description could be minimum 10 characters and maximum 50 characters!");
        return repository.update(product);
    }
}
