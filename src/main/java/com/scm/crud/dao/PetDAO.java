package com.scm.crud.dao;

import java.util.List;

import com.scm.crud.model.Pet;

public interface PetDAO {
    public int savePet(Pet pet);

    public Pet getPetById(int id);

    public List<Pet> getPetList();

    public int updatePet(Pet pet);

    public int deletePet(int id);
}
