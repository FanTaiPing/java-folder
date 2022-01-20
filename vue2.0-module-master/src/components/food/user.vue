  <template>
    <div class="header-table">
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true">
        <el-form-item>
          <el-input
            placeholder="请输入用户名称"
            v-model="paramQuery.name"
            clearable>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary"  @click="query">查询</el-button>
        </el-form-item>
        <!--
        <el-form-item>
          <el-button type="primary" >新增</el-button>
        </el-form-item>
        <el-form-item>
          <el-date-picker
        v-model="value1"
        placeholder="选择日期时间">
        </el-date-picker>-->
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="goEdit1()" v-model="editForm">添加</el-button>
    </el-col>
    <!--列表-->
    <el-table :data="userList" highlight-current-row v-loading="loading" element-loading-text="拼命加载中" style="width: 100%;">

      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="处理时间">
              <span>{{ props.row.modify_datetime}}</span>
            </el-form-item>
            <el-form-item label="处理意见">
              <span>{{ props.row.clyj}}</span>
            </el-form-item>

          </el-form>
        </template>
      </el-table-column>

      <el-table-column type="index" label="序号" width="100">
      </el-table-column>
      <el-table-column prop="name" label="拼音" width="300" >
      </el-table-column>
      <el-table-column prop="nick_name" label="中文用户名" width="200" >
      </el-table-column>
       <el-table-column prop="mobile" label="联系方式" width="300" >
      </el-table-column>
     <!-- <el-table-column prop="save_datetime" label="提交时间" width="200" >
      </el-table-column>
      <el-table-column  label="受理状态" width="200" >
        <template slot-scope="scope">
          <a v-if="scope.row.slzt === 0">
            未受理
          </a>
          <a v-if="scope.row.slzt === 1">
            已受理
          </a>
        </template>
      </el-table-column> -->

      <el-table-column   fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="goEdit(scope.row)" type="text" size="small">处理</el-button>
        </template>
      </el-table-column>

  <!--
      <el-table-column prop="Phone" label="电话" width="120" >
      </el-table-column>
      <el-table-column prop="CreateTime" label="生成时间" width="180" >
      </el-table-column>
      <el-table-column prop="EndDateTime" label="兑换截止日期" width="180" >
      </el-table-column>
      <el-table-column prop="UserdTime" label="兑换时间" width="180" >
      </el-table-column>
      <el-table-column prop="registTime" label="注册时间" width="180" >
      </el-table-column>
-->
      <!--<el-table-column prop="NickName" label="性别" :formatter="formatSex" width="100" >-->
      <!--</el-table-column>-->
    </el-table>
    <!--工具条-->
    <el-col :span="24" class="toolbar">
      <el-pagination layout="prev,total,pager, next"
      :page-size="filter.pageSize"
      :current-page="filter.currentPage"
      @current-change="handleCurrentChange"
      @size-change="handleSizeChange"
      :total="total"
      style="text-align:center;">
      </el-pagination>
    </el-col>
    <!--添加界面-->
    <el-dialog title="处理" v-model="addFormVisible">
      <el-form label-width="80px" :model="addForm" ref="addForm">
        <el-form-item  label="拼音"  prop="name">
          <el-input v-model="addForm.name"></el-input>
        </el-form-item>

        <el-form-item  label="中文用户名"  prop="name">
          <el-input v-model="addForm.nickName"></el-input>
        </el-form-item>
        <el-form-item  label="联系方式"  prop="name">
          <el-input v-model="addForm.mobile"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="addForm1" :loading="loading" class="title1">提交</el-button>
      </div>
    </el-dialog>
    <!--编辑界面-->
    <el-dialog title="处理" v-model="editFormVisible">
      <el-form label-width="80px" :model="editForm" ref="editForm">
        <el-form-item  label="拼音"  prop="name">
          <el-input v-model="editForm.name"></el-input>
        </el-form-item>

        <el-form-item  label="中文用户名"  prop="name">
          <el-input v-model="editForm.nick_name"></el-input>
        </el-form-item>
        <el-form-item  label="联系方式"  prop="name">
          <el-input v-model="editForm.mobile"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="close">取消</el-button>
        <el-button type="primary" @click="Submit" :loading="loading" class="title1">提交</el-button>
      </div>
    </el-dialog>
    </div>
</template>

<script type="text/ecmascript-6">
import axios from "axios";
export default {
  data() {
    return {
      goods: [],
      userList: [],
      userData: [],
      loading: false,
      total: 0,
      value1: "",
      editFormVisible: false,
      addFormVisible: false,
      filter: {
        pageSize: 4, // 页大小
        currentPage: 1, // 当前页
      },
      addForm: {
        // id: '',
        name: "",
        nickName: "",
        mobile: "",
      },
      editForm: {
        // id: '',
        name: "",
        nickName: "",
        mobile: "",
      },
      paramQuery: {
        cdkey: null,
      },
    };
  },
  created() {
    this.getuserData((data) => {
      this.goods = data;
      this.getuser(data);
    });
  },
  methods: {
    //性别显示转换
    formatSex: function (row, column) {
      return row.number == 1 ? "男" : row.number == 0 ? "女" : "女";
    },
    close() {
      this.editFormVisible = false;
      this.addFormVisible = false;
    },
    //点击添加按钮之后，将添加表单显示进行添加操作
    goEdit1() {
      this.addFormVisible = true;
    },
    goEdit(row) {
      this.editFormVisible = true;
      this.editForm = row;
    },
    //显示编辑界面
    handleEdit: function (index, row) {
      this.editFormVisible = true;
      this.editForm = Object.assign({}, row); //合并对象操作
    },

    handleDelete(index, row) {
      this.$confirm("确认删除吗?", "提示", {
        type: "warning",
      }).then(() => {
        this.loading = true;
        setTimeout(() => {
          this.$message({
            message: "删除成功",
            type: "success",
          });
          this.userData.splice(index, 1);
          this.loading = false;
        }, 2000);
        this.getuserData();
      });
      console.log(index, row);
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      let datalist = this.goods;
      this.filter.currentPage = val;
      this.getuser(datalist);
      console.log(`当前页: ${val}`);
    },
    //添加用户时提交表单
    addForm1() {
      this.$refs.addForm.validate((valid) => {
        if (valid) {
          this.$confirm("确认提交吗？", "提示", {}).then(() => {
            this.$http
              .post("api/user/insertSysUser", this.addForm)
              .then((response) => {
                const state = response.data;
                setTimeout(() => {
                  if (state === 1) {
                    this.$message({
                      message: "处理成功",
                      type: "success",
                    });
                    this.loading = false;
                  } else {
                    this.$message({
                      message: "处理失败",
                      type: "faile",
                    });
                    this.loading = false;
                  }
                }, 200);
                this.addFormVisible = false;
                this.getuserData();
              })
              .catch(function (error) {
                console.log(error);
              });
          });
        }
      });
    },
    //编辑用户时提交表单
    Submit() {
      this.$refs.editForm.validate((valid) => {
        if (valid) {
          this.$confirm("确认提交吗？", "提示", {}).then(() => {
            this.$http
              .post("api/person/save", this.editForm)
              .then((response) => {
                const state = response.data;
                setTimeout(() => {
                  if (state === 1) {
                    this.$message({
                      message: "处理成功",
                      type: "success",
                    });
                    this.loading = false;
                  } else {
                    this.$message({
                      message: "处理失败",
                      type: "faile",
                    });
                    this.loading = false;
                  }
                }, 200);
                this.editFormVisible = false;
                this.getuserData();
              })
              .catch(function (error) {
                console.log(error);
              });
          });
        }
      });
    },

    query() {
      this.loading = true;
      if (this.paramQuery.name == null || this.paramQuery.name == "") {
        this.paramQuery.name = "";
      }
      this.$http
        .get("api/user/findAllMap?name=" + this.paramQuery.name)
        .then((response) => {
          this.userList = response.data.page;
          console.log(this.userList);
          setTimeout(() => {
            this.loading = false;
          }, 200);
        })
        .catch(function (error) {
          console.log(error);
        });
    },

    getuserData(callback) {
      this.loading = true;
      this.$http
        .get("/api/user/findAllMap")
        .then((response) => {
          if (true) {
            this.userList = response.data.page;
            console.log(this.userList);
            setTimeout(() => {
              this.loading = false;
            }, 200);
            callback(this.userList);
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    getuser(data) {
      let pageSize = this.filter.pageSize;
      console.log(pageSize);
      this.total = this.userList.length;
      let total = this.total;
      let curNo = (this.filter.currentPage - 1) * pageSize;
      let num = total % pageSize;
      console.log(curNo + "页");
      let userDatalist = [];
      for (let i = 0; i < pageSize; i++) {
        userDatalist.push(data[curNo + i]);
      }
      this.userData = userDatalist;
      console.log(userDatalist);
    },
  },
};
</script>
<style lang="stylus" rel="stylesheet/stylus">
.title1 {
  font-size: 12px;
}

.demo-table-expand {
  font-size: 0;
}

.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}

.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}

el-form-item__label {
  font-size: 20px;
  font-family: Arial, Helvetica, sans-serif;
}
</style>
