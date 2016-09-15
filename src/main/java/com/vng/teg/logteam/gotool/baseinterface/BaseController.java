package com.vng.teg.logteam.gotool.baseinterface;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {
    protected void writeJsonResponse(HttpServletResponse response, Object result) throws IOException {
        Map<String, Object> value = new HashMap<>();
        value.put("code", "200");
        value.put("message", result);

        ObjectMapper objectMapper = new ObjectMapper();

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(value));
    }

    protected String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    protected void setSessionAttribute(HttpServletRequest request, String name, Object object) {
        if (request != null && !StringUtils.isEmpty(name)) {
            request.getSession().setAttribute(name, object);
        }
    }

    protected <T> T getSessionAttribute(HttpServletRequest request, String name) {
        if (request == null || StringUtils.isEmpty(name)) {
            return null;
        }

        Object object = request.getSession().getAttribute(name);
        return object == null ? null : (T) object;
    }
}
