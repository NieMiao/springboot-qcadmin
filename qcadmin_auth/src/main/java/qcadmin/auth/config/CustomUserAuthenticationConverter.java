package qcadmin.auth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;
import qcadmin.auth.entity.UserJwt;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        LinkedHashMap response = new LinkedHashMap();
        String name = authentication.getName();
        response.put("user_name", name);

        Object principal = authentication.getPrincipal();
        UserJwt userJwt = null;
        if(principal instanceof  UserJwt){
            userJwt = (UserJwt) principal;
        }else{
            UserDetails userDetails = userDetailsService.loadUserByUsername(name);
            userJwt = (UserJwt) userDetails;
        }
        response.put("id", userJwt.getId());
        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
            response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
        }

        return response;
    }


}
