package kodlama.io.ecommerce.repository.concretes;

import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
   private List<Product> products;

    public InMemoryProductRepository() {
        products=new ArrayList<>();
        products.add(new Product(1,"Mirror",5,156.45,"This is a nice decorative mirror.",false));
        products.add(new Product(2,"Carpet",3,2396.99,"This is a nice decorative carpet with 1060X2024 size.",false));
        products.add(new Product(3,"Notebook",26,18.86,"This is a usefull notebook.",false));
        products.add(new Product(4,"Pen",146,5.58,"This is a nice red pen.",false));
        products.add(new Product(5,"Calendar",58,56.12,"This is a nice decorative wall calendar with flower photo.",false));

    }
    public boolean create(Product product){
        try {
            products.add(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean delete(int id){
        for (Product product:products
             ) {
            if(product.getId()==id){
                product.setDeleted(true);
                return true;
            }
        }
        return false;
    }
    public List<Product> getAll(){
        return products;
    }
    public Product getById(int id){
        for (Product product:products
             ) {
             if(product.getId()==id){
                 return product;
             }
        }
        return null;
    }
    public boolean update(Product product){
        for (Product p:products
             ) {
            if(product.getId()==p.getId()){
                p.setName(product.getName());
                p.setQuantity(product.getQuantity());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                return true;
            }

        }
        return false;
    }
}
