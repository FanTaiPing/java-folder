<template>
  <div class="app-container">
    <el-row>
      <div>
        <el-button type="primary" class="btn-add" @click="addUser()">添加用户</el-button>
      </div>
      <el-table ref="multipleTable" :data="userList" tooltip-effect="dark" style="width: 100%"
        @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" style="border: 1px solid black;">
        </el-table-column>
        <el-table-column fixed prop="id" label="编号" width="150">
        </el-table-column>
        <el-table-column prop="username" label="姓名" width="120">
        </el-table-column>
        <el-table-column prop="email" label="电子邮箱" width="150">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="230">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="150" align="center">
          <template slot-scope="scope">
            <el-button type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>
            <el-button type="primary" size="mini">修改</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-row>
  </div>
</template>

<script>
  import {
    findAllSysUser,
    deleteUser,
  } from "@/api/admin";
  export default {
    name: "userList",
    data() {
      return {
        userList: [],
        multipleSelection: [],
      };
    },
    created() {
      this.getList();
    },
    methods: {
      getList() {
        let value = "";
        findAllSysUser(value).then((response) => {
          // console.log("*********************");
          // console.log(response);
          this.userList = response.data;
          // console.log(this.userList);
        });
      },
      addUser() {
        this.$router.push({
          path: "/example/addUser"
        });
      },

      handleDelete(row) {
        // console.log("-------------------------")

        this.$confirm("是否要删除姓名为【"+row.username+"】的用户", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }).then(() => {
          deleteUser(row.id).then((response) => {
            this.$message({
              message: "删除成功",
              type: "success",
              duration: 1000,
            });
            this.getList();
          });
        });
      },
      toggleSelection(rows) {
        if (rows) {
          rows.forEach(row => {
            this.$refs.multipleTable.toggleRowSelection(row);
          });
        } else {
          this.$refs.multipleTable.clearSelection();
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
    },


  }

</script>
