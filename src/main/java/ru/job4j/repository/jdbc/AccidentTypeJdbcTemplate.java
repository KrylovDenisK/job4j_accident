package ru.job4j.repository.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.model.AccidentType;
import ru.job4j.repository.StoreDAO;
import java.util.List;

@Repository
public class AccidentTypeJdbcTemplate implements StoreDAO<AccidentType> {
    private final JdbcTemplate jdbc;

    public AccidentTypeJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    @Override
    public AccidentType saveOrUpdate(AccidentType entity) {
        return null;
    }

    @Override
    public AccidentType getById(Integer id) {
        return null;
    }

    @Override
    public AccidentType delete(Integer id) {
        return null;
    }

    @Override
    public List<AccidentType> getAll() {
        return jdbc.query("SELECT id, name FROM aTypes",
                (rs, row) -> (
                        AccidentType.of(
                                rs.getInt("id"),
                                rs.getString("name")
                        )
                        ));
    }
}
