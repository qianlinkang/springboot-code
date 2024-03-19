package org.sboot.ssmp.service.impl;

import org.junit.jupiter.api.Test;
import org.sboot.ssmp.domain.Book;
import org.sboot.ssmp.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceImpl2Test {

    @Autowired
    BookService2 bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("测试数据");
        book.setType("测试数据");
        book.setDescription("测试数据");
        System.out.println(bookService.save(book));
    }

    @Test
    void testDelete() {
        System.out.println(bookService.delete(51));
    }

    @Test
    void testPage() {
        System.out.println(bookService.getByPage(1, 5));
    }

}