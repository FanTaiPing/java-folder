<template> 
    <el-card class="form-container" shadow="never">
        <el-form :model="sysOrg" :rules="rules" ref="SysOrgFrom" label-width="150px">


                    <el-form-item
                            label="部门id"
                            prop="id">
                        <el-input v-model="sysOrg.id" style="width: 370px;"/>
                    </el-form-item>


                    <el-form-item
                            label="上级部门id"
                            prop="pid">
                        <el-input v-model="sysOrg.pid" style="width: 370px;"/>
                    </el-form-item>


                    <el-form-item
                            label="层级"
                            prop="deep">
                        <el-input v-model="sysOrg.deep" style="width: 370px;"/>
                    </el-form-item>


                    <el-form-item
                            label="名称"
                            prop="name">
                        <el-input v-model="sysOrg.name" style="width: 370px;"/>
                    </el-form-item>

  
                    </el-form-item>


            <el-form-item>
                <el-button type="primary" @click="onSubmit('SysOrgFrom')">提交</el-button>
                <el-button v-if="!isEdit" @click="resetForm('SysOrgFrom')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</template>
<script>
    import {createSysOrg, getSysOrg, updateSysOrg} from '@/api/sys/sysOrg'
    import SingleUpload from '@/components/Upload/singleUpload'

    const defaultSysOrg = {
        name: ''
    };
    export default {
        name: 'SysOrgDetail',
        components: {SingleUpload},
        props: {
            isEdit: {
                type: Boolean,
                default: false
            }
        },
        data() {
            return {
            sysOrg:
            Object.assign({},
        defaultSysOrg),
            rules: {
                name: [
                    {required: true, message: '请输入品牌名称', trigger: 'blur'},
                    {min: 2, max: 140, message: '长度在 2 到 140 个字符', trigger: 'blur'}
                ],
                    logo
            :
                [
                    {required: true, message: '请输入品牌logo', trigger: 'blur'}
                ],
                    sort
            :
                [
                    {type: 'number', message: '排序必须为数字'}
                ],
            }
        }
        },
        created() {
            if (this.isEdit) {
                getSysOrg(this.$route.query.id).then(response => {
                    this.sysOrg = response.data;
            })
                ;
            } else {
                this.sysOrg = Object.assign({},
            defaultSysOrg)
                ;
            }
        },
        methods: {
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if(valid) {
                        this.$confirm('是否提交数据', '提示', {
                            confirmButtonText: '确定',
                            cancelButtonText: '取消',
                            type: 'warning'
                        }).then(() => {
                            if(this.isEdit
                    )
                        {
                            updateSysOrg(this.$route.query.id, this.sysOrg).then(response => {
                                if(response.code == 200
                        )
                            {
                                this.$refs[formName].resetFields();
                                this.$message({
                                    message: '修改成功',
                                    type: 'success',
                                    duration: 1000
                                });
                                this.$router.back();
                            }
                        else
                            {
                                this.$message({
                                    message: response.msg,
                                    type: 'error',
                                    duration: 1000
                                });
                            }

                        })
                            ;
                        }
                    else
                        {
                            createSysOrg(this.sysOrg).then(response => {
                                if(response.code == 200
                        )
                            {
                                this.$refs[formName].resetFields();
                                this.sysOrg = Object.assign({},
                            defaultSysOrg)
                                ;
                                this.$message({
                                    message: '提交成功',
                                    type: 'success',
                                    duration: 1000
                                });
                                this.$router.back();
                            }
                        else
                            {
                                this.$message({
                                    message: response.msg,
                                    type: 'error',
                                    duration: 1000
                                });
                            }

                        })
                            ;
                        }
                    })
                        ;

                    } else {
                        this.$message({
                            message: '验证失败',
                            type: 'error',
                            duration: 1000
                        });
                return false;
            }
            })
                ;
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
                this.sysOrg = Object.assign({},
            defaultSysOrg)
                ;
            }
        }
    }
</script>
<style>
</style>


