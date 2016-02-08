package com.empmgmt.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mongodb.MongoClient;

/**
 * Application Lifecycle Listener implementation class MongoDBContextListener
 *
 */
@WebListener
public class MongoDBContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MongoDBContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	 MongoClient mongo = (MongoClient) sce.getServletContext()
                 .getAttribute("MONGO_CLIENT");
    	 mongo.close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	 try {
             ServletContext ctx = sce.getServletContext();
             MongoClient mongo = new MongoClient(
                     ctx.getInitParameter("MONGODB_HOST"), 
                     Integer.parseInt(ctx.getInitParameter("MONGODB_PORT")));
             sce.getServletContext().setAttribute("MONGO_CLIENT", mongo);
         } catch (Exception e) {
             throw new RuntimeException("MongoClient init failed");
         }
    }
	
}
