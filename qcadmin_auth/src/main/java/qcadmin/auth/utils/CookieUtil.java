package qcadmin.auth.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 2019年4月25日 17:17:09
 */
public class CookieUtil {

    /**
    * @Description: 添加设置cookie
    * @Param: [response, domain, path, name, value, maxAge, httpOnly]
    * @return: void
    * @Author: NieMiao
    * @Date: 2019/4/25
    */
    public static void addCookie(HttpServletResponse response,String domain,String path, String name,
                                 String value, int maxAge,boolean httpOnly) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(httpOnly);
        response.addCookie(cookie);
    }



   /**
   * @Description: 根据cookie名来读取cookie
   * @Param: [request, cookieNames]
   * @return: java.util.Map<java.lang.String,java.lang.String>
   * @Author: NieMiao
   * @Date: 2019/4/25
   */
    public static Map<String,String> readCookie(HttpServletRequest request,String ... cookieNames) {
        Map<String,String> cookieMap = new HashMap<String,String>();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String cookieName = cookie.getName();
                    String cookieValue = cookie.getValue();
                    for(int i=0;i<cookieNames.length;i++){
                        if(cookieNames[i].equals(cookieName)){
                            cookieMap.put(cookieName,cookieValue);
                        }
                    }
                }
            }
        return cookieMap;
    }
}
