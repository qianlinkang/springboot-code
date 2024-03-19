package org.sboot.mapper;

import org.junit.jupiter.api.Test;
import org.sboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {

//    @Autowired
//    private BookMapper bookMapper;



    @Test
    void test1() {
//        Book book = bookMapper.selectById(10);
//        System.out.println("book = " + book);
    }

    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate) {
//        String sql = "select * from tbl_book";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        System.out.println("maps = " + maps);
    }


    @Test
    void testJdbcTemplate2(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "select * from tbl_book";
        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setType(rs.getString("type"));
                book.setDescription(rs.getString("description"));
                return book;
            }
        };

        List<Book> list = jdbcTemplate.query(sql, rm);
        System.out.println("list = " + list);

    }
}