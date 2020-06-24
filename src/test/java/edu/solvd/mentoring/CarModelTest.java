package edu.solvd.mentoring;

import edu.solvd.mentoring.myBatis.model.CarModel;
import edu.solvd.mentoring.service.CarService;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarModelTest {
    private static final Logger LOGGER = Logger.getLogger(CarModelTest.class);

    @Test
    public void testCarModelGetById() {
        CarModel a = new CarService().getCarModelById(1);
        Assert.assertEquals(a.getBoost(),5);
    }
}
