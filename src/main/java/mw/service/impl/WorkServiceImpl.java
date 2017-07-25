package mw.service.impl;

import mw.model.Work;
import mw.service.WorkService;
import mw.dao.GenericDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class WorkServiceImpl extends GenericServiceImpl<Work, Integer> implements WorkService {

@Override
@Autowired
@Qualifier("workDaoImpl")
void setGenericDao(GenericDao<Work, Integer> genericDao) {
super.genericDao = genericDao;
}
}