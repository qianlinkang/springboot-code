package org.sboot.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.sboot.ssmp.domain.Book;

public interface IBookService extends IService<Book> {

    Boolean customSave(Book book);

    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book);
}
