package ru.job4j.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import ru.job4j.model.Rule;
import ru.job4j.repository.StoreDAO;
import java.util.List;



@Repository
public class RuleStore implements StoreDAO<Rule> {
    private final SessionFactory sessionFactory;

    public RuleStore(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Rule saveOrUpdate(Rule entity) {
        return null;
    }

    @Override
    public Rule getById(Integer id) {
        Rule rule;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            rule = session.createQuery("SELECT rule FROM ru.job4j.model.Rule rule WHERE rule.id = :id", Rule.class)
            .setParameter("id", id).getSingleResult();
            tx.commit();
        }
        return rule;
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.createQuery("DELETE FROM ru.job4j.model.Rule rule " +
                    "WHERE rule.id = :id", Rule.class).setParameter("id", id)
                    .executeUpdate();
            tx.commit();
        }
    }

    @Override
    public List<Rule> getAll() {
        List<Rule> rules;
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            rules = session.createQuery("FROM ru.job4j.model.Rule", Rule.class)
                    .list();
            tx.commit();
        }
        return rules;
    }
}
