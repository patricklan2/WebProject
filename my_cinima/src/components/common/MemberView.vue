<template>
    <div>
        <div class="header">
            <div class="MemberLogo">电影院会员系统</div>
            <div class="header-right">
                <div class="user-avatar">
                    <img src="@/assets/img/admin.png"/>
                </div>
                <el-dropdown class="user-name" trigger="click" @command="handleCommand">
                    <span class="dropdown-link">{{ id }}<i class="el-icon-caret-bottom"></i></span>
                    <el-dropdown-menu slot="dropdown"><el-dropdown-item divided command="loginOut">退出登录</el-dropdown-item></el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>
        <div class="memberBody">
            <el-row :gutter="25">
                <el-col :span="14">
                    <el-row :gutter="20" class="mgb20">
                        <el-card shadow="hover" style="height:252px;">
                            <div class="user-info">
                                <img src="@/assets/img/admin.png" class="manager-avatar" alt/>
                                <div class="user-info-cont">
                                    <div class="user-info-name">{{member.name}}</div>
                                </div>
                            </div>
                            <div class="user-info-list">会员ID<span>{{member.memberId}}</span></div>
                            <div class="user-info-list">拥有的积分<span>{{member.integral}}</span></div>
                        </el-card>
                    </el-row>
                    <el-row :gutter="20" class="mgb20">
                        <el-card>
                            <div slot="header">
                                <div style="font-size: 20px; line-height: 30px">我的会员卡</div>
                            </div>
                            <el-table :data="cardData" border class="table">
                                <el-table-column prop="cardId" label="ID" width="200" align="center"></el-table-column>
                                <el-table-column prop="grade" label="等级" align="center"></el-table-column>
                                <el-table-column prop="balance" label="余额" align="center">
                                    <template slot-scope="scope">￥{{scope.row.balance}}</template>
                                </el-table-column>
                                <el-table-column prop="lose" label="状态" align="center">
                                    <template slot-scope="scope">
                                        <el-tag :type="scope.row.lose===0?'success':'danger'" >
                                            {{scope.row.lose===0?'正常':'挂失'}}
                                        </el-tag></template>
                                </el-table-column>
                                <el-table-column label="操作" width="200px" align="center">
                                    <template slot-scope="scope">
                                        <el-button type="primary" v-if="scope.row.lose===0" @click="handleRecharge(scope.row)">充值</el-button>
                                        <el-button type="primary" v-if="scope.row.lose===0" :disabled="scope.row.balance == 0" @click="handleConsume(scope.row)">消费</el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </el-card>
                    </el-row>
                    
                </el-col>
                <el-col :span="10">
                    <el-row :gutter="20" class="mgb20">
                        <el-card style="height:200px;">
                            <div slot="header">
                                <div style="font-size: 20px; line-height: 30px"><i class="el-icon-user"></i>  讯息</div>
                            </div>
                            <span>{{ member.info }}</span>
                        </el-card>
                    </el-row>
                    <el-row :gutter="20" class="mgb20">
                        <el-card style="height:400px;">
                            <div style="font-size: 20px; line-height: 30px" slot="header">电影列表</div>
                            <el-table class="table" border :data="movieData">
                                <el-table-column prop="name" label="电影名"></el-table-column>
                                <el-table-column prop="price" label="价格" width="55"></el-table-column>
                                <el-table-column prop="time" label="时间"></el-table-column>
                                <el-table-column prop="integral" label="积分" width="55"></el-table-column>
                            </el-table>
                            <el-pagination class="pagination" background layout="total, prev, pager, next"
                                :current-page="page1.index" :page-size="page1.size" :total="page1.total"
                                @current-change="handlePageChange">
                            </el-pagination>
                        </el-card>
                    </el-row>
                    <el-row :gutter="20" class="mgb20">
                        <el-card shadow="hover">
                            <div slot="header">
                                <div style="font-size: 20px; line-height: 30px">商品
                                    <el-button type="primary" @click="handleExchange">兑换</el-button>
                                </div>
                            </div>
                            <el-table :data="goodData" border class="table">
                                <el-table-column prop="name" label="name" align="center"></el-table-column>
                                <el-table-column prop="integral" label="积分" align="center"></el-table-column>
                                <el-table-column prop="stock" label="存量" align="center"></el-table-column>
                            </el-table>
                            <el-pagination class="pagination" background layout="total, prev, pager, next" @current-change="handlePage2Change" 
                                :current-page="page2.index" :page-size="page2.size" :total="page2.total">
                            </el-pagination>
                        </el-card>
                    </el-row>
                </el-col>
            </el-row>
        </div>
        
        <consume-dialog ref="consume"></consume-dialog>
        <recharge-dialog ref="recharge"></recharge-dialog>
        <exchange-dialog ref="exchange"></exchange-dialog>
    </div>
</template>

<script>
import { getMemberAllInfo, selectCardByMemberId, exchange } from "@/api/member";
import { consume, recharge } from "@/api/card";
import { selectAllMovie } from "@/api/dashboard";
import { selectAllGood } from "@/api/good";
import Head from './Head.vue';
import ConsumeDialog from "../page/card/ConsumeDialog.vue";
import RechargeDialog from "../page/card/RechargeDialog.vue";
import ExchangeDialog from "../page/member/ExchangeDialog.vue";
export default {
    components: { Head, ExchangeDialog, RechargeDialog, ConsumeDialog },
    data() {
        return {
            member: {
                name: localStorage.getItem('memberId'),
            },
            cardData: [],
            movieData: [],
            page1: {
                index: 1,
                size: 4,
                total: 0,
            },
            goodData: [],
            page2: {
                index: 1,
                size: 4,
                total: 0,
            },
        }
    },
    created() {
        this.getMemberData();
        this.getMovieData();
        this.getGoodData();
    },
    mounted(){
        this.$refs.consume.$on('ConsumeDialogConfirm', form => {
            consume(form).then(res=>{
                if(res.status==200){
                    this.$message.success('消费成功');
                    this.getMemberData();
                }else{
                    this.$message.error("消费失败，服务器出现故障")
                }
            })
        });
        this.$refs.recharge.$on('RechargeDialogConfirm', form => {
            recharge(form).then(res=>{
                if(res.status==200){
                    this.$message.success('充值成功');
                    this.getMemberData();
                }else{
                    this.$message.error("充值失败，服务器出现故障")
                }
            })
        });
        this.$refs.exchange.$on("ExchangeDialogConfirm", form=>{
            exchange(form).then(res=>{
                if(res.status==200) {
                    this.$message.success(`兑换成功`);
                    this.getMemberData();
                }else{
                    this.$message.success(`兑换失败，服务端出现问题`);
                }
            });
        })
    },
    methods: {
        getMemberData() {
            getMemberAllInfo(this.member).then(res=>{
                this.member = res.data;
                this.getCardData();
            })
        },
        getCardData(){
            selectCardByMemberId(this.member).then(res=>{
                this.cardData = res.data.list;
            })
        },
        handleRecharge(row){
            this.$refs.recharge.show(row);
        },
        handleConsume(row){
            this.$refs.consume.show(row);
        },
        getMovieData() {
            selectAllMovie  ({
                "pageIndex" : this.page1.index,
                "pageSize" : this.page1.size
            }).then(res => {
                this.movieData = res.data.list;
                this.page1.total = res.data.pageTotal;
            })
        },
        handlePageChange(val) {
            this.page1.index = val;
            this.getMovieData();
        },
        getGoodData(){
            selectAllGood({
                pageIndex: this.page2.index,
                pageSize: this.page2.size,
            }).then(res => {
                this.goodData = res.data.list;
                this.page2.total = res.data.pageTotal;
            })
        },
        handlePage2Change(val) {
            this.page2.index = val;
            this.getGoodData();
        },
        handleExchange(){
            this.$refs.exchange.show(this.member);
        },
        handleCommand(command) {
            if (command == 'loginOut') {
                localStorage.removeItem('memberId');
                this.$router.push('/login');
            }
        },
    }
}
</script>

<style>
.memberBody{
    margin-left: 10px;
    margin-right: 10px;
}
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

.MemberLogo {
    float: left;
    width: 250px;
    padding-left: 30px;
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
.mgb20 {
    margin-bottom: 20px;
}
</style>