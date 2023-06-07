<template>
    <div class="header">
        <!-- 折叠按钮 -->
        <div class="collapse-btn" @click="collapseChange">
            <i v-if="!collapse" class="el-icon-s-fold"></i>
            <i v-else class="el-icon-s-unfold"></i>
        </div>
        <div class="logo">电影院会员管理系统</div>
        <div class="header-right">
            <!-- 用户头像 -->
            <div class="user-avatar">
                <img src="../../assets/img/admin.png"/>
            </div>
            <!-- 用户名下拉菜单 -->
            <el-dropdown class="user-name" trigger="click" @command="handleCommand">
                <span class="dropdown-link">{{ id }}<i class="el-icon-caret-bottom"></i></span>
                <el-dropdown-menu slot="dropdown"><el-dropdown-item divided command="loginOut">退出登录</el-dropdown-item></el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
import bus from "@/utils/bus";
export default {
    data() {
        return {
            collapse: false,
            fullscreen: false,
            defaultManagerId: 'admin'
        };
    },
    computed: {
        id() {
            return this.defaultManagerId;
        }
    },
    methods: {
        handleCommand(command) {
            if (command == 'loginOut') {
                // localStorage.removeItem('ms_username');
                this.$router.push('/');
            }
        },
        collapseChange() {
            this.collapse = !this.collapse;
            bus.$emit('collapse',this.collapse);
        },
        handleCommand(command) {
            if (command == 'loginOut') {
                localStorage.removeItem('managerId');
                this.$router.push('/login');
            }
        },
    },
}
</script>

<style>
.header {
    position: relative;

    margin: 0;
    padding: 0;
    box-sizing: border-box;
    width: 100%;
    height: 70px;
    line-height: 70px;

    background-color: #242f42;
    font-size: 22px;
    color: #fff;
}

.collapse-btn {
    float: left;
    padding: 0 21px;
    cursor: pointer;
}

.logo {
    float: left;
    width: 250px;
}

.header-right {
    float: right;
    padding-right: 50px;
    display: flex;
    align-items: center;
}

.user-name {
    margin-left: 10px;
}

.user-avatar {
    margin-left: 20px;
}

.user-avatar img {
    display: block;
    width: 40px;
    height: 40px;
    border-radius: 50%;
}

.dropdown-link {
    color: #fff;
    font-size: 18px;
    cursor: pointer;
}
</style>