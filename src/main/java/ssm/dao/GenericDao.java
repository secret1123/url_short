package ssm.dao;

import ssm.util.Pagination;

import java.io.Serializable;

/**
 * Created by AnLu on
 * 2017/7/23 21:27.
 * ssm
 */
public interface GenericDao<T extends Serializable,ID extends Number> {

    void create(T t);

    void remove(ID id);

    void remove(String statement,Object parameter);

    void modify(T t);

    void modify(String statement,Object parameter);

    T query(String statement,Object parameter);

    T queryById(ID id);

    Pagination<T> query(String statement, Object parameter, int currentPage);

    Pagination<T> queryAll(int currentPage);
}
