<template>
    <div>
        <el-card shadow="hover">
            <div slot="header">
                <div style="font-size: 20px; line-height: 30px"><i class="el-icon-user"></i> 会员卡列表</div>
                <el-input v-model="condition.memberId" clearable placeholder="会员ID查询" class="handle-input mr10"></el-input>
                <el-input v-model="condition.name" clearable placeholder="会员名称查询" class="handle-input mr10"></el-input>
                <el-input v-model="condition.cardId" clearable placeholder="cadId查询" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">查询</el-button>
            </div>
            <el-table :data="cardData" border class="table" @selection-change="handleSelectionChange">
                <el-table-column prop="cardId" label="ID" width="180" align="center"></el-table-column>
                <el-table-column prop="grade" label="等级" width="180" align="center"></el-table-column>
                <el-table-column prop="name" label="会员" align="center"></el-table-column>
                <el-table-column prop="balance" label="余额" align="center">
                    <template slot-scope="scope">￥{{scope.row.balance}}</template>
                </el-table-column>
                <el-table-column prop="lose" label="状态" align="center">
                    <template slot-scope="scope">
                        <el-tag :type="scope.row.lose===0?'success':'danger'" >
                            {{scope.row.lose===0?'正常':'挂失'}}
                        </el-tag></template>
                </el-table-column>
                <el-table-column label="操作" width="500px" align="center">
                    <template slot-scope="scope">
                        <el-button type="primary" v-if="scope.row.lose===0" @click="handleRecharge(scope.row)">充值</el-button>
                        <el-button type="primary" v-if="scope.row.lose===0" :disabled="scope.row.balance == 0" @click="handleConsume(scope.row)">消费</el-button>
                        <el-button type="warning" v-if="scope.row.lose===0" @click="handleLose(scope.row)">挂失</el-button>
                        <el-button type="danger" v-if="scope.row.lose===1" @click="handleCancel(scope.row)">解挂</el-button>
                        <!-- <el-button type="danger" v-if="scope.row.lose===1" @click="handleReissue(scope.row)">补卡</el-button> -->
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination class="pagination" background layout="total, prev, pager, next" @current-change="handlePageChange" 
                :current-page="page.index" :page-size="page.size" :total="page.total">
            </el-pagination>

            <consume-dialog ref="consume"></consume-dialog>
            <recharge-dialog ref="recharge"></recharge-dialog>
        </el-card>
    </div>
</template>

<script>
import { selectAllCard, selectCardByCondition, recharge, consume, cardCancel, cardLose } from "@/api/card.js";
import ConsumeDialog from './card/ConsumeDialog.vue';
import RechargeDialog from './card/RechargeDialog.vue';
export default {
    components: {ConsumeDialog, RechargeDialog},
    data() {
        return {
            cardData: [],
            page: {
                index: 1,
                size: 5,
                total: 0,
            },
            condition: {
                nameId: "",
                name: "",
                cardId: "",
            }
        }
    },
    created() {
        this.getCardData();
    },
    mounted(){
        this.$refs.consume.$on('ConsumeDialogConfirm', form => {
            consume(form).then(res=>{
                    if(res.status==200){
                        this.$message.success('挂失成功');
                        this.getCardData();
                    }else{
                        this.$message.error("挂失失败，服务器出现故障")
                    }
                })
        });
        this.$refs.recharge.$on('RechargeDialogConfirm', form => {
            recharge(form).then(res => {
                this.handleSearch();
            })
        });
    },
    methods: {
        getCardData() {
            selectAllCard({
                pageIndex: this.page.index,
                pageSize: this.page.size
            }).then(res => {
                this.cardData = res.data.list;
                this.page.total = res.data.pageTotal;
            });
        },
        handlePageChange(val) {
            this.page.index = val;
            this.handleSearch();
        },
        handleSearch(){
            selectCardByCondition({
                pageIndex: this.page.index,
                pageSize: this.page.size,
                memberId: this.condition.memberId,
                name: this.condition.name,
                cardId: this.condition.cardId,
            }).then(res => {
                this.cardData = res.data.list;
                this.page.total = res.data.pageTotal;
            });
        },
        handleRecharge(row){
            this.$refs.recharge.show(row);
        },
        handleConsume(row){
            this.$refs.consume.show(row);
        },
        handleLose(row){
            this.$confirm('确定要挂失吗？', '提示', {
                type: 'warning'
            }).then(() => {
                cardLose(row).then(res=>{
                    if(res.status==200){
                        this.$message.success('挂失成功');
                        this.getCardData();
                    }else{
                        this.$message.error("挂失失败，服务器出现故障")
                    }
                });
            }).catch(() => {        
            });
        },
        handleCancel(row){
            this.$confirm('确定要解挂吗？', '提示', {
                type: 'warning'
            }).then(() => {
                cardCancel(row).then(res=>{
                    if(res.status==200){
                        this.$message.success('解挂成功');
                        this.getCardData();
                    }else{
                        this.$message.error("解挂失败，服务器出现故障")
                    }
                })
            }).catch(() => {        
            });
        },
        handleReissue(row){
            this.$confirm('确定要补卡吗？', '提示', {
                type: 'warning'
            }).then(() => {
                console.log(index);
                console.log(row);
            }).catch(() => {        
            });
        },
    },
}
</script>

<style>
.handle-input {
    width: 200px;
    margin-left: 0px;
    margin-right: 10px;
    margin-top: 4px;
}
</style>