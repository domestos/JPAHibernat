package DataBaseDao.DataBaseImpl;


import DataBaseDao.CompanyDao;
import DataBaseObject.Company;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by v.pelenskyi on 16.07.2015. extends DataBaseDaoImp<Company> implements CompanyDao
 */
public class CompanyDaoImp extends DataBaseDaoImp<Company> implements CompanyDao {


    public CompanyDaoImp(EntityManager em) {
        super(em);
    }

    public List<Company> findAll() {
        return  em.createQuery("from Company").getResultList();
    }



}
