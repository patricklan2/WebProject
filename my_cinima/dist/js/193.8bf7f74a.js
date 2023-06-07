"use strict";(self["webpackChunkmy_cinima"]=self["webpackChunkmy_cinima"]||[]).push([[193],{7193:function(t,e,a){a.r(e),a.d(e,{default:function(){return P}});var i=function(){var t=this,e=t._self._c;return e("div",[e("el-row",{staticClass:"mgb20",attrs:{gutter:25}},[e("el-col",{attrs:{span:8}},[e("manager-card",{staticStyle:{height:"252px"},attrs:{manager:t.manager}}),e("deal-card",{staticStyle:{height:"252px"}})],1),e("el-col",{attrs:{span:16}},[e("el-row",{staticClass:"mgb20",attrs:{gutter:20}},[e("statistic-card")],1),e("movie-card")],1)],1)],1)},s=[],r=function(){var t=this,e=t._self._c;return e("el-card",{staticStyle:{height:"252px"},attrs:{shadow:"hover"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",[t._v("交易金额比例")])]),t._v(" 消费"),t.getDealRadio?e("el-progress",{attrs:{percentage:t.getDealRadio,color:"#42b983"}}):t._e(),t._v(" 充值"),t.rechargeRadio?e("el-progress",{attrs:{percentage:t.rechargeRadio,color:"#f1e05a"}}):t._e(),t._v(" 积分兑换"),t.integralRadio?e("el-progress",{attrs:{percentage:t.integralRadio}}):t._e()],1)},n=[],l=a(555),o={data(){return{dealData:{}}},computed:{totalNumber:function(){return this.dealData.consume+this.dealData.recharge+this.dealData.integral},getDealRadio:function(){return Math.round(this.dealData.consume/this.totalNumber*100)},rechargeRadio:function(){return Math.round(this.dealData.recharge/this.totalNumber*100)},integralRadio:function(){return Math.round(this.dealData.integral/this.totalNumber*100)}},created(){this.getDeal()},methods:{getDeal(){(0,l._m)().then((t=>{this.dealData=t.data}))}}},c=o,d=a(1001),u=(0,d.Z)(c,r,n,!1,null,null,null),m=u.exports,g=function(){var t=this,e=t._self._c;return e("el-card",{staticClass:"mgb20",attrs:{shadow:"hover"}},[e("div",{staticClass:"user-info"},[e("img",{staticClass:"manager-avatar",attrs:{src:a(9017),alt:""}}),e("div",{staticClass:"user-info-cont"},[e("div",{staticClass:"user-info-name"},[t._v(t._s(t.manager.name))]),e("div",[t._v(t._s(t.manager.role))])])]),e("div",{staticClass:"user-info-list"},[t._v("管理员ID"),e("span",[t._v(t._s(t.manager.managerId))])]),e("div",{staticClass:"user-info-list"},[t._v("已工作时间"),e("span",[t._v(t._s(t.workTime))])])])},h=[],p={data(){return{managerId:localStorage.getItem("managerId"),manager:{},workTime:"",worker:""}},created(){this.getManagerData();const t=this;t.timer=setInterval((()=>{t.getWorkTime()}),1e3)},methods:{getWorkTime(){let t=new Date(new Date-new Date(this.manager.time)),e=t.getHours()-8,a=t.getMinutes(),i=t.getSeconds();i<10&&(i="0"+i),this.workTime=e+":"+a+":"+i},getManagerData(){console.log(this.managerId),(0,l.g2)({managerId:this.managerId}).then((t=>{this.manager=t.data,this.getWorkTime()}))}}},f=p,v=(0,d.Z)(f,g,h,!1,null,null,null),b=v.exports,D=function(){var t=this,e=t._self._c;return e("el-card",{attrs:{shadow:"hover"}},[e("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[e("span",[t._v("电影票")]),e("el-button",{staticStyle:{float:"right",padding:"3px 0"},attrs:{type:"text"},on:{click:t.handleAdd}},[t._v("添加")])],1),e("el-table",{staticClass:"table",attrs:{border:"",data:t.movieData}},[e("el-table-column",{attrs:{prop:"name",label:"电影名"}}),e("el-table-column",{attrs:{prop:"price",label:"价格",width:"55"}}),e("el-table-column",{attrs:{prop:"time",label:"时间"}}),e("el-table-column",{attrs:{prop:"integral",label:"积分",width:"55"}}),e("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{attrs:{type:"text",icon:"el-icon-edit"},on:{click:function(e){return t.handleModify(a.row)}}},[t._v("编辑")]),e("el-button",{staticClass:"red",attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(e){return t.handleDelete(a.row)}}},[t._v("删除")])]}}])})],1),e("el-pagination",{staticClass:"pagination",attrs:{background:"",layout:"total, prev, pager, next","current-page":t.page.index,"page-size":t.page.size,total:t.page.total},on:{"current-change":t.handlePageChange}}),e("movie-dialog",{ref:"add",attrs:{title:"添加"}}),e("movie-dialog",{ref:"modify",attrs:{title:"编辑"}})],1)},_=[],x=function(){var t=this,e=t._self._c;return e("el-dialog",{attrs:{title:t.title,visible:t.visible,width:"30%"},on:{"update:visible":function(e){t.visible=e}}},[e("el-form",{attrs:{model:t.form,"label-width":"70px"}},[e("el-form-item",{attrs:{label:"电影名"}},[e("el-input",{model:{value:t.form.name,callback:function(e){t.$set(t.form,"name",e)},expression:"form.name"}})],1),e("el-form-item",{attrs:{label:"价格"}},[e("el-input",{model:{value:t.form.price,callback:function(e){t.$set(t.form,"price",e)},expression:"form.price"}})],1),e("el-form-item",{attrs:{label:"积分"}},[e("el-input",{model:{value:t.form.integral,callback:function(e){t.$set(t.form,"integral",e)},expression:"form.integral"}})],1)],1),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(e){t.visible=!1}}},[t._v("取 消")]),e("el-button",{attrs:{type:"primary"},on:{click:t.confirm}},[t._v("确 定")])],1)],1)},C=[],w={props:["title"],data(){return{visible:!1,form:{}}},methods:{confirm(){this.visible=!1,this.$emit("movieDialogConfirm",this.form)},show(t){this.form=t,this.visible=!0}}},y=w,M=(0,d.Z)(y,x,C,!1,null,null,null),k=M.exports,$={components:{MovieDialog:k},data(){return{movieData:[],page:{index:1,size:4,total:0}}},created(){this.getMovieData()},mounted(){this.$refs.add.$on("movieDialogConfirm",(t=>{(0,l.dO)(t).then((t=>{200==t.status?(this.$message.success("添加成功"),this.getMovieData()):this.$message.success("添加失败，服务端出现问题")}))})),this.$refs.modify.$on("movieDialogConfirm",(t=>{(0,l.LZ)(t).then((t=>{200==t.status?(this.$message.success("编辑成功"),this.getMovieData()):this.$message.success("编辑失败，服务端出现问题")}))}))},methods:{getMovieData(){(0,l.zS)({pageIndex:this.page.index,pageSize:this.page.size}).then((t=>{this.movieData=t.data.list,this.page.total=t.data.pageTotal}))},handlePageChange(t){this.page.index=t,this.getMovieData()},handleAdd(){this.$refs.add.show({})},handleModify(t){this.$refs.modify.show(t)},handleDelete(t){this.$confirm("确定要删除吗？","提示",{type:"warning"}).then((()=>{(0,l.fx)(t).then((t=>{200==t.status?(this.$message.success("删除成功"),this.getMovieData()):this.$message.error("删除失败，服务器出现故障")}))})).catch((()=>{}))}}},Z=$,S=(0,d.Z)(Z,D,_,!1,null,null,null),I=S.exports,R=function(){var t=this,e=t._self._c;return e("div",t._l(t.statisticData,(function(a){return e("el-col",{key:a,attrs:{span:a.span}},[e("el-card",{attrs:{shadow:"hover","body-style":{padding:"0px"}}},[e("div",{staticClass:"grid-content",class:"grid-con-"+a.index},[e("i",{staticClass:"grid-con-icon",class:a.icon}),e("div",{staticClass:"grid-cont-right"},[e("div",{staticClass:"grid-num"},[t._v(t._s(a.number))]),e("div",[t._v(t._s(a.title))])])])])],1)})),1)},z=[],N={data(){return{statisticData:{member:{index:1,icon:"el-icon-user",title:"已注册会员",number:0,span:8},card:{index:2,icon:"el-icon-postcard",title:"已办理会员卡",number:0,span:8},movie:{index:3,icon:"el-icon-goods",title:"已售电影票",number:0,span:8}}}},created(){this.getStatistic()},methods:{getStatistic(){(0,l.DG)().then((t=>{let e=t.data;this.statisticData.member.number=e.memberNum,this.statisticData.card.number=e.cardNum,this.statisticData.movie.number=e.movieNum}))}}},T=N,A=(0,d.Z)(T,R,z,!1,null,null,null),W=A.exports,G={components:{MovieCard:I,ManagerCard:b,DealCard:m,StatisticCard:W},data(){return{}},mounted:{}},L=G,O=(0,d.Z)(L,i,s,!1,null,null,null),P=O.exports},555:function(t,e,a){a.d(e,{DG:function(){return l},LZ:function(){return c},_m:function(){return n},dO:function(){return o},fx:function(){return d},g2:function(){return s},zS:function(){return r}});var i=a(1117);const s=t=>(0,i.Z)({url:"selectManagerByManagerId",method:"get",params:t}),r=t=>(0,i.Z)({url:"selectAllMovie",method:"get",params:t}),n=t=>(0,i.Z)({url:"getDealData",method:"get",params:t}),l=t=>(0,i.Z)({url:"getStatisticData",method:"get",params:t}),o=t=>(0,i.Z)({url:"addMovie",method:"get",params:t}),c=t=>(0,i.Z)({url:"modifyMovie",method:"get",params:t}),d=t=>(0,i.Z)({url:"deleteMovie",method:"get",params:t})},9017:function(t,e,a){t.exports=a.p+"img/admin.22222124.png"}}]);
//# sourceMappingURL=193.8bf7f74a.js.map