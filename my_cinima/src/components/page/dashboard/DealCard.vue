<template>
    <el-card shadow="hover" style="height:252px;">
        <div slot="header" class="clearfix"> <span>交易金额比例</span></div>
        消费<el-progress v-if="getDealRadio" :percentage="getDealRadio" color="#42b983"></el-progress>
        充值<el-progress v-if="rechargeRadio" :percentage="rechargeRadio" color="#f1e05a"></el-progress>
        积分兑换<el-progress v-if="integralRadio" :percentage="integralRadio"></el-progress>
    </el-card>
</template>

<script>
import { getDealData } from "@/api/dashboard";
export default {
    data() {
        return {
            dealData: {},
        }
    },
    computed: {
        totalNumber: function () {
            return this.dealData.consume + this.dealData.recharge + this.dealData.integral;
        },
        getDealRadio: function () {
            return Math.round(this.dealData.consume / this.totalNumber * 100);
        },
        rechargeRadio: function () {
            return  Math.round(this.dealData.recharge / this.totalNumber * 100);
        },
        integralRadio: function () {
            return  Math.round(this.dealData.integral / this.totalNumber * 100);
        }
    },
    created() {
        this.getDeal();
    },
    methods: {
        getDeal(){
            getDealData().then(res=>{
                this.dealData = res.data;
            })
        },
    }
}
</script>

<style>

</style>