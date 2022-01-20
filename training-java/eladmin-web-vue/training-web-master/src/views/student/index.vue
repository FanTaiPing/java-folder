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
        <label class="el-form-item-label">所属老师</label>
		<gd-select url="api/tbTeacher" v-model="query.teacherId" style="width: 185px;" keyName="name" @keyup.enter.native="crud.toQuery" valueName="teacherId" placeholder="请选择教师" />
		<label class="el-form-item-label">所属班级</label>
		<gd-select  url="api/tbClass" v-model="query.classId" style="width: 185px;" keyName="name" @keyup.enter.native="crud.toQuery" valueName="classId" placeholder="请选择班级" />
		
		<rrOperation :crud="crud" />
      </div>
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation :permission="permission" />
      <!--表单组件-->
      <el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title" width="45%">
        <el-form ref="form" :model="form" :rules="rules" :inline="true" size="small" label-width="90px">
          <el-form-item label="姓名" prop="name">
            <el-input v-model="form.name"  />
          </el-form-item>
          <el-form-item label="入学时间" prop="leanTime">
            <el-date-picker v-model="form.leanTime" type="datetime"  style="width: 300px;"/>
          </el-form-item>
		  <el-form-item label="所属班级" prop="classId">
			<gd-select url="api/tbClass" v-model="form.classId" style="width: 300px;" keyName="name"  valueName="classId" placeholder="请选择班级" />
		  </el-form-item>
          <el-form-item label="性别" prop="sex">
            <el-select v-model="form.sex" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.user_sex"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="生日" prop="birthday">
            <el-date-picker v-model="form.birthday" type="datetime" style="width: 300px;" />
          </el-form-item>
          <el-form-item label="籍贯">
            <el-input v-model="form.nativePlace" style="width: 300px;" />
          </el-form-item>
          <el-form-item label="学历">
            <el-input v-model="form.education"  style="width: 300px;"/>
          </el-form-item>
          <el-form-item label="毕业院校">
            <el-input v-model="form.graduationSchool" style="width: 300px;" />
          </el-form-item>
          <el-form-item label="专业">
            <el-input v-model="form.major"  style="width: 300px;"/>
          </el-form-item>
          <el-form-item label="身份证号码">
            <el-input v-model="form.idcode"  style="width: 300px;"/>
          </el-form-item>
          <el-form-item label="手机号码">
            <el-input v-model="form.telNumber" style="width: 300px;" />
          </el-form-item>
          <el-form-item label="QQ">
            <el-input v-model="form.qqNumber" style="width: 300px;" />
          </el-form-item>
          <el-form-item label="微信">
            <el-input v-model="form.wxNumber" style="width: 300px;" />
          </el-form-item>
          <el-form-item label="家庭住址">
            <el-input v-model="form.jtAddress" style="width: 300px;" />
          </el-form-item>
          <el-form-item label="现居住地址">
            <el-input v-model="form.nowAddress" style="width: 300px;" />
          </el-form-item>
          <el-form-item label="自我介绍">
            <el-input v-model="form.selfContext" :rows="3" type="textarea" style="width: 300px;" />
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
        <el-table-column prop="leanTime" label="入学时间" />
        <el-table-column prop="sex" label="性别">
          <template slot-scope="scope">
            {{ dict.label.user_sex[scope.row.sex] }}
          </template>
        </el-table-column>
        <el-table-column prop="birthday" label="生日" />
        <el-table-column prop="nativePlace" label="籍贯" />
        <el-table-column prop="education" label="学历" />
        <el-table-column prop="graduationSchool" label="毕业院校" />
        <el-table-column prop="major" label="专业" />
        <el-table-column prop="idcode" label="身份证号码" />
        <el-table-column prop="telNumber" label="手机号码" />
        <el-table-column prop="qqNumber" label="QQ" />
        <el-table-column prop="wxNumber" label="微信" />
        <el-table-column prop="jtAddress" label="家庭住址" />
        <el-table-column prop="nowAddress" label="现居住地址" />
        <el-table-column prop="selfContext" label="自我介绍" />
        <el-table-column v-if="checkPer(['admin','tbStudent:edit','tbStudent:del'])" label="操作" width="150px" align="center">
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
import crudTbStudent from '@/api/tbStudent'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'
import gdSelect from '@/components/GDcodeTools/GdSelect'

const defaultForm = { stId: null, classId: null, name: null, leanTime: null, sex: null, birthday: null, nativePlace: null, education: null, graduationSchool: null, major: null, idcode: null, telNumber: null, qqNumber: null, wxNumber: null, jtAddress: null, nowAddress: null, selfContext: null, photoId: null }
export default {
  name: 'TbStudent',
  components: { pagination, crudOperation, rrOperation, udOperation, gdSelect },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  dicts: ['user_sex'],
  cruds() {
    return CRUD({ title: '学生信息管理', url: 'api/tbStudent', idField: 'stId', sort: 'stId,desc', crudMethod: { ...crudTbStudent }})
  },
  data() {
    return {
	  teacher:{
		selected:1  
	  },
      permission: {
        add: ['admin', 'tbStudent:add'],
        edit: ['admin', 'tbStudent:edit'],
        del: ['admin', 'tbStudent:del']
      },
      rules: {
        name: [
          { required: true, message: '姓名不能为空', trigger: 'blur' }
        ],
        leanTime: [
          { required: true, message: '入学时间不能为空', trigger: 'blur' }
        ],
        sex: [
          { required: true, message: '性别不能为空', trigger: 'blur' }
        ],
        birthday: [
          { required: true, message: '生日不能为空', trigger: 'blur' }
        ]
      },
      queryTypeOptions: [
        { key: 'name', display_name: '姓名' },
        { key: 'sex', display_name: '性别' }
      ]
    }
  },
  
  methods: {
    // 钩子：在获取表格数据之前执行，false 则代表不获取数据
    [CRUD.HOOK.beforeRefresh]() {
      return true
    },
  }
}
</script>

<style scoped>

</style>
