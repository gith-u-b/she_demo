package cn.com.demo.action;


import java.util.List;



import cn.com.demo.dao.UserDao;
import cn.com.demo.entity.User;
import cn.com.demo.util.MD5Code;

@SuppressWarnings("serial")
public class UserAction extends BaseAction{
	private UserDao userDao = new UserDao();
	private User user;
	private String validateCode;
	private String passWord;
	private String newpwd1;
	private String newpwd2;
	//注册
	public String register(){
		MD5Code md5 = new MD5Code();
		try {
			if(userDao.findUserByName(user.getUserName().trim())){
				user.setPassWord(md5.getMD5ofStr(user.getPassWord()));
				userDao.save(user);
				this.getRequest().setAttribute("msg", "注册成功");
			}else{
				this.getRequest().setAttribute("msg", "此用户名已被占用");
			}
		} catch (Exception e) {
			this.getRequest().setAttribute("msg", "服务器异常，请联系管理员！");
			e.printStackTrace();
		}
		return "register";
		
	}
	//登录
	public String login(){
		if(user.getUserName() == null || "".equals(user.getUserName().trim())){
			this.getRequest().setAttribute("msg", "请输入帐号！");
			return "loginfail";
		}
		if(user.getPassWord() == null || "".equals(user.getPassWord())){
			this.getRequest().setAttribute("msg", "请输入密码！");
			return "loginfail";
		}
		//有的时候注册码还没有加载出来，用户就开始登录
		if(this.getSession().getAttribute("rand")==null){   
			this.getRequest().setAttribute("msg", "验证码错误！");
			return "loginfail";
		}
		String rand = (String) this.getSession().getAttribute("rand");
		MD5Code md5 = new MD5Code();
		if(rand.equalsIgnoreCase(validateCode.trim())){
			user.setPassWord(md5.getMD5ofStr(user.getPassWord()));
			List<User> ulist = userDao.findByNameAndPwd(user);
			if(ulist != null && ulist.size()>0){
					User user = ulist.get(0);
					this.getSession().setAttribute("user", user);
					return "frontloginsuc";
			}
			this.getRequest().setAttribute("msg", "用户名或者密码错误！");
			return "frontloginfail";
		}
		this.getRequest().setAttribute("msg", "验证码错误！");
		return "frontloginfail";
	}
	//注销
	public String logout(){
		this.getSession().removeAttribute("user");
		this.getSession().setAttribute("history", "history");
		return "loginfail";
	}
	//修改密码
	/*public String updatePassword() throws Exception{
		try {
			MD5Code md5 = new MD5Code();
			if(!md5.getMD5ofStr(passWord).equalsIgnoreCase(user.getPassWord())){
				this.printJSON("no1");
			}else if(!newpwd1.equals(newpwd2)){
				this.printJSON("no2");
			}else{
				CmsUser u = cuservice.findUserById(user.getUserId());
				u.setUploadSize(u.getUploadSize()+1);
				u.setUserPassword(md5.getMD5ofStr(newpwd1));
				cuservice.doUpdateUser(u);
				this.printJSON("yes");
			}
		} catch (Exception e) {
			this.printJSON("no3");
			this.getLogger().info("更改密码失败");
			e.printStackTrace();
		}
		
		return null;
	}*/
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNewpwd1() {
		return newpwd1;
	}
	public void setNewpwd1(String newpwd1) {
		this.newpwd1 = newpwd1;
	}
	public String getNewpwd2() {
		return newpwd2;
	}
	public void setNewpwd2(String newpwd2) {
		this.newpwd2 = newpwd2;
	}
	
}
