package edu.solvd.mentoring.myBatis.dao.impl;

import edu.solvd.mentoring.myBatis.config.SessionFactory;
import edu.solvd.mentoring.myBatis.dao.ClutchDAO;
import edu.solvd.mentoring.myBatis.model.ClutchModel;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClutchDAOImpl implements ClutchDAO {

    private final static String namespace = "clutch_mapper";

    @Override
    public void create(ClutchModel clutch) {

    }

    @Override
    public List<ClutchModel> getById(long id) {
        SqlSession sqlSession = SessionFactory.getSession();
        List<ClutchModel> a = sqlSession.selectList(namespace + ".getById", id);
        sqlSession.close();
        return a;
    }

    @Override
    public List<ClutchModel> getAll(long id) {
        SqlSession sqlSession = SessionFactory.getSession();
        List<ClutchModel> as = sqlSession.selectList(namespace + ".get");
        sqlSession.close();
        return as;
    }


}
