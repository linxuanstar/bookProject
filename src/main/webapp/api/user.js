// 删除API
function deleteUser(id) {
    return $axios({
        url: '/user/delete',
        method: 'delete',
        params: {id}
    })
}

// 分页查询借阅者借阅数据
function getUserRecordPage(params) {
    return $axios({
        url: "/user/record",
        method: 'get',
        // 如果是GET请求直接这样，这样会将params放在URL中。GET请求中Data不能使用，Data是放在请求体里面的
        params
    })
}

// 添加借阅者信息
function addUser(params) {
    return $axios({
        url: "/user",
        method: 'post',
        data: {...params}
    })
}

// 修改借阅者信息
function updateUser(params) {
    return $axios({
        url: "/user",
        method: "put",
        data: {...params}
    })
}

// 查询所有查询所有账号开启着的借阅者信息
function getAllUsers() {
    return $axios({
        url: "/user",
        method: "get"
    })
}
