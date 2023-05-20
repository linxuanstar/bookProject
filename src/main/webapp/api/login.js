// 登录API
function loginApi(param) {
    return $axios({
        url: '/admin/login',
        method: 'post',
        data: {...param}
    })
}

// 退出API
function logoutApi(){
    return $axios({
        'url': '/admin/logout',
        'method': 'post',
    })
}
