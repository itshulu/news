package top.sl.news.service;

import top.sl.news.entity.Type;

import java.sql.SQLException;
import java.util.List;

public interface TypeService {
    List<Type> selectType() throws SQLException;
}
