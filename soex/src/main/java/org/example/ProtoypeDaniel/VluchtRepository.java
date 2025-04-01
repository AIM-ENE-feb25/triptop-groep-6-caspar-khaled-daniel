package org.example.ProtoypeDaniel;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class VluchtRepository {

    private final JdbcTemplate jdbcTemplate;

    public VluchtRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Vlucht> findByUsername(String username) {
        return null;
    }

    public void slaVluchtOp(Vlucht vlucht, String username) {

    }
}
