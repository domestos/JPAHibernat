package DataBaseDao.DataBaseImpl;


import DataBaseDao.DataBaseDao;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

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
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
    }

    public void delete(T c){
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();

    }

    public T findID(int id){
        return  em.find(getEntityClass(), id);
    }

    public void printList(List<T> obj){
        for(Object ob: obj){
            System.out.print(ob + " ");
        }
        System.out.println();
    }

    public void mergeThis(T c){
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    public List<String> selectQvery(String quvery){
        System.out.println(quvery);
        return em.createQuery(quvery).getResultList();
    }

    public List<T> selectObjecQvery(String quvery){
        System.out.println(quvery);

        return em.createQuery(quvery).getResultList();
    }


}
