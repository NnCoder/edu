package kcsj.edu.manager.shiro;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import kcsj.edu.manager.pojo.User;
import kcsj.edu.manager.system.service.PermissionService;
import kcsj.edu.manager.system.service.UserService;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private PasswordHash passwordHash; //加密用
	
	/**
	 * 登录token认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		//password = passwordHash.toHex(username+password);
		User user = userService.getUserByName(username);
		if (user == null) {
			throw new UnknownAccountException("账号或密码错误!");
		}
		
		if (!user.getPassword().equals(password)) {
			throw new IncorrectCredentialsException("账号或密码错误!");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}
	
	/**
	 * 权限授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		//取得权限列表
		Set<String> perms = permissionService.getPerms(user.getId());
		//设置权限信息
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		return info;
	}
	
}
