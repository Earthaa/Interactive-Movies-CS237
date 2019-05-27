/********************************
 *	프로젝트 : Movie
 *	패키지   : net.balusc.webapp
 *	작성일   : 2016. 8. 17.
 *	프로젝트 : OPERA 
 *	작성자   : KYJ
 *******************************/
package net.balusc.webapp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextInitializer implements ServletContextListener {
	public static String BASE_PATH = "";

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("init");
		BASE_PATH = sce.getServletContext().getInitParameter("basePath");
		//		sce.getInitParameter("basePath");(
		//		System.setProperty("org.slf4j.simpleLogger.showDateTime", "true");
		//		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");
		//		System.setProperty("org.slf4j.simpleLogger.dateTimeFormat", "yyyy-MM-dd::HH-mm-ss-SSS");
		//		logger = LoggerFactory.getLogger(ContextInitializer.class);
		//		logger.error("I have hit contextInitialized: " + sce.getServletContext().toString());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//		logger.debug("I have hit contextDestroyed.");

	}

}
