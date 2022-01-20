<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <div v-if="crud.props.searchToggle">
        <!-- 搜索 -->
        <label class="el-form-item-label">公司名称</label>
        <el-input v-model="query.name" clearable placeholder="公司名称" style="width: 185px;" class="filter-item"
          @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">公司位置</label>
        <el-input v-model="query.address" clearable placeholder="公司位置" style="width: 185px;" class="filter-item"
          @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">公司类型</label>
        <el-input v-model="query.companyType" clearable placeholder="公司类型" style="width: 185px;" class="filter-item"
          @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">面邀途径</label>
        <el-select v-model="query.interviewChannel" clearable placeholder="请选择" style="width: 185px;"
          class="filter-item" @keyup.enter.native="crud.toQuery">
          <el-option v-for="item in dict.interview_channel" :key="item.id" :label="item.label" :value="item.value" />
        </el-select>
        <label class="el-form-item-label">面邀平台</label>
        <el-select v-model="query.interviewPlatform" clearable placeholder="请选择" style="width: 185px;"
          class="filter-item" @keyup.enter.native="crud.toQuery">
          <el-option v-for="item in dict.interview_platform" :key="item.id" :label="item.label" :value="item.value" />
        </el-select>
        <label class="el-form-item-label">岗位类型</label>
        <el-input v-model="query.postType" clearable placeholder="岗位类型" style="width: 185px;" class="filter-item"
          @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">面试岗位</label>
        <el-input v-model="query.postName" clearable placeholder="面试岗位" style="width: 185px;" class="filter-item"
          @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">面试时间</label>
        <el-input v-model="query.interviewTime" clearable placeholder="面试时间" style="width: 185px;" class="filter-item"
          @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">面试结果</label>
        <el-select v-model="query.result" clearable placeholder="请选择" style="width: 185px;" class="filter-item"
          @keyup.enter.native="crud.toQuery">
          <el-option v-for="item in dict.ms_result" :key="item.id" :label="item.label" :value="item.value" />
        </el-select>
        <rrOperation :crud="crud" />
      </div>
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation />



      <!--表格渲染-->
      <el-table ref="table" v-loading="crud.loading" :data="crud.data" size="small" style="width: 100%;"
        @selection-change="crud.selectionChangeHandler">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="name" label="公司名称" />
        <el-table-column prop="address" label="公司位置" />
        <el-table-column prop="companyType" label="公司类型" />
        <!-- <el-table-column prop="interviewChannel" label="面邀途径">
            <template slot-scope="scope">
              {{ dict.label.interview_channel[scope.row.interviewChannel] }}
            </template>
          </el-table-column>
          <el-table-column prop="interviewPlatform" label="面邀平台">
            <template slot-scope="scope">
              {{ dict.label.interview_platform[scope.row.interviewPlatform] }}
            </template>
          </el-table-column> -->
        <!-- <el-table-column prop="postType" label="岗位类型" /> -->
        <el-table-column prop="postName" label="面试岗位" />
        <el-table-column prop="interviewTime" label="面试时间" />
        <!-- <el-table-column prop="postNeed" label="岗位要求补充" /> -->
        <el-table-column prop="postSalary" label="岗位设定薪资" />
        <!-- <el-table-column prop="companyStaff" label="公司联系人" />
          <el-table-column prop="companyStaffPost" label="联系人岗位" />
          <el-table-column prop="companyStaffTell" label="联系人电话" />
          <el-table-column prop="companyStaffWx" label="联系人微信" />
          <el-table-column prop="companyStaffQq" label="联系人QQ" /> -->
        <el-table-column prop="result" label="面试结果">
          <template slot-scope="scope">
            {{ dict.label.ms_result[scope.row.result] }}
          </template>
        </el-table-column>
        <!-- <el-table-column prop="resultDesc" label="结果描述" />
          <el-table-column prop="feeling" label="面试感想" /> -->
        <el-table-column prop="isFrist" label="是否一面">
          <template slot-scope="scope">
            {{ dict.label.isOrNot[scope.row.isFrist] }}
          </template>
        </el-table-column>
        <el-table-column prop="isNext" label="是否进入下轮">
          <template slot-scope="scope">
            {{ dict.label.isOrNot[scope.row.isNext] }}
          </template>
        </el-table-column>
        <el-table-column prop="isLy" label="是否录用">
          <template slot-scope="scope">
            {{ dict.label.isOrNot[scope.row.isLy] }}
          </template>
        </el-table-column>
        <!-- <el-table-column prop="interviewTimes" label="第几次面试此公司" />
          <el-table-column prop="q1" label="问题1" />
          <el-table-column prop="a1" label="回答1" />
          <el-table-column prop="q2" label="问题2" />
          <el-table-column prop="a2" label="回答2" />
          <el-table-column prop="q3" label="问题3" />
          <el-table-column prop="a3" label="回答3" />
          <el-table-column prop="q4" label="问题4" />
          <el-table-column prop="a4" label="回答4" />
          <el-table-column prop="q5" label="问题5" />
          <el-table-column prop="a5" label="回答5" />
          <el-table-column prop="q6" label="问题6" />
          <el-table-column prop="a6" label="回答6" /> -->
        <el-table-column label="操作" width="150px" align="center">
          <template slot-scope="scope">
            <!-- <udOperation
                :data="scope.row"
                :permission="permission"
              /> -->

            <el-row>
              <el-button type="success" @click="edit(scope.$index,scope.row)">编辑</el-button>
              <el-button type="danger">删除</el-button>
            </el-row>
          </template>
        </el-table-column>
      </el-table>
      <!--分页组件-->
      <pagination />
    </div>
  </div>
</template>

<script>
  import crudTbInterview from '@/api/tbInterview'
  import CRUD, {
    presenter,
    header,
    // form,
    crud
  } from '@crud/crud'
  import rrOperation from '@crud/RR.operation'
  import crudOperation from '@crud/CRUD.operation'
  //   import udOperation from '@crud/UD.operation'
  import pagination from '@crud/Pagination'

//   const defaultForm = {
//     infoId: null,
//     name: null,
//     address: null,
//     companyType: null,
//     interviewChannel: null,
//     interviewPlatform: null,
//     postType: null,
//     postName: null,
//     interviewTime: null,
//     postNeed: null,
//     postSalary: null,
//     companyStaff: null,
//     companyStaffPost: null,
//     companyStaffTell: null,
//     companyStaffWx: null,
//     companyStaffQq: null,
//     result: null,
//     resultDesc: null,
//     feeling: null,
//     isFrist: null,
//     isNext: null,
//     isLy: null,
//     interviewTimes: null,
//     q1: null,
//     a1: null,
//     q2: null,
//     a2: null,
//     q3: null,
//     a3: null,
//     q4: null,
//     a4: null,
//     q5: null,
//     a5: null,
//     q6: null,
//     a6: null
//   }
  export default {
    name: 'TbInterview',
    // udOperation
    components: {
      pagination,
      crudOperation,
      rrOperation,
    },
    //form(defaultForm),
    mixins: [presenter(), header(),  crud()],
    dicts: ['interview_channel', 'interview_platform', 'ms_result', 'isOrNot', 'isOrNot', 'isOrNot'],
    cruds() {
      return CRUD({
        title: '面试记录',
        url: 'api/tbInterview',
        idField: 'infoId',
        sort: 'infoId,desc',
        crudMethod: {
          ...crudTbInterview
        }
      })
    },
    data() {
      return {
        activeName: 'a1',
        permission: {
          add: ['admin', 'tbInterview:add'],
          edit: ['admin', 'tbInterview:edit'],
          del: ['admin', 'tbInterview:del']
        },

        queryTypeOptions: [{
            key: 'name',
            display_name: '公司名称'
          },
          {
            key: 'address',
            display_name: '公司位置'
          },
          {
            key: 'companyType',
            display_name: '公司类型'
          },
          {
            key: 'interviewChannel',
            display_name: '面邀途径'
          },
          {
            key: 'interviewPlatform',
            display_name: '面邀平台'
          },
          {
            key: 'postType',
            display_name: '岗位类型'
          },
          {
            key: 'postName',
            display_name: '面试岗位'
          },
          {
            key: 'interviewTime',
            display_name: '面试时间'
          },
          {
            key: 'result',
            display_name: '面试结果'
          }
        ]
      }
    },
    methods: {
      // 钩子：在获取表格数据之前执行，false 则代表不获取数据
      [CRUD.HOOK.beforeRefresh]() {
        return true
      },
      edit(index, row) {
        this.$router.push({
          path: '/mydemo/edit',
          query:{
            infoId:row.infoId,
          }
        })
      }
    }
  }

</script>

<style scoped>

</style>
