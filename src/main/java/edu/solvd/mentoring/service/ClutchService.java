package edu.solvd.mentoring.service;

import edu.solvd.mentoring.myBatis.dao.ClutchDAO;
import edu.solvd.mentoring.myBatis.dao.impl.ClutchDAOImpl;
import edu.solvd.mentoring.myBatis.model.ClutchModel;

import java.util.List;

public class ClutchService {
    ClutchDAO clutchDAO = new ClutchDAOImpl();

    public List<ClutchModel> getClutchModelById(long id) {
        return clutchDAO.getById(id);
    }
}
