package DataBaseObject;

import javax.persistence.*;
import java.util.List;

/**
 * Created by v.pelenskyi on 16.07.2015.
 */
@Entity
@Table (name = "cartridge")
public class Cartridge  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "type")
    private String typeCartridge;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "id_company")
    private Company company;

    public Cartridge(){

    }
    // BEGIN // COMSTRUCTOR
    public Cartridge(String typeCartridge, Company company) {
        this.typeCartridge = typeCartridge;
        this.company = company;
    }
    // END // COMSTRUCTOR

    // BEGIN // GETTER & SETTER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeCartridge() {
        return typeCartridge;
    }

    public void setTypeCartridge(String typeCartridge) {
        this.typeCartridge = typeCartridge;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    // END // GETTER & SETTER

    // BEGIN // TOSTRING
    @Override
    public String toString() {
        return "\n type='" + typeCartridge + '\'' ;
    }
    // END // TOSTRING
}
