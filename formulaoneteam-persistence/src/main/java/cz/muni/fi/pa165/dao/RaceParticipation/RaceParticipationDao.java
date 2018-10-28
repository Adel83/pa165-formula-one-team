package cz.muni.fi.pa165.dao.RaceParticipation;

import cz.muni.fi.pa165.entity.Race;
import cz.muni.fi.pa165.entity.carSetup;
import cz.muni.fi.pa165.entity.Driver;
import cz.muni.fi.pa165.entity.RaceParticipation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaceParticipationDao {
    public RaceParticipation findById(Long id);
    public void add(RaceParticipation p);
    public void delete(RaceParticipation p);
    public void update(RaceParticipation p);
    public List <RaceParticipation> findByResultPosition(int resultPosition);
    public List <RaceParticipation> findByCar(carSetup car);
    public List <RaceParticipation> findByDriver(Driver driver);
    public List <RaceParticipation> findByRace(Race race);

}
