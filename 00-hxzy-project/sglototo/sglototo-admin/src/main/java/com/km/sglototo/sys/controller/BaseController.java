package com.km.sglototo.sys.controller;


import com.km.sglototo.bo.AdminUserDetails;
import com.km.sglototo.sys.entity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    public SysUser getCurrentUser() {
        try {
            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication auth = ctx.getAuthentication();
            AdminUserDetails memberDetails = (AdminUserDetails) auth.getPrincipal();
            return memberDetails.getUmsAdmin();
        } catch (Exception e) {
            return new SysUser();
        }
    }


}
