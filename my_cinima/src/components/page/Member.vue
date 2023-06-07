<template>
    <div>
        <el-card shadow="hover">
            <div slot="header">
                <div style="font-size: 20px; line-height: 30px"><i class="el-icon-user"></i> 会员列表</div>
                <el-button type="primary" class="handle-del mr10" @click="handleRegister">会员注册</el-button>
                <el-select v-model="condition.birthdayQuery" clearable placeholder="按生日查询" class="handle-input mr10">
                    <el-option key="0" label="当天过生日" value="1"></el-option>
                    <el-option key="2" label="七天内过生日" value="7"></el-option>
                    <el-option key="3" label="十天内过生日" value="10"></el-option>
                </el-select>
                <el-input v-model="condition.name" clearable placeholder="会员名称查询" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">查询</el-button>
            </div>
            <el-table :data="memberData" border class="table">
                <el-table-column prop="memberId" label="ID" width="180" align="center"></el-table-column>
                <el-table-column prop="grade" label="等级" width="180" align="center"></el-table-column>
                <el-table-column prop="integral" label="积分" align="center"></el-table-column>
                <el-table-column prop="name" width="150" label="会员姓名" align="center"></el-table-column>
                <el-table-column prop="sex" label="性别" align="center"></el-table-column>
                <el-table-column prop="birthday" label="生日" align="center"> </el-table-column>
                <el-table-column label="操作" width="500" align="center">
                    <template slot-scope="scope">
                        <el-button type="primary" icon="el-icon-postcard" @click="exchangeClick(scope.row)">兑换商品</el-button>
                        <el-button type="primary" icon="el-icon-postcard" @click="checkClick(scope.row)">查看会员卡</el-button>
                        <el-button type="warning" icon="el-icon-edit" @click="modifyClick(scope.row)" >修改 </el-button>
                        <el-button type="danger" icon="el-icon-delete" @click="deleteClick(scope.row)" >删除 </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination class="pagination" background layout="total, prev, pager, next" @current-change="handlePageChange" 
                :current-page="page.index" :page-size="page.size" :total="page.total">
            </el-pagination>
            <member-dialog title="注册" :type="registerType" ref="register"></member-dialog>
            <member-dialog title="确认会员信息" :type="checkType" ref="check"></member-dialog>
            <member-dialog title="修改" :type="modifyType" ref="modify"></member-dialog>
            <exchange-dialog ref="exchange"></exchange-dialog>
        </el-card>
    </div>
</template>

<script>
import { selectAllMember, selectMemberByCondition, registerMember, modifyMember, deleteMember, exchange } from "@/api/member.js";
import MemberDialog from './member/MemberDialog.vue';
import ExchangeDialog from './member/ExchangeDialog.vue';
export default {  
    components: { MemberDialog, ExchangeDialog },
    data() {
        return {
            condition: {
                birthdayQuery: "",
                name: "",
            },
            memberData: [],
            page: {
                index: 1,
                size: 5,
                total: 0,
            },
            checkType: {item: ["memberId","name"],disabled: true,},
            modifyType: {item: ["name","password","sex","birthday"],},
            registerType: {item: ["name","password","sex","birthday"],},
        }
    },
    mounted(){
        this.$refs.register.$on('memberDialogConfirm', form => {
            registerMember(form).then(res=>{
                if(res.status==200) {
                    this.$message.success(`添加成功`);
                    this.getMemberData();
                }else{
                    this.$message.success(`添加失败，服务端出现问题`);
                };
            });
        });
        this.$refs.modify.$on('memberDialogConfirm', form => {
            modifyMember(form).then(res=>{
                if(res.status==200) {
                    this.$message.success(`编辑成功`);
                    this.getMemberData();
                }else{
                    this.$message.success(`编辑失败，服务端出现问题`);
                }
            });
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
    created() {
        this.getMemberData();
    },  
    methods:{
        getMemberData(){
            selectAllMember({
                pageIndex: this.page.index,
                pageSize: this.page.size,
            }).then(res => {
                this.memberData = res.data.list;
                this.page.total = res.data.pageTotal;
            });
        },
        handlePageChange(val){
            this.page.index = val;
            this.handleSearch();
        },
        checkClick(row){
            this.$refs.check.show(row);
        },
        modifyClick(row){
            this.$refs.modify.show(row);
        },
        handleRegister() {
            this.$refs.register.show({});
        },
        exchangeClick(row){
            this.$refs.exchange.show(row);
        },
        handleSearch() {
            selectMemberByCondition({
                pageIndex: this.page.index,
                pageSize: this.page.size,
                name: this.condition.name,
                birthdayType: this.condition.birthdayQuery,
            }).then(res => {
                this.memberData = res.data.list;
                this.page.total = res.data.pageTotal;
            });
        },
        deleteClick(row){
            this.$confirm('确定要删除吗？', '提示', {
                type: 'warning'
            }).then(() => {
                deleteMember(row).then(res=>{
                    if(res.status==200){
                        this.$message.success('删除成功');
                        this.getMemberData();
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
.handle-input {
    width: 200px;
    margin-left: 0px;
    margin-right: 10px;
    margin-top: 4px;
}
</style>