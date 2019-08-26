package rpa;
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
import java.io.File;

import org.apache.log4j.Logger;

import it.sauronsoftware.cron4j.Scheduler;

public class RPAExecuteCron {
	static Logger log = Logger.getLogger(RPAExecuteCron.class.getName());
	public static void main(String[] args) {
		
		// start the logging
		log.info("---Cron4j executing started.---");
		
		// Declares the file.
		File file=null;
		if (args.length==0) {
			//file = new File("D:\\Java\\Projects\\CronTest\\src\\cron4jtab.txt");
			log.info("---There is no params to execute.---");
			return;
		} else {
			file = new File(args[0]);
		}
			
		//System.out.println(file.getName());
		log.info("setting file:" + file.getName());
		// Creates the scheduler.
		Scheduler scheduler = new Scheduler();
		// Schedules the file.
		scheduler.scheduleFile(file);
		scheduler.addSchedulerListener(new RPASchedulerListener());
		// Starts the scheduler.
		scheduler.start();
		// Stays alive for five minutes.
//		try {
//			Thread.sleep(5L * 60L * 1000L);
//		} catch (InterruptedException e) {
//			;
//		}
		// Stops the scheduler.
		//scheduler.stop();
	}

}
