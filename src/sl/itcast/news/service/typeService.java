package sl.itcast.news.service;

import sl.itcast.news.entity.type;

import java.sql.SQLException;
import java.util.List;

public interface typeService {
    List<type> selectType() throws SQLException;
}
