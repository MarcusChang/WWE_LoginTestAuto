package com.outlook.test.BPM.Utils;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
 * Created by Marcus_Chang on 2016/4/13.
 * extends the log4j，
 * To change this template use File | Settings | File Templates.
 */
public class Log4jFileAppender extends DailyRollingFileAppender {

    public boolean isAsSevereAsThreshold(Priority priority)
    {
        if( threshold == null ){
            return true;
        }
        //the message type info and warn only used on spring global operation
        if( Priority.INFO_INT  == this.getThreshold().toInt() ) {
            if( priority.toInt() == Priority.INFO_INT || priority.toInt() == Priority.WARN_INT ){
                return true;
            }

        }
        //if the error pop-up, only print error
        if( Priority.ERROR_INT == this.getThreshold().toInt() ){
            return  this.getThreshold().equals(priority);
        }

        return  false;
    }


}
