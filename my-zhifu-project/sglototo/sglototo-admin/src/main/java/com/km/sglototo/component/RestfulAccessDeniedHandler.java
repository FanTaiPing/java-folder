package com.km.sglototo.component;


import com.km.sglototo.util.JsonUtil;
import com.km.sglototo.utils.CommonResult;
import com.km.sglototo.util.JsonUtil;
import com.km.sglototo.utils.CommonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JsonUtil.objectToJson(new CommonResult().forbidden(e.getMessage())));
        response.getWriter().flush();
    }
}
