<template>
    <el-dialog title="消费" :visible.sync="visible" width="70%">
        <el-form :model="form" label-width="70px" size="mini">
            <el-form-item label="cardId">
                <el-input v-model="recharge.cardId" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="额度"> <el-input v-model="recharge.number"></el-input></el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="visible = false">取 消</el-button>
            <el-button type="primary" @click="confirm">确 定</el-button>
        </span>
    </el-dialog>
</template>

<script>
export default {
    data() {
        return {
            visible: false,
            cardInfo: {},
            recharge: {
                cardId: '',
                number: 0,
            },
        }
    },
    methods: {
        confirm() {
            this.visible = false;
            this.$emit("RechargeDialogConfirm",this.recharge);
        },
        show(cardInfo) {
            this.cardInfo = cardInfo;
            this.recharge.cardId = cardInfo.cardId;
            this.visible = true;
        },
    }
}
</script>

<style>

</style>