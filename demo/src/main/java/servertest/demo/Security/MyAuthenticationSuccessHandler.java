package servertest.demo.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//处理登录成功
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        //调用父类的方法 直接放行至controller节点
        //登录后默认跳转到主页 /dash
        //super.onAuthenticationSuccess(request, response, authentication);

        //这里可以根据实际情况，来确定是跳转到页面或者json格式。
        //如果是返回json格式，那么我们这么写

        /*
        Map<String,String> map=new HashMap<>();
        map.put("code", "200");
        map.put("msg", "toLogin");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(objectMapper.writeValueAsString(map));
        */

        //如果是要跳转到某个页面的，比如我们的那个whoim的则
        new DefaultRedirectStrategy().sendRedirect(request, response, "http://localhost:3000/dash");

    }
}
