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
    public Race findById(Long id);
    public void add(Race p);
    public void delete(Race p);
    public void update(Race p);
    public List <Race> findByDate(Date date);
    public Race findByTitle(String title);
    public List<Race> findByLocation(String Location);



}
