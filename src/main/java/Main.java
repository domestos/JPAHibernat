import DataBaseDao.CartridgeDao;
import DataBaseDao.CompanyDao;
import DataBaseDao.DataBaseImpl.CompanyDaoImp;
import DataBaseDao.FactoryDao;
import DataBaseObject.Cartridge;
import DataBaseObject.Company;

import javax.persistence.EntityManager;
import javax.transaction.TransactionRequiredException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VarenikWin10 on 16.07.2015.
 */
public class Main {
    public static void main(String[] args) throws SQLException {

        CompanyDao companyDao = FactoryDao.getInstance().getCompanyDao();

        CartridgeDao cartridgeDao =FactoryDao.getInstance().getCartridgeDao();

        List<Cartridge> cartridgeList = new ArrayList<Cartridge>();


       Company company = new Company("dzk company use factory", cartridgeList);


        Cartridge cartridge1 = new Cartridge("Samsung scx-4300",company);
        Cartridge cartridge2 = new Cartridge("Samsung scx-4300",company);

        cartridgeList.add(cartridge1);
        cartridgeList.add(cartridge2);


        // BEGIN //  ADD ---------------------------------------------------
        //companyDao.insert(company);
        //companyDao.mergeThis(new Company("NEW COMPANY",null));
        // END //  ADD -----------------------------------------------------


        // BEGIN // fin ALL-------------------------------------------------
       //  companyDao.printList(companyDao.findAll());
         // END // fin ALL---------------------------------------------------


       // BEGIN // fin object id -------------------------------------------
        // System.out.println(companyDao.findID(6));
        // END // fin object id --------------------------------------------


        // BEGIN // UPDATE -------------------------------------------------
           // variant 1
          //  Company com = companyDao.findID(7);
         //   com.setNameCompany("new company ZHOPA");
         //   companyDao.mergeThis(com);

        // variant 2 //pereday cartrig inshiy kompaniy
        //   Cartridge car = cartridgeDao.findID(2);
         //  car.setCompany(companyDao.findID(1));
          // cartridgeDao.mergeThis(car);
        // END // UPDATE ---------------------------------------------------


        // BEGIN // SELECT QUVERY  LIST< STRING >---------------------------
        int id = 3;
        String quvery = "SELECT b.nameCompany FROM Company b WHERE id ="+id+"";
        List<String> result =  companyDao.selectQvery(quvery);
        for(String res : result){
            System.out.println(res);
        }
        // END // SELECT QUVERY  LIST< STRING > -----------------------------


        // BEGIN // SELECT QUVERY  LIST< OBJECT > ---------------------------
         quvery = "FROM Company c WHERE c.nameCompany like '% ZHOPA%'";
         List<Company> result1 = companyDao.selectObjecQvery(quvery);
         for(Company res1 : result1){
            System.out.println(res1);
        }
        // END// SELECT QUVERY  LIST< OBJECT > -----------------------------

        /*
                * SELECT c, p.name FROM Country c LEFT OUTER JOIN c.capital p


          CriteriaQuery<Country> q = cb.createQuery(Country.class);
          Root<Country> c = q.from(Country.class);
          Joinjavax.persistence.criteria.JoinJPA interfaceA join to an entity, embeddable, or basic type.
        See JavaDoc Reference Page...<Country> p = c.join("capital", JoinType.LEFT);
          q.multiselect(c, p.get("name"));*/





     FactoryDao.getInstance().closeFactory();


    }

    // List<Author> authors = em.createQuery(
    // "from Author a where a.name like 'Tol%'").getResultList();
    // System.out.println(authors);
    // Author a = (Author) em.createQuery("from Author a where a.age=124")
    // .getSingleResult(); // only when result is REALLY SINGLE!!!



}
