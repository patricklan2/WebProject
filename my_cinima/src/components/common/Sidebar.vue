<template>
    <el-menu 
        background-color="#324157" text-color="#bfcbd9" active-text-color="#20a0ff"
        class="sidebar-el-menu" :collapse="collapse" unique-opened router>
        <menu-item :collapse="collapse" :menuList="menuList" head="/index"></menu-item>
    </el-menu>
</template>

<script>
import MenuItem from './MenuItem.vue'
import bus from '@/utils/bus';
export default {
    components: { MenuItem },
    data: () => {
        return {
            collapse: false,
            menuList: [
                {index: 'dashboard', title: '系统首页', icon: 'el-icon-s-home'},
                {index: 'member', title: '会员管理', icon: 'el-icon-user',
                    children: [
                        {index: 'member', title: '会员列表'}
                    ]
                },
                {index: 'card',  title: '会员卡管理', icon: 'el-icon-document-copy',
                    children: [
                        {index: 'card', title: '会员卡列表'},
                        {index: 'record', title: '交易记录'}
                    ]
                },
                {index: 'integral', title: '商品管理',icon: 'el-icon-shopping-cart-2',
                    children: [
                        {index: 'integral', title: '商品列表'}
                    ]
                },
                {index: 'care', title: '会员关怀', icon: 'el-icon-date'},
                // {index: 'charts',title: '统计数据', icon: 'el-icon-odometer'},
            ]
        };
    },
    created() {
        bus.$on('collapse',msg => {
            this.collapse = msg;
        })
    }
    
}
</script>

<style scoped>
.sidebar-el-menu{
    position: absolute;
    height: 100%;
    border: 0;
}

.sidebar-el-menu:not(.el-menu--collapse) {
    width: 250px;
}

.el-menu--collapse{
    width: 80px;
}
</style>