package top.sl.news.dao;

import top.sl.news.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeDao {
    List<Type> selectType() throws SQLException;
}
