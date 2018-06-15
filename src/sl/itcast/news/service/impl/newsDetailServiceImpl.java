package sl.itcast.news.service.impl;

import sl.itcast.news.dao.impl.newsDetailDaoImpl;
import sl.itcast.news.dao.NewsDetailDao;
import sl.itcast.news.entity.newsDetail;
import sl.itcast.news.service.newsDetailService;

import java.sql.SQLException;
import java.util.List;

public class newsDetailServiceImpl implements newsDetailService {
    private NewsDetailDao detailDao = new newsDetailDaoImpl();

    @Override
    public void addNew(newsDetail newsdetail) {
        detailDao.addNew(newsdetail);
    }

    @Override
    public void delectNew(String id) {
        detailDao.delectNew(id);
    }

    @Override
    public void updataNew(newsDetail newsDetail) {
        detailDao.updataNew(newsDetail);
    }

    @Override
    public List<newsDetail> updataLikeNew(String newsname) throws SQLException {
        return detailDao.updataLikeNew(newsname);
    }

    @Override
    public List<newsDetail> select() throws SQLException {
        return detailDao.select();
    }

    @Override
    public newsDetail findById(String id) throws SQLException {
        return detailDao.findById(id);
    }

    @Override
    public newsDetail quire(String id) throws SQLException {
        return detailDao.quire(id);
    }
}
