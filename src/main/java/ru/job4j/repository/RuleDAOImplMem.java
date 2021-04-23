package ru.job4j.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class RuleDAOImplMem implements StoreDAO<Rule> {
    private Map<Integer, Rule> rules;

    public RuleDAOImplMem() {
        this.rules = new HashMap<>();
        rules.put(1, Rule.of(1, "Статья...1"));
        rules.put(2, Rule.of(2, "Статья...2"));
        rules.put(3, Rule.of(3, "Статья...3"));
    }

    @Override
    public Rule save(Rule entity) {
        return null;
    }

    @Override
    public Rule getById(Integer id) {
        return rules.get(id);
    }

    @Override
    public Rule delete(Integer id) {
        return null;
    }

    @Override
    public List<Rule> getAll() {
        return new ArrayList<>(rules.values());
    }
}