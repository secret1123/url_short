package url.dao.impl;

import url.model.Mapper;
import url.dao.MapperDao;

import org.springframework.stereotype.Repository;

@Repository
public class MapperDaoImpl extends GenericDaoImpl<Mapper, Long> implements MapperDao {
}