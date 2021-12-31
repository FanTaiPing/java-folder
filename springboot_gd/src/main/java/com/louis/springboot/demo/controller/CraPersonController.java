package com.louis.springboot.demo.controller;

import com.google.gson.Gson;
import com.louis.springboot.demo.model.CraPerson;
import com.louis.springboot.demo.model.CraPersonExample;
import com.louis.springboot.demo.service.CarPersonService;
import com.louis.springboot.demo.util.DateUtil;
import com.louis.springboot.demo.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class CraPersonController {
    @Autowired
    private CarPersonService carPersonService;
    

    @GetMapping(value="/findAllMap")
    public Object findAllMap(HttpServletRequest rq) {
        String name=rq.getParameter("name");
        String mobile=rq.getParameter("mobile");
        name=name==""?null:name;
        Map<String, String> param= new HashMap<String, String>();
        param.put("name",name);
        param.put("mobile",mobile);
//        param.put("pageNo",name);

        return R.ok().put("page",carPersonService.findAllMap(param));
    }

    @GetMapping(value="/findAllJson")
    public String findAllMap2(HttpServletRequest rq) {
        String name=rq.getParameter("name");
        String mobile=rq.getParameter("mobile");
        name=name==""?null:name;
        Map<String, String> param= new HashMap<String, String>();
        param.put("name",name);
        param.put("mobile",mobile);

        List<Map<String,Object>> arrayList= carPersonService.findAllMap(param);

        Map<String,Object> returnmap = new HashMap<String,Object>();
        returnmap.put("pageParam",null);
        returnmap.put("resultCode",200);
        returnmap.put("resultDesc","OK");
        returnmap.put("exception",null);
        returnmap.put("affectedRows",-1);
        returnmap.put("columnNames",arrayList);
        returnmap.put("outParams",null);
        returnmap.put("callbackParams",null);

        Gson gson = new Gson();

        return gson.toJson(returnmap);
    }

    @PostMapping(value="/findAllMapPost")
    public String findAllMapPost(HttpServletRequest rq) {
        String name=rq.getParameter("name");
        String mobile=rq.getParameter("mobile");
        name=name==""?null:name;
        Map<String, String> param= new HashMap<String, String>();
        param.put("name",name);
        param.put("mobile",mobile);
//        param.put("pageNo",name);
        return carPersonService.findAllMap(param).toString();
    }



    @PostMapping(value="/save")
    public String updateAccount(@RequestBody Map<String, Object> ws) {
        System.out.println(ws);

        Object oid = ws.get("id");
        Object oslzt = ws.get("slzt");
        String mobile=String.valueOf(ws.get("mobile"));
        Object clyj=ws.get("clyj");
        Object tzyx=ws.get("tzyx");
        CraPerson p = new CraPerson();
        p.setName(String.valueOf(ws.get("name")));
        p.setMobile(mobile);
        p.setTzyx(tzyx == null?"":String.valueOf(tzyx));
        p.setClyj(clyj == null?"":String.valueOf(clyj));
        p.setSlzt((Integer) oslzt);


        Integer msg=0;
        if(oid==null){
            Map<String, String> param= new HashMap<String, String>();
            param.put("mobile",mobile);
            List<Map<String,Object>> list = carPersonService.findAllMap(param);
            if(list.size() !=0) {
                msg = 2;  // 记录已存在！
            }else {
                p.setSaveDatetime(DateUtil.getCurrentDateTime());
                msg=carPersonService.insert(p);
            }

        }else{
            Integer id= (Integer) oid;
            p.setId(id);
            p.setModifyDatetime(new Timestamp(System.currentTimeMillis()));
            msg=carPersonService.updateByPrimaryKey(p);
            System.out.println(p.getModifyDatetime());
        }

        return msg.toString();
    }


}