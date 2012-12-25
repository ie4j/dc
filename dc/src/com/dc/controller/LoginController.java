package com.dc.controller;

import java.util.List;

import com.dc.interfaces.UserLogin;
import com.dc.model.UserBase;
import com.dc.service.UserLoginImpl;
import com.dc.tool.MD5;
import com.jfinal.core.Controller;

public class LoginController extends Controller {

	public void index() {
		String kaptchaExpected = (String) getSessionAttr(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (kaptchaExpected.equals(getPara("identifier"))) {
			UserLogin ul = new UserLoginImpl();
			boolean flag = ul.login(getPara("username"),
					MD5.toMD5(getPara("password")));
			if (flag == true) {
				setSessionAttr("username", getPara("username"));
				render("");
			} else {
				render("");
			}
		} else {
			setAttr("idenError", "验证码错误！");
			render("");
		}

	}

}
