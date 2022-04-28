<template>
  <div style="padding: 20px;width: 60px">

    <el-form :model="form" label-width="60px">
      <el-form-item label="姓名">
        <el-input v-model="form.name" />
      </el-form-item>
      <el-form-item label="Activity zone">
        <el-select v-model="form.region" placeholder="please select your zone">
          <el-option label="Zone one" value="shanghai" />
          <el-option label="Zone two" value="beijing" />
        </el-select>
      </el-form-item>
      <el-form-item label="Activity time">
        <el-col :span="11">
          <el-date-picker
              v-model="form.date1"
              type="date"
              placeholder="Pick a date"
              style="width: 100%"
          />
        </el-col>
        <el-col :span="2" class="text-center">
          <span class="text-gray-500">-</span>
        </el-col>
        <el-col :span="11">
          <el-time-picker
              v-model="form.date2"
              placeholder="Pick a time"
              style="width: 100%"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="Instant delivery">
        <el-switch v-model="form.delivery" />
      </el-form-item>
      <el-form-item label="Activity type">
        <el-checkbox-group v-model="form.type">
          <el-checkbox label="Online activities" name="type" />
          <el-checkbox label="Promotion activities" name="type" />
          <el-checkbox label="Offline activities" name="type" />
          <el-checkbox label="Simple brand exposure" name="type" />
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="Resources">
        <el-radio-group v-model="form.resource">
          <el-radio label="Sponsor" />
          <el-radio label="Venue" />
        </el-radio-group>
      </el-form-item>
      <el-form-item label="Activity form">
        <el-input v-model="form.desc" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">Create</el-button>
        <el-button>Cancel</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>


import request from "@/utils/request";

export default {
  name: 'Person',
  components: {},
  data() {
    return {
      form: {},
      zhenduanform:{},
      dialogVisible: false,
      search: '',
      currentPage: 1,
      pageSize: 10,
      total: 0,
      tableData: [],
      doctorList:[],
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
              search: this.search,

            }
          }).then(res => {
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    save() {
        //ctrl+r把user换成yuyue
        request.put("/yuyue/zhenduan",this.zhenduanform).then(res => {
          console.log(res)
          if (res.code === '0') {
            this.$message({
              type: "success",
              message: "诊断完成"
            })
          } else {
            this.$message({
              type: "error",
              message: "诊断失败"
            })
          }
        })

      //  else {
      //   request.post("/yuyue", this.form).then(res => {
      //     console.log(res)
      //     if (res.code === '0') {
      //       this.$message({
      //         type: "success",
      //         message: "新增成功"
      //       })
      //     } else {
      //       this.$message({
      //         type: "error",
      //         message: "新增失败"
      //       })
      //     }
      //   })
      // }
      this.dialogVisible = false
      this.load()
    },
    add() {
      this.dialogVisible = true;
      this.form = {}
    },
    handleEdit(row) {
      this.zhenduanform = JSON.parse(JSON.stringify(row))
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
