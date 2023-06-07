<template>
    <div>
        <el-card shadow="hover">
            <div slot="header">
                <el-button type="primary" @click="flushAll">更新所有</el-button>
            </div>
            <el-col span="12" class="care_col">
                <el-card>
                    <div>会员等级一</div>
                    <el-input class="care_input" type="textarea" :rows="3" placeholder="请输入内容" v-model="grade.grade_1" size="medium"> </el-input>
                    <div>会员等级二</div>
                    <el-input class="care_input" type="textarea" :rows="3" placeholder="请输入内容" v-model="grade.grade_2" size="medium"> </el-input>
                    <div>会员等级三</div>
                    <el-input class="care_input" type="textarea" :rows="3" placeholder="请输入内容" v-model="grade.grade_3" size="medium"> </el-input>
                    <el-button type="primary" @click="apply">应用</el-button>
                </el-card>
            </el-col>
            <el-col span="12" class="care_col">
                <el-card>
                    <div>生日祝福</div>
                    <el-input class="care_input" type="textarea" :rows="3" placeholder="请输入内容" v-model="blessing" size="medium"> </el-input>
                    <el-button type="primary" @click="apply2">应用</el-button>
                </el-card>
            </el-col>
        </el-card>
    </div>  
</template>

<script>
import { selectAllCareInfo, setGradeInfo, setBlessing, flushCareInfo } from "@/api/care.js";
export default {
    data() {
        return {
            grade: {grade_1: "",grade_2: "",grade_3:""},
            blessing: "",
        }
    },
    created() {
        this.getCareInfo();
    },
    methods: {
        getCareInfo(){
            selectAllCareInfo({}).then(res => {
                let data = res.data;
                this.blessing = data[0].info;
                this.grade.grade_1 = data[1].info;
                this.grade.grade_2 = data[2].info;
                this.grade.grade_3 = data[3].info;
            })
        },
        apply(){
            setGradeInfo(this.grade).then(res=>{
                if(res.status==200){
                    this.$message.success('应用成功');
                }else{
                    this.$message.error("应用失败，服务器出现故障")
                }
            })
        },
        apply2(){
            setBlessing({
                blessing: this.blessing
            }).then(res=>{
                if(res.status==200){
                    this.$message.success('应用成功');
                }else{
                    this.$message.error("应用失败，服务器出现故障")
                }
            })
        },
        flushAll(){
            flushCareInfo({}).then(res=>{
                if(res.status==200){
                    this.$message.success('刷新成功');
                }else{
                    this.$message.error("刷新失败，服务器出现故障")
                }
            })
        }
    }
}
</script>

<style>
.care_input{
    font-size: 30px
}
.care_col{
    padding-right: 5px;
}
</style>