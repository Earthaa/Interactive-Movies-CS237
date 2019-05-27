package net.balusc.webapp;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.Globals;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class Main {

	public static void main(String[] args) throws Exception {
		launch();
	}

	private static Tomcat tomcat;
	private static boolean wasStart;


	private static void launch() throws Exception {

		// db-server start
		// DerbyServerStarter dbserver = new DerbyServerStarter();
		// dbserver.setDaemon(true);
		// dbserver.start();

		// BeanUtil.setApplicationContext(
		// new ClassPathXmlApplicationContext(new String[] {
		// "classpath:META-INF/spring/application-context.xml" }));

		String webappDirLocation = "src/main/webapp/";
		tomcat = new Tomcat();
		int webPort = Integer.parseInt("8080");

		System.out.println("Use port : " + webPort);

		tomcat.setPort(Integer.valueOf(webPort));
		Connector connector = tomcat.getConnector();
		connector.setURIEncoding("UTF-8");
		File file = new File(webappDirLocation);
		if (!file.exists())
			file.mkdirs();

		Context webContext = tomcat.addWebapp("/", file.getAbsolutePath());
		webContext.getServletContext().setAttribute(Globals.ALT_DD_ATTR, new File(file, "WEB-INF/web.xml").getAbsolutePath());
		
		System.out.println("configuring app with basedir: " + file.getAbsolutePath());
		tomcat.start();
		wasStart = true;
		tomcat.getServer().await();

	}
}
