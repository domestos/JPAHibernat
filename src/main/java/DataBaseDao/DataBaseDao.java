package DataBaseDao;

import DataBaseObject.Company;

import java.util.List;

/**
 * Created by VarenikWin10 on 16.07.2015.
 */
public interface DataBaseDao<T> {


    void insert(T c);

    void delete(T c);

    void printList(List<T> obj);

    void mergeThis(T c);

    T findID(int id);

    List<T> findAll();


}
