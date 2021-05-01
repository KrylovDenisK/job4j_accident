package ru.job4j.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.StoreDAO;

import java.util.List;


//@Repository
public class AccidentTypeStore implements StoreDAO<AccidentType> {
    private final SessionFactory sessionFactory;

    public AccidentTypeStore(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
       }

    @Override
    public AccidentType saveOrUpdate(AccidentType accidentType) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(accidentType);
            tx.commit();
        }
        return accidentType;

    }

    @Override
    public AccidentType getById(Integer id) {
        AccidentType accidentType;
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            accidentType = session.createQuery("SELECT accidentType FROM ru.job4j.model.AccidentType accidentType " +
                    "WHERE accidentType.id = :id", AccidentType.class).setParameter("id", id)
                    .uniqueResult();
            tx.commit();
        }
        return accidentType;
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createQuery("DELETE FROM ru.job4j.model.AccidentType accidentType " +
                    "WHERE accidentType.id = :id", AccidentType.class).setParameter("id", id)
                    .executeUpdate();
            tx.commit();
        }
    }

    @Override
    public List<AccidentType> getAll() {
        List<AccidentType> accidentTypes;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            accidentTypes = session.createQuery("FROM ru.job4j.model.AccidentType", AccidentType.class)
                    .list();
            tx.commit();
        }
        return accidentTypes;
    }
}
