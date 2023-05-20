package com.linxuan.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.linxuan.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
// 如果是配置文件开发（或者混合开发），那么就是用这种方式加载配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    /**
     * 测试新增图书
     */
    @Test
    public void testInsertBook() {
        Book book = new Book(null, "图书名称", "图书ISBN编号",
                "图书出版社", "图书作者", 10,
                10.0, "2022-2", '0',
                null, null, null);
        // Book book = new Book(null, "图书名称", "图书ISBN编号", "图书出版社", "图书作者", 10, 10D, "2022-2", '0', null, null, null);
        bookService.insertBookAndRecord(book);
            System.out.println("新增成功");

    }

    /**
     * 测试删除图书信息
     */
    @Test
    public void testDeleteBook() {
        bookService.deleteBookAndRecord(16);
        System.out.println("删除成功");

    }

    /**
     * 测试修改图书信息
     */
    @Test
    public void testUpdateBook() {
        Book book = new Book(15, "图书名称111", "图书ISBN编号",
                "图书出版社", "图书作者", 10,
                10.0, "2022-2", '0',
                null, null, null);
        bookService.updateBookAndRecord(book);
            System.out.println("修改成功");

    }

    /**
     * 测试分页查询
     */
    @Test
    public void testFindBookPage() {
        PageInfo<Book> bookPageInfo = bookService.findBookPage(1, 5, null);
        System.out.println(bookPageInfo);
    }

    /**
     * 测试根据BOOKID查询图书信息
     */
    @Test
    public void testGetBookById() {
        Book book = bookService.getBookById(1);
        System.out.println(book);
    }
}
