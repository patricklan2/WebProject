<template>
    <div class="menuitem">
        <template v-for="item of menuList">
            <el-submenu v-if="item.children" :index="head + '/' + item.index">
                <template slot="title"><i v-if="item.icon" :class="item.icon"></i> <span v-if="!collapse">{{ item.title }}</span></template>
                <my-menu-item v-if="item.children" :menuList="item.children" :head="head + '/' + item.index"></my-menu-item>
            </el-submenu>
            <el-menu-item v-else :index="head + '/' + item.index" class="menu-item">
                <i v-if="item.icon" :class="item.icon"></i>
                <template slot="title"><span>{{ item.title }}</span></template>
            </el-menu-item>
        </template>
    </div>
</template>

<script>

export default {
    name: "MyMenuItem",
    props: ['menuList', 'head', 'collapse'],
    data: () => {
        return {
        }  
    },
}
</script>

<style>
.el-submenu .el-menu-item{
    min-width: 0;
}
</style>