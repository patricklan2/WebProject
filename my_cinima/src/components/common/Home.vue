<template>
    <div class="wrapper">
        <my-head></my-head>
        <sidebar class="aside"></sidebar>
        <div class="content-box" :class="{ 'content-collapse' : collapse}">
            <my-tag></my-tag>
            <div class="content">
                <transition name="move" mode="out-in">
                    <keep-alive :include="tagsList">
                        <router-view></router-view>
                    </keep-alive>
                </transition>
                <el-back-top target=".content"></el-back-top>
            </div>
        </div>
    </div>
</template>

<script>
import MyHead from "./Head.vue";
import Sidebar from "./Sidebar.vue";
import MyTag from "./Tag.vue"

import bus from '@/utils/bus';
export default {
    components: { MyHead, Sidebar, MyTag },
    data() {
        return {
            collapse: false, 
        };
    },
    created() {
        bus.$on('collapse',msg => {
            this.collapse = msg;
        })
    },
    methods: {

    }
}
</script>

<style>
.content-box{
    background-color: aqua;
    position: absolute;
    top: 70px;
    left: 250px;
    right: 0;
    bottom: 0;
    padding-bottom: 30px;
    -webkit-transition: left .3s ease-in-out;
    transition: left .3s ease-in-out;
    background: #f0f0f0;
}

.content {
    width: auto;
    height: 100%;
    padding: 10px;
    overflow-y: scroll;
    box-sizing: border-box;
}   

.content-collapse {
    left: 80px;
}

.aside{
    top: 70px;
}
    
</style>