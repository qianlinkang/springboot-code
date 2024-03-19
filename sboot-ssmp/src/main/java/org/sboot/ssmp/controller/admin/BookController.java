package org.sboot.ssmp.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sboot.ssmp.domain.Book;
import org.sboot.ssmp.service.IBookService;
import org.sboot.ssmp.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "书籍接口")
@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private IBookService bookService;

    @ApiOperation("获取全部书籍")
    @GetMapping
    public Result<List<Book>> getAll() {
        return Result.ok(bookService.list());
    }

    @ApiOperation("新增书籍")
    @PostMapping
    public Result<Boolean> save(@RequestBody Book book) throws Exception {
        if ("error".equals(book.getName())) throw new Exception("111");
        return Result.ok(bookService.save(book));
    }

    @ApiOperation("更新书籍")
    @PutMapping
    public Result<Boolean> update(@RequestBody Book book) {
        return Result.ok(bookService.updateById(book));
    }

    @ApiOperation("删除书籍")
    @DeleteMapping("{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.ok(bookService.removeById(id));
    }

    @ApiOperation("获取单本书籍")
    @GetMapping("{id}")
    public Result<Book> getById(@PathVariable Integer id) {
        return Result.ok(bookService.getById(id));
    }

    @ApiOperation("分页")
    @GetMapping("/{currentPage}/{pageSize}")
    public Result<IPage<Book>> getAll(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Book book) {
        // 如果当前页码值大于总页码值,那么重新执行查询操作,使用最大页码值作为当前页码值
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return Result.ok(page);
    }
}
