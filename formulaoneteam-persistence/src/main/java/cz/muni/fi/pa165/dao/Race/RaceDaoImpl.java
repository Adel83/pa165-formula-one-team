package cz.muni.fi.pa165.dao.Race;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

import cz.muni.fi.pa165.entity.Race;
import org.springframework.stereotype.Repository;

/**
 * @author Adel Chakouri
 */

@Repository
public class RaceDaoImpl implements RaceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Race findById(Long id) {
        return entityManager.find(Race.class, id);
    }

    @Override
    public void add(Race p) {
        entityManager.persist(p);
    }

    @Override
    public void update(Race p) {
        entityManager.merge(p);
    }

    @Override
    public void delete(Race p) {
        entityManager.remove(p);
    }

    @Override
    public List<Race> findByDate(Date date) {
        return entityManager
                .createQuery("select r from Race r where r.date = :date", Race.class)
                .getResultList();
    }

    @Override
    public Race findByTitle(String title) {
        try {
            return entityManager
                    .createQuery("select r from Race r where r.title = :title",
                            Race.class).setParameter("title", title)
                    .getSingleResult();
        } catch (NoResultException nrf) {
            return null;
        }
    }

    @Override
    public List<Race> findByLocation(String Location) {
        List<Race> resultList = entityManager
                .createQuery("select r from Race r where r.Location = :Location", Race.class)
                .getResultList();
        return resultList;
    }

    @Override
    public List<Race> findAll() {
        return entityManager
                .createQuery("select r from Race r", Race.class)
                .getResultList();
    }
}