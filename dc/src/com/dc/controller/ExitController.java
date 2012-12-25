package com.dc.controller;

import com.jfinal.core.Controller;

public class ExitController extends Controller {
	public void index(){
		setSessionAttr("username", null);
		render("");
	}
}
