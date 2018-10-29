package cz.muni.fi.pa165.dao.RaceParticipation;

import cz.muni.fi.pa165.entity.RaceParticipation;
import org.springframework.stereotype.Repository;
import cz.muni.fi.pa165.entity.Race;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 * @author Adel Chakouri
 */

@Repository
public class RaceParticipationDaoImpl implements RaceParticipationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RaceParticipation findById(Long id) {
        return entityManager.find(RaceParticipation.class, id);
    }
    @Override
    public void add(RaceParticipation p) {entityManager.persist(p);}

    @Override
    public void update(RaceParticipation p) {entityManager.merge(p);}

    @Override
    public void delete(RaceParticipation p) {entityManager.remove(p);}

    @Override
    public List<RaceParticipation> findByResultPosition(int resultPosition){
        return entityManager
                .createQuery("select r from RaceParticipation r where r.resultPosition = :resultPosition", RaceParticipation.class)
                .getResultList();

    }

    @Override
    public List <RaceParticipation> findByCar(carSetup car){
        return entityManager
                .createQuery("select r from RaceParticipation r where r.car = :car", RaceParticipation.class)
                .getResultList();

    }

    @Override
    public List <RaceParticipation> findByDriver(Driver driver){
        return entityManager
                .createQuery("select r from RaceParticipation r where r.driver = :driver", RaceParticipation.class)
                .getResultList();

    }

    @Override
    public List <RaceParticipation> findByRace(Race race){
        return entityManager
                .createQuery("select r from RaceParticipation r where r.race = :race", RaceParticipation.class)
                .getResultList();

    }

    @Override
    public List<RaceParticipationDao> findAll() {
        return entityManager
                .createQuery("select r from RaceParticipation r", RaceParticipation.class)
                .getResultList();

    }
}
