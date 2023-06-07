<template>
    <el-dialog title="消费" :visible.sync="visible" width="70%">
        <el-table border :data="movieData" @current-change="chooseMovie">
            <el-table-column prop="name" label="电影名"></el-table-column>
            <el-table-column prop="price" label="价格"></el-table-column>
            <el-table-column prop="integral" label="积分"></el-table-column>
        </el-table>
        <el-pagination class="pagination" background layout="total, prev, pager, next"
            :current-page="page.index" :page-size="page.size" :total="page.total"
            @current-change="handlePageChange">
        </el-pagination>
        <el-form :model="form" label-width="70px" size="mini">
            <el-form-item label="电影名字"> {{consume.name}} </el-form-item>
            <el-form-item label="数量"> <el-input v-model="consume.number" @change="inputNumber"></el-input> </el-form-item>
            <el-form-item label="价格"> {{consume.totalPrice}} </el-form-item>
            <el-form-item label="获得积分"> {{consume.totalIntegral}} </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="visible = false">取 消</el-button>
            <el-button type="primary" @click="confirm">确 定</el-button>
        </span>
    </el-dialog>
</template>

<script>
import { selectAllMovie } from "@/api/dashboard";
export default {
    data() {
        return {
            visible: false,
            cardInfo: {},
            movieData: [],
            page: {
                index: 1,
                size: 4,
                total: 0,
            },
            consume: {
                cardId: "",
                name: '',
                totalPrice: 0,
                totalIntegral: 0,
                number: 0,
            },
        }
    },
    created() {
        this.getMovieData();
    },
    methods: {
        confirm() {
            this.visible = false;
            this.$emit('ConsumeDialogConfirm',this.consume);
        },
        show(cardInfo) {
            this.cardInfo = cardInfo;
            this.consume.cardId = cardInfo.cardId;
            this.visible = true;
        },
        getMovieData() {
            selectAllMovie({
                "pageIndex" : this.page.index,
                "pageSize" : this.page.size
            }).then(res => {
                this.movieData = res.data.list;
                this.page.total = res.data.pageTotal;
            })
        },
        handlePageChange(val) {
            this.page.index = val;
            this.getMovieData();
        },
        chooseMovie(val) {
            let movie = val;
            this.consume.name = movie.name;
            if (this.consume.number === 0) {
                this.consume.number = 1;
            }
            this.consume.totalPrice = movie.price * this.consume.number;
            this.consume.totalIntegral = movie.integral * this.consume.number;
        },
        inputNumber() {
            this.consume.totalPrice = movie.price * this.consume.number;
            this.consume.totalIntegral = movie.integral * this.consume.number;
        }
    }
}
</script>

<style>

</style>