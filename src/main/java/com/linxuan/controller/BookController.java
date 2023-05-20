package com.linxuan.controller;

import com.github.pagehelper.PageInfo;
import com.linxuan.common.R;
import com.linxuan.entity.Book;
import com.linxuan.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 添加图书信息
     *
     * @param book 前端传过来的图书信息
     * @return 返回添加成功
     */
    @PostMapping()
    public R<String> insert(@RequestBody Book book) {
        if (book == null) {
            return R.error("添加错误");
        }
        bookService.insertBookAndRecord(book);
        return R.success("添加成功");
    }

    /**
     * 删除图书信息以及借阅记录信息
     *
     * @param id 前端传过来需要删除图书信息的ID
     * @return 返回删除结果
     */
    @DeleteMapping("/delete")
    public R<String> delete(Integer id) {
        if (id == null) {
            return R.error("删除错误");
        }
        bookService.deleteBookAndRecord(id);
        return R.success("删除成功");
    }

    /**
     * 修改图书信息以及借阅信息
     *
     * @param book 前端传过来需要修改为的图书信息
     * @return 返回修改是否成功
     */
    @PutMapping()
    public R<String> update(@RequestBody Book book) {
        // 如果前端传过来的图书信息为0可借阅 3已下架 那么强制让借阅人、借阅时间、归还时间为NULL
        if (book.getBookStatus() == '0' || book.getBookStatus() == '3') {
            book.setBookBorrower(null);
            book.setBookBorrowtime(null);
            book.setBookReturntime(null);
        }
        // 修改图书信息已经借阅信息
        bookService.updateBookAndRecord(book);
        return R.success("修改成功");
    }

    /**
     * 分页查询图书信息
     *
     * @param page     页数
     * @param pageSize 每页数量
     * @return 返回分页查询出来的结果
     */
    @GetMapping("/page")
    public R<PageInfo<Book>> page(Integer page, Integer pageSize, Character status) {
        PageInfo<Book> pageInfo = bookService.findBookPage(page, pageSize, status);
        return R.success(pageInfo);
    }

    /**
     * 根据图书ID查询图书信息
     *
     * @param id 图书ID
     * @return 返回查询出来的图书信息
     */
    @GetMapping("/{id}")
    public R<Book> get(@PathVariable Integer id) {
        if (id != null) {
            Book book = bookService.getBookById(id);
            return R.success(book);
        }
        return R.error("查询失败");
    }
}
