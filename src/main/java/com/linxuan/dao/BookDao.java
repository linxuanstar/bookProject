package com.linxuan.dao;

import com.linxuan.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookDao {

    /**
     * 添加图书信息
     *
     * @param book 添加图书信息
     */
    @Insert("insert into book values(null, #{bookName}, #{bookIsbn}, " +
            "#{bookPress}, #{bookAuthor}, #{bookPagination}, #{bookPrice}, " +
            "#{bookUploadtime}, #{bookStatus}, #{bookBorrower}, #{bookBorrowtime}, " +
            "#{bookReturntime})")
    @SelectKey(statement = "select distinct last_insert_id() from book", before = false,
            resultType = Integer.class, keyColumn = "book_id", keyProperty = "bookId")
    void insertBook(Book book);

    /**
     * 根据图书信息ID删除图书信息
     * @param id 图书ID
     * @return 返回影响结果行数
     */
    @Delete("delete from book where book_id = #{id};")
    int deleteBook(int id);

    /**
     * 根据图书ID修改图书信息
     * @param book 图书信息 包括 图书ID
     * @return 返回影响结果行数
     */
    @Update("update book set book_name = #{bookName}, book_isbn = #{bookIsbn}, " +
            "book_press = #{bookPress}, book_author = #{bookAuthor}, " +
            "book_pagination = #{bookPagination}, book_price = #{bookPrice}, " +
            "book_uploadtime = #{bookUploadtime}, book_status = #{bookStatus}, " +
            "book_borrower = #{bookBorrower}, book_borrowtime = #{bookBorrowtime}, " +
            "book_returntime = #{bookReturntime} where book_id = #{bookId}")
    int updateBook(Book book);

    /**
     * 查询所有图书信息
     * @return 返回所有图书信息
     */
    @Select("select * from book")
    List<Book> findAllBook();

    /**
     * 根据状态来查询图书信息
     * @return 返回查询的图书信息
     */
    @Select("select * from book where book_status = #{status}")
    List<Book> findAllBookByStatus(Character status);

    /**
     * 根据ID查询图书信息
     * @param id 图书ID
     * @return 返回查询出来的图书信息
     */
    @Select("select * from book where book_id = #{id}")
    Book getBookById(Integer id);
}
