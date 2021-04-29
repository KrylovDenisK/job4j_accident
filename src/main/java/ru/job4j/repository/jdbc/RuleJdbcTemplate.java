package ru.job4j.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Rule;
import ru.job4j.repository.StoreDAO;
import java.util.List;
import java.util.Set;

//@Repository
public class RuleJdbcTemplate implements StoreDAO<Rule> {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Rule> ruleMapper;

    public RuleJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        ruleMapper = (rs, row) -> (
                Rule.of(
                        rs.getInt("id"),
                        rs.getString("name")
                )
        );
    }

    @Override
    public Rule saveOrUpdate(Rule entity) {
        return null;
    }

    @Override
    public Rule getById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT id, name FROM rules WHERE id = ?",
                ruleMapper, id);
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public List<Rule> getAll() {
        return jdbcTemplate.query("SELECT id, name FROM rules",
                ruleMapper
                );
    }

    public List<Rule> findRulesByAccidentId(Integer id) {
        return jdbcTemplate.query("SELECT id, name FROM accident_rule acru JOIN rules r ON acru.rule_id = r.id WHERE accident_id = ?",
                ruleMapper, id
        );
    }

    public void saveAccidentRule(Integer accidentId, Set<Rule> rules) {
            for (Rule rule : rules) {
                jdbcTemplate.update("INSERT INTO accident_rule (accident_id, rule_id) VALUES (?, ?)",
                        accidentId, rule.getId());
            }
    }

    public void updateAccidentRule(Integer accidentId, Set<Rule> rules) {
        jdbcTemplate.update("DELETE FROM accident_rule WHERE accident_id = ?",
                accidentId);
        saveAccidentRule(accidentId, rules);
    }
}
