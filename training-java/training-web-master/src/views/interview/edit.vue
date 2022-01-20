<template>
  <div class="app-container">
    <!--工具栏-->
    <el-form ref="form" :model="form" size="small" label-width="100px">
      <el-tabs v-model="activeName">

        <el-tab-pane label="公司信息" name="a1">
          <el-form-item label="公司名称">
            <el-input v-model="form.name" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="公司类型">
            <el-input v-model="form.companyType" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="公司位置">
            <el-input v-model="form.address" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>

        </el-tab-pane>

        <el-tab-pane label="面试信息" name="a2">
          <el-form-item label="面邀途径">
            <!-- <el-select v-model="form.interviewChannel" filterable placeholder="请选择">
          <el-option
            v-for="item in dict.interview_channel"
            :key="item.id"
            :label="item.label"
            :value="item.value" />
        </el-select> -->
          </el-form-item>
          <el-form-item label="面邀平台">
            <!-- <el-select v-model="form.interviewPlatform" filterable placeholder="请选择">
          <el-option
            v-for="item in dict.interview_platform"
            :key="item.id"
            :label="item.label"
            :value="item.value" />
        </el-select> -->
          </el-form-item>
          <el-form-item label="岗位类型">
            <el-input v-model="form.postType" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="面试岗位">
            <el-input v-model="form.postName" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="面试时间">
            <el-date-picker v-model="form.interviewTime" type="datetime" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="岗位设定薪资">
            <el-input v-model="form.postSalary" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="岗位要求补充">
            <el-input v-model="form.postNeed" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
        </el-tab-pane>

        

    <el-tab-pane label="联系方式" name="a3">
      <el-form-item label="公司联系人">
        <el-input v-model="form.companyStaff" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="联系人岗位">
        <el-input v-model="form.companyStaffPost" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="联系人电话">
        <el-input v-model="form.companyStaffTell" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="联系人微信">
        <el-input v-model="form.companyStaffWx" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="联系人QQ">
        <el-input v-model="form.companyStaffQq" style="width: 370px;" />
      </el-form-item>
    </el-tab-pane>
<!--
    <el-tab-pane label="面试结果" name="a4">
      <el-form-item label="面试结果">
        <el-select v-model="form.result" filterable placeholder="请选择">
          <el-option
            v-for="item in dict.ms_result"
            :key="item.id"
            :label="item.label"
            :value="item.value" />
        </el-select>
      </el-form-item>

      <el-form-item label="是否一面">
        <el-select v-model="form.isFrist" filterable placeholder="请选择">
         <el-option label="是" value="1" />
         <el-option label="否" value="0" />
        </el-select>
      </el-form-item>
      <el-form-item label="是否进入下轮">
        <el-select v-model="form.isNext" filterable placeholder="请选择">
          <el-option label="是" value="1" />
              <el-option label="否" value="0" />
        </el-select>
      </el-form-item>
      <el-form-item label="是否录用">
        <el-select v-model="form.isLy" filterable placeholder="请选择">
         <el-option label="是" value="1" />
         <el-option label="否" value="0" />
        </el-select>
      </el-form-item>
      <el-form-item label="第几次面试" >
        <el-input v-model="form.interviewTimes" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="结果描述">
        <el-input v-model="form.resultDesc" :rows="3" type="textarea" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="面试感想">
        <el-input v-model="form.feeling" :rows="3" type="textarea" style="width: 370px;" />
      </el-form-item>
    </el-tab-pane>

    <el-tab-pane label="问题整理" name="a5">
      <el-form-item label="问题1">
        <el-input v-model="form.q1" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="回答1">
        <el-input v-model="form.a1" :rows="3" type="textarea" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="问题2">
        <el-input v-model="form.q2" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="回答2">
        <el-input v-model="form.a2" :rows="3" type="textarea" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="问题3">
        <el-input v-model="form.q3" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="回答3">
        <el-input v-model="form.a3" :rows="3" type="textarea" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="问题4">
        <el-input v-model="form.q4" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="回答4">
        <el-input v-model="form.a4" :rows="3" type="textarea" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="问题5">
        <el-input v-model="form.q5" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="回答5">
        <el-input v-model="form.a5" :rows="3" type="textarea" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="问题6">
        <el-input v-model="form.q6" style="width: 370px;" />
      </el-form-item>
      <el-form-item label="回答6">
        <el-input v-model="form.a6" :rows="3" type="textarea" style="width: 370px;" />
      </el-form-item>
    </el-tab-pane>
         -->
      </el-tabs>

    </el-form>
  </div>
</template>

<script>
import tbInterviewPage from '@/api/tbInterviewPage'
export default {
  data() {
    return {
      activeName: 'a1',
      form: {
        // name: null,
        // companyType: null,
        // address: null,
      }
    }
  },
  created() {
    var id = this.$route.query.infoId

    tbInterviewPage.get(id).then(res => {
      console.log('dddd' + res)
      this.form = res
    }).catch(() => {
      // data.enabled = !data.enabled
    })
  }
}
</script>

<style scoped>

</style>
