<template>
<div style="width: 100%;height: 100vh;background-color: darkslateblue;overflow: hidden">
<div style="width: 400px;margin: 150px auto">
  <div style="color: #cccccc;font-size: 30px;text-align: center;padding: 30px 0">欢迎注册</div>
  <el-form :model="form" >
    <el-form-item >
      用户名<el-input v-model="form.username" />
    </el-form-item>
    <el-form-item >
      密码
      <el-input  show-password v-model="form.password" ></el-input>
    </el-form-item>
    <el-form-item >
      确认密码
      <el-input  show-password v-model="form.confirm" ></el-input>
    </el-form-item>
    <el-form-item >
      <el-button style="width: 100%" type="primary" @click="register">注册</el-button>
    </el-form-item>
  </el-form>
</div>
</div>
</template>


<script>
import request from "@/utils/request";
export default {
  name: "Register",
  data(){
    return{
      form:{}
    }
  },
  methods:{
    register(){
      if (this.form.password!==this.form.confirm){
        this.$message({
          type:"error",
          message:"两次密码输入不一致"
        })
        return
      }
      request.post("/user/register",this.form).then(res=>{
        console.log(res)
        if (res.code==='0'){
          this.$message({
            type:"success",
            message:"注册成功"
          })
          this.$router.push("/login")//成功后进行页面跳转
        }else {
          this.$message({
            type:"error",
            message:res.msg
          })
        }

      })
    }
  }
}
</script>

<style scoped>

</style>