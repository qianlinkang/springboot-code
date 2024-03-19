package org.sboot.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.sboot.ssmp.domain.Book;

import java.util.List;

public interface BookService2 {

    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getByPage(int currentPage, int pageSize);
}
