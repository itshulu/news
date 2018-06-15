package sl.itcast.news.service;

import sl.itcast.news.entity.newsDetail;

import java.sql.SQLException;
import java.util.List;

public interface newsDetailService {
    void addNew(newsDetail newsdetail);
    void delectNew(String id);
    void updataNew(newsDetail newsDetail);
    List<newsDetail> updataLikeNew(String newsname) throws SQLException;
    List<newsDetail> select() throws SQLException;
    newsDetail findById(String id) throws SQLException;
    newsDetail quire(String id) throws SQLException;
}