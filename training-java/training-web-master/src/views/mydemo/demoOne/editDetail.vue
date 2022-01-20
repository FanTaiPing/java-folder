<template>
  <!--表单组件:before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title"-->
  <el-dialog :close-on-click-modal="false" width="1200px">
    <el-form ref="form" :model="interviewForm" :inline="true" :rules="rules" size="small" label-width="100px">
      <el-tabs v-model="activeName">
        <el-tab-pane label="公司信息" name="a1">
          <el-form-item label="公司名称">
            <el-input v-model="interviewForm.name" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="公司类型">
            <el-input v-model="interviewForm.companyType" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="公司位置">
            <el-input v-model="interviewForm.address" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>

        </el-tab-pane>
        <el-tab-pane label="面试信息" name="a2">
          <el-form-item label="面邀途径">
            <el-select v-model="interviewForm.interviewChannel" filterable placeholder="请选择">
              <el-option v-for="item in dict.interview_channel" :key="item.id" :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="面邀平台">
            <el-select v-model="interviewForm.interviewPlatform" filterable placeholder="请选择">
              <el-option v-for="item in dict.interview_platform" :key="item.id" :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="岗位类型">
            <el-input v-model="interviewForm.postType" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="面试岗位">
            <el-input v-model="interviewForm.postName" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="面试时间">
            <el-date-picker v-model="interviewForm.interviewTime" type="datetime" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="岗位设定薪资">
            <el-input v-model="interviewForm.postSalary" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="岗位要求补充">
            <el-input v-model="interviewForm.postNeed" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>

        </el-tab-pane>
        <el-tab-pane label="联系方式" name="a3">
          <el-form-item label="公司联系人">
            <el-input v-model="interviewForm.companyStaff" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="联系人岗位">
            <el-input v-model="interviewForm.companyStaffPost" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="联系人电话">
            <el-input v-model="interviewForm.companyStaffTell" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="联系人微信">
            <el-input v-model="interviewForm.companyStaffWx" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="联系人QQ">
            <el-input v-model="interviewForm.companyStaffQq" style="width: 370px;" />
          </el-form-item>
        </el-tab-pane>
        <el-tab-pane label="面试结果" name="a4">
          <el-form-item label="面试结果">
            <el-select v-model="interviewForm.result" filterable placeholder="请选择">
              <el-option v-for="item in dict.ms_result" :key="item.id" :label="item.label" :value="item.value" />
            </el-select>
          </el-form-item>

          <el-form-item label="是否一面">
            <el-select v-model="interviewForm.isFrist" filterable placeholder="请选择">
              <el-option label="是" value="1" />
              <el-option label="否" value="0" />
            </el-select>
          </el-form-item>
          <el-form-item label="是否进入下轮">
            <el-select v-model="interviewForm.isNext" filterable placeholder="请选择">
              <el-option label="是" value="1" />
              <el-option label="否" value="0" />
            </el-select>
          </el-form-item>
          <el-form-item label="是否录用">
            <el-select v-model="interviewForm.isLy" filterable placeholder="请选择">
              <el-option label="是" value="1" />
              <el-option label="否" value="0" />
            </el-select>
          </el-form-item>
          <el-form-item label="第几次面试">
            <el-input v-model="interviewForm.interviewTimes" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="结果描述">
            <el-input v-model="interviewForm.resultDesc" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="面试感想">
            <el-input v-model="interviewForm.feeling" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
        </el-tab-pane>
        <el-tab-pane label="问题整理" name="a5">
          <el-form-item label="问题1">
            <el-input v-model="interviewForm.q1" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="回答1">
            <el-input v-model="interviewForm.a1" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="问题2">
            <el-input v-model="interviewForm.q2" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="回答2">
            <el-input v-model="interviewForm.a2" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="问题3">
            <el-input v-model="interviewForm.q3" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="回答3">
            <el-input v-model="interviewForm.a3" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="问题4">
            <el-input v-model="interviewForm.q4" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="回答4">
            <el-input v-model="interviewForm.a4" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="问题5">
            <el-input v-model="interviewForm.q5" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="回答5">
            <el-input v-model="interviewForm.a5" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="问题6">
            <el-input v-model="interviewForm.q6" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="回答6">
            <el-input v-model="interviewForm.a6" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
        </el-tab-pane>
      </el-tabs>
    </el-form>
    <!-- @click="crud.cancelCU" @click="crud.submitCU"  :loading="crud.status.cu === 2"-->
    <div slot="footer" class="dialog-footer">
      <el-button type="text">取消</el-button>
      <el-button type="primary">确认</el-button>
    </div>
  </el-dialog>
</template>
<script>
  export default {
    data() {
      return {
        activeName: 'a1',
        interviewForm: {
          infoId: null,
          name: null,
          address: null,
          companyType: null,
          interviewChannel: null,
          interviewPlatform: null,
          postType: null,
          postName: null,
          interviewTime: null,
          postNeed: null,
          postSalary: null,
          companyStaff: null,
          companyStaffPost: null,
          companyStaffTell: null,
          companyStaffWx: null,
          companyStaffQq: null,
          result: null,
          resultDesc: null,
          feeling: null,
          isFrist: null,
          isNext: null,
          isLy: null,
          interviewTimes: null,
          q1: null,
          a1: null,
          q2: null,
          a2: null,
          q3: null,
          a3: null,
          q4: null,
          a4: null,
          q5: null,
          a5: null,
          q6: null,
          a6: null
        },
        rules: {
          infoId: [{
            required: true,
            message: '记录id不能为空',
            trigger: 'blur'
          }]
        }
      }
    },
    dicts: ['interview_channel', 'interview_platform', 'ms_result', 'isOrNot', 'isOrNot', 'isOrNot'],

  }

</script>
