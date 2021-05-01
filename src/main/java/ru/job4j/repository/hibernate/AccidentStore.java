package ru.job4j.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import ru.job4j.repository.StoreDAO;
import java.util.List;


//@Repository
public class AccidentStore implements StoreDAO<Accident> {
    private final SessionFactory sessionFactory;

    public AccidentStore(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Accident saveOrUpdate(Accident accident) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(accident);
            tx.commit();
        }
        return accident;
    }

    @Override
    public Accident getById(Integer id) {
        Accident accident;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            accident = session.createQuery("SELECT DISTINCT accident FROM ru.job4j.model.Accident accident " +
                    "JOIN FETCH accident.type LEFT JOIN FETCH accident.rules WHERE accident.id = :id ",
                    Accident.class).setParameter("id", id).uniqueResult();
            tx.commit();
        }
        return accident;
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createQuery("DELETE FROM ru.job4j.model.Accident accident " +
                    "WHERE accident.id = :id", Accident.class).setParameter("id", id)
                    .executeUpdate();
            tx.commit();
        }
    }


    @Override
    public List<Accident> getAll() {
        List<Accident> accidents;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            accidents = session.createQuery("SELECT DISTINCT accident FROM ru.job4j.model.Accident accident " +
                    "LEFT JOIN FETCH accident.type at LEFT JOIN FETCH accident.rules", Accident.class)
                    .getResultList();
            tx.commit();
        }
        return accidents;
    }
}
