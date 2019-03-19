package com.atgaoyf.esearch.repository;

import com.atgaoyf.esearch.com.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import java.util.List;


public interface StudentRepository extends ElasticsearchRepository<Student, Integer> {

    List<Student> findByNameLike(String name);
}
