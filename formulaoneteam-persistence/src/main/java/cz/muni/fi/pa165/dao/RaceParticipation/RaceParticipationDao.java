package cz.muni.fi.pa165.dao.RaceParticipation;

import cz.muni.fi.pa165.dao.base.Dao;
import cz.muni.fi.pa165.entity.Race;
import cz.muni.fi.pa165.entity.CarSetup;
import cz.muni.fi.pa165.entity.Driver;
import cz.muni.fi.pa165.entity.RaceParticipation;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Adel Chakouri
 */

@Repository
public interface RaceParticipationDao extends Dao<RaceParticipation> {
    public List <RaceParticipation> findByResultPosition(int resultPosition);
    public List <RaceParticipation> findByCar(CarSetup car);
    public List <RaceParticipation> findByDriver(Driver driver);
    public List <RaceParticipation> findByRace(Race race);

}
