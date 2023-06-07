import request from '../utils/request';

export const selectAllGood = query=>{
    return request({
        url:"selectAllGood",
        method:'get',
        params:query
    });
};

export const addGood = query=>{
    return request({
        url:"addGood",
        method:'post',
        params:query
    });
};

export const modifyGood = query=>{
    return request({
        url:"modifyGood",
        method:'post',
        params:query
    });
};

export const deleteGood = query=>{
    return request({
        url:"deleteGood",
        method:'post',
        params:query
    });
};