package servertest.demo.Dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import servertest.demo.Dao.MenuDao;
import servertest.demo.entity.Menu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class MenuDaoImpl implements MenuDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Menu> getAllMenu() {
        String hql = "FROM Menu as m ORDER BY m.parent";
        return (List<Menu>) entityManager.createQuery(hql).getResultList();
    }
}
