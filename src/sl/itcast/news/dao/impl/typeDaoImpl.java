package sl.itcast.news.dao.impl;

import sl.itcast.news.dao.typeDao;
import sl.itcast.news.entity.type;
import sl.itcast.news.util.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class typeDaoImpl implements typeDao {
    @Override
    public List<type> selectType() throws SQLException {

        List<type> list=new ArrayList<>();
        String sql="select * from type";
        ResultSet resultSet = DaoUtils.getDaoUtils().executeQuerySQL(sql, null, DaoUtils.getConn());
        while (resultSet.next()){
            type type = new type();
            type.setType_id(resultSet.getString("typeid"));
            type.setTypename(resultSet.getString("typename"));
            list.add(type);
        }
        return list;
    }
}
