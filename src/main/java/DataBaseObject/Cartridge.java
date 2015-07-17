package DataBaseObject;

import javax.persistence.*;
import java.util.List;

/**
 * Created by v.pelenskyi on 16.07.2015.
 */
@Entity
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

    public Cartridge(String typeCartridge, Company company) {
        this.typeCartridge = typeCartridge;
        this.company = company;
    }


    @Override
    public String toString() {
        return "Cartridge{" +
                "typeCartridge='" + typeCartridge + '\'' +
                '}';
    }
}
