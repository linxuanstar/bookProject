// 分页查询API
function getBookList(params) {
    return $axios({
        url: '/book/page',
        method: 'get',
        // 如果是GET请求直接这样即可，GET请求中Data不能使用，Data是放在请求体里面的
        params
    })
}

// 删除API
function deleteBook(id) {
    return $axios({
        url: '/book/delete',
        method: 'delete',
        params: {id}
    })
}

// 新增---添加图书信息
function addBook(params) {
    return $axios({
        url: '/book',
        method: 'post',
        data: {...params}
    })
}

// 修改---添加员工
function editBook(params) {
    return $axios({
        url: '/book',
        method: 'put',
        // 这三个点是ES6的语法，叫做扩展运算符，就是将params里面数据拆开放入data里面
        data: {...params}
    })
}

// 修改页面反查详情接口
function queryBookById(id) {
    return $axios({
        url: `/book/${id}`,
        method: 'get'
    })
}