<template>
  <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #ccc;display:flex">
    <div style="width: 200px;padding-left: 30px;font-weight: bold;color: dodgerblue">商大医院</div>
    <div style="flex:1"></div>
    <div style="width:200px">
      <el-dropdown>
    <span class="el-dropdown-link">
      <br/>
      {{doctorName}}<el-icon class="el-icon--right">
      <svg viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg" data-v-ba633cb8=""><path fill="currentColor" d="M831.872 340.864 512 652.672 192.128 340.864a30.592 30.592 0 0 0-42.752 0 29.12 29.12 0 0 0 0 41.6L489.664 714.24a32 32 0 0 0 44.672 0l340.288-331.712a29.12 29.12 0 0 0 0-41.728 30.592 30.592 0 0 0-42.752 0z"></path></svg>
        <arrow-down />
      </el-icon>
    </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="$router.push('/personal')">个人信息</el-dropdown-item>
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
      doctorName: JSON.parse(sessionStorage.getItem('user')).doctorName.toString()
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
