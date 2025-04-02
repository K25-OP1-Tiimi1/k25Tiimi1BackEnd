package k25tiimi1backend.k25tiimi1backend.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nimi;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private List<Product> tuotteet = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public List<Product> getTuotteet() {
        return tuotteet;
    }

    public void setTuotteet(List<Product> tuotteet) {
        this.tuotteet = tuotteet;
    }

    public void save(Manufacturer manufacturer1) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    

}
