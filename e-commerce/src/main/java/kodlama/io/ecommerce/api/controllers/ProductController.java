package kodlama.io.ecommerce.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.ecommerce.buisness.abstracts.ProductService;
import kodlama.io.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//controller mvc için direkt sayfa döneceğin zaman
@RestController
//url ile bağlamak için
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    //productmanager da kullanabilirdim ancak interface den alt instancalarada ulaşabiliyorum.
    ProductService service;
    //put veri güncelleme patch obje güncelleme ie.yeni alan ekleme, çok kullanılmaz

     //filtreleme yaparken requestparam gerekir
    //nesne alacağım zaman requestbody
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody Product product){
        return service.create(product);
    }
    @DeleteMapping("/{id}")

    public void delete(@PathVariable(value = "id")int id){
        service.delete(id);
    }
    //(/getAll) formata uygun değil, gerek de yok get işleminde products dönüyor zaten
    @GetMapping
    public List<Product> findAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable(value = "id")int id){
        return service.getById(id);
    }
    @PutMapping("/{id}")
    public Product update(@Valid @RequestBody Product product,@PathVariable(value = "id")int id){
        return service.update(product,id);
    }
}
