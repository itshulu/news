package sl.itcast.news.dao;

import sl.itcast.news.entity.type;

import java.sql.SQLException;
import java.util.List;

public interface typeDao {
    List<type> selectType() throws SQLException;
}
