import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/login', component: ()=> import('../components/page/Login.vue'),
        },
        {
            path: '/memberView', component: ()=> import('../components/common/MemberView.vue'),
        },
        {
            path: '/index', component: ()=> import('../components/common/Home.vue'),
            name: 'index',
            redirect: '/index/dashboard',
            children: [
                { path: 'dashboard', component: ()=> import('../components/page/Dashboard.vue'), meta: {title: '系统首页'}},
                { path: 'member/member', component: ()=> import('../components/page/Member.vue'), meta: {title: '会员列表'}},
                { path: 'card/card', component: ()=> import('../components/page/Card.vue'), meta: {title: '会员卡列表'}},
                { path: 'card/record', component: ()=> import('../components/page/Record.vue'), meta: {title: '交易记录'}},
                { path: 'integral/integral', component: ()=> import('../components/page/Good.vue'), meta: {title: '商品列表'}},
                { path: 'care', component: ()=> import('../components/page/Care.vue'), meta: {title: '会员关怀'}},
                { path: 'charts', component: ()=> import('../components/page/Charts.vue'), meta: {title: '统计数据'}},

            ]
        },
        {
            path: '/', redirect: '/login',
        },
        {
            path: '*', component: () => import('../components/page/404.vue')
        }
    ]
});