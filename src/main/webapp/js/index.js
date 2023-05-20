// 获取url地址上面的参数
function requestUrlParam(argname) {
    // 假设地址栏URL地址为http://localhost:8080/dish?id=123&name=456
    const url = location.href;
    // url.substring(url.indexOf("?") + 1)：找到url中的第一个?号，将?号后面的字符串切割下来
    // split("&")：切割每一个字符串中的&，然后转为数组存储，这样数组中存储的是id=123 name=456
    const arrStr = url.substring(url.indexOf("?") + 1).split("&");
    // 循环数组
    for (let i = 0; i < arrStr.length; i++) {
        const loc = arrStr[i].indexOf(argname + "=");
        if (loc !== -1) {
            // 返回argname的值
            return arrStr[i].replace(argname + "=", "")
                .replace("?", "")
        }
    }
    return ""
}
