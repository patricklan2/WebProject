<template>
    <div>
        <el-col :span="item.span" v-for=" item in statisticData" :key="item">
            <el-card shadow="hover" :body-style="{padding: '0px'}">
                <div class="grid-content" :class="'grid-con-' + item.index">
                    <i :class="item.icon" class="grid-con-icon"></i>
                    <div class="grid-cont-right">
                        <div class="grid-num">{{ item.number }}</div>
                        <div>{{ item.title }}</div>
                    </div>
                </div>
            </el-card>
        </el-col>
    </div>
</template>

<script>
import { getStatisticData } from "@/api/dashboard";
export default {
    data() {
        return {
            statisticData: {
                member: {
                    index: 1, icon: "el-icon-user", title: '已注册会员', number: 0, span: 8,
                },
                card: { 
                    index: 2, icon: "el-icon-postcard", title: '已办理会员卡', number: 0, span: 8,
                },
                movie:{
                    index: 3, icon: "el-icon-goods", title: '已售电影票', number: 0, span: 8,
                },
            },
        }
    },
    created() {
        this.getStatistic();
    },
    methods: {
        getStatistic() {
            getStatisticData().then(res => {
                let data = res.data;
                this.statisticData.member.number = data.memberNum;
                this.statisticData.card.number = data.cardNum;
                this.statisticData.movie.number = data.movieNum;
            })
        },
    }
}
</script>

<style>
.grid-content {
    display: flex;
    align-items: center;
    height: 100px;
}

.grid-cont-right {
    flex: 1;
    text-align: center;
    font-size: 14px;
    color: #999;
}

.grid-num {
    font-size: 30px;
    font-weight: bold;
}

.grid-con-icon {
    font-size: 50px;
    width: 100px;
    height: 100px;
    text-align: center;
    line-height: 100px;
    color: #fff;
}

.grid-con-1 .grid-con-icon {
    background: rgb(45, 140, 240);
}

.grid-con-1 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-2 .grid-con-icon {
    background: rgb(100, 213, 114);
}

.grid-con-2 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-3 .grid-con-icon {
    background: rgb(242, 94, 67);
}

.grid-con-3 .grid-num {
    color: rgb(242, 94, 67);
}
</style>