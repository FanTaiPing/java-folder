<template> 
  <div style="margin-top: 50px">
    <el-form :model="role" :rules="rules" ref="roleFrom"
             label-width="120px" style="width: 680px"
             size="small">
      <el-form-item label="角色名称：" prop="name">
        <el-input v-model="role.name"></el-input>
      </el-form-item>
      <el-form-item label="角色描述：">
        <el-input
          placeholder="请输入内容"
          type="textarea"
          v-model="role.description"
          :autosize="true"></el-input>
      </el-form-item>

      <el-tabs v-model="activeName" @tab-click="handleClick" style="margin-left:100px;margin-right:100px">
        <el-tab-pane label="菜单分配" name="first">
              <el-form-item label="">
                <div slot="header" class="clearfix">
                  <el-tooltip class="item" effect="dark" content="选择指定角色分配菜单" placement="top">
                    <span class="role-span">菜单分配</span>
                  </el-tooltip>
                </div>
                <el-tree
                        ref="menu"
                        :data="menus"
                        :default-checked-keys="menuIds"
                        :props="defaultProps" 
                        default-expand-all
                        show-checkbox
                        accordion
                        show-el-checkbox 
                        node-key="id"/> 
                </el-form-item>
 


                <el-form-item>
                  <el-button type="primary" @click="onSubmit('roleFrom',1)">提交</el-button>
                  <el-button  @click="resetForm('roleFrom')">返回</el-button>
                </el-form-item>
        </el-tab-pane>

        <el-tab-pane label="部门权限配置" name="second">                   
            <el-form-item label="">
              <div slot="header" class="clearfix">
                <el-tooltip class="item" effect="dark" content="选择指定角色分配菜单" placement="top">
                  <span class="role-span">菜单分配</span>
                </el-tooltip>
              </div>
              <el-tree
                      ref="org"
                      :data="orgs"
                      :default-checked-keys="orgIds"
                      :props="defaultProps" 
                      default-expand-all 
                      show-checkbox
                      accordion
                      show-el-checkbox 
                      node-key="id"/> 

            </el-form-item> 
            <el-form-item>
              <el-button type="primary" @click="onOrgSubmit('roleFrom',2)">提交</el-button>
              <el-button  @click="resetForm('roleFrom')">返回</el-button>
            </el-form-item>
        </el-tab-pane>

        <el-tab-pane label="APP权限配置" name="third">
            <el-form-item label="">
              <div slot="header" class="clearfix">
                <el-tooltip class="item" effect="dark" content="选择指定角色分配APP菜单" placement="top">
                  <span class="role-span">APP权限配置</span>
                </el-tooltip>
              </div>
              <el-tree
                      ref="appMenu"
                      :data="appMenus"
                      :default-checked-keys="appMenuIds"
                      :props="defaultProps" 
                      default-expand-all 
                      show-checkbox
                      accordion
                      show-el-checkbox 
                      node-key="id"/> 

            </el-form-item> 
            <el-form-item>
              <el-button type="primary" @click="onAppMeunSubmit('roleFrom',3)">提交</el-button>
              <el-button  @click="resetForm('roleFrom')">返回</el-button>
            </el-form-item>  
        </el-tab-pane> 
      </el-tabs>
  </el-form>

  </div>
</template>
<script>
  import {createRole, getRole, updateRole,rolePermission} from '@/api/role'
  import {treeList,orgList} from '@/api/permission' 
  import {appMenuList} from '@/api/app/appMenuModule' 
  import SingleUpload from '@/components/Upload/singleUpload'
  const defaultRole={
    name: ''
  };
  export default {
    name: 'RoleDetail',
    components:{SingleUpload},

    props: {
      isEdit: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        role:Object.assign({}, defaultRole),
        // role:null,
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        currentId: 0, menuLoading: false, showButton: false,
        delLoading: false, 
        menus: [], menuIds: [],
        orgs:[], orgIds: [],
        appMenus:[], appMenuIds: [],
        //所有专题列表
        subjectList: [],
        //专题左右标题
        subjectTitles: ['待选择', '已选择'],
        menuIds:null,
        orgIds:null,
        appMenuIds:null,
        roleMenus:null,
        rules: {
          name: [
            {required: true, message: '请输入角色明', trigger: 'blur'}
          ],
        },
        activeName: 'first',
      }
    },
    created() {
    //  this.getMenuList();
      this.initData();

      if (this.isEdit) {
        rolePermission(this.$route.query.id).then(res => {
          if (this.$route.query.id) {

            // 清空菜单的选中
            //  this.$refs.menu.setCheckedKeys([])
            // 保存当前的角色id
            this.currentId = this.$route.query.id
            console.log(this.roleMenus)
            // 初始化
            let menuIds = []
            let orgIds = []
            let appMenuIds = []
            // 菜单数据需要特殊处理
            if (res.data && res.data.length>0){
              res.data.forEach(function(data, index) {
                if(data.typeId==1){
                  menuIds.push(data.permissionId)
                }else if(data.typeId==2){
                  orgIds.push(data.permissionId)
                }else if(data.typeId == 3){
                  appMenuIds.push(data.permissionId)
                }


              })
            } 
            this.menuIds = menuIds;    
            this.orgIds  = orgIds;
            this.appMenuIds  = appMenuIds;
          }
        });
        getRole(this.$route.query.id).then(response => {
          this.role = response.data;
        });

      }else{
        this.role = Object.assign({},defaultRole);
      }
    },

    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      },
 
 
      initData() {
        treeList().then(res => { 
          this.menus = res.data
        })
        
        orgList().then(res => { 
          this.orgs = res.data
        })

        appMenuList().then(res => { 
          this.appMenus = res.data 
        })
      },


      filterMethod(query, item) {
        return item.label.indexOf(query) > -1;
      },

      onSubmit(formName,typeId) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('是否提交数据', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              let serviceIds='';

              // 得到半选的父节点数据，保存起来
              this.$refs.menu.getHalfCheckedNodes().forEach(function(data, index) {
                serviceIds += data.id + ',';
              })

              console.log("------------**********-----------")
              console.log(serviceIds)

              // 得到已选中的 key 值
              this.$refs.menu.getCheckedKeys().forEach(function(data, index) {
                serviceIds += data + ',';
              })

              console.log(serviceIds) 

              if (serviceIds.endsWith(',')) {
                serviceIds = serviceIds.substr(0, serviceIds.length - 1)
              }
              this.role.menuIds = serviceIds;
 
              this.role.typeId = typeId;
              if (this.isEdit) {
                updateRole(this.$route.query.id, this.role).then(response => {
                  this.$refs[formName].resetFields();
                  this.$message({
                    message: '修改成功',
                    type: 'success',
                    duration:1000
                  });
                  this.$router.back();
                });
              } else {
                createRole(this.role).then(response => {
                  this.$refs[formName].resetFields();
                  this.role = Object.assign({},defaultRole);
                  this.$message({
                    message: '提交成功',
                    type: 'success',
                    duration:1000
                  });
                this.$router.back();
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
      
      onOrgSubmit(formName,typeId) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('是否提交数据', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              let serviceIds='';

              // 得到半选的父节点数据，保存起来
              // this.$refs.org.getHalfCheckedNodes().forEach(function(data, index) {
              //   serviceIds += data.id + ',';
              // })

              console.log("------------**********-----------")
              console.log(serviceIds)

              // 得到已选中的 key 值
              this.$refs.org.getCheckedKeys().forEach(function(data, index) {
                serviceIds += data + ',';
              })

              console.log(serviceIds) 

              if (serviceIds.endsWith(',')) {
                serviceIds = serviceIds.substr(0, serviceIds.length - 1)
              }
              this.role.menuIds = serviceIds;
 
              this.role.typeId = typeId;
              if (this.isEdit) {
                updateRole(this.$route.query.id, this.role).then(response => {
                  this.$refs[formName].resetFields();
                  this.$message({
                    message: '修改成功',
                    type: 'success',
                    duration:1000
                  });
                  this.$router.back();
                });
              } else {
                createRole(this.role).then(response => {
                  this.$refs[formName].resetFields();
                  this.role = Object.assign({},defaultRole);
                  this.$message({
                    message: '提交成功',
                    type: 'success',
                    duration:1000
                  });
                this.$router.back();
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

      onAppMeunSubmit(formName,typeId) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('是否提交数据', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              let serviceIds='';

              // 得到半选的父节点数据，保存起来
              // this.$refs.appMenu.getHalfCheckedNodes().forEach(function(data, index) {
              //   serviceIds += data.id + ',';
              // })
 
              // 得到已选中的 key 值
              this.$refs.appMenu.getCheckedKeys().forEach(function(data, index) {
                serviceIds += data + ',';
              })
 
              if (serviceIds.endsWith(',')) {
                serviceIds = serviceIds.substr(0, serviceIds.length - 1)
              }
              this.role.menuIds = serviceIds;
 
              this.role.typeId = typeId;
              if (this.isEdit) {
                updateRole(this.$route.query.id, this.role).then(response => {
                  this.$refs[formName].resetFields();
                  this.$message({
                    message: '修改成功',
                    type: 'success',
                    duration:1000
                  });
                  this.$router.back();
                });
              } else {
                createRole(this.role).then(response => {
                  this.$refs[formName].resetFields();
                  this.role = Object.assign({},defaultRole);
                  this.$message({
                    message: '提交成功',
                    type: 'success',
                    duration:1000
                  });
                this.$router.back();
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
          this.$router.go(-1); 
      }
    }
  }
</script>
<style scoped>

</style>


