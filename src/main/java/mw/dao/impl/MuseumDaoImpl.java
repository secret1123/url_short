package mw.dao.impl;

import mw.model.Museum;
import mw.dao.MuseumDao;

import org.springframework.stereotype.Repository;

@Repository
public class MuseumDaoImpl extends GenericDaoImpl<Museum, Integer> implements MuseumDao {
}