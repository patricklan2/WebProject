import request from '../utils/request';

export const selectAllCareInfo = query=>{
    return request({
        url:"selectAllCareInfo",
        method:'get',
        params:query
    });
};

export const setBlessing = query=>{
    return request({
        url:"setBlessing",
        method:'get',
        params:query
    });
};

export const setGradeInfo = query=>{
    return request({
        url:"setGradeInfo",
        method:'get',
        params:query
    });
};

export const flushCareInfo = query=>{
    return request({
        url:"flushCareInfo",
        method:'get',
        params:query
    });
};