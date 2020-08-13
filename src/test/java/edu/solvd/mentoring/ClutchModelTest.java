package edu.solvd.mentoring;

import edu.solvd.mentoring.myBatis.model.CarModel;
import edu.solvd.mentoring.myBatis.model.ClutchModel;
import edu.solvd.mentoring.service.CarService;
import edu.solvd.mentoring.service.ClutchService;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ClutchModelTest {
    private static final Logger LOGGER = Logger.getLogger(ClutchModelTest.class);

    @Test
    public void testClutchModelGetById() {
        List<ClutchModel> a = new ClutchService().getClutchModelById(1);
        Assert.assertEquals(a.get(1).getClutch(),5);
    }
}
