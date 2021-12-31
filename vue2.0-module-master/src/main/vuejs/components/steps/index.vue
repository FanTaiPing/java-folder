<template>
  <div>
    <el-steps :space="300" :active="active" finish-status="success" class="steps-werpper">
      <el-step title="步骤 1" ></el-step>
      <el-step title="步骤 2"></el-step>
      <el-step title="步骤 3"></el-step>
    </el-steps>
    <transition name="fade">
      <router-view class="view"></router-view>
    </transition>
    <el-button style="margin-top: 12px;" @click="next">下一步</el-button>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data() {
      return {
        active: 0
      };
    },

    methods: {
      next() {
        if (this.active++ > 2) this.active = 0;
      },

      getList(){
        alert(1)
        let param = {
          obj: {
            parentid: 1,
          }
        }
        this.$rpc.post('/autoops/SysOrgREST/getAllByParentid', param).then(
          resp => {
            debugger
            // this.orgUserTree = resp.data.list
            if (typeof(success) == 'function') success(resp.data)
          }
        ).catch(error => {
          if (typeof(fail) == 'function') fail(error)
          else this.$message.error('获取数据失败-' + error.response.status)
        })
      },
    },
    mounted(){
      this.getList()
    }
  }
</script>
<style lang="stylus" rel="stylesheet/stylus">
  .steps-werpper
    text-align: center
</style>
