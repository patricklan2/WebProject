<template>
    <el-card shadow="hover">
        <div slot="header" class="clearfix">
            <span>电影票</span>
            <el-button style="float: right; padding: 3px 0" type="text" @click="handleAdd">添加</el-button>
        </div>
        <el-table class="table" border :data="movieData">
            <el-table-column prop="name" label="电影名"></el-table-column>
            <el-table-column prop="price" label="价格" width="55"></el-table-column>
            <el-table-column prop="time" label="时间"></el-table-column>
            <el-table-column prop="integral" label="积分" width="55"></el-table-column>
            <el-table-column label="操作" align="center">
                <template slot-scope="scope">
                    <el-button type="text" icon="el-icon-edit" @click="handleModify(scope.row)">编辑</el-button>
                    <el-button type="text" icon="el-icon-delete" class="red" @click="handleDelete(scope.row)">删除</el-button>
                </template>
            </el-table-column>  
        </el-table>
        <el-pagination class="pagination" background layout="total, prev, pager, next"
            :current-page="page.index" :page-size="page.size" :total="page.total"
            @current-change="handlePageChange">
        </el-pagination>
        <movie-dialog title="添加" ref="add"></movie-dialog>
        <movie-dialog title="编辑" ref="modify"></movie-dialog>
    </el-card>
</template>

<script>
import MovieDialog from './MovieDialog.vue';
import { selectAllMovie, modifyMovie, addMovie, deleteMovie } from "@/api/dashboard";
export default {
    components: { MovieDialog },
    data() {
        return {
            movieData: [],
            page: {
                index: 1,
                size: 4,
                total: 0,
            },
        }
    },
    created() {
        this.getMovieData();
    },
    mounted() {
        this.$refs.add.$on('movieDialogConfirm',form => {
            addMovie(form).then(res=>{
                if(res.status==200) {
                    this.$message.success(`添加成功`);
                    this.getMovieData();
                }else{
                    this.$message.success(`添加失败，服务端出现问题`);
                }
            });
        }),
        this.$refs.modify.$on('movieDialogConfirm', form => {
            modifyMovie(form).then(res=>{
                if(res.status==200) {
                    this.$message.success(`编辑成功`);
                    this.getMovieData();
                }else{
                    this.$message.success(`编辑失败，服务端出现问题`);
                }
            });
        })
    },
    methods: {
        getMovieData() {
            selectAllMovie  ({
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
        handleAdd() {
            this.$refs.add.show({});
        },
        handleModify(row) {
            this.$refs.modify.show(row);
        },
        handleDelete(row) {
            this.$confirm('确定要删除吗？', '提示', {
                type: 'warning'
            }).then(() => {
                deleteMovie(row).then(res=>{
                    if(res.status==200){
                        this.$message.success('删除成功');
                        this.getMovieData();
                    }else{
                        this.$message.error("删除失败，服务器出现故障")
                    }
                })
            }).catch(() => {        
            });
        },
    }
}
</script>

<style>

</style>