
// ISBM格式
function isValidISBM (val) {
    // /^：正则表达式开始、$/：正则表达式结束、\d：数字[0-9]其中一个、{3,9}：最低3次最多9次
    return /^\d{3,9}$/.test(val);
}

// 图书格式
function isValidPage (val) {
    // /^：正则表达式开始、$/：正则表达式结束、[1-9]：第一位数是数字[1-9]其中一个、\d：数字[0-9]其中一个、{0,10}：最低出现0次，最多出现10次
    return /^[1-9]\d{0,10}$/.test(val);
}

// 价格格式
function isValidPrice (val) {
    // *：匹配上一个匹配规则零次或多次
    return /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/.test(val);
}

// 校验图书ISBM编号
function checkISBM (rule, value, callback) {
    if (value === "") {
        callback(new Error("请输入ISBM编号"))
    } else if (!isValidISBM(value)) {
        callback(new Error("ISBM编号应为数字类型，且长度3~9"))
    } else {
        callback()
    }
}

// 校验绝大多数文本框，例如：图书名称、出版社、作者
function checkStr (rule, value, callback) {
    if (value === "") {
        callback(new Error("请输入数据"))
    } else if (value.length > 20 || value.length < 1) {
        callback(new Error("长度应是1-20"))
    } else {
        callback()
    }
}

// 校验图书页数
function checkPage (rule, value, callback) {
    if (value === "") {
        callback(new Error("请输入图书页数"))
    } else if (!isValidPage(value)) {
        callback(new Error("页数应该为数字类型，且首位不为0"))
    } else {
        callback()
    }
}

// 校验价格
function checkPrice (rule, value, callback) {
    if (value === "") {
        callback(new Error("请输入图书价格"))
    } else if (!isValidPrice(value)) {
        callback(new Error("价格应为Double类型，小数点后面最多2位"))
    } else {
        callback()
    }
}

// 校验时间，包括：上架时间、借阅时间、归还时间
function checkTime (rule, value, callback) {
    if (value === "") {
        callback(new Error("请选择时间"))
    } else {
        callback()
    }
}