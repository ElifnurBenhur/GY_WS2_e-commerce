package kodlama.io.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//jpa jakarta SQL nesnesi olduğunu belirtmek için
@Entity
//veri tabanında tablo oluşturmak için
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;

    private boolean deleted;
    @Enumerated(EnumType.STRING) //enum 0,1,2 olarak değil string anlamı olarak görünsün diye
    private Status status;//1-avaliable 2-notavailable
    //many to many de sonsuz döngünün sebep olduğu seriazable hatasını önlemek için
    //json dönüşümünü güvenli hale getirir
    //parent da kullanılmalıdır
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    //veri tekrarını önlemek için set kullanıyoruz list değil!
    //many to many de iki sınıftan herhangi biri parent seçilir ve join table o sınıfta yazılır
    //diğer sınıfta mapped by kullanılır ve ilişki öyle belirtilir
    //join table kullanılmaz ise de otomatik tablo oluşturulur
  /*
    @JoinTable(
            name = "product_catagory",
            joinColumns = @JoinColumn(name="catagory_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )//*/
    private Set<Catagory> catagories=new HashSet<>();






}
