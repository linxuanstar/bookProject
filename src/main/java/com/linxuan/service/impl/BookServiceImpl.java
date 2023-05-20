package com.linxuan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.linxuan.dao.BookDao;
import com.linxuan.dao.RecordDao;
import com.linxuan.dao.UserDao;
import com.linxuan.entity.Book;
import com.linxuan.entity.Record;
import com.linxuan.entity.User;
import com.linxuan.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 图书信息业务层，添加事务注解，同时成功 同时失败
 */
@Slf4j
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private RecordDao recordDao;

    @Autowired
    private UserDao userDao;

    /**
     * 添加图书以及图书借出的记录信息
     *
     * @param book 添加图书信息
     */
    @Override
    public void insertBookAndRecord(Book book) {
        // 借阅者ID
        String userId = null;

        // 如果这些状态都为空 那么代表没有借阅者借阅书籍 所以直接在图书表插入即可
        if (book.getBookBorrower() != null || book.getBookBorrowtime() != null || book.getBookReturntime() != null ) {
            // 先在Book表插入数据 然后在Record表插入数据
            // 在Book表中插入数据之前 要 先对数据进行一下修改 因为前端传过来的bookBorrower是个ID 并不是具体名称
            if (book.getBookBorrower() != null) {
                // 前端传过来的bookBorrower是ID 这里根据ID进行查询 查询出来具体的姓名 然后为其赋值
                userId = book.getBookBorrower();
                User user = userDao.getUserById(userId);
                book.setBookBorrower(user.getUserName());
            }
            // 先在Book表插入数据，插入数据后会为book对象赋主键的值
            bookDao.insertBook(book);
            log.info("新插入的Book数据的主键为：" + book.getBookId());

            // 然后向Record表插入数据，插入的数据有：图书ID、借阅者ID、借阅时间、归还时间
            Record record = new Record(null, book.getBookId(), Integer.parseInt(userId), book.getBookBorrowtime(), book.getBookReturntime());
            recordDao.insertRecord(record);
        } else {
            bookDao.insertBook(book);
        }
    }

    /**
     * 根据图书信息ID删除图书信息以及借阅记录信息
     *
     * @param id 图书ID
     */
    @Override
    public void deleteBookAndRecord(int id) {
        // 删除图书信息
        bookDao.deleteBook(id);
        // 删除借阅信息
        recordDao.deleteRecord(id);
    }

    /**
     * 根据图书ID修改图书信息以及记录信息
     *
     * @param book 图书信息 包括 图书ID
     */
    @Override
    public void updateBookAndRecord(Book book) {
        String userId = book.getBookBorrower();
        // 修改图书信息操作 由于前端传过来的借阅人是ID 我们的数据库中存储的是名称 所以这里查询一下
        if (book.getBookBorrower() != null) {
            // 前端传过来的bookBorrower是ID 这里根据ID进行查询 查询出来具体的姓名 然后为其赋值
            User user = userDao.getUserById(userId);
            book.setBookBorrower(user.getUserName());
        }
        bookDao.updateBook(book);

        // 删除借阅记录
        recordDao.deleteRecord(book.getBookId());

        // 如果需要修改为的借阅记录信息不为空 那么就新增借阅记录
        if (book.getBookBorrower() != null || book.getBookBorrowtime() != null || book.getBookReturntime() != null) {
            Record record = new Record(null, book.getBookId(), Integer.parseInt(userId), book.getBookBorrowtime(), book.getBookReturntime());
            log.info("添加的记录信息：" + record);
            recordDao.insertRecord(record);
        }
    }

    /**
     * 分页查询图书信息
     *
     * @param page     页数
     * @param pageSize 每页数量
     * @return 返回分页查询结果
     */
    @Override
    public PageInfo<Book> findBookPage(int page, int pageSize, Character status) {
        PageHelper.startPage(page, pageSize);
        List<Book> bookList;
        if (status == null) {
            bookList = bookDao.findAllBook();
        } else {
            bookList = bookDao.findAllBookByStatus(status);
        }
        return new PageInfo<>(bookList);
    }

    /**
     * 根据ID查询图书信息
     *
     * @param id 图书ID
     * @return 返回查询出来的图书信息
     */
    @Override
    public Book getBookById(Integer id) {
        return bookDao.getBookById(id);
    }
}
