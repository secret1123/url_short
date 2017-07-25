package demo.dao.impl;

import demo.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class MuseumDaoImpl extends GenericDaoImpl<Museum, Integer> implements GenericDao<Museum, Integer> {
}