"use strict";(self["webpackChunkmy_cinima"]=self["webpackChunkmy_cinima"]||[]).push([[203],{1998:function(e,a,r){r.r(a),r.d(a,{default:function(){return d}});var s=function(){var e=this,a=e._self._c;return a("div",{staticClass:"login-wrap"},[a("div",{staticClass:"ms-login"},[a("div",{staticClass:"ms-title"},[e._v("电影院会员管理系统")]),a("el-form",{ref:"login",staticClass:"ms-content",attrs:{model:e.param,rules:e.rules,"label-width":"0px"}},[a("el-form-item",[a("el-select",{attrs:{clearable:"",placeholder:"登录角色"},model:{value:e.param.role,callback:function(a){e.$set(e.param,"role",a)},expression:"param.role"}},[a("el-option",{key:"0",attrs:{label:"管理员",value:"manager"}}),a("el-option",{key:"1",attrs:{label:"会员",value:"member"}})],1)],1),a("el-form-item",{attrs:{prop:"username"}},[a("el-input",{attrs:{placeholder:"managerId"},model:{value:e.param.id,callback:function(a){e.$set(e.param,"id",a)},expression:"param.id"}},[a("el-button",{attrs:{slot:"prepend",icon:"el-icon-lx-people"},slot:"prepend"})],1)],1),a("el-form-item",{attrs:{prop:"password"}},[a("el-input",{attrs:{type:"password",placeholder:"password"},nativeOn:{keyup:function(a){return!a.type.indexOf("key")&&e._k(a.keyCode,"enter",13,a.key,"Enter")?null:e.submitForm()}},model:{value:e.param.password,callback:function(a){e.$set(e.param,"password",a)},expression:"param.password"}},[a("el-button",{attrs:{slot:"prepend",icon:"el-icon-lx-lock"},slot:"prepend"})],1)],1),a("div",{staticClass:"login-btn"},[a("el-button",{attrs:{type:"primary"},on:{click:function(a){return e.submitForm()}}},[e._v("登录")])],1)],1)],1)])},t=[],l=(r(7658),r(1117));const o=e=>(0,l.Z)({url:"managerLogin",method:"get",params:e}),i=e=>(0,l.Z)({url:"memberLogin",method:"get",params:e});var n={data(){return{param:{role:"",id:"",password:""},rules:{managerId:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}]}}},methods:{submitForm(){"manager"==this.param.role?this.handleManagerLogin():"member"==this.param.role?this.handleMemberLogin():this.$message("请选择角色")},handleManagerLogin(){o(this.param).then((e=>{200==e.status?e.data?(this.$message.success("登录成功"),localStorage.setItem("managerId",this.param.id),this.$router.push("/index/dashboard")):this.$message.error("登录失败"):this.$message.error("服务器错误")}))},handleMemberLogin(){i(this.param).then((e=>{200==e.status?e.data?(this.$message.success("登录成功"),localStorage.setItem("memberId",this.param.id),this.$router.push("/memberView")):this.$message.error("登录失败"):this.$message.error("服务器错误")}))}}},m=n,p=r(1001),u=(0,p.Z)(m,s,t,!1,null,null,null),d=u.exports}}]);
//# sourceMappingURL=203.84532754.js.map