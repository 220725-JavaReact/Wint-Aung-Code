package com.revature.pointsapp.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

// utility that keep track of activities that are happending to your program by logging/nothing them down to a file/sink
public class Logger {
	//creating logger with Singleton DP
	//Singleton is a creational DP, that ensures at most one instance of a class in generated per run time
	//2 kinds of singletons:Early loading ,lazy loaded 
	// eagerly loading the logger instance
	private static Logger logger =new Logger();
	
   // key to singletone DP is a private constructor
	private Logger()
	{
		
	}
	public static  Logger getLogger() 
	{
		//return instances of logger
		return logger;
	}
	private void writeToFile(String log)
	{
		String filePath=LocalDate.now().toString()+ "app.log";
		try(FileWriter writer=new FileWriter(filePath,true))
		{
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void log(LogLevel level,String message)
	{
		
		Log log=new Log(level, LocalDateTime.now(), message);
		writeToFile(log.toString());
	}
	public void log(LogLevel level,Exception ex)
	{
		
		Log log=new Log(level, LocalDateTime.now(), ex.toString());
		writeToFile(log.toString());
	}
	
	private class Log
	{
		LogLevel level;
		String message;
		LocalDateTime timeStamp;
		
		private Log(LogLevel level,LocalDateTime timeStamp,String message)
		{
			this.level=level ;
			this.message=message;
			this.timeStamp=timeStamp;
			
		}
		@Override
		public String toString() {
			return  level + "\t" +timeStamp + "\t" + message;
			}
		
	}
	
	public enum LogLevel 
	{
		info,debug , verbose ,warning ,error ,fatal 
	}
	
}

