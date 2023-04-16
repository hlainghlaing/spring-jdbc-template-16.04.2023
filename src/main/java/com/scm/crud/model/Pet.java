package com.scm.crud.model;

public class Pet {
    private int id;
    private String name;
    private String sex;
    private String age;
    private String type;
    private String hobby;

    public Pet() {
    }

    public Pet(String name, String sex, String age, String type, String hobby) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.hobby = hobby;
    }

    public Pet(int id, String name, String sex, String age, String type, String hobby) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Pet [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", type=" + type + ", hobby="
                + hobby + "]";
    }
}
