<template>
  <div style="padding: 10px">
    <!--    功能区域-->
    <div>
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">删除</el-button>
    </div>
    <!--    搜索区域-->
    <div style="margin: 10px 0">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable/>
      <el-button type="primary" style="margin-left: 5px" @click="querry">查询</el-button>
    </div>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="id" label="ID" sortable/>
      <el-table-column prop="patientList[0].patientName" label="病人姓名"/>
      <el-table-column prop="patientList[0].sex" label="病人性别"/>
      <el-table-column prop="doctorList[0].doctorName" label="医生姓名"/>
      <el-table-column prop="time" label="预约时间"/>
      <el-table-column prop="doctorList[0].department" label="科室"/>
      <el-table-column fixed="right" label="操作" width="200">
        <template #default="scope">
          <el-button type="primary" round @click="handleEdit(scope.row)"
          >诊断
          </el-button>
<!--          <el-button type="primary" round>Primary</el-button>-->
          <el-popconfirm title="确定删除吗?" @confirm="handleDelete(scope.row.id)">-->
            <template #reference>
              <el-button type="danger" round>删除</el-button>

            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0">
      <div class="demo-pagination-block">
        <div class="demonstration"></div>
        <el-pagination
            v-model:currentPage="currentPage"
            v-model:page-size="pageSize"
            :page-sizes="[5, 10, 20]"
            :small="small"
            :disabled="disabled"
            :background="background"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
        />
      </div>

    </div>
    <!--    <el-dialog v-model="dialogVisible" title="新增" width="30%">-->
    <!--      <el-form :model="form" label-width="120px">-->
    <!--        <el-form-item label="用户名">-->
    <!--          <el-input v-model="form.username" style="width: 80%"/>-->
    <!--        </el-form-item>-->
    <!--        <el-form-item label="昵称">-->
    <!--          <el-input v-model="form.nickName" style="width: 80%"/>-->
    <!--        </el-form-item>-->
    <!--        <el-form-item label="年龄">-->
    <!--          <el-input v-model="form.age" style="width: 80%"/>-->
    <!--        </el-form-item>-->
    <!--        <el-form-item label="性别">-->
    <!--          <el-radio v-model="form.sex" label="男">男</el-radio>-->
    <!--          <el-radio v-model="form.sex" label="女">女</el-radio>-->
    <!--          <el-radio v-model="form.sex" label="未知">未知</el-radio>-->

    <!--        </el-form-item>-->
    <!--        <el-form-item label="地址">-->
    <!--          <el-input type="textarea" v-model="form.address" style="width: 80%"/>-->
    <!--        </el-form-item>-->

    <!--      </el-form>-->
    <!--      <template #footer>-->
    <!--      <span class="dialog-footer">-->
    <!--        <el-button @click="dialogVisible = false">取消</el-button>-->
    <!--        <el-button type="primary" @click="save">确定</el-button>-->
    <!--      </span>-->
    <!--      </template>-->
    <!--    </el-dialog>-->

  </div>
</template>

<script>


import request from "@/utils/request";

export default {
  name: 'Yuyue',
  components: {},
  data() {
    return {
      form: {},
      dialogVisible: false,
      search: '',
      currentPage: 1,
      pageSize: 10,
      total: 0,
      tableData: [],
      doctorList:[]
    }

  },
  created() {
    this.load()
  },
  methods: {

    load() {
      var userid = parseInt(JSON.parse(sessionStorage.getItem('user')).id.toString())
      console.log('usertype:' + userid)
      if (userid === 1) {
        request.get("/yuyue/loadall",
            {
              params: {
                pageNum: this.currentPage,
                pageSize: this.pageSize,
              }
            }).then(res => {
          console.log(res)
          this.tableData = res.data.records
          this.total = res.data.total

        })
      } else {
        var doctorid = parseInt(JSON.parse(sessionStorage.getItem('user')).id.toString())
        console.log(doctorid)
        request.get("/yuyue/loadself",
            {
              params: {
                pageNum: this.currentPage,
                pageSize: this.pageSize,
                search: doctorid
              }
            }).then(res => {
          console.log(res)
          this.tableData = res.data.records
          this.total = res.data.total
        })
      }

    },
    querry() {
      request.get("/yuyue/findbyname",
          {
            params: {
              pageNum: this.currentPage,
              pageSize: this.pageSize,
              search: this.search
            }
          }).then(res => {
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    save() {
      if (this.form.id) {
        //ctrl+r把user换成yuyue
        request.put("/yuyue", this.form).then(res => {
          console.log(res)
          if (res.code === '0') {
            this.$message({
              type: "success",
              message: "修改成功"
            })
          } else {
            this.$message({
              type: "error",
              message: "修改失败"
            })
          }

        })
      } else {
        request.post("/yuyue", this.form).then(res => {
          console.log(res)
          if (res.code === '0') {
            this.$message({
              type: "success",
              message: "新增成功"
            })
          } else {
            this.$message({
              type: "error",
              message: "新增失败"
            })
          }
        })
      }

      this.load()
      this.dialogVisible = false
    },
    add() {
      this.dialogVisible = true;
      this.form = {}
    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
      console.log(row)
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.currentPage = pageNum
      this.load()
    },
    handleDelete(id) {
      console.log(id)
      request.delete("/yuyue/delete/" + id).then(res => {
        console.log(res)
        if (res.code === '0') {
          this.$message({
            type: "success",
            message: "删除成功"
          })
        } else {
          this.$message({
            type: "error",
            message: "删除失败"
          })
        }
        this.load() //删除之后重新加载数据
      })
    }

  }
}
</script>
