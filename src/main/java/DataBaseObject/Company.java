package DataBaseObject;

import javax.persistence.*;
import java.util.List;

/**
 * Created by v.pelenskyi on 16.07.2015.
 */
@Entity
public class Company  {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "name_company")
    private String nameCompany;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
    private List<Cartridge> cartridgeList;

    public Company() {
    }

    public Company(String nameCompany, List<Cartridge> cartridgeList) {
        this.nameCompany = nameCompany;
        this.cartridgeList = cartridgeList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "nameCompany='" + nameCompany + '\'' +
                '}';
    }
}
