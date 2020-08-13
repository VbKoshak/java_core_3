package edu.solvd.mentoring.service;

import edu.solvd.mentoring.myBatis.dao.CarDao;
import edu.solvd.mentoring.myBatis.dao.impl.CarDAOImpl;
import edu.solvd.mentoring.myBatis.model.CarModel;

public class CarService {
    CarDao carDAO = new CarDAOImpl();

    public CarModel getCarModelById(long id) {return carDAO.getById(id);}
}
