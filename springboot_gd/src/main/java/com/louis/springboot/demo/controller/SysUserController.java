package com.louis.springboot.demo.controller;
import com.louis.springboot.demo.model.SysUser;
import com.louis.springboot.demo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.springboot.demo.service.SysUserService;
import com.louis.springboot.demo.util.PageRequest;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    
    @GetMapping(value="/findByUserId")
    public Object findByUserId(@RequestParam Long userId) {
        return sysUserService.findByUserId(userId);
    }
    
    @GetMapping(value="/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

    @GetMapping(value="/findAllMap")
    public Object findAllMap() {
//        return sysUserService.findAllMap();
        return R.ok().put("page",sysUserService.findAllMap());
    }


    @PostMapping(value="/findPage")
    public Object findPage(@RequestBody PageRequest pageQuery) {
        return sysUserService.findPage(pageQuery);
    }


//    @PostMapping(value="/save")
//    public String updateAccount(@RequestBody Map<String, Object> ws) {
//        System.out.println(ws);
//
//        Object oid = ws.get("id");
//        Object oslzt = ws.get("slzt");
//        String mobile=String.valueOf(ws.get("mobile"));
//        Object clyj=ws.get("clyj");
//        Object tzyx=ws.get("tzyx");
//        CraPerson p = new CraPerson();
//        p.setName(String.valueOf(ws.get("name")));
//        p.setMobile(mobile);
//        p.setTzyx(tzyx == null?"":String.valueOf(tzyx));
//        p.setClyj(clyj == null?"":String.valueOf(clyj));
//        p.setSlzt((Integer) oslzt);
//
//
//        Integer msg=0;
//        if(oid==null){
//            Map<String, String> param= new HashMap<String, String>();
//            param.put("mobile",mobile);
//            List<Map<String,Object>> list = sysUserService.findAllMap(param);
//            if(list.size() !=0) {
//                msg = 2;  // 记录已存在！
//            }else {
//                p.setSaveDatetime(DateUtil.getCurrentDateTime());
//                msg=sysUserService.insert(p);
//            }
//
//        }else{
//            Integer id= (Integer) oid;
//            p.setId(id);
//            p.setModifyDatetime(new Timestamp(System.currentTimeMillis()));
//            msg=sysUserService.updateByPrimaryKey(p);
//            System.out.println(p.getModifyDatetime());
//        }
//
//        return msg.toString();
//    }

    /**
     * 添加sysUser用户
     * @param sysUser
     * @return
     */
    @PostMapping("insertSysUser")
    public Object insert(@RequestBody SysUser sysUser) {
        return sysUserService.insert(sysUser);
    }
}