package com.http.logging;


import org.apache.log4j.Logger;
//import com.hardware.info.logging.
/**
 * This helper provide logging facilities.
 *
 * @author vikas.bhartiya
 
 */
public final class LogHelper {
    private static final ThreadLocal<String> SESSION_ID = new ThreadLocal<String>() {
        protected synchronized String initialValue() {
            return "Not defined";
        }
    };

    static Logger LOGGER=Logger.getLogger( com.http.logging.LogHelper.class.getName());
   

    /**
     * Default constructor
     */
    private LogHelper() {}


    /**
     * Set the current user session id
     *
     * @param pSessionId User session id
     */
    public static void setSessionId(final String pSessionId) {
        SESSION_ID.set(pSessionId);
    }

    /**
     * Log a message with severity 'critical'.
     *
     * @param string The class where the error occured.
     * @param pException The message to log.
     */
    public static void critical(final String string, final Throwable pException) {
      //  Log4JLogger.critical(formatMessage(pClass, pMessage));
    	
    	// Log4JLogger.(formatMessage(pClass, pMessage));
    }

    /**
     * Log a message with severity 'critical'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     * @param pException A throwable object.
     */
    public static void critical(final Class<?> pClass, final String pMessage, final Throwable pException) {
    	
    	LOGGER.fatal(formatMessage(pClass,pMessage), pException);
       // ( (LogHelper) LOGGER).critical(formatMessage(pClass, pMessage), pException);
    }

    /**
     * Log a message with severity 'alert'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     */
    public static void alert(final Class<?> pClass, final String pMessage) {
        LOGGER.error(formatMessage(pClass, pMessage));
    }

    /**
     * Log a message with severity 'alert'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     * @param pException A throwable object.
     */
    
    /**
     * Log a message with severity 'Error'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     */
    public static void error(final Class<?> pClass, final String pMessage) {
        LOGGER.error(formatMessage(pClass, pMessage));
    }

    /**
     * Log a message with severity 'Error'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     * @param pException A throwable object.
     */
    public static void error(final Class<?> pClass, final String pMessage, final Throwable pException) {
        LOGGER.error(formatMessage(pClass, pMessage), pException);
    }

    /**
     * Log a message with severity 'Warning'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     */
    public static void warning(final Class<?> pClass, final String pMessage) {
        LOGGER.warn(formatMessage(pClass, pMessage));
    }

    /**
     * Log a message with severity 'Warning'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     * @param pException A throwable object.
     */
    public static void warning(final Class<?> pClass, final String pMessage, final Throwable pException) {
        LOGGER.warn(formatMessage(pClass, pMessage), pException);
    }

    /**
     * Log a message with severity 'Info'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     */
    public static void info(final Class<?> pClass, final String pMessage) {
        LOGGER.info(formatMessage(pClass, pMessage));
    }

    /**
     * Log a message with severity 'Info'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     * @param pException A throwable object.
     */
    public static void info(final Class<?> pClass, final String pMessage, final Throwable pException) {
        LOGGER.info(formatMessage(pClass, pMessage), pException);
    }

    /**
     * Log a message with severity 'Debug'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     */
    public static void debug(final Class<?> pClass, final String pMessage) {
        LOGGER.debug(formatMessage(pClass, pMessage));
    }

    /**
     * Log a message with severity 'Debug'.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     * @param pException A throwable object.
     */
    public static void debug(final Class<?> pClass, final String pMessage, final Throwable pException) {
        LOGGER.debug(formatMessage(pClass, pMessage), pException);
    }

    /**
     * Format the prefix and the message to log.
     *
     * @param pClass The class where the error occured.
     * @param pMessage The message to log.
     *
     * @return Returns a formated message with the class' name and the message.
     */
    private static String formatMessage(final Class<?> pClass, final String pMessage) {
        final StringBuffer lMessage = new StringBuffer();
        final String lSessionId = SESSION_ID.get();

        // Append context infos
        lMessage.append('[').append(pClass.getName()).append(']').append(" {Session = ").append(lSessionId).append('}');

        if (pMessage != null) {
            lMessage.append(pMessage);
        }

        return lMessage.toString();
    }
}
