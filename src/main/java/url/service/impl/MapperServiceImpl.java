package url.service.impl;

import url.model.Mapper;
import url.service.MapperService;
import url.dao.GenericDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class MapperServiceImpl extends GenericServiceImpl<Mapper, Long> implements MapperService {

@Override
@Autowired
@Qualifier("mapperDaoImpl")
void setGenericDao(GenericDao<Mapper, Long> genericDao) {
super.genericDao = genericDao;
}
}