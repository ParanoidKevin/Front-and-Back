package servertest.demo.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servertest.demo.Dao.MenuDao;
import servertest.demo.Service.MenuService;
import servertest.demo.entity.Menu;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }
}
