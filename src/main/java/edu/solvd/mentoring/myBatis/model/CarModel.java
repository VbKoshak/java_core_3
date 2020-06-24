package edu.solvd.mentoring.myBatis.model;

import java.util.List;

public class CarModel {
    private long id;
    private long speed;
    private long boost;
    private List<ClutchModel> clutch;

    public CarModel() {

    }

    public CarModel(long speed, long boost, List<ClutchModel> clutch) {
        this.speed = speed;
        this.boost = boost;
        this.clutch = clutch;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public long getBoost() {
        return boost;
    }

    public void setBoost(long boost) {
        this.boost = boost;
    }

    public List<ClutchModel> getClutch() {
        return clutch;
    }

    public void setClutch(List<ClutchModel> clutch) {
        this.clutch = clutch;
    }
}
