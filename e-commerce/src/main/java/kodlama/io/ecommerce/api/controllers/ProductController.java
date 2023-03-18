package kodlama.io.ecommerce.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.ecommerce.buisness.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping ("/create")
    public boolean create(@Valid @RequestBody Product product){
        return service.create(product);
    }
    @DeleteMapping("/delete{id}")
    public boolean delete(@PathVariable(value = "id")int id){
        return service.delete(id);
    }
    @GetMapping("/getAll")
    public List<Product> findAll(){
        return service.getAll();
    }
    @GetMapping("/getById{id}")
    public Product findById(@PathVariable(value = "id")int id){
        return service.getById(id);
    }
    @PutMapping("/update")
    public boolean update(@Valid @RequestBody Product product){
        return service.update(product);
    }
}
