<template>
  <div>
    <el-menu
        style="width: 200px;min-height: calc( 100vh - 50px)"
        :default-active="path"
        router
        class="el-menu-vertical-demo">
      <el-sub-menu v-show="usercontroller" index="1">
        <template #title  >角色管理</template>
        <el-menu-item  index="/doctor">医生管理</el-menu-item>
<!--        index路由就是index.js里path路由。前提开启el-menu里的router-->
        <el-menu-item index="/patient">病人管理</el-menu-item>
        <el-menu-item index="1-3">item three</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="/yuyue">预约查看</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside",
  data(){
    return{
      usercontroller:true,
      path:this.$route.path //设置默认高亮菜单
    }

  },
  created() {
    var id = parseInt(JSON.parse(sessionStorage.getItem('user')).id.toString())
    if (id!==1){
      this.usercontroller=false
      this.$router.push("/yuyue")
    }

  }
}

</script>

<style scoped>

</style>