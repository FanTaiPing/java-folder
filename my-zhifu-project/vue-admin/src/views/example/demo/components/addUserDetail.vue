<template>
  <el-card class="form-container" shadow="never">
    <el-form :model="userForm" :rules="rules" ref="userForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户昵称" prop="nickName" required>
        <el-input v-model="userForm.nickName"></el-input>
      </el-form-item>
      <el-form-item label="姓名" prop="username" required>
        <el-input v-model="userForm.username"></el-input>
      </el-form-item>
      <el-form-item prop="email" label="邮箱" :rules="[
        { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
      ]">
        <el-input v-model="userForm.email"></el-input>
      </el-form-item>
      <el-form-item label="添加时间" prop="dateTime">
        <el-date-picker v-model="userForm.dateTime" type="datetime" placeholder="选择日期时间" align="right"
          :picker-options="rules">
        </el-date-picker>
      </el-form-item>
      <!-- <el-form-item label="是否禁用" prop="status ? 1 : 0">
        <el-switch v-model="userForm.status"></el-switch>
      </el-form-item> -->
      <el-form-item label="备注" prop="note">
        <el-input type="textarea" v-model="userForm.note"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('userForm')">提交</el-button>
        <el-button @click="resetForm('userForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>
<script>
  import {addUser} from '@/api/admin'
  export default {
    data() {
      return {
        userForm: {
          nickName: '',
          username: '',
          email: '',
          dateTime: '',
          // status: false,
          note: ''
        },
        rules: {
          nickName: [{
              required: true,
              message: '请输入用户昵称',
              trigger: 'blur'
            },
            {
              min: 5,
              max: 10,
              message: '长度在 5 到 15 个字符',
              trigger: 'blur'
            }
          ],
          userName: [{
            required: true,
            message: '请输入姓名',
            trigger: 'blur'
          }],
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }],
          email: [{
            required: false,
            message: '备注',
            trigger: 'blur'
          }],
        },
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
              addUser(this.userForm).then(response => {
                if (response.code == 200) {
                  console.log(response)
                  this.$message({
                    message: '提交成功',
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
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }

</script>
