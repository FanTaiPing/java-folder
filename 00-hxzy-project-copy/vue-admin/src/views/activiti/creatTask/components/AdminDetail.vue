<template> 
  <el-card class="form-container" shadow="never">
    <el-form :model="taskMaintain" :rules="addTaskRules" ref="adminFrom" label-width="150px">
      <el-form-item label="作业票号：" prop="workTicket">
        <el-input v-model="taskMaintain.workTicket"></el-input>
      </el-form-item>
      <el-form-item label="作业内容：" prop="taskContent">
        <el-input v-model="taskMaintain.username"></el-input>
      </el-form-item>

      <el-form-item label="操作人员：" prop="createUsername">
        <el-input v-model="taskMaintain.createUsername"></el-input>
      </el-form-item>
      <el-form-item label="是否需要停电" prop="isCutpower">
        <el-radio-group v-model="taskMaintain.isCutpower">
          <el-radio :label="1">是</el-radio>
          <el-radio :label="0">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="上传纸质作业票" prop="workImgurl">
         <single-upload v-model="taskMaintain.workImgurl"></single-upload>
      </el-form-item>
      
      <el-form-item>
        <el-button type="primary" @click="onSubmit('adminFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('adminFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>
<script>
  import {addTaskBill,updateTaskBill,deleteTaskBill,findTask,findUndoTask,findDoneTask} from '@/api/taskCore/Task'
  import {isvalidUsername} from '@/utils/validate';
  import {fetchList} from '@/api/role'
  import SingleUpload from '@/components/Upload/singleUpload'
  const defaultAdmin={
    workTicket: '',
    taskContent:'',
    createUsername:'',
    isCutpower:'',
    workImgurl:'',


  };
  export default {
    name: 'AdminDetail',
    components:{SingleUpload},
    props: {
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      const validateworkTicket = (rule, value, callback) => {
        if (value.length<1) {
          callback(new Error('请输入任务票'))
        } else {
          callback()
        }
      };
      const validatePass = (rule, value, callback) => {
        if (value.length < 3) {
          callback(new Error('密码不能小于3位'))
        } else {
          callback()
        }
      };
      return {
        taskMaintain:Object.assign({}, defaultAdmin),
        allRoles:null,
        userRoles:null,
        roleIds:null,
        listQuery: {
          pageNum: 1,
          pageSize: 100
        },
        addTaskRules: {
          workTicket: [{required: true, trigger: 'blur', message: '请输入任务票',}]
        }

        }

    },
    created() {
      if (this.isEdit) {
        this.listQuery.adminId=this.$route.query.id;
        userRoleCheck(this.listQuery).then(res => {
          if(res.code==200){
          this.allRoles =  res.data
        }
      });

        getAdmin(this.$route.query.id).then(response => {
          this.taskMaintain = response.data;
      });
      }else{
        fetchList(this.listQuery).then(response => {
          this.allRoles = response.data.records;
      });
        this.taskMaintain = Object.assign({},defaultAdmin);
      };


    },
    computed: {
      //选中的服务保证
      allRoles1: {
        get() {
          let list = [];
          if (this.roleIds === undefined || this.roleIds == null || this.roleIds === '') return list;
          let ids = this.roleIds.split(',');
          for (let i = 0; i < ids.length; i++) {
            list.push(Number(ids[i]));
          }
          return list;
        },
        set(newValue) {
          let serviceIds = '';
          if (newValue != null && newValue.length > 0) {
            for (let i = 0; i < newValue.length; i++) {
              serviceIds += newValue[i] + ',';
            }
            if (serviceIds.endsWith(',')) {
              serviceIds = serviceIds.substr(0, serviceIds.length - 1)
            }
            this.roleIds = serviceIds;
          } else {
            this.roleIds = null;
          }
        }
      }
    },
    methods: {

      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('是否提交数据', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
             // this.taskMaintain.roleIds = this.roleIds;
              if (this.isEdit) {
                updateTaskBill(this.$route.query.id, this.taskMaintain).then(response => {
                  if(response.code==200){
                  this.$refs[formName].resetFields();
                  this.$message({
                    message: '修改成功',
                    type: 'success',
                    duration:1000
                  });
                  this.$router.back();
                  }else{
                  this.$message({
                    message: response.msg,
                    type: 'error',
                    duration:1000
                  });

                }


                });
              } else {
                addTaskBill(this.taskMaintain).then(response => {
                  if(response.code==200)
                {
                  this.$refs[formName].resetFields();
                  this.taskMaintain = Object.assign({}, defaultAdmin);
                  this.$message({
                    message: '提交成功',
                    type: 'success',
                    duration: 1000
                  });
                }else{
                  this.$message({
                    message: response.msg,
                    type: 'error',
                    duration:1000
                  });

                }
                });
              }
            });

          } else {
            this.$message({
              message: '验证失败',
              type: 'error',
              duration:1000
            });
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
        this.taskMaintain = Object.assign({},defaultAdmin);
      }
    }
  }
</script>
<style>
</style>


