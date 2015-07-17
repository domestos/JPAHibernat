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


        Cartridge cartridge1 = new Cartridge("Samsung scx-46001",company);
        Cartridge cartridge2 = new Cartridge("Samsung scx-46001",company);

        cartridgeList.add(cartridge1);
        cartridgeList.add(cartridge2);

        // ADD
        companyDao.insert(company);
        FactoryDao.getInstance().closeFactory();



      // System.out.println("find id = "+);
      //  System.out.println(companyDaoImp.findAll());

       // companyDaoImp.delete(companyDaoImp.findID(1));

    }



}
