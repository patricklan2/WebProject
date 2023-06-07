import axios from "axios";

const service = axios.create({
    baseURL: 'http://localhost:8081/cinema',
    timeout: 5000
});

// 添加请求拦截器
service.interceptors.request.use(
    config => {
        // 在发送请求之前做某事，比如说 设置token
        // config.headers['token'] = 'token';
        return config;
    },
    error => {
        // 请求错误时做些事
        console.log(error);
        return Promise.reject();
    }
);

// 添加响应拦截器
service.interceptors.response.use(
    response => {
        // 如果返回的状态不是200 就主动报错
        if (response.status === 200) {
            return response.data;
        } else {
            Promise.reject();
        }
    },
    error => {
        console.log(error);
        // 返回接口返回的错误信息
        return Promise.reject();
    }
);

export default service;