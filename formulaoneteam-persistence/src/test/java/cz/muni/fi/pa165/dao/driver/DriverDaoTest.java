package cz.muni.fi.pa165.dao.driver;

import cz.muni.fi.pa165.AppContextConfig;
import cz.muni.fi.pa165.entity.Driver;
import cz.muni.fi.pa165.entity.DriverStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.AssertJUnit;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author Adel Chakouri
 */

@ContextConfiguration(classes= AppContextConfig.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class DriverDaoTest extends AbstractTestNGSpringContextTests {

    @Inject
    private DriverDao driverDao;

    @Test
    public void addDriver_withValidData_isPersisted() {
        String mail ="Driver@drive.cz";
        Driver driver = createDriver(mail);

        //when
        driverDao.add(driver);

        //then
        AssertJUnit.assertNotNull(driverDao.findById(driver.getId()));
    }

    @Test
    public void deleteDriver_withValidData_isPersiste() {
        String mail = "Driver@drive.cz";
        Driver driver = createDriver(mail);

        driverDao.add(driver);
        driverDao.delete(driver);

        Driver result = driverDao.findByEmail(mail);
        assertNull(result);
    }

    @Test
    public void updateDriver_withEmail() {

       String oldMail="driver1@drive.cz";
       String newMail="driver22@drive.Cz";

       Driver driver = createDriver(oldMail);

       driverDao.add(driver);
       driver.setEmail(newMail);
       driverDao.update(driver);


        Driver newDriver = driverDao.findById(driver.getId());

        assertEquals(newMail,newDriver.getEmail());
    }

    @Test
    public void addTwoDrivers(){
        Driver d1 = createDriver("driver123@driver.fr");
        Driver d2 = createDriver("driver321@driver.cz");

        driverDao.add(d1);
        driverDao.add(d2);

        List<Driver> result = driverDao.findAll();
        assertEquals(2,result.size());
        assertTrue(result.contains(d1));
        assertTrue(result.contains(d2));
    }



    private Date createDate(int date, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }
    private Driver createDriver (String email){
        Driver driver = new Driver();
        driver.setBirthdate(createDate(2, 11, 1995));
        driver.setName("name");
        driver.setSurname("surname");
        driver.setNationality("nationality");
        driver.setDriverStatus(DriverStatus.MAIN);
        driver.setPassword("password");
        driver.setEmail(email);

        return driver;
    }
}
