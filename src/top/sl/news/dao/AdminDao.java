package top.sl.news.dao;

import top.sl.news.entity.Admin;

import java.sql.SQLException;

public interface AdminDao {


    /**
     * 查询是否存在管理员
     * @return 如果存在则返回该用户
     */
    Admin quire(String adminname, String adminpass) throws SQLException;
}
