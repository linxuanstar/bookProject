(function (win) {
    // 设置请求头
    axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
    // 创建axios实例
    const service = axios.create({
        // axios中请求配置有baseURL选项，表示请求URL公共部分
        baseURL: '/',
        // 超时
        timeout: 10000
    })

    // VUE-AXIOS 请求拦截器拦截器 在请求发送之前做一些处理
    service.interceptors.request.use(config => {
        // 如果请求方式是GET并且有请求参数 那么在请求路径后面添加上请求参数
        if (config.method === 'get' && config.params) {
            // 在请求路径后面添加? 这就是开始添加请求参数了
            let url = config.url + '?';
            for (const propName of Object.keys(config.params)) {
                const value = config.params[propName];
                var part = encodeURIComponent(propName) + "=";
                if (value !== null && typeof (value) !== "undefined") {
                    if (typeof value === 'object') {
                        for (const key of Object.keys(value)) {
                            let params = propName + '[' + key + ']';
                            var subPart = encodeURIComponent(params) + "=";
                            url += subPart + encodeURIComponent(value[key]) + "&";
                        }
                    } else {
                        url += part + encodeURIComponent(value) + "&";
                    }
                }
            }
            // 去掉 URL 字符串最后一个字符 通常用于去除 URL 字符串中的末尾斜杠（/），以确保 URL 的统一性。
            url = url.slice(0, -1);
            config.params = {};
            config.url = url;
        }
        return config
    }, error => {
        console.log(error)
        Promise.reject(error)
    })

    // 响应后端拦截器
    service.interceptors.response.use(res => {
        // 如果后端返回状态码为 0 或者 返回信息为 NOTLOGIN 那么重定向至登录页面
        if (res.data.code === 0 && res.data.msg === 'NOTLOGIN') {
            localStorage.removeItem('userInfo')
            // 重定向至登录页面
            console.log("重定向页面")
            window.top.location.href = '/page/login.html'
        } else {
            console.log(res.data)
            return res.data
        }
    }, error => { // 响应的异常的话
        console.log('err' + error)
        let {message} = error;
        if (message === "Network Error") {
            message = "后端接口连接异常";
        } else if (message.includes("timeout")) {
            message = "系统接口请求超时";
        } else if (message.includes("Request failed with status code")) {
            message = "系统接口" + message.substr(message.length - 3) + "异常";
        }
        window.ELEMENT.Message({
            message: message,
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    })
    win.$axios = service
})(window);
