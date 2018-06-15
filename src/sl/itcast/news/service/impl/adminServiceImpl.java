package sl.itcast.news.service.impl;

import sl.itcast.news.dao.adminDao;
import sl.itcast.news.dao.impl.adminDaoImpl;
import sl.itcast.news.entity.admin;
import sl.itcast.news.service.adminService;

import java.sql.SQLException;

public class adminServiceImpl implements adminService {
    private adminDao adminDao=new adminDaoImpl();

    @Override
    public admin quire(String adminname,String adminpass) throws SQLException {
        return adminDao.quire(adminname,adminpass);
    }
}
