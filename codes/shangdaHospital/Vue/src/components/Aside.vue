<template>
  <div>
    <el-menu
        style="width: 200px;min-height: calc( 100vh - 50px)"
        default-active="user"
        router
        class="el-menu-vertical-demo">
      <el-sub-menu index="1">
        <template #title>系统管理</template>
        <el-menu-item index="user" v-show="usercontroller">用户管理</el-menu-item>
<!--        index路由就是index.js里path路由。前提开启el-menu里的router-->
        <el-menu-item index="1-2">item one</el-menu-item>
        <el-menu-item index="1-3">item three</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="yuyue">预约查看</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside",
  data(){
    return{
      usercontroller:true
    }

  },
  created() {
    var usertype = parseInt(JSON.parse(sessionStorage.getItem('user')).type.toString())
    if (usertype!==0){
      this.usercontroller=false
      this.$router.push("/yuyue")
    }
  }
}

</script>

<style scoped>

</style>