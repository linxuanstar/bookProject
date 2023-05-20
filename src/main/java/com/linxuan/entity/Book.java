package com.linxuan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 图书类 对应数据库的book表
 * 问题：
 * 1.图书编号如果数据库使用UUID 那么传向前端注意数据精度问题
 * 2.Java中涉及金额操作都应该使用BigDecimal，数据库中使用Decimal，这个数据库中Double小数点后没有位数
 * 3.时间应该使用时间类型
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    // 图书编号
    private Integer bookId;
    // 图书名称
    private String bookName;
    // 图书ISBN编号
    private String bookIsbn;
    // 图书出版社
    private String bookPress;
    // 图书作者
    private String bookAuthor;
    // 图书页数
    private Integer bookPagination;
    // 图书价格
    private Double bookPrice;
    // 图书上架时间
    private String bookUploadtime;
    // 图书状态 0为可借阅 1为已借阅 2为归还中 3为已下架
    private Character bookStatus;
    // 图书借阅人
    private String bookBorrower;
    // 图书借阅时间
    private String bookBorrowtime;
    // 图书预计归还时间
    private String bookReturntime;
}
