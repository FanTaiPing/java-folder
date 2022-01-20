<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <div v-if="crud.props.searchToggle">
        <!-- 搜索 -->
        <label class="el-form-item-label">班级编号</label>
        <el-input v-model="query.code" clearable placeholder="班级编号" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">班级名称</label>
        <el-input v-model="query.name" clearable placeholder="班级名称" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">开班时间</label>
		<el-date-picker v-model="query.classStart" clearable placeholder="开班时间" type="datetime" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">预计结课时间</label>
		<el-date-picker v-model="query.classEnd" clearable placeholder="预计结课时间" type="datetime" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">班主任</label>
        <el-input v-model="query.mTeacherName" clearable placeholder="班主任" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <rrOperation :crud="crud" />
      </div>
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation :permission="permission" />
      <!--表单组件-->
      <el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title" width="550px">
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="100px">
          <el-form-item label="班级编号">
            <el-input v-model="form.code" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="班级名称">
            <el-input v-model="form.name" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="开班时间">
            <el-date-picker v-model="form.classStart" type="datetime" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="预计结课时间">
            <el-date-picker v-model="form.classEnd" type="datetime" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="班级类型">
            <el-select v-model="form.type" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.class_type"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="班主任">
            <el-input v-model="form.mTeacherName" style="width: 370px;" />
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
        <el-table-column prop="code" label="班级编号" />
        <el-table-column prop="name" label="班级名称" />
        <el-table-column prop="classStart" label="开班时间" />
        <el-table-column prop="classEnd" label="预计结课时间" />
        <el-table-column prop="type" label="班级类型">
          <template slot-scope="scope">
            {{ dict.label.class_type[scope.row.type] }}
          </template>
        </el-table-column>
        <el-table-column prop="mTeacherName" label="班主任" />
        <el-table-column v-if="checkPer(['admin','tbClass:edit','tbClass:del'])" label="操作" width="150px" align="center">
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
import crudTbClass from '@/api/tbClass'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'

const defaultForm = { classId: null, code: null, name: null, classStart: null, classEnd: null, type: null, mTeacherId: null, mTeacherName: null }
export default {
  name: 'TbClass',
  components: { pagination, crudOperation, rrOperation, udOperation },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  dicts: ['class_type'],
  cruds() {
    return CRUD({ title: '班级管理', url: 'api/tbClass', idField: 'classId', sort: 'classId,desc', crudMethod: { ...crudTbClass }})
  },
  data() {
    return {
      permission: {
        add: ['admin', 'tbClass:add'],
        edit: ['admin', 'tbClass:edit'],
        del: ['admin', 'tbClass:del']
      },
      rules: {
        classId: [
          { required: true, message: '班级id不能为空', trigger: 'blur' }
        ]
      },
      queryTypeOptions: [
        { key: 'code', display_name: '班级编号' },
        { key: 'name', display_name: '班级名称' },
        { key: 'classStart', display_name: '开班时间' },
        { key: 'classEnd', display_name: '预计结课时间' },
        { key: 'mTeacherName', display_name: '班主任' }
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
