package DataBaseDao;


import DataBaseDao.DataBaseImpl.CartridgeDaoIml;
import DataBaseDao.DataBaseImpl.CompanyDaoImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by VarenikWin10 on 16.07.2015.
 */
public class FactoryDao {

    private static FactoryDao instance;

    private CompanyDao companyDao;

    private CartridgeDao cartridgeDao;

    private EntityManager em;

    private  EntityManagerFactory factory =  getEntityManagerFactory();

    public EntityManagerFactory getEntityManagerFactory(){
        try {
            factory  = Persistence.createEntityManagerFactory("primary");
        }catch (Exception e){
            System.out.printf("Error parameters or file persistence.xml absent ");
            e.printStackTrace();
        }
        return factory;
    }

    public FactoryDao(){
        em = factory.createEntityManager();
        cartridgeDao = new CartridgeDaoIml(em);
        companyDao = new CompanyDaoImp(em);
    }

    public static FactoryDao getInstance() {
       if(instance == null){
           instance = new FactoryDao();
       }
        return instance;
    }

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public CartridgeDao getCartridgeDao() {
        return cartridgeDao;
    }
    public void closeFactory(){
        if(factory.isOpen()){
        factory.close();
        }
    }
}
