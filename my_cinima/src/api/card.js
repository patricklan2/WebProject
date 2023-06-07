import request from '../utils/request';

//获取会员卡数据，请求参数pageIndex、pageSize
export const selectAllCard = query=>{
    return request({
        url:"selectAllCard",
        method:'post',
        params:query
    });
};

export const selectCardByCondition = query=>{
    return request({
        url:"selectCardByCondition",
        method:'post',
        params:query
    });
};

//交易记录查询，请求参数会员id，pageIndex,pageSize
export const selectAllConsumeRecord = query=>{
    return request({
        url:"selectAllConsumeRecord",
        method:'post',
        params:query
    })
};

export const selectAllExchangeRecord = query=>{
    return request({
        url:"selectAllExchangeRecord",
        method:'post',
        params:query
    })
};

export const cardLose = query=>{
    return request({
        url:"cardLose",
        method:'post',
        params:query
    })
};

export const cardCancel = query=>{
    return request({
        url:"cardCancel",
        method:'post',
        params:query
    })
};

export const recharge = query=>{
    return request({
        url:"recharge",
        method:'post',
        params:query
    })
};


export const consume = query=>{
    return request({
        url:"consume",
        method:'post',
        params:query
    })
};