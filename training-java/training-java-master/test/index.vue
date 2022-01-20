<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <div v-if="crud.props.searchToggle">
        <!-- 搜索 -->
        <label class="el-form-item-label">名称</label>
        <el-input v-model="query.name" clearable placeholder="名称" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">年龄</label>
        <el-input v-model="query.age" clearable placeholder="年龄" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">性别</label>
        <el-input v-model="query.sex" clearable placeholder="性别" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <rrOperation :crud="crud" />
      </div>
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation :permission="permission" />
      <!--表单组件-->
      <el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title" width="500px">
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
          <el-form-item label="名称">
            <el-input v-model="form.name" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="form.age" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="性别">
            <el-radio v-model="form.sex" v-for="item in dict.user_sex" :key="item.id" :label="item.value">{{ item.label }}</el-radio>
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
        <el-table-column prop="name" label="名称" />
        <el-table-column prop="age" label="年龄" />
        <el-table-column prop="sex" label="性别">
          <template slot-scope="scope">
            {{ dict.label.user_sex[scope.row.sex] }}
          </template>
        </el-table-column>
        <el-table-column v-if="checkPer(['admin','tbText:edit','tbText:del'])" label="操作" width="150px" align="center">
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
import crudTbText from '@/api/tbText'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'

const defaultForm = { testId: null, name: null, age: null, sex: null }
export default {
  name: 'TbText',
  components: { pagination, crudOperation, rrOperation, udOperation },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  dicts: ['user_sex'],
  cruds() {
    return CRUD({ title: '学生信息管理测试接口', url: 'api/tbText', idField: 'testId', sort: 'testId,desc', crudMethod: { ...crudTbText }})
  },
  data() {
    return {
      permission: {
        add: ['admin', 'tbText:add'],
        edit: ['admin', 'tbText:edit'],
        del: ['admin', 'tbText:del']
      },
      rules: {
      },
      queryTypeOptions: [
        { key: 'name', display_name: '名称' },
        { key: 'age', display_name: '年龄' },
        { key: 'sex', display_name: '性别' }
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
