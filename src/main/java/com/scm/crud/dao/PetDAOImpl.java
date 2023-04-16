package com.scm.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.scm.crud.model.Pet;

public class PetDAOImpl implements PetDAO {

    private JdbcTemplate jdbcTemplate;

    public PetDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int savePet(Pet pet) {
        String sql = "INSERT INTO petinfo (name,sex,age,type,hobby) values (?,?,?,?,?)";
        int result = jdbcTemplate.update(sql, pet.getName(), pet.getSex(), pet.getAge(), pet.getType(), pet.getHobby());
        return result;
    }

    @Override
    public Pet getPetById(int id) {
        String sql = "SELECT * FROM petinfo where id=" + id;
        ResultSetExtractor<Pet> extractor = new ResultSetExtractor<Pet>() {

            @Override
            public Pet extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String sex = rs.getString("sex");
                    String age = rs.getString("age");
                    String type = rs.getString("type");
                    String hobby = rs.getString("hobby");
                    Pet petObj = new Pet(name, sex, age, type, hobby);
                    return petObj;
                }
                return null;
            }
        };
        return jdbcTemplate.query(sql, extractor);
    }

    @Override
    public List<Pet> getPetList() {
        String sql = "SELECT * FROM petinfo";
        RowMapper<Pet> rMapper = new RowMapper<Pet>() {

            @Override
            public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String age = rs.getString("age");
                String type = rs.getString("type");
                String hobby = rs.getString("hobby");
                Pet petObj = new Pet(id,name, sex, age, type, hobby);
                return petObj;
            }
        };
        return jdbcTemplate.query(sql, rMapper);
    }

    @Override
    public int updatePet(Pet pet) {
        String sql = "UPDATE petinfo SET name=?,sex=?,age=?,type=?,hobby=? WHERE id=?";
        int result = jdbcTemplate.update(sql,pet.getName(),pet.getSex(),pet.getAge(),pet.getType(),pet.getHobby(),pet.getId());
        return result;
    }

    @Override
    public int deletePet(int id) {
        String sql = "DELETE FROM petinfo WHERE id="+id;
        return jdbcTemplate.update(sql);
    }

}
