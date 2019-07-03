package top.sl.news.service.impl;

import top.sl.news.dao.TypeDao;
import top.sl.news.dao.impl.TypeDaoImpl;
import top.sl.news.entity.Type;
import top.sl.news.service.TypeService;

import java.sql.SQLException;
import java.util.List;

public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao=new TypeDaoImpl();
    @Override
    public List<Type> selectType() throws SQLException {
        return typeDao.selectType();
    }
}
