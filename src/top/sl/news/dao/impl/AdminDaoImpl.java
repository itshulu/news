package top.sl.news.dao.impl;

import top.sl.news.dao.AdminDao;
import top.sl.news.entity.Admin;
import top.sl.news.util.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin quire(String adminname, String adminpass) throws SQLException {
        String sql="select * from Admin where adminname=? and adminpass=?";
        String[] strs={adminname,adminpass};
        ResultSet resultSet = DaoUtils.getDaoUtils().executeQuerySQL(sql, strs, DaoUtils.getConn());
        resultSet.next();
        Admin admin = new Admin();
        admin.setAdminid(resultSet.getString("adminid"));
        admin.setAdminname(resultSet.getString("adminname"));
        admin.setAdminpass(resultSet.getString("adminpass"));
        return admin;
    }
}
