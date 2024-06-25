package local.wpr.start.sios.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectURL = request.getContextPath();
        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("GLOBAL_ADMIN"))){
//            redirectURL = "/admin/index";
            redirectURL = "/wkrm/index";
        }
        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("HOSPITAL_ADMIN"))){
            redirectURL = "/hospital/index";
        }
        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ORM_ADMIN"))){
            redirectURL = "/orm/index";
        }
        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ORM_USER"))){
            redirectURL = "/orm/index";
        }
        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("WKRM_ADMIN"))){
            redirectURL = "/wkrm/index";
        }
        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("HOSPITAL_USER"))){
            redirectURL = "/hospital/index";
        }
        if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("WKRM_USER"))){
            redirectURL = "/wkrm/index";
        }
        response.sendRedirect(redirectURL);
    }
}
