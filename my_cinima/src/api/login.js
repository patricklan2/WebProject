import request from '../utils/request';

export const managerLogin = query=>{
    return request({
        url:"managerLogin",
        method:'get',
        params:query
    });
};

export const memberLogin = query=>{
    return request({
        url:"memberLogin",
        method:'get',
        params:query
    });
};