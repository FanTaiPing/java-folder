<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <div v-if="crud.props.searchToggle">
        <!-- 搜索 -->
        <label class="el-form-item-label">记录内容</label>
        <el-input v-model="query.infoDesc" clearable placeholder="记录内容" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">完成进度</label>
        <el-input v-model="query.proess" clearable placeholder="完成进度" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <label class="el-form-item-label">任务名称</label>
        <el-input v-model="query.workName" clearable placeholder="任务名称" style="width: 185px;" class="filter-item" @keyup.enter.native="crud.toQuery" />
        <rrOperation :crud="crud" />
      </div>
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation :permission="permission" />
      <!--表单组件-->
      <el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title" width="500px">
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">
          <el-form-item label="记录内容">
            <el-input v-model="form.infoDesc" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="完成进度">
            <el-input v-model="form.proess" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="form.comment" style="width: 370px;" />
          </el-form-item>
          <el-form-item label="任务名称">
            <el-input v-model="form.workName" style="width: 370px;" />
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
        <el-table-column prop="infoDesc" label="记录内容" />
        <el-table-column prop="proess" label="完成进度" />
        <el-table-column prop="comment" label="备注" />
        <el-table-column prop="workName" label="任务名称" />
        <el-table-column v-if="checkPer(['admin','tbWorkInfo:edit','tbWorkInfo:del'])" label="操作" width="150px" align="center">
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
import crudTbWorkInfo from '@/api/tbWorkInfo'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'

const defaultForm = { tbWorkInfoId: null, infoDesc: null, proess: null, workId: null, comment: null, workName: null, takeTime:null, state:null }
export default {
  name: 'TbWorkInfo',
  components: { pagination, crudOperation, rrOperation, udOperation },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  cruds() {
    return CRUD({ title: '作业提交记录', url: 'api/tbWorkInfo', idField: 'tbWorkInfoId', sort: 'tbWorkInfoId,desc', crudMethod: { ...crudTbWorkInfo }})
  },
  data() {
    return {
      permission: {
        add: ['admin', 'tbWorkInfo:add'],
        edit: ['admin', 'tbWorkInfo:edit'],
        del: ['admin', 'tbWorkInfo:del']
      },
      rules: {
        tbWorkInfoId: [
          { required: true, message: '记录id不能为空', trigger: 'blur' }
        ]
      },
      queryTypeOptions: [
        { key: 'infoDesc', display_name: '记录内容' },
        { key: 'proess', display_name: '完成进度' },
        { key: 'workName', display_name: '任务名称' }
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
