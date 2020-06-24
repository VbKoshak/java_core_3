package edu.solvd.mentoring.myBatis.dao;

import edu.solvd.mentoring.myBatis.model.ClutchModel;

import java.util.List;

public interface ClutchDAO {
    void create (ClutchModel clutch);
    List<ClutchModel> getById(long id);
    List<ClutchModel> getAll(long id);
}
