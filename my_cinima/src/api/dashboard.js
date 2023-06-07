import request from '../utils/request';

export const selectManagerByManagerId = query=>{
    return request({
        url:'selectManagerByManagerId',
        method:'get',
        params:query
    });
};

export const selectAllMovie = query=>{
    return request({
        url:'selectAllMovie',
        method:'get',
        params:query
    });
};

export const getDealData = query=>{
    return request({
        url:'getDealData',
        method:'get',
        params:query
    });
};

export const getStatisticData = query=>{
    return request({
        url:'getStatisticData',
        method:'get',
        params:query
    });
};

export const addMovie = query=>{
    return request({
        url:'addMovie',
        method:'get',
        params:query
    });
};

export const modifyMovie = query=>{
    return request({
        url:'modifyMovie',
        method:'get',
        params:query
    });
};

export const deleteMovie = query=>{
    return request({
        url:'deleteMovie',
        method:'get',
        params:query
    });
};

// export const  = query=>{
//     return request({
//         url:'',
//         method:'get',
//         params:query
//     });
// };
