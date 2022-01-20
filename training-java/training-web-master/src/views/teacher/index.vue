<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <div v-if="crud.props.searchToggle">
        <!-- 搜索 -->
        <label class="el-form-item-label">姓名</label>
        <el-input v-model="query.name" clearable placeholder="姓名" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">性别</label>
        <el-input v-model="query.sex" clearable placeholder="性别" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">教授专业</label>
        <el-input v-model="query.teachMajor" clearable placeholder="教授专业" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <rrOperation :crud="crud" />
      </div>
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation :permission="permission" />
      <!--表单组件-->
      <el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title" width="800px">
        <el-form ref="form" :model="form" :rules="rules" size="small" :inline="true" label-width="110px">
          <el-form-item label="姓名">
            <el-input v-model="form.name" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="性别">
            <el-select v-model="form.sex" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.user_sex"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="form.age" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="学历">
            <el-select v-model="form.education" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.user_education"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="学历专业">
            <el-input v-model="form.educationMajor" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="教授专业">
            <el-select v-model="form.teachMajor" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.user_major"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="职称">
            <el-input v-model="form.technicalTitle" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="岗位">
            <el-select v-model="form.postname" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.user_position"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="岗位类型">
            <el-select v-model="form.positionNature" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.user_type"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="电话">
            <el-input v-model="form.telNumber" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="QQ">
            <el-input v-model="form.qqNumber" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="微信">
            <el-input v-model="form.wxNumber" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="周工作日（起）">
            <el-input v-model="form.jobweekStart" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="周工作日（止）">
            <el-input v-model="form.jobweekEnd" style="width: 200px;" />
          </el-form-item>
          <el-form-item label="入司时间">
            <el-date-picker v-model="form.entryTime" type="datetime" style="width: 200px;" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="text" @click="crud.cancelCU">取消</el-button>
          <el-button :loading="crud.status.cu === 2" type="primary" @click="crud.submitCU">确认</el-button>
        </div>
      </el-dialog>
      <!--表格渲染-->
      <el-table ref="table" v-loading="crud.loading" :data="crud.data" size="small" style="width: 100%;" @selection-change="crud.selectionChangeHandler">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="name" label="姓名" />
        <el-table-column prop="sex" label="性别">
          <template slot-scope="scope">
            {{ dict.label.user_sex[scope.row.sex] }}
          </template>
        </el-table-column>
        <el-table-column prop="age" label="年龄" />
        <el-table-column prop="teachMajor" label="教授专业">
          <template slot-scope="scope">
            {{ dict.label.user_major[scope.row.teachMajor] }}
          </template>
        </el-table-column>
        <el-table-column prop="technicalTitle" label="职称" />
        <el-table-column prop="postname" label="岗位">
          <template slot-scope="scope">
            {{ dict.label.user_position[scope.row.postname] }}
          </template>
        </el-table-column>
        <el-table-column prop="positionNature" label="岗位类型">
          <template slot-scope="scope">
            {{ dict.label.user_type[scope.row.positionNature] }}
          </template>
        </el-table-column>
        <el-table-column prop="telNumber" label="电话" />
        <el-table-column prop="jobweekStart" label="周工作日（起）" />
        <el-table-column prop="jobweekEnd" label="周工作日（止）" />
        <el-table-column v-if="checkPer(['admin','tbTeacher:edit','tbTeacher:del'])" label="操作" width="150px" align="center">
          <template slot-scope="scope">
            <udOperation
              :data="scope.row"
              :permission="permission"
            />
          </template>
        </el-table-column>
      </el-table>
      <!--分页组件-->
      <pagination />
    </div>
  </div>
</template>

<script>
import crudTbTeacher from '@/api/tbTeacher'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'

const defaultForm = { teacherId: null, name: null, sex: null, age: null, education: null, educationMajor: null, teachMajor: null, technicalTitle: null, postname: null, positionNature: null, telNumber: null, qqNumber: null, wxNumber: null, jobweekStart: null, jobweekEnd: null, entryTime: null }
export default {
  name: 'TbTeacher',
  components: { pagination, crudOperation, rrOperation, udOperation },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  dicts: ['user_sex', 'user_education', 'user_major', 'user_position', 'user_type'],
  cruds() {
    return CRUD({ title: '教师信息管理', url: 'api/tbTeacher', idField: 'teacherId', sort: 'teacherId,desc', crudMethod: { ...crudTbTeacher }})
  },
  data() {
    return {
      permission: {
        add: ['admin', 'tbTeacher:add'],
        edit: ['admin', 'tbTeacher:edit'],
        del: ['admin', 'tbTeacher:del']
      },
      rules: {
        teacherId: [
          { required: true, message: '教师ID不能为空', trigger: 'blur' }
        ]
      },
      queryTypeOptions: [
        { key: 'name', display_name: '姓名' },
        { key: 'sex', display_name: '性别' },
        { key: 'teachMajor', display_name: '教授专业' }
      ]
    }
  },
  methods: {
    // 钩子：在获取表格数据之前执行，false 则代表不获取数据
    [CRUD.HOOK.beforeRefresh]() {
      return true
    }
  }
}
</script>

<style scoped>

</style>
