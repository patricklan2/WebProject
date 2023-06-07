<template>
    <el-dialog title="消费" :visible.sync="visible" width="70%">
        <el-table border :data="goodData" @current-change="chooseGood">
            <el-table-column prop="name" label="商品名"></el-table-column>
            <el-table-column prop="stock" label="剩余"></el-table-column>
            <el-table-column prop="integral" label="积分"></el-table-column>
        </el-table>
        <el-pagination class="pagination" background layout="total, prev, pager, next"
            :current-page="page.index" :page-size="page.size" :total="page.total"
            @current-change="handlePageChange">
        </el-pagination>
        <el-form label-width="70px" size="mini">
            <el-form-item label="商品名"> {{exchange.name}} </el-form-item>
            <el-form-item label="数量"> <el-input v-model="exchange.number" @change="inputNumber"></el-input></el-form-item>
            <el-form-item label="总积分"> {{exchange.totalIntegral}} </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="visible = false">取 消</el-button>
            <el-button type="primary" @click="confirm">确 定</el-button>
        </span>
    </el-dialog>
</template>

<script>
import { selectAllGood } from "@/api/good";
export default {
    data() {
        return {
            visible: false,
            memberInfo: {},
            goodData: [],
            page: {
                index: 1,
                size: 4,
                total: 0,
            },
            exchange: {
                memberId: "",
                name: '',
                totalIntegral: 0,
                number: 0,
            },
        }
    },
    created() {
        this.getGoodData();
    },
    methods: {
        confirm() {
            this.visible = false;
            this.$emit('ExchangeDialogConfirm',this.exchange);
        },
        show(memberInfo) {
            this.memberInfo = memberInfo;
            this.exchange.memberId = memberInfo.memberId;
            this.visible = true;
        },
        getGoodData() {
            selectAllGood({
                "pageIndex" : this.page.index,
                "pageSize" : this.page.size
            }).then(res => {
                this.goodData = res.data.list;
                this.page.total = res.data.pageTotal;
            })
        },
        handlePageChange(val) {
            this.page.index = val;
            this.getGoodData();
        },
        chooseGood(val) {
            let good = val;
            this.exchange.name = good.name;
            if (this.exchange.number === 0) {
                this.exchange.number = 1;
            }
            this.exchange.totalIntegral = good.integral * this.exchange.number;
        },
        // inputNumber() {
        //     this.consume.totalPrice = movie.price * this.consume.number;
        //     this.consume.totalIntegral = movie.integral * this.consume.number;
        // }
    }
}
</script>

<style>

</style>