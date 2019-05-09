/*
 * cron4j - A pure Java cron-like scheduler
 * 
 * Copyright (C) 2007-2010 Carlo Pelliccia (www.sauronsoftware.it)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License version
 * 2.1, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License 2.1 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License version 2.1 along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import org.apache.log4j.Logger;

import it.sauronsoftware.cron4j.SchedulerListener;
import it.sauronsoftware.cron4j.TaskExecutor;

/**
 * A very simple SchedulerListener, sending messages to the console.
 */
public class MySchedulerListener implements SchedulerListener {

	static Logger log = Logger.getLogger(MySchedulerListener.class.getName());
	public void taskLaunching(TaskExecutor executor) {
		log.info(executor.getTask().toString() + ":Task launched!");
		//log.info("Task launched!");
		while(checkProcess()) {
			try {
				//System.out.println("UiRobot is running...,wait 30 seconds.");
				log.info(executor.getTask().toString() + ":UiRobot is running...,wait 30 seconds.");
				Thread.sleep(30L*1000L);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.warn(e.getMessage());
				
			}
		}

		
//		String line;
//		try {
//		    Process proc = Runtime.getRuntime().exec("wmic.exe");
//		    BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//		    OutputStreamWriter oStream = new OutputStreamWriter(proc.getOutputStream());
//		    oStream .write("process where name='UiRobot.exe'");
//		    oStream .flush();
//		    oStream .close();
//		    while ((line = input.readLine()) != null) {
//		        System.out.println(line);
//		        if(line.contains("UiRobot.exe")) {
//		        	System.out.println("UiRobot is running...,wait 10 seconds.");
//		        	this.getClass()
//		        	this.wait(10L * 1000L);
//		        	break;
//		        }
////		        System.out.println("UiRobot is running...,wait 30 seconds.");
////		        Thread.sleep(30L * 1000L);
//		        //executor.pause();
//		    }
//		    input.close();
//		} catch (IOException ioe) {
//		    ioe.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void taskSucceeded(TaskExecutor executor) {
		log.info(executor.getTask().toString() + ":Task completed!" );
	}

	public void taskFailed(TaskExecutor executor, Throwable exception) {
		log.warn(executor.getTask().toString() + ":Task failed due to an exception!");
		exception.printStackTrace();
	}
	
	private boolean checkProcess() {
		boolean tmp=false;
	    Process process;
		try {
			process = Runtime.getRuntime().exec("tasklist.exe");
		    Scanner scanner = new Scanner(new InputStreamReader(process.getInputStream()));
		    while (scanner.hasNext()) {
		    	String strtmp=scanner.nextLine();
//		        System.out.println(strtmp);
		        if(strtmp.contains("UiRobot.exe")) {
//		        	System.out.println("UiRobot is running...,wait 10 seconds.");
//		        	Thread.sleep(30L * 1000L);
		        	tmp=true;
		        	break;
		        	//this.wait(10L*1000L);
		        }
		        
		    }
		    scanner.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return tmp;
	}

}
