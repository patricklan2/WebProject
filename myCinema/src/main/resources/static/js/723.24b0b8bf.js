"use strict";(self["webpackChunkmy_cinima"]=self["webpackChunkmy_cinima"]||[]).push([[723],{1723:function(e,a,t){t.r(a),t.d(a,{default:function(){return p}});var n=function(){var e=this,a=e._self._c;return a("div",[a("el-card",{attrs:{shadow:"hover"}},[a("div",{attrs:{slot:"header"},slot:"header"},[a("div",{staticStyle:{"font-size":"20px","line-height":"30px"}},[a("i",{staticClass:"el-icon-file"}),e._v("全部交易记录")]),a("el-input",{staticClass:"handle-input mr10",attrs:{clearable:"",placeholder:"会员名称查询"},model:{value:e.condition.name,callback:function(a){e.$set(e.condition,"name",a)},expression:"condition.name"}}),a("el-input",{staticClass:"handle-input mr10",attrs:{clearable:"",placeholder:"cadId查询"},model:{value:e.condition.cardId,callback:function(a){e.$set(e.condition,"cardId",a)},expression:"condition.cardId"}}),a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.handleSearch}},[e._v("查询")])],1),a("el-col",{attrs:{span:"12"}},[a("el-table",{attrs:{data:e.consumeData,border:"",size:"mini"}},[a("el-table-column",{attrs:{prop:"cardId",label:"会员卡ID",align:"center"}}),a("el-table-column",{attrs:{prop:"reason",label:"交易类型",align:"center"}}),a("el-table-column",{attrs:{prop:"value",label:"金额",align:"center"}}),a("el-table-column",{attrs:{prop:"time",label:"时间",align:"center"}})],1),a("el-pagination",{staticClass:"pagination",attrs:{background:"",layout:"total, prev, pager, next","current-page":e.page.index,"page-size":e.page.size,total:e.page.total},on:{"current-change":e.handlePageChange}})],1),a("el-col",{attrs:{span:"12"}},[a("el-table",{attrs:{data:e.exchangeData,border:"",size:"mini"}},[a("el-table-column",{attrs:{prop:"memberId",label:"会员ID",align:"center"}}),a("el-table-column",{attrs:{prop:"reason",label:"交易类型",align:"center"}}),a("el-table-column",{attrs:{prop:"value",label:"积分",align:"center"}}),a("el-table-column",{attrs:{prop:"time",label:"时间",align:"center"}})],1),a("el-pagination",{staticClass:"pagination",attrs:{background:"",layout:"total, prev, pager, next","current-page":e.page2.index,"page-size":e.page2.size,total:e.page2.total},on:{"current-change":e.handlePage2Change}})],1)],1)],1)},l=[],r=t(4307),o={data(){return{condition:{name:"",cardId:""},page:{index:1,size:5,total:0},page2:{index:1,size:5,total:0},consumeData:[],exchangeData:[]}},created(){this.getConsumeData(),this.getExchangeData()},methods:{getConsumeData(){(0,r.U$)({pageIndex:this.page.index,pageSize:this.page.size}).then((e=>{this.consumeData=e.data.list,this.page.total=e.data.pageTotal}))},handlePageChange(e){this.page.index=e,this.getConsumeData()},getExchangeData(){(0,r.L5)({pageIndex:this.page2.index,pageSize:this.page2.size}).then((e=>{this.exchangeData=e.data.list,this.page2.total=e.data.pageTotal}))},handlePageChange(e){this.page2.index=e,this.getExchangeData()}}},i=o,s=t(1001),c=(0,s.Z)(i,n,l,!1,null,null,null),p=c.exports},4307:function(e,a,t){t.d(a,{AN:function(){return r},F_:function(){return d},H3:function(){return p},L5:function(){return i},NN:function(){return c},TA:function(){return s},U$:function(){return o},sz:function(){return l}});var n=t(1117);const l=e=>(0,n.Z)({url:"selectAllCard",method:"post",params:e}),r=e=>(0,n.Z)({url:"selectCardByCondition",method:"post",params:e}),o=e=>(0,n.Z)({url:"selectAllConsumeRecord",method:"post",params:e}),i=e=>(0,n.Z)({url:"selectAllExchangeRecord",method:"post",params:e}),s=e=>(0,n.Z)({url:"cardLose",method:"post",params:e}),c=e=>(0,n.Z)({url:"cardCancel",method:"post",params:e}),p=e=>(0,n.Z)({url:"recharge",method:"post",params:e}),d=e=>(0,n.Z)({url:"consume",method:"post",params:e})}}]);
//# sourceMappingURL=723.24b0b8bf.js.map