package top.sl.news.service.impl;

import top.sl.news.dao.impl.NewsDetailDaoImpl;
import top.sl.news.dao.NewsDetailDao;
import top.sl.news.entity.NewsDetail;
import top.sl.news.service.NewsDetailService;

import java.sql.SQLException;
import java.util.List;

public class NewsDetailServiceImpl implements NewsDetailService {
    private NewsDetailDao detailDao = new NewsDetailDaoImpl();

    @Override
    public void addNew(NewsDetail newsdetail) {
        detailDao.addNew(newsdetail);
    }

    @Override
    public void delectNew(String id) {
        detailDao.delectNew(id);
    }

    @Override
    public void updataNew(NewsDetail newsDetail) {
        detailDao.updataNew(newsDetail);
    }

    @Override
    public List<NewsDetail> updataLikeNew(String newsname) throws SQLException {
        return detailDao.updataLikeNew(newsname);
    }

    @Override
    public List<NewsDetail> select() throws SQLException {
        return detailDao.select();
    }

    @Override
    public NewsDetail findById(String id) throws SQLException {
        return detailDao.findById(id);
    }

    @Override
    public NewsDetail quire(String id) throws SQLException {
        return detailDao.quire(id);
    }
}
