package edu.solvd.mentoring.myBatis.dao.impl;

import edu.solvd.mentoring.myBatis.config.SessionFactory;
import edu.solvd.mentoring.myBatis.dao.CarDao;
import edu.solvd.mentoring.myBatis.model.CarModel;
import org.apache.ibatis.session.SqlSession;

public class CarDAOImpl implements CarDao {

    private final static String namespace = "car_mapper";

    @Override
    public CarModel getById(long id) {
            SqlSession sqlSession = SessionFactory.getSession();
            CarModel cm = sqlSession.selectOne(namespace + ".getById", id);
            sqlSession.close();
            return cm;

    }
}
