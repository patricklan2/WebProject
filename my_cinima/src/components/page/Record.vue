<template>
    <div>
        <el-card shadow="hover">
            <div slot="header">
                <div style="font-size: 20px; line-height: 30px"><i class="el-icon-file"></i>全部交易记录</div>
                <el-input v-model="condition.name" clearable placeholder="会员名称查询" class="handle-input mr10"></el-input>
                <el-input v-model="condition.cardId" clearable placeholder="cadId查询" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">查询</el-button>
            </div>
            <el-col span="12">
                <el-table :data="consumeData" border size="mini">
                    <el-table-column prop="cardId" label="会员卡ID" align="center"></el-table-column>
                    <el-table-column prop="reason" label="交易类型" align="center">
                        <!-- <template slot-scope="scope">
                            <el-tag :type="scope.row.reason===1?'danger':'success'">{{scope.row.reason===1?'消费':'充值'}}</el-tag>
                        </template> -->
                    </el-table-column>
                    <el-table-column prop="value" label="金额" align="center"></el-table-column>
                    <el-table-column prop="time" label="时间" align="center"></el-table-column>
                </el-table>
                <el-pagination class="pagination" background layout="total, prev, pager, next" @current-change="handlePageChange" 
                    :current-page="page.index" :page-size="page.size" :total="page.total">
                </el-pagination>
            </el-col>
            <el-col span="12">
                <el-table :data="exchangeData" border size="mini">
                    <el-table-column prop="memberId" label="会员ID" align="center"></el-table-column>
                    <el-table-column prop="reason" label="交易类型" align="center">
                        <!-- <template slot-scope="scope">
                            <el-tag :type="scope.row.reason===1?'danger':'success'">{{scope.row.reason===1?'兑换':'获得积分'}}</el-tag>
                        </template> -->
                    </el-table-column>
                    <el-table-column prop="value" label="积分" align="center"></el-table-column>
                    <el-table-column prop="time" label="时间" align="center"></el-table-column>
                </el-table>
                <el-pagination class="pagination" background layout="total, prev, pager, next" @current-change="handlePage2Change" 
                    :current-page="page2.index" :page-size="page2.size" :total="page2.total">
                </el-pagination>
            </el-col>
        </el-card>
    </div>  
</template>

<script>
import { selectAllConsumeRecord, selectAllExchangeRecord } from "@/api/card.js";
export default {
    data() {
        return {
            condition: {
                name: "",
                cardId: "",
            },
            page: {
                index: 1,
                size: 5,
                total: 0,
            },
            page2: {
                index: 1,
                size: 5,
                total: 0,
            },
            consumeData: [],
            exchangeData: [],
        }
    },
    created() {
        this.getConsumeData();
        this.getExchangeData();
    },
    methods: {
        getConsumeData(){
            selectAllConsumeRecord({
                pageIndex: this.page.index,
                pageSize: this.page.size,
            }).then(res => {
                this.consumeData = res.data.list;
                this.page.total = res.data.pageTotal;
            })
        },
        handlePageChange(val) {
            this.page.index = val;
            this.getConsumeData();
        },
        getExchangeData(){
            selectAllExchangeRecord({
                pageIndex: this.page2.index,
                pageSize: this.page2.size,
            }).then(res => {
                this.exchangeData = res.data.list;
                this.page2.total = res.data.pageTotal;
            })
        },
        handlePageChange(val) {
            this.page2.index = val;
            this.getExchangeData();
        }
    }
        
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