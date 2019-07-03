package top.sl.news.dao;

import top.sl.news.entity.NewsDetail;

import java.sql.SQLException;
import java.util.List;

public interface NewsDetailDao {
    void addNew(NewsDetail newsdetail);
    void delectNew(String id);
    void updataNew(NewsDetail newsDetail);
    List<NewsDetail> updataLikeNew(String newsname) throws SQLException;
    NewsDetail quire(String id) throws SQLException;
    List<NewsDetail> select() throws SQLException;
    NewsDetail findById(String id) throws SQLException;
}
