package cn.com.demo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
  public HttpServletRequest getRequest(){
	  return ServletActionContext.getRequest();
  }
  
  public HttpSession getSession(){
	  return ServletActionContext.getRequest().getSession();
  }
}
