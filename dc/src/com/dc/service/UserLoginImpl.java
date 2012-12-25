package com.dc.service;

import java.util.List;

import com.dc.interfaces.UserLogin;
import com.dc.model.UserBase;

public class UserLoginImpl implements UserLogin {

	@Override
	public boolean login(String username, String password) {
		List<UserBase> userbases = UserBase.ub.find(
				"select * from userbase where username=? and password=?",
				username, password);
		if (userbases.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
