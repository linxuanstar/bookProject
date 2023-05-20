package com.linxuan.service;

import com.github.pagehelper.PageInfo;
import com.linxuan.entity.Book;
import org.apache.ibatis.annotations.Select;

public interface BookService{

    /**
     * 添加图书信息
     * @param book 添加图书信息
     */
    void insertBookAndRecord(Book book);

    /**
     * 根据图书信息ID删除图书信息以及借阅信息
     * @param id 图书ID
     */
    void deleteBookAndRecord(int id);

    /**
     * 根据图书ID修改图书信息
     * @param book 图书信息 包括 图书ID
     * @return 返回影响结果行数
     */
    void updateBookAndRecord(Book book);

    /**
     * 使用pagehelper分页查询
     * @return 返回分页查询结果
     */
    PageInfo<Book> findBookPage(int page, int pageSize, Character status);

    /**
     * 根据ID查询图书信息
     * @param id 图书ID
     * @return 返回查询出来的图书信息
     */
    Book getBookById(Integer id);
}
