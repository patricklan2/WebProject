<template>
    <el-dialog :title="title" :visible.sync="visible" width="40%">
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-form-item v-if="memberId" label="会员Id" prop="memberId">
                    <el-input v-model="form.memberId" :disabled="isDisabled"></el-input>
                </el-form-item>
                <el-form-item v-if="name" label="会员姓名" prop="name">
                    <el-input v-model="form.name" :disabled="isDisabled"></el-input>
                </el-form-item>
                <el-form-item v-if="password" label="密码" prop="password">
                    <el-input v-model="form.password" show-password placeholder="请输入密码" :disabled="isDisabled"></el-input>
                </el-form-item>
                <el-form-item v-if="sex" label="性别" prop="sex">
                    <el-radio v-model="form.sex" label="男" :disabled="isDisabled">男</el-radio>
                    <el-radio v-model="form.sex" label="女" :disabled="isDisabled">女</el-radio>
                </el-form-item>
                <el-form-item v-if="birthday" label="生日" prop="birthday">
                    <el-date-picker :disabled="isDisabled"
                            v-model="form.birthday"
                            value-format="yyyy-MM-dd"
                            type="date"
                            placeholder="选择日期"
                            format="yyyy-MM-dd">
                    </el-date-picker>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="visible = false">取 消</el-button>
                <el-button type="primary" @click="confirm">确 定</el-button>
            </span>
        </el-dialog>
</template>

<script>
export default {
    props: ["title", "type"],
    data() {
        return {
            visible: false,
            form: {},
            rules: {
                memberId: [{required: true, message: '请输入会员名', trigger: 'blur'}],
                password: [{required: true, message: '请输入密码', trigger: 'blur'}],
                name: [{required: true, message: '请输入姓名', trigger: 'blur'}],
                sex: [{required: true, message: '请输入性别', trigger: 'blur'}],
                birthday: [{required: true, message: '请输入生日', trigger: 'blur'}],
            },
        }
    },
    computed: {
        isDisabled: function() {
            if (this.type.disabled) {
                return this.type.disabled;
            }else return false;
        },
        memberId: function () {
            return this.isExist('memberId');
        },
        name: function() {
            return this.isExist('name');
        },
        password: function() {
            return this.isExist('password');
        },
        sex: function() {
            return this.isExist('sex');
        },
        birthday: function() {
            return this.isExist('birthday');
        },
    },
    methods: {
        confirm() {
            this.visible = false;
            this.$emit('memberDialogConfirm' , this.form);
        },
        show(form) {
            this.form = form;
            this.visible = true;
        },
        isExist(title){
            return this.type.item.indexOf(title) != -1;
        }
    }
}
</script>

<style>

</style>