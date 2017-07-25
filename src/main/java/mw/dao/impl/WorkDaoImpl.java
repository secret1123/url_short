package mw.dao.impl;

import mw.model.Work;
import mw.dao.WorkDao;

import org.springframework.stereotype.Repository;

@Repository
public class WorkDaoImpl extends GenericDaoImpl<Work, Integer> implements WorkDao {
}