package com.lirui.boat.shiro;

import com.lirui.boat.entity.User;
import com.lirui.boat.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ShiroRealm extends AuthorizingRealm {
  @Autowired
  private UserServiceImpl userService;

  /**
   * 授权
   * @param principals
   * @return
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    log.info("授权");
    return null;
  }

  /**
   * 默认使用此方法进行用户名正确与否验证，错误抛出异常
   * @param token
   * @return
   * @throws AuthenticationException
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    log.info("执行验证----");
    String username = (String) token.getPrincipal();
    User user = userService.getByAccount(username);
    if (user == null) {
      throw new UnknownAccountException("没有此用户->"+username);
    }
    return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
  }
}
