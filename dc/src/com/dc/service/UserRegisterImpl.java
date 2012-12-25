package com.dc.service;

import com.dc.interfaces.UserRegister;
import com.dc.model.UserDetail;

public class UserRegisterImpl implements UserRegister {

	@Override
	public boolean register(UserDetail ud) {
		boolean flag = ud.save();
		return flag;
	}

}
