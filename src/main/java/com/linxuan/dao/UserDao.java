package com.linxuan.dao;

import com.linxuan.dto.RecordDto;
import com.linxuan.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 借阅者数据层
 */
public interface UserDao {

    /**
     * 查询所有账号开启着的借阅者信息
     * @return 返回所有借阅者信息
     */
    @Select("select * from user where user_status = 0")
    List<User> getAllUsers();

    /**
     * 根据ID查询借阅者信息
     * @param id 借阅者Id
     * @return 借阅者信息
     */
    @Select("select * from user where user_id = #{id}")
    User getUserById(String id);

    /**
     * 添加借阅者信息
     * @param user 需要添加的借阅者信息
     * @return 返回是否成功
     */
    @Insert("insert into user value(null, #{userName}, " +
            "#{userPassword}, #{userEmail}, #{userRole}, #{userStatus})")
    int insertUser(User user);

    /**
     * 修改借阅者信息
     * @param user 需要修改的借阅者信息
     */
    @Update("update user set user_name = #{userName}, " +
            "user_password = #{userPassword}, " +
            "user_status = #{userStatus} " +
            "where user_id = #{userId}")
    void updateUser(User user);

    /**
     * 删除借阅者信息
     * @param id 需要删除的借阅者ID
     * @return 返回影响结果行数
     */
    @Delete("delete from user where user_id = #{id}")
    int deleteUser(@Param("id") int id);

    /**
     * 查询所有借阅者借书情况
     * @return 返回借阅者借书情况
     */
    @Select("SELECT \n" +
            "  user.user_id,\n" +
            "  user.user_name,\n" +
            "  user.user_email,\n" +
            "  user.user_status,\n" +
            "  book.book_id,\n" +
            "  book.book_name,\n" +
            "  record.record_id,\n" +
            "  record.record_borrowtime,\n" +
            "  record.record_remandtime\n" +
            "FROM\n" +
            "  USER \n" +
            "  LEFT JOIN record ON record.user_id = user.user_id\n" +
            "  LEFT JOIN book ON record.book_id = book.book_id")
    List<RecordDto> getAllUserAndRecord();
}
