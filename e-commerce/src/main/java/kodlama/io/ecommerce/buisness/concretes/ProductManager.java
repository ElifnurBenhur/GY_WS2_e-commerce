package kodlama.io.ecommerce.buisness.concretes;

import kodlama.io.ecommerce.buisness.abstracts.ProductService;
import kodlama.io.ecommerce.entities.Product;
import kodlama.io.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
//Kendi servisimizi yazdığımız için annote etmeliyiz.
@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    //veri değiştirmeyeceğimiz için final kullanmalıyız!Autowired dır burası
    private final ProductRepository repository;



    @Override
    public Product create(Product product) {
        validateProduct(product);
        return repository.save(product);
    }



    @Override
    public void delete(int id) {
       // if (repository.delete(id)==false) throw new RuntimeException("Product with id:"+id+" could not be found!");
        checkIfProductExist(id);
        repository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        if (repository.findAll().size()==0) throw new RuntimeException("There is no product in the system!");
        return repository.findAll();
    }

    @Override
    public Product getById(int id) {

        checkIfProductExist(id);
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Product update(Product product,int id) {
      //  if (repository.update(product)==false) throw new RuntimeException("Product with id:"+product.getId()+" could not be found!");
        checkIfProductExist(id);
        validateProduct(product);
        product.setId(id);
        return repository.save(product);
    }

    //Buisness Rules (extract methoc ctrl+alt+m)

    private void validateProduct(Product product){
        checkIfPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionLengthValid(product);
    }
    private  void checkIfDescriptionLengthValid(Product product) {
        if(product.getDescription().length()<10|| product.getDescription().length()>50)throw new RuntimeException("Description could be minimum 10 characters and maximum 50 characters!");
    }

    private  void checkIfQuantityValid(Product product) {
        if(product.getQuantity()<0) throw new RuntimeException("Quantity must be greater than zero or equals to!");
    }

    private  void checkIfPriceValid(Product product) {
        if(product.getPrice()<=0) throw new RuntimeException("Price must be greater than zero!");
    }
    private void checkIfProductExist(int id){

        if(!repository.existsById(id)) throw new IllegalArgumentException("There is no such a brand!");
    }
}
