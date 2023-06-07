<template>
    <el-dialog :title="title" :visible.sync="visible" width="30%">
        <el-form :model="form" label-width="70px">
            <el-form-item label="电影名">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="价格">
                <el-input v-model="form.price"></el-input>
            </el-form-item>
            <el-form-item label="积分">
                <el-input v-model="form.integral"></el-input>
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
    props: ['title'],
    data() {
        return {
            visible: false,
            form: {},
        }
    },
    methods: {
        confirm() {
            this.visible = false;
            this.$emit('movieDialogConfirm' , this.form);
        },
        show(form) {
            this.form = form;
            this.visible = true;
        },
    }
}
</script>

<style>

</style>