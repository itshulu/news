package sl.itcast.news.service;

import sl.itcast.news.entity.admin;

import java.sql.SQLException;

public interface adminService {


    /**
     * 查询是否存在管理员
     * @return 如果存在则返回该用户
     */
    admin quire(String adminname,String adminpass) throws SQLException;
}
