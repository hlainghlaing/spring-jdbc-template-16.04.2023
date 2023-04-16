package com.scm.crud.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.scm.crud.model.Pet;

class PetDAOImplTest {

    private DriverManagerDataSource dataSource;
    private PetDAO dao;

    @BeforeEach
    void setForAll() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pet_list_db");
        dataSource.setUsername("root");
        dataSource.setPassword("#hh@root2023");
        dao = new PetDAOImpl(dataSource);
    }

    @Test
    void testSavePet() {
        Pet pet = new Pet("Shwe War", "Female", "7 months", "Cat", "Jumping");
        int result = dao.savePet(pet);
        assertTrue(result > 0);
    }

    @Test
    void testGetById() {
        Pet pet = dao.getPetById(2);
        assertNotNull(pet);
        System.out.println(pet);
    }

    @Test
    void testList() {
        List<Pet> petList = dao.getPetList();
        for (Pet list : petList) {
            System.out.println(list);
        }
        assertTrue(!petList.isEmpty());
    }

    @Test
    void testUpdate() {
        Pet pet = new Pet(2, "Shwe War", "Female", "8 months", "Cat", "Sleeping");
        int result = dao.updatePet(pet);
        assertTrue(result > 0);
    }

    @Test
    void testDelete() {
        int id = 2;
        int rs = dao.deletePet(id);
        assertTrue(rs > 0);
    }
}
