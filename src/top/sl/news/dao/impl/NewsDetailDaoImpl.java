package top.sl.news.dao.impl;

import top.sl.news.dao.NewsDetailDao;
import top.sl.news.entity.NewsDetail;
import top.sl.news.util.DaoUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NewsDetailDaoImpl implements NewsDetailDao {
    @Override
    public void addNew(NewsDetail newsdetail) {
        String sql = "insert into newsdetail values(?,?,?,?,?,?)";
        Timestamp timestamp = new Timestamp(newsdetail.getTime().getTime());
        PreparedStatement pstmt = null;
        try {
            pstmt = DaoUtils.getConn().prepareStatement(sql);
            pstmt.setString(1, newsdetail.getId());
            pstmt.setString(2, newsdetail.getTitle());
            pstmt.setString(3, newsdetail.getContent());
            pstmt.setString(4, newsdetail.getAuthor());
            pstmt.setTimestamp(5, timestamp);
            pstmt.setString(6, newsdetail.getType_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DaoUtils.getDaoUtils().closeAll(DaoUtils.getConn(), pstmt, null);
        }
    }

    @Override
    public void delectNew(String id) {
        System.out.println(id);
        String sql = "delete from newsdetail where id=?";
        String[] strs = {id};
        DaoUtils.getDaoUtils().executeUpdateSQL(sql, strs, DaoUtils.getConn());
    }

    @Override
    public void updataNew(NewsDetail newsDetail) {
        String sql = "UPDATE newsdetail SET title=?,content=?,author=?,type_id=? WHERE id=?";
        String[] strs = {newsDetail.getTitle(), newsDetail.getContent(), newsDetail.getAuthor(), newsDetail.getType_id(), newsDetail.getId()};
        DaoUtils.getDaoUtils().executeUpdateSQL(sql, strs, DaoUtils.getConn());
    }

    @Override
    public List<NewsDetail> updataLikeNew(String newsname) throws SQLException {
        List<NewsDetail> list = new ArrayList<>();
        String sql = "SELECT id,title,content,author,[time],typename AS type_id FROM newsdetail JOIN Type ON typeid=newsdetail.type_id where title like ?";
        NewsDetail newsDetail = new NewsDetail();
        newsname = "%" + newsname + "%";
        String[] strs = {newsname};
        ResultSet resultSet = DaoUtils.getDaoUtils().executeQuerySQL(sql, strs, DaoUtils.getConn());
        while (resultSet.next()) {
            newsDetail.setId(resultSet.getString("id"));
            newsDetail.setAuthor(resultSet.getString("author"));
            newsDetail.setContent(resultSet.getString("content"));
            newsDetail.setTime(resultSet.getTime("time"));
            newsDetail.setTitle(resultSet.getString("title"));
            newsDetail.setType_id(resultSet.getString("type_id"));
            list.add(newsDetail);
        }
        return list;
    }

    @Override
    public NewsDetail quire(String id) throws SQLException {
        NewsDetail newsDetail = new NewsDetail();
        String sql = "SELECT id,title,content,author,[time],typename AS type_id FROM newsdetail JOIN Type ON typeid=newsdetail.type_id where id=?";
        String[] strs = {id};
        ResultSet resultSet = DaoUtils.getDaoUtils().executeQuerySQL(sql, strs, DaoUtils.getConn());
        resultSet.next();
        newsDetail.setId(resultSet.getString("id"));
        newsDetail.setAuthor(resultSet.getString("author"));
        newsDetail.setContent(resultSet.getString("content"));
        newsDetail.setTime(resultSet.getTime("time"));
        newsDetail.setTitle(resultSet.getString("title"));
        newsDetail.setType_id(resultSet.getString("type_id"));
        return newsDetail;
    }

    @Override
    public List<NewsDetail> select() throws SQLException {
        List<NewsDetail> list = new ArrayList<>();
        String sql = "SELECT id,title,content,author,[time],typename AS type_id FROM newsdetail JOIN Type ON typeid=newsdetail.type_id";
        ResultSet resultSet = DaoUtils.getDaoUtils().executeQuerySQL(sql, null, DaoUtils.getConn());
        while (resultSet.next()) {
            NewsDetail newsDetail = new NewsDetail();
            newsDetail.setId(resultSet.getString("id"));
            newsDetail.setAuthor(resultSet.getString("author"));
            newsDetail.setContent(resultSet.getString("content"));
            newsDetail.setTime(resultSet.getTime("time"));
            newsDetail.setTitle(resultSet.getString("title"));
            newsDetail.setType_id(resultSet.getString("type_id"));
            list.add(newsDetail);
        }
        return list;
    }

    @Override
    public NewsDetail findById(String id) throws SQLException {
        String sql = "SELECT id,title,content,author,[time],typename AS type_id FROM newsdetail JOIN Type ON typeid=newsdetail.type_id where id=?";
        NewsDetail newsDetail = new NewsDetail();
        String[] strs = {id};
        ResultSet resultSet = DaoUtils.getDaoUtils().executeQuerySQL(sql, strs, DaoUtils.getConn());
        resultSet.next();
        newsDetail.setId(resultSet.getString("id"));
        newsDetail.setAuthor(resultSet.getString("author"));
        newsDetail.setContent(resultSet.getString("content"));
        newsDetail.setTime(resultSet.getTime("time"));
        newsDetail.setTitle(resultSet.getString("title"));
        newsDetail.setType_id(resultSet.getString("type_id"));
        return newsDetail;
    }
}
