package DataBaseDao.DataBaseImpl;


import DataBaseDao.DataBaseDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

/**
 * Created by VarenikWin10 on 16.07.2015.
 */
public abstract class DataBaseDaoImp<T> implements DataBaseDao<T>{

    protected EntityManager em;

    public DataBaseDaoImp(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    protected final Class<T> getEntityClass() {
        final Type type = getClass().getGenericSuperclass() instanceof ParameterizedType ? getClass().getGenericSuperclass()
                : getClass().getSuperclass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            final ParameterizedType paramType = (ParameterizedType) type;
            return (Class<T>) paramType.getActualTypeArguments()[0];
        } else
            throw new IllegalArgumentException("Could not guess entity class by reflection");
    }

    public void insert(T c) {
        try{
            if(em == null){
                System.out.println("this vary bed");
            }
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }finally {
            closeEntytiManager(em);
        }
    }

    public void delete(T c){

        try{

            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }finally{
            closeEntytiManager(em);
        }

    }

    public T findID(Object id){

        try{

            return  em.find(getEntityClass(), id);
        }finally {
            closeEntytiManager(em);
        }

    }

    public List<T> findAll(){
        List<T> findList = null;

        return findList;
    }


    public void closeEntytiManager(EntityManager em){
        if(em.isOpen()){
            em.close();
        }
    }
}



/*
*

    private  static EntityManagerFactory fuctory = getEmptityManagerFactory();

    public static EntityManagerFactory getEmptityManagerFactory()  {
        fuctory = Persistence.createEntityManagerFactory("primary");
        return fuctory;
    }

    public void tempSession(){
        EntityManager em = fuctory.createEntityManager();
    }

    public void insert(Company company) {
        EntityManager em = fuctory.createEntityManager();
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
    }

    public Company findID (int id) {
        Company result = null;
        EntityManager em = fuctory.createEntityManager();
        result = em.find(Company.class, id);
        return result;
    }


    public List<Company> findAll () {
        Company result = null;
        EntityManager em = fuctory.createEntityManager();
        return em.createQuery("from Company").getResultList();


    }

    public void delete(Company company){
        EntityManager em = fuctory.createEntityManager();
        em.getTransaction().begin();
        em.remove(company);
        em.getTransaction().commit();
    }


*/