package org.sboot.ssmp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.sboot.ssmp.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    void testSelect() {
        System.out.println(bookMapper.selectById(1));
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("测试数据");
        book.setName("测试数据");
        book.setDescription("测试数据");
        System.out.println(bookMapper.insert(book));
    }

    @Test
    void testDelete() {
        System.out.println(bookMapper.deleteById(54));
    }

    @Test
    void testGetAll() {
        System.out.println(bookMapper.selectList(null));
    }

    @Test
    void testPage() {
        IPage page = new Page(1, 5);
        System.out.println(bookMapper.selectPage(page, null));
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");
        System.out.println(bookMapper.selectList(qw));
    }

    @Test
    void testGetBy2() {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//        lqw.like(Book::getName, "Spring");
        lqw.likeRight(Book::getName, "Spring");
        System.out.println(bookMapper.selectList(lqw));
    }

    @Test
    void testGetBy3() {
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//        if (name != null) lqw.like(Book::getName, "Spring");
        lqw.like(name != null, Book::getName, "Spring");
        System.out.println(bookMapper.selectList(lqw));
    }
}