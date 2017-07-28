package url.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import url.model.Mapper;
import url.service.MapperService;

@Controller
@RequestMapping("mapper")
public class MapperController extends BaseController {

private final MapperService mapperService;

@Autowired
public MapperController(MapperService mapperService) {
this.mapperService = mapperService;
}

@RequestMapping("create")
private String create(Mapper mapper) {
mapperService.create(mapper);
return "redirect:/mapper/queryAll";
}

@RequestMapping("remove/{id}")
private String remove(@PathVariable("id") Long id) {
mapperService.remove(id);
return "redirect:/mapper/queryAll";
}

@RequestMapping("modify")
private String modify(Mapper mapper) {
mapperService.modify(mapper);
return "redirect:/mapper/queryAll";
}

@RequestMapping("queryAll/{page}")
private String queryAll(@PathVariable int page) {
session.setAttribute("pagination", mapperService.queryAll(page));
return "redirect:/mapper/list.jsp";
}

@RequestMapping("queryAll")
private String queryAll() {
return queryAll(1);
}

@RequestMapping("queryById/{id}")
private String queryById(@PathVariable("id") Long id) {
session.setAttribute("mapper", mapperService.queryById(id));
return "redirect:/mapper/edit.jsp";
}
}