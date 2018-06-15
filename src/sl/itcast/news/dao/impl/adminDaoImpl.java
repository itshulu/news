package sl.itcast.news.dao.impl;

import sl.itcast.news.dao.adminDao;
import sl.itcast.news.entity.admin;
import sl.itcast.news.util.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class adminDaoImpl implements adminDao{
    @Override
    public admin quire(String adminname,String adminpass) throws SQLException {
        String sql="select * from admin where adminname=? and adminpass=?";
        String[] strs={adminname,adminpass};
        ResultSet resultSet = DaoUtils.getDaoUtils().executeQuerySQL(sql, strs, DaoUtils.getConn());
        resultSet.next();
        admin admin = new admin();
        admin.setAdminid(resultSet.getString("adminid"));
        admin.setAdminname(resultSet.getString("adminname"));
        admin.setAdminpass(resultSet.getString("adminpass"));
        return admin;
    }
}
