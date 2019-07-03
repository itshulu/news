package top.sl.news.dao.impl;

import top.sl.news.dao.TypeDao;
import top.sl.news.entity.Type;
import top.sl.news.util.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    @Override
    public List<Type> selectType() throws SQLException {

        List<Type> list=new ArrayList<>();
        String sql="select * from Type";
        ResultSet resultSet = DaoUtils.getDaoUtils().executeQuerySQL(sql, null, DaoUtils.getConn());
        while (resultSet.next()){
            Type type = new Type();
            type.setType_id(resultSet.getString("typeid"));
            type.setTypename(resultSet.getString("typename"));
            list.add(type);
        }
        return list;
    }
}
