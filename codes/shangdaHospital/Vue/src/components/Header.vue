<template>
  <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #ccc;display:flex">
    <div style="width: 200px;padding-left: 30px;font-weight: bold;color: dodgerblue">后台管理</div>
    <div style="flex:1"></div>
    <div style="width:200px">
      <el-dropdown>
    <span class="el-dropdown-link">
      <br/>
      {{realName}}<el-icon class="el-icon--right">
        <arrow-down />
      </el-icon>
    </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item >个人信息</el-dropdown-item>
            <el-dropdown-item @click="exit">退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>

export default {
  name: "Header",
  // nickName: JSON.parse(sessionStorage.getItem('user')).nickName,
  data(){
    return{
      realName: JSON.parse(sessionStorage.getItem('user')).realName.toString()
      //sessionStorage.getItem()输入的参数是key，获取的是他的value,本例返回的是一个json字符串
    }
  },
  methods:{
    exit(){
      sessionStorage.clear();
      this.$router.push('/login')
    }
  }

}

</script>


<style scoped>

</style>
