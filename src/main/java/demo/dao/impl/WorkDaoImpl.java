package demo.dao.impl;

import demo.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class WorkDaoImpl extends GenericDaoImpl<Work, Integer> implements GenericDao<Work, Integer> {
}