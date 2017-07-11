package com.myboot.config;

import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.log.LogChute;

public class LoggerExample implements LogChute{
	
	    public LoggerExample()
	    {
	        /*try
	        {
	            
	             *  this class implements the LogSystem interface, so we
	             *  can use it as a logger for Velocity
	             

	            Velocity.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM, this );
	            Velocity.init();

	            
	             *  that will be enough.  The Velocity initialization will be
	             *  output to stdout because of our
	             *  logVelocityMessage() method in this class
	             
	        }
	        catch( Exception e )
	        {
	            System.out.println("Exception : " + e);
	        }*/
	    }

		/**
		 *  Required init() method for LogSystem
		 *  to get access to RuntimeServices
		 */
		 public void init( RuntimeServices rs )
		 {
		 	return;
		 }

	    /**
	     * This just prints the message and level to System.out.
	     */
	    public void log(int level, String message)
	    {
	        System.out.println("level : " + level + " msg : " + message);
	    }


	    /**
	     * This prints the level, message, and the Throwable's message to
	     * System.out.
	     */
	    public void log(int level, String message, Throwable t)
	    {
	        System.out.println("level : " + level + " msg : " + message + " t : "
	                           + t.getMessage());
	    }

	    /**
	     * This always returns true because logging levels can't be disabled in
	     * this impl.
	     */
	    public boolean isLevelEnabled(int level)
	    {
	        return true;
	    }

//	    public static void main(String[] args)
//	    {
//	        LoggerExample t = new LoggerExample();
//	    }
}
