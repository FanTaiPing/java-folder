<template>
  <div class="app-container">
    <!-- ref="selectForm"queryList.selectName -->
    <el-form :inline="true" :model="queryList" @submit.native.prevent label-width="80px" size="medinum">
      <!-- <el-form-item label="商品id" size="medinum">
        <el-input v-model="queryList.selectId" placeholder="请输入商品id" style="width: 200px;"></el-input>
      </el-form-item> -->
      <el-form-item label="商品名称" size="medinum">
        <el-input @keyup.enter.native="searchProductList" v-model="queryList.selectName" placeholder="请输入商品名称"
          style="width: 200px;"></el-input>
      </el-form-item>
      <el-button type="success" size="medinum" @click="searchProductList()">查询</el-button>

      <el-row>
        <div>
          <el-button type="info" class="btn-add" style="float: right;" size="medinum" @click="addProduct()">添加商品
          </el-button>
        </div>
        <el-table ref="multipleTable" :data="productList" tooltip-effect="dark" style="width: 100%"
          @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="55" align="center">
          </el-table-column>
          <el-table-column fixed prop="id" label="编号" width="150">
          </el-table-column>
          <el-table-column prop="name" label="商品名称" width="120">
          </el-table-column>
          <el-table-column prop="productCount" label="商品数量" width="150">
          </el-table-column>
          <el-table-column prop="navStatus" label="导航栏显示状态" width="230">
          </el-table-column>
          <el-table-column prop="showStatus" label="商品显示状态" width="150">
          </el-table-column>
          <el-table-column prop="icon" label="商品图标" width="150">
          </el-table-column>
          <el-table-column prop="keywords" label="关键词" width="150">
          </el-table-column>
          <el-table-column prop="description" label="描述" width="150">
          </el-table-column>
          <el-table-column fixed="right" label="操作" width="150" align="center">
            <template slot-scope="scope">
              <el-button type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>
              <el-button type="primary" size="mini" @click="updateProduct(scope.$index,scope.row)">修改</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-row>
      <div class="block">
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
          :current-page.sync="queryList.pageNum" :page-sizes="[5, 10, 15, 20]" :page-size="queryList.pageSize"
          layout="total, sizes, prev, pager, next, jumper" :total="total">
        </el-pagination>
      </div>
    </el-form>
  </div>
</template>

<script>
  import {
    findAllProduct,
    deleteProductById,
    updateProduct,
  } from "@/api/product";
  export default {
    name: "productList",
    data() {
      return {
        // selectName: null,
        // selectId: '',
        productList: [],
        multipleSelection: [],
        queryList: {
          // selectId: '',
          selectName: null,
          // 当前页
          pageNum: 1,
          //每页显示信息条数
          pageSize: 5
        },
        total: null,
        listLoading: true

      }
    },
    created() {
      this.getList();
    },
    methods: {
      getList() {
        listLoading: true,
        //查询商品信息
        findAllProduct(this.queryList).then((response) => {
          // debugger
          this.productList = response.data.records;
          this.total = response.data.total;
          // this.pageNum = response.data.pages;
          this.pageSize = response.data.size;
          // this.currentPage = response.current;
          console.log(response.data);
        });
      },
      searchProductList() {
        listLoading: true;
        // console.log(this.queryList)
        if (this.queryList.selectName == '') {
          //查询条件为空时，调用查询所有的方法
          this.getList()
          // return
        }
        this.getList(this.queryList)
      },
      //添加商品信息
      addProduct() {
        this.$router.push({
          path: "/products/addProduct"
        });
      },
      // 修改商品信息
      updateProduct(index, row) {
        this.$router.push({
          path: "/products/updateProduct",
          query: {
            id: row.id
          }
        });
      },
      //删除商品信息
      handleDelete(row) {
        this.$confirm("是否要删除姓名为【" + row.name + "】的用户", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }).then(() => {
          deleteProductById(row.id).then((response) => {
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

      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
        this.queryList.pageNum = 1;
        this.queryList.pageSize = val;
        this.getList();
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        this.queryList.pageNum = val;
        this.getList();
      },
    },


  }

</script>
