/**   
* @Title: StartServlet.java
* @Package com.zoc.common
* @Description: TODO
* @author superzoc@gmail.com   
* @date Apr 29, 2013 2:50:51 AM
* @version   
*/
package com.zoc.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.h2.server.web.WebServer;
import org.h2.util.New;
import org.nutz.resource.Scans;

/**
 * @author Administrator
 *
 */
public class StartSetupServlet extends HttpServlet {
	
	public void init() {
        List<Class<?>> controllers = Scans.me().scanPackage("com.zoc.web");
    }

}
