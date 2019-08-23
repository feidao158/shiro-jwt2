package com.example.shirojwt2.realm;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.example.shirojwt2.database.UserList;
import com.example.shirojwt2.exception.TokenErrorException;
import com.example.shirojwt2.util.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

@Service
public class JwtRealm extends AuthorizingRealm {

    @Override
    public boolean supports(AuthenticationToken token) {

        return true;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String username = JwtUtils.getUsername(token);

        if (username==null) {
            throw new AuthenticationException("token异常");
        }
        if (!UserList.userList.containsKey(username)){
            throw new AuthenticationException("该用户不存在");
        }

        if (!JwtUtils.verifyToken(username,UserList.userList.get(username).getPassword(),token)){
            throw new AuthenticationException("token异常");
        }
        return new SimpleAuthenticationInfo(token,token,"jwtRealm");
    }
}
