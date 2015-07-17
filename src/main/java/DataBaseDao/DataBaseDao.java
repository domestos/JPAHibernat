package DataBaseDao;

import java.util.List;

/**
 * Created by VarenikWin10 on 16.07.2015.
 */
public interface DataBaseDao<T> {


    void insert(T c);

    void delete(T c);

    T findID(Object id);

    List<T> findAll();
}
