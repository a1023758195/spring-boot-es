package com.atgaoyf.esearch;

import com.atgaoyf.esearch.com.Student;
import com.atgaoyf.esearch.repository.StudentRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootEsApplicationTests {

    @Autowired
    private JestClient jestClient;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void contextLoads() {

        //索引一个文档
        Student student = new Student();
        student.setId(1);
        student.setName("王二");
        student.setSex("女");
        student.setAge(22);

        Index index = new Index.Builder(student).index("atgaoyf").type("cls").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {

        String json = "{\n" +
                "\"query\" : {\n" +
                "\"match\" : {\n" +
                "\"name\" : \"王\"\n" +
                "}\n" +
                "}\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("atgaoyf").addType("cls").build();
        try {
            SearchResult searchResult = jestClient.execute(search);
            System.out.println(searchResult.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRes() {

        Student student = new Student();
        student.setId(2);
        student.setName("欧阳");
        student.setAge(13);
        student.setSex("男");
        studentRepository.index(student);
    }

    @Test
    public  void testSearch2() {

        for(Student student : studentRepository.findByNameLike("欧")) {

            System.out.println(student);
        }
    }



}
