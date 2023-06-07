<template>
    <div>
        <el-row :gutter="25"  class="mgb20">
            <el-col :span="8">
                <manager-card :manager="manager" style="height:252px;"></manager-card>
                <deal-card style="height:252px;"></deal-card>
            </el-col>
            <el-col :span="16">
                <el-row :gutter="20" class="mgb20">
                    <statistic-card></statistic-card>
                </el-row>
                <movie-card></movie-card>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import DealCard from './dashboard/DealCard.vue';
import ManagerCard from './dashboard/ManagerCard.vue';
import MovieCard from './dashboard/MovieCard.vue';
import StatisticCard from "./dashboard/StatisticCard.vue";
export default {
    components: { MovieCard, ManagerCard, DealCard, StatisticCard },
    data() {
        return {
        }
    },
    mounted: {
    },
}
</script>

<style>
.mgb20 {
    margin-bottom: 20px;
}
</style>