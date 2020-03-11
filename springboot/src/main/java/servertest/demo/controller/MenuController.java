package servertest.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import servertest.demo.Service.MenuService;
import servertest.demo.entity.Menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ComponentScan("servertest.demo")
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public String Welcome() {
        return "Welcome to Webshop";
    }

    @RequestMapping("/whoim")
    @ResponseBody
    public Object whoIm() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @RequestMapping("/api/getAllMenu")
    @ResponseBody
    public Map<String, Map<String, String>> getAllMenu() throws IOException {
        List<Menu> temp = menuService.getAllMenu();
        Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
        for (int i = 0; i < temp.size(); i++) {
            if (null == result.get(temp.get(i).getParent())) {
                Map<String, String> temp1 = new HashMap<String, String>();
                temp1.put(temp.get(i).getChild(), temp.get(i).getUrl());
                result.put(temp.get(i).getParent(), temp1);
            } else {
                Map<String, String> temp2 = result.get(temp.get(i).getParent());
                temp2.put(temp.get(i).getChild(), temp.get(i).getUrl());
                result.put(temp.get(i).getParent(), temp2);
            }
        }
        return result;
    }
}
