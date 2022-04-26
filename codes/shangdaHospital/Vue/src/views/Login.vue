<template>
<div style="width: 100%;height: 100vh;background-color: darkslateblue;overflow: hidden">
<div style="width: 400px;margin: 150px auto">
  <div style="color: #cccccc;font-size: 30px;text-align: center;padding: 30px 0">欢迎登录</div>
  <el-form :model="form" :rules="rules">
    <el-form-item prop="username">
      用户名<el-input v-model="form.username" />
    </el-form-item>
    <el-form-item prop="password">
      密码
      <el-input  show-password v-model="form.password" ></el-input>
    </el-form-item>
    <el-form-item >
      <el-button style="width: 100%" type="primary" @click="login">登录</el-button>
    </el-form-item>
    <el-form-item >
      <el-button style="width: 100%" type="primary" @click="$router.push('/register')">注册</el-button>
    </el-form-item>
  </el-form>
</div>
</div>
</template>


<script>
import request from "@/utils/request";
export default {
  name: "Login",
  data(){
    return{
      form:{},
      rules:{
        username:[
          {required:true,message:'请输入用户名',trigger:'blur'},
        ],
        password:[
          {required:true,message:'请输入密码',trigger:'blur'}
        ]
      }
    }
  },
  methods:{
    login(){
      request.post("/user/login",this.form).then(res=>{
        console.log(res)
        if (res.code==='0'){
          this.$message({
            type:"success",
            message:"登陆成功"
          })
          sessionStorage.setItem("user",JSON.stringify(res.data))//缓存用户信息
          this.$router.push("/user")//登录成功后进行页面跳转
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