package com.atgaoyf.esearch.com;

import io.searchbox.annotations.JestId;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "atgaoyf", type = "cls")
public class Student {

    @JestId
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}
