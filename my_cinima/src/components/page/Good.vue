<template>
    <div>
        <div>integral</div>
        <el-card shadow="hover">
            <div slot="header">
                <div style="font-size: 20px; line-height: 30px"><i class="el-icon-user"></i>商品</div>
                <el-button type="primary" @click="handleAdd">添加</el-button>
            </div>
            <el-table :data="goodData" border class="table">
                <el-table-column prop="name" label="name" width="180" align="center"></el-table-column>
                <el-table-column prop="integral" label="积分" align="center"></el-table-column>
                <el-table-column prop="stock" label="存量" align="center"></el-table-column>
                <el-table-column label="操作" width="500px" align="center">
                    <template slot-scope="scope">
                        <el-button type="primary" @click="handleModify(scope.row)">修改</el-button>
                        <el-button type="primary" @click="handleDelete(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination class="pagination" background layout="total, prev, pager, next" @current-change="handlePageChange" 
                :current-page="page.index" :page-size="page.size" :total="page.total">
            </el-pagination>

            <good-dialog ref="add"></good-dialog>
            <good-dialog :modify="true" ref="modify"></good-dialog>
        </el-card>
    </div>
</template>

<script>
import { selectAllGood, modifyGood, deleteGood, addGood } from "@/api/good.js";
import GoodDialog from "./integral/GoodDialog.vue";
export default {
    components: { GoodDialog },
    data() {
        return {
            goodData: [],
            page: {
                index: 1,
                size: 8,
                total: 0,
            },
        }
    },
    created() {
        this.getGoodData();
    },
    mounted() {
        this.$refs.add.$on("goodDialogConfirm",form => {
            addGood(form).then(res=>{
                if(res.status==200){
                    this.$message.success('添加成功');
                    this.getGoodData();
                }else{
                    this.$message.error("添加失败，服务器出现故障")
                }
            })
        });
        this.$refs.modify.$on("goodDialogConfirm",form => {
            modifyGood(form).then(res=>{
                if(res.status==200) {
                    this.$message.success(`编辑成功`);
                    this.getGoodData();
                }else{
                    this.$message.success(`编辑失败，服务端出现问题`);
                }
            });
        });
    },
    methods: {
        getGoodData(){
            selectAllGood({
                pageIndex: this.page.index,
                pageSize: this.page.size,
            }).then(res => {
                this.goodData = res.data.list;
                this.page.total = res.data.pageTotal;
            })
        },
        handlePageChange(val) {
            this.page.index = val;
            this.getGoodData();
        },
        handleAdd(){
            this.$refs.add.show({});
        },
        handleModify(row){
            this.$refs.modify.show(row);
        },
        handleDelete(row){
            this.$confirm('确定要删除吗？', '提示', {
                type: 'warning'
            }).then(() => {
                deleteGood(row).then(res=>{
                    if(res.status==200){
                        this.$message.success('删除成功');
                        this.getGoodData();
                    }else{
                        this.$message.error("删除失败，服务器出现故障")
                    }
                });
            }).catch(() => {        
            });
        },
    }
}
</script>

<style>

</style>