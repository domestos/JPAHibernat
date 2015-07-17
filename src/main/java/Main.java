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
         companyDao.printList(companyDao.findAll());
         // END // fin ALL---------------------------------------------------

       // BEGIN // fin object id -------------------------------------------
         System.out.println(companyDao.findID(6));
        // END // fin object id --------------------------------------------

        // BEGIN // UPDATE -------------------------------------------------
           // variant 1
            Company com = companyDao.findID(7);
            com.setNameCompany("new company ZHOPA");
            companyDao.mergeThis(com);

        // variant 2 //pereday cartrig inshiy kompaniy
           Cartridge car = cartridgeDao.findID(2);
           car.setCompany(companyDao.findID(1));
           cartridgeDao.mergeThis(car);
        // END // UPDATE ---------------------------------------------------

      FactoryDao.getInstance().closeFactory();


    }





}
