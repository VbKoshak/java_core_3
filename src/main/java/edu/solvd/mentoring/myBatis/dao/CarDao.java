package edu.solvd.mentoring.myBatis.dao;

import edu.solvd.mentoring.myBatis.config.SessionFactory;
import edu.solvd.mentoring.myBatis.model.CarModel;
import org.apache.ibatis.session.SqlSession;

public interface CarDao {

    public CarModel getById(long id);
}
