import request from '../utils/request';


export const selectAllMember = query=>{
    return request({
        url:'selectAllMember',
        method:'get',
        params:query
    });
};

export const registerMember = query=>{
    return request({
        url:'registerMember',
        method:'post',
        params:query
    });
};

export const modifyMember = query=>{
    return request({
        url:'modifyMember',
        method:'get',
        params:query
    });
};

export const deleteMember = query=>{
    return request({
        url:'deleteMember',
        method:'get',
        params:query
    });
};

export const exchange = query=>{
    return request({
        url:'exchange',
        method:'get',
        params:query
    });
};

export const selectMemberByCondition = query=>{
    return request({
        url:'selectMemberByCondition',
        method:'get',
        params:query
    });
};

export const getMemberAllInfo = query=>{
    return request({
        url:'getMemberAllInfo',
        method:'get',
        params:query
    });
};

export const selectCardByMemberId = query=>{
    return request({
        url:'selectCardByMemberId',
        method:'get',
        params:query
    });
};