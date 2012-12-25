package com.dc.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.dc.controller.ExitController;
import com.dc.controller.LoginController;
import com.dc.controller.RegisterController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;


public class GlobalConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("login", LoginController.class,"/");
		me.add("register",RegisterController.class,"/");
		me.add("exit",ExitController.class,"/");
	}

	@Override
	public void configPlugin(Plugins me) {
		DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost/test","root","login");
		me.add(dp);
		dp.addFilter(new StatFilter());
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		//me.add(new GlobalInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		DruidStatViewHandler dsvh = new DruidStatViewHandler("/druid");
		me.add(dsvh);
	}

}
