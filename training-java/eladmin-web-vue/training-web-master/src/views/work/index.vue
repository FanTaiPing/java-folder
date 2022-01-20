<template>
	<div class="app-container">
		<!--工具栏-->
		<div class="head-container">
			<div v-if="crud.props.searchToggle">
				<!-- 搜索 -->
				<label class="el-form-item-label">任务名称</label>
				<el-input v-model="query.name" clearable placeholder="任务名称" style="width: 185px;" class="filter-item"
					@keyup.enter.native="crud.toQuery" />
				<label class="el-form-item-label">审查教师</label>
				<el-input v-model="query.crTeacherName" clearable placeholder="审查教师" style="width: 185px;"
					class="filter-item" @keyup.enter.native="crud.toQuery" />
				<label class="el-form-item-label">任务状态</label>
				<el-select v-model="query.workState" clearable placeholder="请选择" style="width: 185px;"
					class="filter-item" @keyup.enter.native="crud.toQuery">
					<el-option v-for="item in dict.work_state" :key="item.id" :label="item.label" :value="item.value" />
				</el-select>
				<label class="el-form-item-label">班级名称</label>
				<el-input v-model="query.crClassName" clearable placeholder="对应班级名称" style="width: 185px;"
					class="filter-item" @keyup.enter.native="crud.toQuery" />
				<label class="el-form-item-label">学生姓名</label>
				<el-input v-model="query.crStudentName" clearable placeholder="对应学生名称" style="width: 185px;"
					class="filter-item" @keyup.enter.native="crud.toQuery" />
				<rrOperation :crud="crud" />
			</div>
			<!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
			<crudOperation :permission="permission" />
			<!--表单组件-->
			<el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0"
				:title="crud.status.title" width="60%">
				<el-form ref="form" :model="form" :rules="rules" :inline="true" size="small" label-width="110px">
					<el-form-item label="所属班级">
						<gd-select @gdChange="form_classChange" url="api/tbClass" v-model="form.crClassId"
							style="width: 370px;" keyName="name" valueName="classId" placeholder="请选择班级" />
					</el-form-item>
					<el-form-item label="安排学生">
						<gd-select @gdChange="form_studentChange" :isMultiple="true" url="api/tbStudent"
							v-model="form.crStudentName" style="width: 370px;" keyName="name" valueName="stId"
							placeholder="请选择学生" />
					</el-form-item>
					<el-form-item label="审查教师">
						<gd-select @gdChange="form_teacherChange" url="api/tbTeacher" v-model="form.crTeacherName"
							style="width: 370px;" keyName="name" valueName="teacherId" placeholder="请选择教师" />
					</el-form-item>
					<el-form-item label="任务名称">
						<el-input v-model="form.name" style="width: 370px;" />
					</el-form-item>

					<el-form-item label="完成进度">
						<el-slider v-model="form.proess" style="width: 370px;"></el-slider>
					</el-form-item>

					<el-form-item label="任务状态">
						<el-select v-model="form.workState" clearable placeholder="请选择">
							<el-option v-for="item in dict.work_state" :key="item.id" :label="item.label"
								:value="item.value" />
						</el-select>
					</el-form-item>

					<el-form-item label="任务描述">
						<el-input type="textarea" :rows="10" v-model="form.workDesc" placeholder="请输入作业描述"
							style="width: 500px;" />
					</el-form-item>



				</el-form>
				<div slot="footer" class="dialog-footer">
					<el-button type="text" @click="crud.cancelCU">取消</el-button>
					<el-button :loading="crud.status.cu === 2" type="primary" @click="crud.submitCU">确认</el-button>
				</div>
			</el-dialog>

			<!-- 提交作业记录 -->
			<el-dialog :close-on-click-modal="false" :visible.sync="dilog.takeWork" @closed="clear_takeWork()"
				title="提交作业" width="500px">
				<el-form ref="takeWorkForm" :model="takeWork" size="small" label-width="80px">
					<el-form-item label="完成进度">
						<el-slider v-model="takeWork.proess" style="width: 370px;"></el-slider>
					</el-form-item>
					<el-form-item label="记录内容">
						<el-input type="textarea" :rows="10" v-model="takeWork.infoDesc" style="width: 370px;" />
					</el-form-item>

					<el-form-item label="备注">
						<el-input type="textarea" :rows="10" v-model="takeWork.comment" style="width: 370px;" />
					</el-form-item>
				</el-form>
				<div slot="footer" class="dialog-footer">
					<el-button type="text" @click="dilog.takeWork = false">取消</el-button>
					<el-button :loading="takeWork.isLooding" type="primary" @click="doTakeWork">确认</el-button>
				</div>
			</el-dialog>

			<!-- 教师审核作业 -->
			<el-dialog :close-on-click-modal="false" :visible.sync="dilog.checkWork" @closed="clear_checkWork()"
				title="审核作业" width="500px">
				<el-form ref="checkWorkForm" :model="checkWork" size="small" label-width="80px">
					<el-form-item label="任务状态">
						<el-select v-model="checkWork.state" clearable placeholder="请选择">
							<el-option v-for="item in dict.work_state" :v-if="false" :key="item.id" :label="item.label"
								:value="item.label" />
						</el-select>
					</el-form-item>
					<el-form-item label="审核意见">
						<el-input type="textarea" :rows="10" v-model="checkWork.infoDesc" style="width: 370px;" />
					</el-form-item>

					<el-form-item label="备注">
						<el-input type="textarea" :rows="10" v-model="checkWork.comment" style="width: 370px;" />
					</el-form-item>
				</el-form>
				<div slot="footer" class="dialog-footer">
					<el-button type="text" @click="dilog.checkWork = false">取消</el-button>
					<el-button :loading="checkWork.isLooding" type="primary" @click="doCheckWork">确认</el-button>
				</div>
			</el-dialog>

			<!-- 作业提交记录 -->
			<el-dialog :close-on-click-modal="false"  :visible.sync="dilog.workinfo" @closed="clear_workinfo()"
				title="作业过程记录" width="500px">
				<div>
				<span v-if="workinfo.list.length==0">暂无任何作业提交数据！</span>
				<el-timeline v-if="workinfo.list.length>0">
					<el-timeline-item v-for="(activity, index) in workinfo.list" :key="index" :icon="activity.icon"
						:type="activity.type" :color="activity.color" :size="activity.size"
						:timestamp="activity.timestamp">
						{{activity.content}}
					</el-timeline-item>
				</el-timeline>
				</div>
			</el-dialog>

			<!--表格渲染-->
			<el-table ref="table" v-loading="crud.loading" :data="crud.data" size="small" style="width: 100%;"
				@selection-change="crud.selectionChangeHandler">
				<el-table-column type="selection" width="55" />
				<el-table-column prop="workCode" label="编号" />
				<el-table-column prop="name" label="任务名称" />
				<el-table-column prop="crClassName" label="班级名称" />
				<el-table-column prop="crStudentName" label="学生名称" />
				<el-table-column prop="workDesc" label="任务描述" />
				<el-table-column prop="proess" label="完成进度">
					<template slot-scope="scope">
						<el-progress :text-inside="true" :stroke-width="26" :percentage="scope.row.proess">
						</el-progress>
					</template>
				</el-table-column>
				<el-table-column prop="crTeacherName" label="审查教师" />
				<el-table-column prop="workState" label="任务状态">
					<template slot-scope="scope">
						{{ dict.label.work_state[scope.row.workState] }}
					</template>
				</el-table-column>

				<el-table-column label="操作" width="150px"
					align="center">
					<template slot-scope="scope">
						<el-button class="toolBar" size="mini" type="success" v-permission="['学生','takeWork']"
							@click="takeWorkDilog({id:scope.row.workId,name:scope.row.name})" icon="el-icon-s-claim"
							round>提交
						</el-button>
						<el-button class="toolBar" size="mini" type="warning" v-permission="['老师','checkWork']"
							@click="checkWorkDilog({id:scope.row.workId,name:scope.row.name})" icon="el-icon-s-check"
							round>审核
						</el-button>
						<el-button class="toolBar" size="mini" type="primary"
							@click="workinfoDilog({id:scope.row.workId,name:scope.row.name})" icon="el-icon-s-order"
							round>记录
						</el-button>
					</template>
				</el-table-column>
			</el-table>
			<!--分页组件-->
			<pagination />
		</div>
	</div>
</template>

<script>
	import request from '@/utils/request'
	import crudTbWork from '@/api/tbWork'
	import CRUD, {
		presenter,
		header,
		form,
		crud
	} from '@crud/crud'
	import rrOperation from '@crud/RR.operation'
	import crudOperation from '@crud/CRUD.operation'
	import udOperation from '@crud/UD.operation'
	import pagination from '@crud/Pagination'
	import gdSelect from '@/components/GDcodeTools/GdSelect'
	const defaultForm = {
		name: null,
		proess: null,
		workId: null,
		workCode: null,
		workDesc: null,
		crTeacherId: null,
		crTeacherName: null,
		crClassId: null,
		crStudentId: null,
		workState: '1',
		crClassName: null,
		crStudentName: null
	}
	export default {
		name: 'TbWork',
		components: {
			pagination,
			crudOperation,
			rrOperation,
			udOperation,
			gdSelect
		},
		mixins: [presenter(), header(), form(defaultForm), crud()],
		dicts: ['work_state'],
		cruds() {
			console.dir("表格刷新！！！");
			return CRUD({
				title: '作业管理',
				url: 'api/tbWork',
				idField: 'workId',
				sort: 'workId,desc',
				crudMethod: {
					...crudTbWork
				}
			})
		},
		data() {
			return {
				//弹出层状态
				dilog: {
					takeWork: false,
					checkWork: false,
					workinfo: false
				},
				//提交作业记录
				takeWork: {
					infoDesc: null,
					proess: 0,
					workId: null,
					comment: null,
					workName: null,
					isLooding: false
				},
				//审核作业表单
				checkWork: {
					infoDesc: null,
					workId: null,
					comment: null,
					workName: null,
					state: '进行中',
					isLooding: false
				},
				//作业记录
				workinfo: {
					workId: null,
					loding:false,
					list: []
				},
				permission: {
					add: ['老师', 'addWork'],
					edit: ['老师', 'addWork'],
					del: ['老师', 'addWork']
				},
				rules: {
					workId: [{
						required: true,
						message: '任务id不能为空',
						trigger: 'blur'
					}]
				},
				queryTypeOptions: [{
						key: 'name',
						display_name: '任务名称'
					},
					{
						key: 'crTeacherName',
						display_name: '审查教师'
					},
					{
						key: 'workState',
						display_name: '任务状态'
					},
					{
						key: 'crClassName',
						display_name: '对应班级名称'
					},
					{
						key: 'crStudentName',
						display_name: '对应学生名称'
					}
				]
			}
		},
		methods: {
			//重置表单
			resetForm(name) {
				this.$refs[name].resetFields();
			},
			// 钩子：在获取表格数据之前执行，false 则代表不获取数据
			[CRUD.HOOK.beforeRefresh]() {
				return true
			},
			form_teacherChange(e) {
				//console.dir(e);
				this.form.crTeacherId = e.value;
				this.form.crTeacherName = e.name;
			},
			form_classChange(e) {
				//console.dir(e);
				this.form.crClassId = e.value;
				this.form.crClassName = e.name;
			},
			form_studentChange(e) {
				//console.dir(e);
				if (e.name != "") {
					this.form.crStudentId = e.value.split(",")[0];

					//学生 1,张三;2,李四;3,王五
					var valueArr = e.value.split(",");
					var nameArr = e.name.split(",");

					var nameStr = "";

					for (var i in valueArr) {
						nameStr += valueArr[i] + "," + nameArr[i] + ";"
					}

					if (nameStr != "") {
						nameStr = nameStr.substring(0, nameStr.length - 1);
					}

					this.form.crStudentName = nameStr;
				} else {
					this.form.crStudentId = e.value;
					this.form.crStudentName = "";
				}


			},
			//提交任务记录-弹窗打开
			takeWorkDilog(e) {
				//console.dir(e);
				this.dilog.takeWork = true;
				this.takeWork.workId = e.id;
				this.takeWork.workName = e.name;
			},
			//提交任务记录-提交
			doTakeWork() {
				this.takeWork.isLooding = true;
				//TODO:ajax
				var param = {
					url: "api/tbWorkInfo",
					method: "POST",
					data: this.takeWork
				};
				request(param).then(data => {
					//console.dir(data);
					this.dilog.takeWork = false;
					this.clear_takeWork();
					this.takeWork.isLooding = false;
					
					this.crud.refresh();
					
					this.$notify({
						title: data,
						type: 'success'
					});
				})
			},
			//提交任务-清空表单
			clear_takeWork() {
				this.takeWork = {
					infoDesc: null,
					proess: 0,
					workId: null,
					comment: null,
					workName: null
				}
			},
			//审查任务记录-弹窗打开
			checkWorkDilog(e) {
				//console.dir(e);
				this.dilog.checkWork = true;
				this.checkWork.workId = e.id;
				this.checkWork.workName = e.name;
			},
			//提交审查记录-提交
			doCheckWork() {
				this.checkWork.isLooding = true;
				//TODO:ajax
				var param = {
					url: "api/tbWorkInfo",
					method: "POST",
					data: this.checkWork
				};
				request(param).then(data => {
					//console.dir(data);
					this.dilog.checkWork = false;
					this.clear_checkWork();
					this.checkWork.isLooding = false;

					this.crud.refresh();

					this.$notify({
						title: data,
						type: 'success'
					});
				}).catch(err => {
					//console.dir("失败！");
					this.checkWork.isLooding = false;
					this.$notify.error({
						title: "提交出错"
					});
				})
			},
			//提交审查-清空表单
			clear_checkWork() {
				this.checkWork = {
					infoDesc: null,
					workId: null,
					comment: null,
					workName: null,
					state: '进行中'
				}
			},
			//打开作业记录弹窗
			workinfoDilog(e) {
				//console.dir(e);
				this.dilog.workinfo = true;
				this.workinfo.workId = e.id;
				this.workinfo.loding = true;

				var param = {
					url: "api/tbWorkInfo/list?workId=" + e.id,
					method: "GET"
				};
				request(param).then(data => {

					console.dir(data);

					for(var i in data){
						
						var icons = "el-icon-success";
						var types = "primary";
						
						if(data[i].state == "不合格继续进行" || data[i].state == "不合格"){
							icons = "el-icon-close";
							types = "warning";
						}else if(data[i].state == "合格"){
							icons = "el-icon-check";
							types = "success";
						}else if(data[i].state == "已完成"){
							icons = "el-icon-star-off";
							types = "success";
						}else{
							icons = "el-icon-chat-dot-square";
							types = "primary";
						}
						
						var obj = {
							content: data[i].info_desc,
							timestamp: data[i].take_time,
							size: 'large',
							type: types,
							icon: icons
						}
						
						this.workinfo.list.push(obj);
						
					}
					
					this.workinfo.loding = false;

				})

			},
			//作业记录数据清空
			clear_workinfo() {
				this.workinfo = {
					workId: null,
					list: []
				}
			}
		}
	}
</script>

<style scoped>
	.toolBar {
		display: inline;
	}
</style>
