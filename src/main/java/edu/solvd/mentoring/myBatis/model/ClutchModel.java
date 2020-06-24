package edu.solvd.mentoring.myBatis.model;

public class ClutchModel {
    private int id;
    private int clutch;
    private String sym;
    private String surface;

    public ClutchModel() {

    }

    public int getClutch() {
        return clutch;
    }

    public void setClutch(int clutch) {
        this.clutch = clutch;
    }

    public String getSym() {
        return sym;
    }

    public void setSym(String sym) {
        this.sym = sym;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public ClutchModel(int clutch, String sym, String surface, int id) {
        this.clutch = clutch;
        this.sym = sym;
        this.surface = surface;
        this.id = id;
    }

    @Override
    public String toString() {return sym + clutch;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
