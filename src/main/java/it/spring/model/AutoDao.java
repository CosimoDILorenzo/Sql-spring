package it.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import it.spring.Dao;

@Component
public class AutoDao implements Dao<Auto> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Auto", Integer.class);
    }
    @Override
    public Auto getOne(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Auto WHERE id = ?", new BeanPropertyRowMapper<Auto>(Auto.class),id);
    }

    @Override
    public List<Auto> getData() {
        return jdbcTemplate.query("SELECT * FROM Auto", new BeanPropertyRowMapper<Auto>(Auto.class));
    }

    @Override
    public boolean insert(Auto model) {
        int result = jdbcTemplate.update("INSERT INTO Auto (modello,colore,cv,brand_id) VALUE (?,?,?,?)", model.getModello(), model.getColore(), model.getCvv(), model.getBrand_id());
        return result > 0;
    }

    @Override
    public boolean update(Long id, Auto model) {
        int result = jdbcTemplate.update("UPDATE Auto SET modello = ?, colore = ?, cv = ?, brand_id = ? WHERE id = ?",model.getModello(), model.getColore(), model.getCvv(), model.getBrand_id(), id);
        return result > 0;
    }

    @Override
    public boolean delete(Long id) {
        int result = jdbcTemplate.update("DELETE FROM Auto WHERE id = ?",id);
        return result > 0;
    }
    
}
