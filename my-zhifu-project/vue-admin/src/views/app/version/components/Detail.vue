<template> 
  <el-card class="form-container" shadow="never">
    <el-form :model="version" :rules="versionRules" ref="adminFrom" label-width="150px">

      <el-form-item label="版本类型：" prop="versionType">
        <el-radio-group v-model="version.versionType" @change="getAppVersionInfo">
          <el-radio label="1" >手机APP应用</el-radio>
          <el-radio label="2" >锁箱APP应用</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="版本名称：" prop="versionName">
        <el-input v-model="version.versionName"></el-input>
      </el-form-item>

      <el-form-item label="版本值：" prop="versionValue">
        <el-input v-model="version.versionValue"></el-input>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="onSubmit('adminFrom')">提交</el-button>
        <el-button v-if="!isEdit" @click="resetForm('adminFrom')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script>
 // import {createAdmin, getAdmin, updateAdmin,userRoles,userRoleCheck,getVersionInfo} from '@/api/admin'
   import {getVersionInfo,createNewVersion} from '@/api/app/appversion'
  import {isInteger} from '@/utils/validate';
  import SingleUpload from '@/components/Upload/singleUpload'
   
  var defaultVersion = {
          fid:0,
          versionName: '',
          versionValue:'',
          versionType:'1'
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
      return {
      versionType:null,
        version: Object.assign({},defaultVersion),
        allRoles:null,
        userRoles:null,
        listQuery: {
          pageNum: 1,
          pageSize: 100
        },
        versionRules: {
          versionName: [{required: true, trigger: 'blur', message: '请输入版本号',}],
          versionValue:[{required:true,  trigger: 'blur', message: '请输入版本值',}],
          versionValue:[{required:true,  trigger: 'blur', message: '请输入版本值'},{validator:isInteger,trigger:'blur'}],
        }
        }

    },
    created() {
      this.getAppVersionInfo("1");
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
      /**
       * 提交表单
       */
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('是否提交数据', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
                createNewVersion(this.version).then(response => {
                  if(response.code==200)
                {
                  this.$message({
                    message: '提交成功',
                    type: 'success',
                    duration: 1000
                  });
                  this.$router.push({path: '/app/appversion'});
                }else{
                  this.$message({
                    message: response.msg,
                    type: 'error',
                    duration:1000
                  });
                }
                });
              
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
      getAppVersionInfo(_value){
          getVersionInfo(_value).then(response => {
          if(response.code==200)
            {
                defaultVersion.versionName = response.data.versionName;
                defaultVersion.versionValue = response.data.versionValue;
                defaultVersion.fid = response.data.id;
                this.version = Object.assign({},defaultVersion); 
                this.version.versionType = _value;
            }
          });  
      },
      /**
       * 重置表单
       */
      resetForm(formName) {
        this.$refs[formName].resetFields();
        this.version = Object.assign({},defaultVersion);
        this.getAppVersionInfo("1");
      }
    }
  }
</script>
<style>
</style>


