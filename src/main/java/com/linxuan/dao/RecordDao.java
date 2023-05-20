package com.linxuan.dao;

import com.linxuan.entity.Record;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 借阅记录数据层
 */
public interface RecordDao {

    /**
     * 添加借阅记录
     *
     * @param record 借阅记录
     */
    @Insert("insert into record value(null, #{bookId}, #{userId}, " +
            "#{recordBorrowtime}, #{recordRemandTime})")
    void insertRecord(Record record);


    /**
     * 根据图书编号删除借阅记录
     * @param bookId bookId为图书编号。根据图书编号删除借阅记录，一本书只能被借出一次，所以可以根据这个删除
     */
    @Delete("delete from record where book_id = #{bookId}")
    void deleteRecord(@Param("bookId") int bookId);

    /**
     * 更改借阅记录信息
     * @param record 需要更改的借阅记录信息
     */
    @Update("update from record set user_id = #{userId}, " +
            "record_borrowtime = #{recordBorrowtime}, record_remandtime = #{recordRemandTime}")
    void updateRecord(Record record);
}
