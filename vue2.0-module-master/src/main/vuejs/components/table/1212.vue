<template>
  <div id="container">
    <div id="showColDetailId" class="gt-showColDetail">
      <div>业务系统：</div>
      <div>告警信息：</div>
    </div>
    <div class="header" style="background-color: #40A0E2;text-align: center; line-height: 30px; color: #F0F0F0;"> <DIV style="float:left;width:90%;">作业看板（申请时间：{{dis_start_optime}}至{{dis_end_optime}}）</DIV>
      <DIV style="width:5%; float: left;  " @click="dialogQueryVisible=true">查询</DIV>
      <DIV style="width:5%;  float: left; " @click="cardShowAllFun" v-text="cardShowAll==true?'全部':'部分'"></DIV>
    </div>

    <div class="header box" style="text-align: center; line-height: 30px">
      <div class="first" @click="is_show_card_mid" v-text="card_s3_display==true?'展开':'隐藏'"></div>

      <div class="header_module" :style="style_col_width_value" v-for="v in kanbanNodeList" >
        <a v-text="showNodeName(v)"></a>  <a class="p4" v-text="showCalc(v)" ></a>
      </div>
    </div>
    <div id="main" class="box" :style="style_module_height_value"  @mousemove='updateXY'>
      <div class="first" >
        <div class="main_module_top text-vertil" :style="style_module_top_height_value"><div style="min-height: 100px"></div>作业处理区</div>
        <div class="demo_line" style="background-color: #4AB7BD;height: 2px"></div>
        <div class="text-vertil "><div style="min-height: 100px"></div>作业等待区</div>
      </div>
      <div class="main_module" :style="style_col_width_value" v-for="n in kanbanNodeList" >

        <div class="main_module_top" :style="style_module_top_height_value">
          <div v-for="(info,index) in OpKanbanInfoAllList"  v-if="card_calc_isdisplay(info,n.kanban_node,OpKanbanInfoAllList,1)" >
            <card ref="card" :n="n" :info="info"
                  :condition="(n.kanban_node==info.kanban_nodeid)&&(info.regflag==1)"
                  :titleImg="loadTitleImage(info)" :card_s3_display="card_s3_display" :card_s4_display="info.rel_billid !=null"  @show="show" @s_hide="hide" @openDetailInfo="openDetailInfo"></card>
          </div>
          <div v-for="(info,index) in OpKanbanInfoAllList"  v-if="card_calc_isdisplay(info,n.kanban_node,OpKanbanInfoAllList,-1)" >
            <card ref="card" :n="n" :info="info"
                  :condition="(n.kanban_node==info.kanban_nodeid)&&(info.regflag==-1)"
                  :titleImg="loadTitleImage(info)" :card_s3_display="card_s3_display" :card_s4_display="info.rel_billid !=null"  @show="show" @s_hide="hide" @openDetailInfo="openDetailInfo"></card>

          </div>
          <div  v-if="card_calc_more_isdisplay(null,n.kanban_node,OpKanbanInfoAllList)"> 更多...</div>
        </div>

        <div class="demo_line" style="background-color: #4AB7BD;height: 2px"  v-if="n.kanban_node  ==1 || n.kanban_node ==2 || n.kanban_node ==4"> </div>
        <!--作业等待区 start-->
        <div>
          <div v-for="(info,index) in OpKanbanInfoAllList" v-if="card_calc_isdisplay(info,n.kanban_node,OpKanbanInfoAllList,0)" >
            <card ref="card" :n="n" :info="info"
                  :condition="(n.kanban_node==info.kanban_nodeid)&&(info.regflag==0)"
                  :titleImg="loadTitleImage(info)" :card_s3_display="card_s3_display" :card_s4_display="info.rel_billid !=null"  @show="show" @s_hide="hide" @openDetailInfo="openDetailInfo"></card>
          </div>
          <div  v-if="card_calc_more_isdisplay(0,n.kanban_node,OpKanbanInfoAllList)"> 更多...</div>
        </div>
        <!--作业等待区 end-->


      </div>
    </div>

    <el-dialog class="autoops-dialog" title="作业明细" :visible.sync="dialogBillVisible">
      <bill-base-info ref="billBaseInfo" :key_billId="chooseBillId"></bill-base-info>
    </el-dialog>

    <el-dialog class="autoops-dialog" title="作业计划明细" :visible.sync="dialogBillplanVisible"  @close='closeDialog'>
      <bill-plan-base-info ref="billPlanBaseInfo"   :key_billId="chooseBillPlanId"></bill-plan-base-info>
    </el-dialog>

    <el-dialog class="autoops-dialog" title="查询" :visible.sync="dialogQueryVisible" width="40%" @close='closeDialog'>
      <el-form ref="form" class="demo-ruleForm form-container"  label-width="100px" :label-position="labelPosition">
        <el-row :gutter="30">

          <el-col span="24">
            <el-form-item label="作业申请时间" >
              <el-date-picker  type="date" placeholder="开始日期" :clearable="false" style="width: 140px;"
                               v-model="param.start_optime" ></el-date-picker>
              到
              <el-date-picker  type="date" placeholder="结束日期" :clearable="false" style="width: 140px;"
                               v-model="param.end_optime" ></el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row v-if="query_display_1">
          <el-col span="24">
            只显示计划开始时间在&nbsp;
            <el-date-picker  type="date" placeholder="计划开始日期" :clearable="true" style="width: 150px;"
                             v-model="param.plan_start_time" ></el-date-picker>
            &nbsp; 之后的作业计划
            <p/>
          </el-col>
        </el-row>

        <el-row v-if="query_display_1">
          <el-col span="24">
            <el-form-item label="计划-处理区"  >
              <el-input-number v-model="areas.plan_min1" controls-position="right" @change="handleChange" :min="1" :max="10" style="width: 140px;"></el-input-number>
              到
              <el-input-number v-model="areas.plan_max1" controls-position="right" @change="handleChange" :min="1" :max="10" style="width: 140px;"></el-input-number>
              &nbsp; 天内计划开展的，且包含已经超过计划开展时间的
            </el-form-item>
          </el-col>
          <el-col>
            <el-form-item label="计划-等待区"  >
              <el-input-number v-model="areas.plan_min2" controls-position="right" @change="handleChange" :min="1" :max="10" style="width: 140px;"></el-input-number>
              到
              <el-input-number v-model="areas.plan_max2" controls-position="right" @change="handleChange" :min="1" :max="10" style="width: 140px;"></el-input-number>
              &nbsp; 天内计划开展的
            </el-form-item>
          </el-col>
        </el-row>
        <el-row v-if="query_display_2">
          <el-col span="24">
            <el-form-item label="审批-等待区"  >
              <el-input-number v-model="areas.auth_min2" controls-position="right" @change="handleChange" :min="0" :max="10" style="width: 140px;"></el-input-number>
              到
              <el-input-number v-model="areas.auth_max2" controls-position="right" @change="handleChange" :min="0" :max="10" style="width: 140px;"></el-input-number>
              &nbsp; 天内计划开展的
            </el-form-item>

          </el-col>
        </el-row>
        <el-row >
          <el-col span="24">
            <el-form-item label="作业计划分类"  >
              <el-select  style="width: 300px"
                          v-model="param.plan_types" multiple placeholder="请选择">
                <el-option
                  v-for="item in plan_type_list"
                  :key="item.dimision_id"
                  :label="item.dimision_name"
                  :value="item.dimision_id">
                </el-option>
              </el-select>

            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col span="24">
            <el-form-item class="submit-button-autoops">
              <el-button type="primary" @click="load_opkanban_info">查询</el-button>
            </el-form-item>
          </el-col>
        </el-row>


      </el-form>
    </el-dialog>

    <opbillplan ref="opbillplan"></opbillplan>

    <div id="infoDiv" class="card-s3 p5" style="z-index:999;position: fixed;" @mouseover="showtips">
      <el-row>
        <el-col :span="8" class="tip1">标题:</el-col>
        <el-col :span="16" class="tip2" v-text="OpKanbanInfoSingle.title"></el-col>
      </el-row>

      <el-row>
        <el-col :span="8" class="tip1">工单编号:</el-col>
        <el-col :span="16" class="tip2" v-text="OpKanbanInfoSingle.billid"></el-col>
      </el-row>

      <el-row>
        <el-col :span="8" class="tip1">计划开始时间:</el-col>
        <el-col :span="16" class="tip2" v-text="OpKanbanInfoSingle.planstarttime"></el-col>
      </el-row>

      <el-row>
        <el-col :span="8" class="tip1">计划结束时间:</el-col>
        <el-col :span="16" class="tip2" v-text="OpKanbanInfoSingle.planendtime"></el-col>
      </el-row>


      <el-row>
        <el-col :span="8" class="tip1">工作负责人:</el-col>
        <el-col :span="16" class="tip2" v-text="OpKanbanInfoSingle.workheader"></el-col>
      </el-row>


      <el-row>
        <el-col :span="8" class="tip1">申请单位:</el-col>
        <el-col :span="16" class="tip2" v-text="OpKanbanInfoSingle.deptname"></el-col>
      </el-row>

      <el-row>
        <el-col :span="8" class="tip1">所处环节:</el-col>
        <el-col :span="16" class="tip2" v-text="OpKanbanInfoSingle.nodename"></el-col>
      </el-row>

      <el-row v-if="OpKanbanInfoSingle.rel_billid!=null">
        <el-col :span="8" class="tip1">关联编号:</el-col>
        <el-col :span="16" class="tip2" v-text="OpKanbanInfoSingle.rel_billid"></el-col>
      </el-row>
    </div>
    <kanban-grid ref="kanbanGrid"></kanban-grid>
  </div>
</template>

<script>
  import defaultToolImg from '@/assets/images/tool/tool_01.png';
  import jquery from '@/assets/js/jquery-3.1.1.min.js';
  import url_board_img1 from '@/assets/images/board/board-title1.png';
  import url_board_img2 from '@/assets/images/board/board-title2.png';
  import url_board_img3 from '@/assets/images/board/board-title3.png';
  import url_board_img4 from '@/assets/images/board/board-title4.png';
  import url_board_img5 from '@/assets/images/board/board-title5.png';
  import util from '@/utils/util';
  export default {
    components : {
      'kanbanGrid': require('#/viewModels/AutoopsKanbanNodeGridManager'),
      'opbillplan' : require('#/viewModels/OpBillPlanREST'),
      'opbill' : require('#/viewModels/OpBillREST'),
      'cascader': require('@/auto_op/components/Cascader'),
      'sysBaseDimision': require('#/viewModels/SysBaseDimisionREST'),
      'billBaseInfo' : require('@/auto_op/components/board/billBaseInfo'),
      'billPlanBaseInfo' : require('@/auto_op/components/board/billPlanBaseInfo'),
      'card' : require('@/auto_op/components/board/card'),
      'opkanbannode' : require('#/viewModels/AutoopsOpKanbanNodeGridManager'),
    },
    props : {
      __pageNum__: {  default:1 },
      __pageSize__: {  default:1000 }
    },
    data() {
      return {
        // activeNames: ['1'],
        card_s3_display: false,
        mouseX:0,
        mouseY:0,
        style_col_width_value:'',
        style_module_top_height_value:'',
        style_module_height_value:'',
        max_cards_num_1: 0,
        max_cards_num_all: 0,
        card_height: 95,
        card_height_1: 60,
        style_card3_height_value:'height:50px;',

        defaultToolImg,
        opbill_options: [],
        opbillplan_options: [],
        dialogBillVisible: false,
        dialogBillplanVisible: false,
        dialogQueryVisible: false,
        dialogWorkdetailVisible: false,
        cardShowAll: true,
        gridHeight: document.documentElement.clientHeight,
        chooseBillId: "",//选中的作业ID
        chooseBillPlanId:"",//选中的作业计划ID
        regionMap: new Map(),//看板区域显示数据明细MAP
        kanbanNodeList:[],
        plan_type_list:[],
        param: {
          start_optime:util.formatDate.format(new Date(), 'yyyy-MM')+'-01',
          end_optime: util.formatDate.format(new Date(), 'yyyy-MM-dd'),
          plan_start_time:null,
          plan_types: [],
        },
        dis_start_optime:util.formatDate.format(new Date(), 'yyyy-MM')+'-01',
        dis_end_optime:util.formatDate.format(new Date(), 'yyyy-MM')+'-01',
        query_display_1: false,
        query_display_2: false,
        areas: {
          plan_min1: 2,
          plan_max1: 3,
          plan_min2: 4,
          plan_max2: 5,
          auth_min1: 0,
          auth_max1: 1,
          auth_min2: 0,
          auth_max2: 1,
        },
        OpKanbanInfoSingle: {
          billid:null,
          title:null,
          content:null,
          applyman:null,
          deptname:null,
          nodename:null,
          rel_billid:null,
          planstarttime:null,
          planendtime:null,
        },
        OpKanbanInfoSingles: [],
        OpKanbanInfoAllList:[],

        HEAD_WIDTH: 96,
        label_width : '100px',
        style_img1: {
          backgroundImage: "url(" + url_board_img1 + ")"
        },
        style_img2: {
          backgroundImage: "url(" + url_board_img2 + ")"
        },
        style_img3: {
          backgroundImage: "url(" + url_board_img3 + ")"
        },
        style_img4: {
          backgroundImage: "url(" + url_board_img4 + ")"
        },
        style_img5: {
          backgroundImage: "url(" + url_board_img5 + ")"
        },

      }
    },
    created(){

    },

    beforeDestroy(){

    },
    methods: {
      handleChange(val) {
        if(this.areas.plan_min1 > this.areas.plan_max1){
          setTimeout(()=>{
            this.areas.plan_min1=this.areas.plan_max1
          },100)
        }
        if(this.areas.plan_min2 > this.areas.plan_max2){
          setTimeout(()=>{
            this.areas.plan_min2 = this.areas.plan_max2
          },100)
        }
        if(this.areas.auth_min1 > this.areas.auth_max1){
          setTimeout(()=>{
            this.areas.auth_min1 = this.areas.auth_max1
          },100)
        }

      },

      updateXY:function(event){
        var e = event || window.event;
        var scrollX=document.documentElement.scrollTop||document.body.scrollTop;
        var scrollY=document.documentElement.scrollLeft||document.body.scrollLeft;
        this.mouseX = e.pageX || e.clientX + scrollX;
        this.mouseY = e.pageY || e.clientY + scrollY;
        if(this.mouseX>900){
          this.mouseX=this.mouseX-400
        }

        if(this.mouseY>500){
          this.mouseY=this.mouseY-300
        }
        document.getElementById('infoDiv').style.display = "none";
      },

      show(event,value){
        setTimeout(()=>{
          var infoDiv = document.getElementById('infoDiv');
          this.mouseOver(event);
          infoDiv.style.display = "block";
          infoDiv.style.left = this.mouseX +"px";
          infoDiv.style.top = this.mouseY + "px";

          // console.log('this.mouseX     this.mouseY')
          // console.log(this.mouseX +'----'+this.mouseY)

          if(value!=null ) {
            this.OpKanbanInfoSingles = this.OpKanbanInfoAllList.filter((item, index, arr) => {
              return item.billid == value.billid  //新数组为[3,4]
            })

            this.OpKanbanInfoSingle.billid=this.OpKanbanInfoSingles[0].billid
            this.OpKanbanInfoSingle.deptname=this.OpKanbanInfoSingles[0].deptname
            this.OpKanbanInfoSingle.applyman=this.OpKanbanInfoSingles[0].applyman
            this.OpKanbanInfoSingle.workheader=this.OpKanbanInfoSingles[0].workheader
            this.OpKanbanInfoSingle.title=this.OpKanbanInfoSingles[0].title
            this.OpKanbanInfoSingle.nodename=this.OpKanbanInfoSingles[0].nodename
            this.OpKanbanInfoSingle.rel_billid=this.OpKanbanInfoSingles[0].rel_billid
            this.OpKanbanInfoSingle.planstarttime=this.OpKanbanInfoSingles[0].planstarttime
            this.OpKanbanInfoSingle.planendtime=this.OpKanbanInfoSingles[0].planendtime
          }
        },1500)
      },

      showtips(){
        var infoDiv = document.getElementById('infoDiv');
        infoDiv.style.display = "block";
      },

      hide(){
        document.getElementById('infoDiv').style.display = "none";
      },

      mouseOver(obj) {
        let e = obj || window.event;
      },

      is_show_card_mid(){
        if(this.card_s3_display==true){
          this.card_s3_display=false
          this.card_height=95
        }else {
          this.card_s3_display=true
          this.card_height=160
        }
        this.max_module_height()
      },

      cardShowAllFun(){
        if(this.cardShowAll==true){
          this.cardShowAll=false
        }else {
          this.cardShowAll=true
          this.load_opkanban_info()
        }
      },

      load_opkanban_info() {
        this.dialogQueryVisible=false
        let default_sdate=util.formatDate.format(new Date(), 'yyyy-MM')+'-01'
        let default_edate=util.formatDate.format(new Date(), 'yyyy-MM-dd')
        this.param.start_optime = util.formatDate.format(new Date(this.param.start_optime), 'yyyy-MM-dd');
        this.param.end_optime = util.formatDate.format(new Date(this.param.end_optime), 'yyyy-MM-dd');
        var plan_start_time = this.param.plan_start_time==null?'2018-07-01':util.formatDate.format(new Date(this.param.plan_start_time), 'yyyy-MM-dd');
        this.dis_start_optime = this.param.start_optime;
        this.dis_end_optime = this.param.end_optime;
        let param = {
          start_optime: this.param.start_optime,
          end_optime:  this.param.end_optime,
          plan_start_time: plan_start_time,
          plan_min1: this.areas.plan_min1,
          plan_max1: this.areas.plan_max1,
          plan_min2: this.areas.plan_min2,
          plan_max2: this.areas.plan_max2,
          auth_min1: this.areas.auth_min1,
          auth_max1: this.areas.auth_max1,
          auth_min2: this.areas.auth_min2,
          auth_max2: this.areas.auth_max2,
          plan_types: this.param.plan_types.length==0?null:"'"+this.param.plan_types.join("','")+"'",
          // plan_types: this.param.plan_types,
        }
        this.$rpc.post('/Autoops/OpKanbanInfoGridManager/GetOpKanbanInfoList',param).then(
          resp => {
            this.OpKanbanInfoAllList = [];
            this.regionMap = new Map();
            let item = resp.data.opKanbanInfoList.list;
            for(let i=0;i<item.length;i++){
              if (item[i].opertypeid===null || (param.plan_types!=null && param.plan_types.indexOf(item[i].opertypeid)>0)){
                this.OpKanbanInfoAllList.push(item[i]);

                if (this.regionMap.get(item[i].kanban_nodeid) == null){
                  this.regionMap.set(item[i].kanban_nodeid,new Map())
                }
                let node = this.regionMap.get(item[i].kanban_nodeid);
                if (node.get(item[i].regflag) == null){
                  node.set(item[i].regflag,1);
                }else{
                  node.set(item[i].regflag,node.get(item[i].regflag)+1);
                }

              }
            }
            console.log("11111111111111111111")
            console.log(this.regionMap)
            let max_cards_num_0=0;
            let max_cards_num_1=0
            let max_cards_num_sum=0
            this.regionMap.forEach((value,key)=>{
              let node = value;
              let sum = 0;
              value.forEach((value1,key1)=>{
                // console.log(key1+'='+value);
                // alert("key:" + key1 + ";value=" + value1);
                if (key1===0 && value1>max_cards_num_0){
                  max_cards_num_0 = value1;
                }
                if (key1===1 && value1>max_cards_num_1){
                  max_cards_num_1 = value1;
                }
                if (key1===0 || key1===1 || key1===-1)
                  sum += value1;
              });

              max_cards_num_sum = (sum>max_cards_num_sum)?sum:max_cards_num_sum;
            });
            this.max_cards_num_1 = max_cards_num_1;
            this.max_cards_num_all = (max_cards_num_0+this.max_cards_num_1)>max_cards_num_sum?(max_cards_num_0+this.max_cards_num_1):max_cards_num_sum


            let top_height=350
            let max_height=650
            if(this.max_cards_num_1>0&&this.max_cards_num_1 <= 10){
              top_height=this.max_cards_num_1*this.card_height+80;
            }else if(this.max_cards_num_1>0){
              top_height=this.max_cards_num_1*0.8*this.card_height+80;
            }else if(this.max_cards_num_1>0){
              top_height=350
            }

            max_height = this.max_cards_num_all*this.card_height+150;
            this.style_module_top_height_value="height: "+top_height+"px";
            this.style_module_height_value="height: "+max_height+"px";

            if (typeof(success) == 'function') noMessage = success(resp.data)
          }
        ).catch(error=>{
          if (typeof(fail) == 'function') fail(error)
          else {
            console.log(error)
            this.$message.error('服务失败-'+error.response.status)
          }
        })
      },

      load_opkanban_node() {
        this.$refs['kanbanGrid'].vm.GetKanbanNodeListParam().pageNum=0;
        this.$refs['kanbanGrid'].vm.GetKanbanNodeListParam().pageSize=100;
        this.$refs['kanbanGrid'].vm.GetKanbanNodeListParam().is_display=1;
        this.$refs['kanbanGrid'].vm.GetKanbanNodeListParam().kanban_type = 1;
        this.$refs['kanbanGrid'].vm.GetKanbanNodeList(0, (r) => {
          this.kanbanNodeList = r.kanbanNodeList.list;
          if(this.kanbanNodeList.length!=0){
            let w_value=this.HEAD_WIDTH/this.kanbanNodeList.length;
            this.style_col_width_value="width: "+w_value+"%";
          }

          let arr1 = this.kanbanNodeList.filter(item => item.kanban_node==1)
          let arr2 = this.kanbanNodeList.filter(item => item.kanban_node==2)
          this.query_display_1 = arr1.length>0?true:false
          this.query_display_2 = arr2.length>0?true:false



        }, (e) => {
          if (e != null && e.response.status != 200) {
            this.setSubmitBut(false);
            this.$message.error('服务失败-' + e.response.status)
          }
        });
      },


      load_play_type_List(url, success, fail) {
        let param = {
          obj: {
            typeid: 1403,
            dim_status: 1,
          }
        }
        this.$rpc.post('/autoops/SysBaseDimisionREST/getAllByTypeidAndStatus', param).then(
          resp => {
            this.plan_type_list = resp.data.list
            this.plan_type_list.forEach((item,index,arr)=>{
              this.param.plan_types.push(item.dimision_id)
            })
            this.load_opkanban_info();
            if (typeof(success) == 'function') success(resp.data)
          }
        ).catch(error => {
          if (typeof(fail) == 'function') fail(error)
          else this.$message.error('获取数据失败-' + error.response.status)
        })
      },

      showNodeName(v){
        return v.node_name;
      },

      showCalc(v){
        let result="";
        let v1 = 0;
        let v0 = 0;
        let v_1 = 0;
        let value = this.regionMap.get(v.kanban_node);
        if (value != null){
          v1 = value.get(1)==null ? v1 : value.get(1);
          v0 = value.get(0)==null ? v0 : value.get(0);
          v_1 = value.get(-1)==null ? v_1 : value.get(-1);
        }
        if(v.kanban_node==1 || v.kanban_node==2 || v.kanban_node==4){
          // result="("+v.c1+"/"+v.c0+")"
          result="("+v1+"/"+v0+")"
        }else{
          // result="("+v.c_1+")"
          result="("+v_1+")"
        }
        return result
      },

      openDetailInfo(v){
        if (v.billid.indexOf("ZY") >=0) {
          this.chooseBillPlanId = v.billid;
          this.dialogBillplanVisible = true;
        }else{
          this.chooseBillId = v.billid;
          this.dialogBillVisible = true;
        }
      },


      card_calc_isdisplay(info,nodeid,arrs,regflag){
        if(this.cardShowAll){
          return true
        }

        let result=true
        var arr=[]
        arr=arrs.filter(item =>{
          return (item.kanban_nodeid==nodeid)&&(item.regflag==regflag)
          // return item.kanban_nodeid==nodeid
        })
        let cur_index = arr.findIndex((item, index, arr) => {
          if(item.billid==info.billid){
            return index
          }
        })

        // result = cur_index<this.card_show_nums(nodeid)?true:false
        result = (cur_index<this.card_show_nums(nodeid))&&(info.regflag==regflag)?true:false
        this.style_module_top_height_value=''
        this.style_module_height_value=''

        return result
      },

      card_calc_more_isdisplay(value,nodeid,arrs){

        // if(1==1){
        //     return true
        // }

        let result=true
        var arr=[]
        arr=arrs.filter(item =>{
          return item.kanban_nodeid==nodeid
        })
        let cur_item = arr.findIndex((item, index, arr) => {
          if(item.kanban_node==nodeid){
            return item
          }
        })

        return result=cur_item.length>0?true:false
      },


      card_show_nums(nodeid){
        var hidden_card=8
        var show_card=5
        if(nodeid==1 || nodeid==2 || nodeid==4){
          hidden_card=4
          show_card=2
        }
        return this.card_s3_display==true?show_card:hidden_card
      },

      max_module_height(){

        let top_height=350
        let max_height=650

        if(this.max_cards_num_1>4){
          top_height=this.max_cards_num_1*this.card_height;
        }
        if(this.max_cards_num_all>4){
          max_height=this.max_cards_num_all*this.card_height;
        }
        this.style_module_top_height_value="height: "+top_height+"px";
        this.style_module_height_value="height: "+max_height+"px";
        console.log("$$$$$$$$$$$")
        console.log(this.style_module_height_value)
      },


      closeDialog(done) {
        this.$refs['opbillplan'].vm.data.obj=null;
        this.dialogBillplanVisible = false;
        done();
      },


      loadTitleImage(value){
        let result=this.style_img4
        if(value.billtag===1){//超时-红色
          result=this.style_img3
        }else if(value.billtag===2){//预警-黄色
          result=this.style_img1
        }
        return result
      },

      strslice (value,num) {
        if (!value) return ''
        if (value.length > num) {
          return value.slice(0,num) + '...'
        }
        return value
      },


    },

    mounted() {
      this.load_opkanban_node();
      // this.load_opkanban_info();
      this.load_play_type_List();
    },
    created: function () {
      // setInterval(this.load_opkanban_info, 30000);
    },
  }
</script>


<style>
  /*主面板样式*/
  #container {
    width:95%;
    margin:0px auto;/*主面板DIV居中*/
  }
  /*顶部面板样式*/
  .header {
    text-align: center;
    width:100%;
    height:30px;
    border:1px #4AB7BD solid;
    font-size: 0.9vw;
    font-weight: bold;
  }
  /*中间部分面板样式*/
  #main {
    text-align: center;
    width:100%;
    height:30px;
    border:1px #4AB7BD solid;
    min-height: 650px;
  }
  /*底部面板样式*/
  #footer {
    width:100%;
    height:100px;
    border:1px #4AB7BD solid;
  }


  .first{
    overflow: hidden;
    display: inline-block;
    white-space: normal;
    float: left;
    width: 4.7%;
    height: 100%;
    margin-right: -4px;
    border-right: 1px solid #ddd;
  }
  .header_module{
    overflow: hidden;
    display: inline-block;
    height: 100%;
    /*background-color: #D5D6D7;*/
    margin-right: -4px;
    letter-spacing: 0;
    border-top: 1px solid #ddd;
    border-left: 1px solid #F0F0F0;
    font-size: 0.9vw;
    font-weight: bold;
    color: #000FFF;
  }
  .main_module{
    /*padding: 2px,2px,2px,2px;*/
    overflow: hidden;
    display: inline-block;
    width: 19%;
    height: 100%;
    margin-right: -4px;
    letter-spacing: 0;
    border-top: 1px solid #ddd;
    border-right: 1px solid #ddd;
  }
  .main_module_top{
    height: 350px;
  }

  .demo_line{
    height:2.0px;
    width:100%;
    background:#4AB7BD;
    overflow:hidden;
  }
  .mid_line{
    height:2.5px;
    width:100%;
    /*background:#ddd;*/
    background:#ddd;
    overflow:hidden;
  }

  .card{
    margin: 5px 2px 5px 2px;
    overflow: hidden;
    display: inline-block;
    height:100%;
    width: 180px;
    /*background-color: #4AB7BD;*/
  }


  .card-a{
    overflow: hidden;
    display: inline-block;
    /*padding: 12px,2px,2px,2px;*/
    padding-top: 15px;
    height:100px;
    width: 180px;
    background-color: #4AB7BD;
  }

  /*  .card-sub{
        margin: 0 auto;
        width: 100%;
        height:100%;
        background-color: #5e7382;
    }*/
  .card-s1{
    margin:0 auto;
    width:100%;
    height:25px;
    background-image: url('../../../assets/images/board/board-img1.png');
    background-repeat: no-repeat;
    /*background-color: #BAB7BD;*/
  }
  .card-s1-a{
    /*    padding-top: 5px;*/
    /*padding-left: 10px;*/
    overflow: hidden;
    vertical-align: middle;
    text-align: center;
    float: left;
    width: 90px;
    height:100%;
    line-height: 25px; /*设置line-height与父级元素的height相等*/
    text-align: center; /*设置文本水平居中*/
    overflow: hidden; /*防止内容超出容器或者产生自动换行*/
  }
  .card-s1-b{
    line-height: 25px; /*设置line-height与父级元素的height相等*/
    text-align: left; /*设置文本水平居中*/
    overflow: hidden; /*防止内容超出容器或者产生自动换行*/
    float: left;
    width: 89px;
    height:100%;
  }
  .card-s1-b-top{
    line-height: 12px; /*设置line-height与父级元素的height相等*/
    text-align: center; /*设置文本水平居中*/
    overflow: hidden; /*防止内容超出容器或者产生自动换行*/
    float: left;
    width: 90px;
    height: 50%;
  }
  .card-s1-b-bottom{
    line-height: 12px; /*设置line-height与父级元素的height相等*/
    text-align: center; /*设置文本水平居中*/
    overflow: hidden; /*防止内容超出容器或者产生自动换行*/
    float: left;
    width: 90px;
    height: 50%;
  }
  .card-s2{
    margin:0 auto;
    width:100%;
    height:25px;
    background-image: url('../../../assets/images/board/board-title4.png');
    background-repeat: no-repeat;
    color: #F0F0F0;
    font-size:12px;
    font-weight: bold;
    line-height: 20px; /*设置line-height与父级元素的height相等*/
    text-align: center; /*设置文本水平居中*/
    overflow: hidden; /*防止内容超出容器或者产生自动换行*/
  }
  .card-s3{
    margin:0 auto;
    width:90%;
    height:50px;
    font-size: 10px;
    color: #1f2d3d;
    /*background-color: #F0F0F0;*/
    border-left:1px solid #1f2d3d;
    border-right:1px solid #1f2d3d;
    border-bottom:1px solid #1f2d3d;
  }
  .card-s4{
    margin:0 auto;
    width:91.5%;
    height:15px;
    background-color: #F0F0F0;
    font-size: 10px;
  }

  .card-s4-a{
    float: left;
    width:100px;
    height:100%;
    background-color: #F0F0F0;
    border-left: 1px solid #1f2d3d;
    border-right: 1px solid #1f2d3d;
    border-bottom: 1px solid #1f2d3d;
  }
  .card-s4-b{
    float: right;
    width:60px;
    height:100%;
    background-color: #F0F0F0;
    border-right: 1px solid #1f2d3d;
    border-bottom: 1px solid #1f2d3d;
  }

  .text-vertil {
    margin-left: 20px;
    width: 30%;
    line-height: 30px;
    overflow: hidden;
    color: #536276;
    font-size: 0.9vw;
    font-weight: bold;
    text-align: center;
    float: left;
    position: relative;
  }



  .gt-showColDetail{
    /*      position:absolute;
          background-color: #fff;
          width: 100%;
          height: 150px;
          z-index:999;
          margin-top: -150px;*/
    display: none;
    overflow: hidden;
    border: 2px solid #080808;
  }

  #infoDiv{
    top:0px;left:0px;
    display: none; position: absolute; width: 400px; height: 300px;
    background-color: #ffffff;
    border: 2px solid #ddd;
    border-radius: 10px;
  }
  /*
    el-form-item{
      background-color: #ffffff;
      font-weight: bold;
    }*/

  .p1{

    font-size: xx-small;
    transform: scale(0.79);
  }

  .p2{
    font-size: xx-small;
    transform: scale(0.78);
  }
  .p4{
    font-family:"Microsoft YaHei";
    font-size: x-small;
  }
  .p5{
    font-family:"Microsoft YaHei";
    font-size: 16px;
  }
  .tip1{
    text-align: right;
    margin-top: 10px;
    padding-right: 10px;
    font-weight: bold;
  }
  .tip2{
    text-align: left;
    margin-top: 10px;
  }

  .style-date-picker{
    width: 150px;
  }


</style>
