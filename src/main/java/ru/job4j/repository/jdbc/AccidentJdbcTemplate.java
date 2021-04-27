package ru.job4j.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.job4j.model.Accident;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.StoreDAO;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;

@Repository
public class AccidentJdbcTemplate implements StoreDAO<Accident> {
    private final JdbcTemplate jdbc;
    private final RuleJdbcTemplate ruleJdbcTemplate;
    private final RowMapper<Accident> accidentMapper;

    public AccidentJdbcTemplate(JdbcTemplate jdbc, RuleJdbcTemplate ruleJdbcTemplate) {
        this.jdbc = jdbc;
        this.ruleJdbcTemplate = ruleJdbcTemplate;
        accidentMapper = (rs, row) ->
                (Accident.of(
                        rs.getInt("id"),
                        rs.getString("name"),
                        AccidentType.of(
                                rs.getInt("type_id"),
                                rs.getString("type_name")),
                        new HashSet<>(ruleJdbcTemplate.findRulesByAccidentId(rs.getInt("id"))),
                        rs.getString("text"),
                        rs.getString("address")));
    }

    public Accident saveOrUpdate(Accident accident) {
        return accident.getId() == 0 ? save(accident) : update(accident);
    }

    private Accident save(Accident accident) {
        String insertSql = "INSERT INTO accidents (name, text, address, type_id)"
                + " VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertSql, new String[]{"id"});
            ps.setString(1, accident.getName());
            ps.setString(2, accident.getText());
            ps.setString(3, accident.getAddress());
            ps.setInt(4, accident.getType().getId());
            return ps;
        }, keyHolder);

        Number keyNumber = keyHolder.getKey();
        if (keyNumber != null && accident.getRules() != null) {
            int key = keyNumber.intValue();
            accident.setId(key);
            ruleJdbcTemplate.saveAccidentRule(key, accident.getRules());
        }
        return accident;
    }

    private Accident update(Accident accident) {
        String update = "UPDATE accidents SET name = ?, text = ?, address = ?, type_id = ?"
                + " WHERE id = ?";
        jdbc.update(update,
                accident.getName(), accident.getText(), accident.getAddress(), accident.getType().getId(), accident.getId());
        if (accident.getRules() != null) {
            ruleJdbcTemplate.updateAccidentRule(accident.getId(), accident.getRules());
        }
        return accident;
    }
    @Override
    public Accident getById(Integer id) {
        return jdbc.queryForObject("SELECT a.id, a.name, text, address, at.id type_id, at.name type_name FROM accidents a JOIN atypes at ON a.type_id = at.id WHERE a.id = ?;",
                accidentMapper, id
        );
    }

    @Override
    public Accident delete(Integer id) {
        return null;
    }

    public List<Accident> getAll() {
        return jdbc.query("SELECT a.id, a.name, text, address, at.id type_id, at.name type_name FROM accidents a JOIN atypes at ON a.type_id = at.id;",
                accidentMapper
            );
    }
}