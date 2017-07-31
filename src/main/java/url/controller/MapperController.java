package url.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import url.model.Mapper;
import url.service.MapperService;

import java.io.IOException;
import java.util.Map;


@Controller
public class MapperController extends BaseController {

    private final MapperService mapperService;

    @Autowired
    public MapperController(MapperService mapperService) {
        this.mapperService = mapperService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private void redirect() throws IOException {
        String creation = request.getRequestURI().substring(1);
        Mapper mapper = mapperService.queryOne("queryMapperByCreation",creation);
        response.sendRedirect(mapper.getOriginal());
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    private String createMapper(Mapper mapper) {
        String path = application.getRealPath("/") + "assets/qrcode/";
        Map<String,Object> map = mapperService.createMapper(mapper,path);
        session.setAttribute("mapper",map.get("mapper"));
        session.setAttribute("mapper", mapper);
        return "redirect:/default.jsp";
    }
}