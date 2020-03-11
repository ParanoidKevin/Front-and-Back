package servertest.demo.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MySessionInformationExpiredStrategy implements SessionInformationExpiredStrategy  {

    @Autowired
    private ObjectMapper objectMapper;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        HttpServletResponse response = event.getResponse();
        HttpServletRequest request = event.getRequest();
        //JSONObject returnObj = new JSONObject();
        /*if (RequestUtils.isAjax(request)) {
            returnObj.put("status", "0");
        } else {
            returnObj.put("status", "-1");
            returnObj.put("message", "非法登录");
        }*/
        Map<String,String> map=new HashMap<>();
        map.put("msg","Session expired, please login again.");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(objectMapper.writeValueAsString(map));
        response.flushBuffer();
    }
}
