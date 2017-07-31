package url.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import url.dao.GenericDao;
import url.model.Mapper;
import url.service.MapperService;
import url.util.GenCreation;
import url.util.GenQRCode;

import java.util.HashMap;
import java.util.Map;

import static url.util.Constant.MESSAGE_CREATION_EXISTED;

@Service
public class MapperServiceImpl extends GenericServiceImpl<Mapper, Long> implements MapperService {

@Override
@Autowired
@Qualifier("mapperDaoImpl")
void setGenericDao(GenericDao<Mapper, Long> genericDao) {
super.genericDao = genericDao;
}

    @Override
    public Map<String, Object> createMapper(Mapper mapper, String path) {
        Mapper mapperInDb = genericDao.queryOne("getMapperByOriginal",mapper.getOriginal());
        String message = null;
        if (mapperInDb == null) {
            if (mapper.getCreation().isEmpty()) {
                mapper.setCreation(GenCreation.getCreation());
            } else {
                if (genericDao.queryOne("queryMapperByCreation",mapper.getCreation()) != null) {
                    message = MESSAGE_CREATION_EXISTED;
                    mapper.setCreation(GenCreation.getCreation());
                }
            }
            genericDao.create(mapper);
        } else {
            mapper = mapperInDb;
        }
        GenQRCode.gen(mapper,path);
        Map<String,Object> map = new HashMap<>();
        map.put("mapper",mapper);
        map.put("message",message);
        return map;
    }
}