package sl.itcast.news.service.impl;

import sl.itcast.news.dao.impl.typeDaoImpl;
import sl.itcast.news.dao.typeDao;
import sl.itcast.news.entity.type;
import sl.itcast.news.service.typeService;

import java.sql.SQLException;
import java.util.List;

public class typeServiceImpl implements typeService {
    private typeDao typeDao=new typeDaoImpl();
    @Override
    public List<type> selectType() throws SQLException {
        return typeDao.selectType();
    }
}
