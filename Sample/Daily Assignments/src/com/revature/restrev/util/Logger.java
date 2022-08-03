package com.revature.restrev.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.security.auth.callback.LanguageCallback;

/**
 * @author wintk
 *class that takes in any events i want to record and write it to some file
 */
public class Logger 
{ //singleton design pattern
	//private instance 
	private static Logger Logger=new Logger();
	//private constuctor logger shi loe
	private Logger() 
	{
		
	}
	//getter for the only instance of the class 
	public static Logger getLogger()
	{
		return Logger;
	}
private  void writeToFile(String message)	
{
	//try with resource block-opens a resource- then close it code block finish execution once
try(FileWriter writer = new FileWriter ("app.log") )
{
	writer.write(message);
	}catch (IOException e) {
		// TODO: handle exception
	e.printStackTrace();
	}
}
//method overloading
public  void log(LogLevel logLevel, LogLevel message)
{
	Log newLog=new Log(logLevel,LocalDateTime.now(),message);
	writeToFile(newLog.toString());
	}

private class Log
{
	LogLevel timestamp;
	 LocalDateTime message;
	 LogLevel loglevel;
	public Log(LogLevel timestamp, LocalDateTime message, LogLevel loglevel) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.loglevel = loglevel; 
		
}
	
	 
}



 

//enum is a type that allows you to set constant values
public enum LogLevel
{
info,debug,verbose, warning ,fatal ,error
}





public void log(LogLevel warning, String string) {
	// TODO Auto-generated method stub
	
}

}
