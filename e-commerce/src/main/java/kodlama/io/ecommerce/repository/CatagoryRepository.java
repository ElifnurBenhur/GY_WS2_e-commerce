package kodlama.io.ecommerce.repository;

import kodlama.io.ecommerce.entities.Catagory;
import kodlama.io.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepository extends JpaRepository<Catagory,Integer> {
}
