package url.dao.impl;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import url.dao.GenericDao;
import url.util.Constant;
import url.util.Pagination;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by AnLu on
 */
public class GenericDaoImpl<T extends Serializable, ID extends Number> implements GenericDao<T, ID> {

    @Autowired
    private SqlSession sqlSession;
    private String namespace;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        namespace = StringUtils.uncapitalize(clazz.getSimpleName());
    }

    private String getStatement(String sqlId) {
        return namespace.concat(".").concat(sqlId);
    }

    @Override
    public void create(T t) {
        sqlSession.insert(getStatement("create"), t);
    }

    @Override
    public void remove(ID id) {
        sqlSession.delete(getStatement("remove"),id);
    }

    @Override
    public void remove(String statement, Object parameter) {
        sqlSession.delete(getStatement(statement),parameter);
    }

    @Override
    public void modify(T t) {
        sqlSession.update(getStatement("modify"),t);
    }

    @Override
    public void modify(String statement, Object parameter) {
        sqlSession.update(getStatement(statement),parameter);
    }

    @Override
    public T queryOne(String statement, Object parameter) {
        return sqlSession.selectOne(getStatement(statement),parameter);
    }

    @Override
    public T queryById(ID id) {
        return sqlSession.selectOne(getStatement("queryById"),id);
    }

    @Override
    public List<T> queryList(String statement, Object parameter) {
        return sqlSession.selectList(getStatement(statement),parameter);
    }

    @Override
    public List<T> queryAll() {
        return sqlSession.selectList(getStatement("queryAll"));
    }


    @Override
    public Pagination<T> query(String statement, Object parameter, int currentPage) {
        return getPagination(statement,parameter,currentPage);
    }

    @Override
    public Pagination<T> queryAll(int currentPage) {
        return getPagination("queryAll",null,currentPage) ;
    }

    private Pagination<T> getPagination(String statement,Object parameter,int currentPage){
        int pageSize = Constant.PAGE_SIZE;
        int totalRows = sqlSession.selectList(getStatement(statement),parameter).size();
        int totalPages = (int) Math.ceil(totalRows / (double)pageSize);
        RowBounds rowBounds = new RowBounds(pageSize * (currentPage - 1), pageSize);
        List<T> list = sqlSession.selectList(getStatement(statement),parameter,rowBounds);
        return new Pagination<>(list,statement,pageSize,totalRows,totalPages,currentPage);
    }
}
