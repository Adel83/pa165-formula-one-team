package cz.muni.fi.pa165.dao.TestDrive;
import cz.muni.fi.pa165.dao.base.Dao;
import cz.muni.fi.pa165.entity.TestDrive;
import cz.muni.fi.pa165.entity.carSetup;
import cz.muni.fi.pa165.entity.Driver;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Adel Chakouri
 */
@Repository
public interface TestDriveDao extends Dao<TestDrive> {

    public TestDrive findById(Long id);
    public void add(TestDrive p);
    public void delete(TestDrive p);
    public void update(TestDrive p);
    public List<TestDrive> findByNotes(String notes);
    public List<TestDrive> findByCar(carSetup car);
    public List<TestDrive> findByRace(Driver driver);
}
