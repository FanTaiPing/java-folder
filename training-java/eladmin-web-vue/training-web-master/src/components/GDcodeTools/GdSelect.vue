<template>
	<div class="gd_select">
		<el-select v-if="isMultiple" v-model="selectedValue" multiple :placeholder="placeholder" @change="selectChange">
			<el-option v-for="item in options" :key='item.value' :label="item.label" :value="item.value">
			</el-option>
		</el-select>
		<el-select v-if="!isMultiple" v-model="selectedValue" clearable :placeholder="placeholder" @change="selectChange">
			<el-option v-for="item in options" :key='item.value' :label="item.label" :value="item.value">
			</el-option>
		</el-select>
	</div>
</template>

<script>
	import request from '@/utils/request'
	export default {
		name: 'GdSelect',
		model: {
			prop: "selectedValue",
			event: "change"
		},
		props: {
			url: String,
			method: {
				type: String,
				default: 'GET'
			},
			keyName: {
				type: String,
				default: 'name'
			},
			valueName: {
				type: String,
				default: 'value'
			},
			placeholder: {
				type: String,
				default: '请选择'
			},
			isMultiple: {
				type: Boolean,
				default: false
			}
		},
		data() {
			return {
				selectedValue: null,
				options: []
			}
		},
		created() {
			//初始化查询
			this.initSelect();
		},
		methods: {
			//查询列表方法
			initSelect() {
				var param = {
					url: this.url,
					method: this.method
				};
				request(param).then(data => {
					const arr = data.content;
					for (var i in arr) {
						var obj = {
							value: arr[i][this.valueName],
							label: arr[i][this.keyName]
						};
						this.options.push(obj);
					}
				}).catch(err => {
					console.dir("失败！");
				})
			},
			//选项切换事件
			selectChange(e) {

				if(this.isMultiple){
					
					var obj = {
						name: "",
						value: ""
					};
					
					for(var i in e){
						var nameStr = this.getNameByID(e[i]);
						obj.name += nameStr+",";
						obj.value += e[i]+",";
					}
					
					if(obj.name!=""){
						obj.name = obj.name.substring(0,obj.name.length - 1);
						obj.value = obj.value.substring(0,obj.value.length - 1);
					}
					
					this.$emit('change', e);
					this.$emit('gdChange', obj);
					
				}else{
					var obj = {
						name: "",
						value: ""
					};
					
					for (var i in this.options) {
						if (this.options[i].value == e) {
							obj.name = this.options[i].label;
							obj.value = e;
							break;
						}
					}
					
					this.$emit('change', e);
					this.$emit('gdChange', obj);
				}
				
			},
			//通过id获取名称
			getNameByID(id){
				
				var name = "";
				
				for(var i in this.options){
					if(this.options[i].value == id){
						name = this.options[i].label;
						break;
					}
				}
				
				return name;
				
			}
		}
	}
</script>
</script>

<style scoped>
	.gd_select {
		display: inline-block;
		vertical-align: middle;
		margin: 0 3px 10px 0;
	}
</style>
