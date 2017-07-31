package url.service;

import url.model.Mapper;

import java.util.Map;

public interface MapperService extends GenericService<Mapper, Long> {

    Map<String,Object> createMapper(Mapper mapper,String path);
}
