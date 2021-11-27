package util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ljsy
 **/
public class RequestUtil {
    /**
     * 取请求中的int值, 为空则返回0
     * @param request
     * @param parameter 值名
     * @return 解析到的int值
     */
    static public int getIntParameter(HttpServletRequest request, String parameter){
        String para = request.getParameter(parameter);
        return para == null || "".equals(para)? 0 : Integer.parseInt(para);
    }
}
