package org.sboot.ssmp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.sboot.ssmp.domain.Book;
import org.sboot.ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    IBookService bookService;

    @Test
    void testGetById() {
        System.out.println(bookService.getById(4));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据");
        book.setName("测试数据");
        book.setDescription("测试数据");
        System.out.println(bookService.save(book));
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(52);
        book.setType("测试数据2");
        book.setName("测试数据2");
        book.setDescription("测试数据2");
        System.out.println(bookService.updateById(book));
    }

    @Test
    void testDelete() {
        System.out.println(bookService.removeById(54));
    }

    @Test
    void testPage() {
        IPage<Book> page = new Page<>(1,5);
        System.out.println(bookService.page(page));
    }

}