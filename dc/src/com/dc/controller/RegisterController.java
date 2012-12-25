package com.dc.controller;

import com.dc.interfaces.UserRegister;
import com.dc.model.UserDetail;
import com.dc.service.UserRegisterImpl;
import com.jfinal.core.Controller;

public class RegisterController extends Controller {
	public void index() {
		UserDetail ud = getModel(UserDetail.class);
		UserRegister ur = new UserRegisterImpl();
		boolean flag = ur.register(ud);
		if (flag == true) {
			render("");
		} else {
			render("");
		}
	}
}
