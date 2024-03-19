package org.sboot;

import org.junit.jupiter.api.Test;
import org.sboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testSave() {
        Book book = new Book();
        book.setId(2);
        book.setName("springboot");
        book.setType("sboot");
        book.setDescription("描述");
        mongoTemplate.save(book);
    }

    @Test
    void testSelect() {
        List<Book> all = mongoTemplate.findAll(Book.class);
        System.out.println("all = " + all);
    }

    @Test
    void testData() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
        String format1 = format.format(new Date());
        System.out.println("format1 = " + format1);

    }
}
