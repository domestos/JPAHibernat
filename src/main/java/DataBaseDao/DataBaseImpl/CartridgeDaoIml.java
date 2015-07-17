package DataBaseDao.DataBaseImpl;

import DataBaseDao.CartridgeDao;
import DataBaseDao.DataBaseDao;
import DataBaseObject.Cartridge;
import DataBaseObject.Company;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by VarenikWin10 on 16.07.2015.
 */
public class CartridgeDaoIml extends DataBaseDaoImp<Cartridge> implements CartridgeDao{

    public CartridgeDaoIml(EntityManager em) {
        super(em);
    }



    public List<Cartridge> findAll(){

        //List<Cartridge> findList = null;

        return  em.createQuery("from Cartridge").getResultList();
    }

}
