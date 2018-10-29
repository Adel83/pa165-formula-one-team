package cz.muni.fi.pa165.dao.Race;
import cz.muni.fi.pa165.dao.base.Dao;
import cz.muni.fi.pa165.entity.Race;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Adel Chakouri
 */
@Repository
public interface RaceDao extends Dao<Race> {
     List <Race> findByDate(Date date);
     Race findByTitle(String title);
     List<Race> findByLocation(String Location);
}
