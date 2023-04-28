package kodlama.io.ecommerce.entities;

import jakarta.persistence.*;
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
@Table(name = "catagories")
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //fetch type lazy ve eager olabilir performans yüksek olsun diye lazy yapıyoruz ki katogoriye de aynı anda istek atmasın!
    @ManyToMany(mappedBy = "catagories",fetch = FetchType.LAZY)
    private Set<Product> products=new HashSet<>();
}
