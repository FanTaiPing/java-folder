<template>
  <el-card class="form-container" shadow="never">
    <!--  -->
    <el-form :model="product" ref="Form" label-width="100px" class="demo-ruleForm">
      <el-form-item label="商品名称" prop="name" required>
        <el-input v-model="product.name"></el-input>
      </el-form-item>
      <el-form-item label="商品数量" prop="productCount">
        <el-input v-model="product.productCount"></el-input>
      </el-form-item>
      <el-form-item prop="icon" label="商品图标">
        <el-input v-model="product.icon"></el-input>
        <!-- <el-upload class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/" :on-preview="handlePreview"
          :on-remove="handleRemove" :file-list="fileList" list-type="picture" v-model="productForm.icon">
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload> -->
      </el-form-item>
      <el-form-item prop="keywords" label="关键词">
        <el-input v-model="product.keywords"></el-input>
      </el-form-item>
      <!-- <el-form-item label="添加时间" prop="dateTime">
        <el-date-picker v-model="productForm.dateTime" type="datetime" placeholder="选择日期时间" align="right"
          :picker-options="rules">
        </el-date-picker>
      </el-form-item> -->
      <!-- <el-form-item label="是否禁用" prop="status ? 1 : 0">
          <el-switch v-model="userForm.status"></el-switch>
        </el-form-item> -->
      <el-form-item label="备注" prop="description">
        <el-input type="textarea" v-model="product.description"></el-input>
      </el-form-item>
      <el-form-item>
        <!--  -->
        <el-button type="primary" @click="submitForm('Form')">提交</el-button>
        <el-button type="primary" v-if="!isEdit" @click="resetForm('Form')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>
<script>
  import {
    addProduct,
    getProductById,
    updateProduct
  } from '@/api/product';

  export default {
    name: "productDetail",
    props: {
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        product: {
          name: '',
          productCount: '',
          icon: '',
          keywords: '',
          description: ''
        },
        // listQuery: {
        //   pageNum: 1,
        //   pageSize: 10
        // },
        //图片上传
        // List: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}, {name: 'food2.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}]
        // rules: {
        //   productCount: [{
        //     // min:0,
        //     type: Number,
        //     message: '输入的值必须为正整数',
        //     trigger: 'blur'
        //   }]
        // }
      }
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('是否提交数据', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'waring'
            }).then(() => {
              if (this.isEdit) {
                updateProduct(this.$route.query.id,this.product).then(response =>{
                  if (response.code == 200) {
                    this.$message({
                      message: '修改成功',
                      tyep: 'success',
                      duration: 1000
                    });
                    this.$router.back();
                  } else {
                    this.$message({
                      message: response.msg,
                      type: 'error',
                      duration: 1000
                    })
                  }
                });
              } else {
                addProduct(this.product).then(response => {
                  if (response.code == 200) {
                    this.$message({
                      message: '添加成功',
                      tyep: 'success',
                      duration: 1000
                    });
                    this.$router.back();
                  } else {
                    this.$message({
                      message: response.msg,
                      type: 'error',
                      duration: 1000
                    })
                  }
                })
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },

      // getProductByIds() {
      //   // debugger
      //   var productid= this.$route.query.id
      //   getProductById(productid).then(response => {

      //     this.product = response.data;
      //     console.log(this.product)

      //   })
      // }
    },
    created() {
      if (this.isEdit) {
        // alert(this.$route.query.id);
        // debugger
        //根据商品id查询商品信息
        var productid = this.$route.query.id
        getProductById(productid).then(response => {
          this.product = response.data;
        })
        // console.log(this.$route.query.id)

        // this.getProductByIds();

      }
    }
  }

</script>
