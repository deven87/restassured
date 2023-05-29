package gorest.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	private Log() {
		
	}
	
	private static Logger logger = LogManager.getLogger(Log.class.getName());
	
	
	public static void logInfo(String info) {
		logger.info(info);
	}
	
	public static void logDebug(String debugInfo) {
		logger.debug(debugInfo);
	}
	
	public static void logError(String error) {
		logger.error(error);
	}
	
	
	
	
}