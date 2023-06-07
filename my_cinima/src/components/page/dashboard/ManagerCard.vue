<template>
    <el-card shadow="hover" class="mgb20">
        <div class="user-info">
            <img src="../../../assets/img/admin.png" class="manager-avatar" alt/>
            <div class="user-info-cont">
                <div class="user-info-name">{{manager.name}}</div>
                <div>{{manager.role}}</div>
            </div>
        </div>
        <div class="user-info-list">管理员ID<span>{{manager.managerId}}</span></div>
        <div class="user-info-list">已工作时间<span>{{workTime}}</span></div>
    </el-card>
</template>

<script>
import { selectManagerByManagerId } from "@/api/dashboard";
export default {
    data() {
        return {
            managerId: localStorage.getItem('managerId'),
            manager: {},
            workTime: "",
            worker: "",
        }
    },
    created() {
        this.getManagerData();
        const _this = this;
        _this.timer = setInterval(()=>{
            _this.getWorkTime();
        },1000);
    },
    methods: {
        getWorkTime(){
            let span = new Date(new Date() - new Date(this.manager.time));
            let hour = span.getHours() - 8;
            let minutes = span.getMinutes();
            let seconds = span.getSeconds();
            if(seconds<10){ seconds =  "0"+seconds; }
            this.workTime = hour + ":" + minutes + ":" + seconds;
        },
        getManagerData(){
            console.log(this.managerId)
            selectManagerByManagerId({
                managerId: this.managerId
            }).then(res=>{
                this.manager = res.data;
                this.getWorkTime()
            })
        }
    },
}
</script>

<style>
.user-info {
    display: flex;
    align-items: center;
    padding-bottom: 20px;
    border-bottom: 2px solid #ccc;
    margin-bottom: 20px;
}
 
.manager-avatar {
    width: 120px;
    height: 120px;
    border-radius: 50%;
}

.user-info-cont {
    padding-left: 50px;
    flex: 1;
    font-size: 14px;
    color: #999;
}

.user-info-cont div:first-child {
    font-size: 30px;
    color: #222;
}

.user-info-list {
    font-size: 14px;
    color: #999;
    line-height: 25px;
}

.user-info-list span {
    margin-left: 70px;
}
</style>