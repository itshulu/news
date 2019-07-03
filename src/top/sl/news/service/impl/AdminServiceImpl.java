package top.sl.news.service.impl;

import top.sl.news.dao.AdminDao;
import top.sl.news.dao.impl.AdminDaoImpl;
import top.sl.news.entity.Admin;
import top.sl.news.service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao=new AdminDaoImpl();

    @Override
    public Admin quire(String adminname, String adminpass) throws SQLException {
        return adminDao.quire(adminname,adminpass);
    }
}
