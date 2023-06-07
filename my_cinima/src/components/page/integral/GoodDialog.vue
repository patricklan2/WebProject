<template>
    <el-dialog title="添加" :visible.sync="visible" width="70%">
        <el-form :model="good" label-width="70px" size="mini">
            <el-form-item label="名字"> <el-input v-model="good.name" :disabled="modify"></el-input></el-form-item>
            <el-form-item label="数量"> <el-input v-model="good.stock"></el-input></el-form-item>
            <el-form-item label="积分"> <el-input v-model="good.integral"></el-input></el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="visible = false">取 消</el-button>
            <el-button type="primary" @click="confirm">确 定</el-button>
        </span>
    </el-dialog>
</template>

<script>
export default {
    props: ['modify'],
    data() {
        return {
            visible: false,
            good: {
                name: '',
                stock: 0,
                integral: 0,
            },
        }
    },
    methods: {
        confirm() {
            this.visible = false;
            this.$emit("goodDialogConfirm",this.good);
        },
        show(goodInfo) {
            this.good = goodInfo;
            this.visible = true;
        },
    }

}
</script>

<style>

</style>