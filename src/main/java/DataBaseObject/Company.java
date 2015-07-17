package DataBaseObject;

import javax.persistence.*;
import java.util.List;

/**
 * Created by v.pelenskyi on 16.07.2015.
 */
@Entity
@Table(name = "company")
public class Company  {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "name_company")
    private String nameCompany;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
    private List<Cartridge> cartridgeList;

    // BEGIN // COMSTRUCTOR
    public Company() {
    }

    public Company(String nameCompany, List<Cartridge> cartridgeList) {
        this.nameCompany = nameCompany;
        this.cartridgeList = cartridgeList;
    }
    // END // COMSTRUCTOR


    // BEGIN // GETTER & SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public List<Cartridge> getCartridgeList() {
        return cartridgeList;
    }

    public void setCartridgeList(List<Cartridge> cartridgeList) {
        this.cartridgeList = cartridgeList;
    }
    // END // GETTER & SETTER


    // BEGIN // TOSTRING
    @Override
    public String toString() {
        return  "|*** " +
                "Name:-> " + nameCompany +
                "***|  \n cartridge: " + cartridgeList+"\n\n\n"  ;
    }
    // END // TOSTRING
}
