/*
 * @description
 * To test interactively you need to test EITHER the bad or good methods by commenting one or
 * the other out.
 * 
 * The idea for testing the bad implementation is that you have 2 browser windows open
 * The first window you go to this URL:
 * http://localhost:8080/testcases/CWE567_Unsynchronized_Access_to_Shared_Data__servlet_01?inc=blah
 * In the second window you go to this URL:
 * http://localhost:8080/testcases/CWE567_Unsynchronized_Access_to_Shared_Data__servlet_01
 * 
 * You refresh the first window multiple times.
 * 
 * Then, when its refreshing one of the times, hit the refresh button on the 2nd browser window.
 * 
 * This simulates someone resetting the number to 0 while another person is changing it.
 * 
 * For testing the good implementation, you do the same thing.
 * Notice how when you try and change the variable to 0 by refreshing the 2nd window, the first window
 * still shows the expected result (not what you got in the bad implementation). 
 * 
 * */

/* note on servlets - when a new Servlet is created, it must be listed in the web.xml
 * file in order to run.  The easy way to do this is in Eclipse:
 *   - right click on testcases in package explorer
 *   - select New->Servlet
 *   - Check the box that says use an existing Servlet class or JSP
 *   - Click browse and select the new Servlet class you have created
 *   - Click OK, Next, then Finish  
 *   - You should now be able to test the servlet by clicking Run in eclipse  
 */

package testcases.CWE567_Unsynchronized_Shared_Data;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE567_Unsynchronized_Shared_Data__Servlet_01 extends AbstractTestCaseServlet {
	private static final long serialVersionUID = 1L;

	static int shared_count = 0; /* FLAW: unsynchronized access to this, see bad, would result in unintended updates */
	
	public void bad(HttpServletRequest request, HttpServletResponse response)
			throws IOException, InterruptedException 
    {

		if (request.getParameter("inc") != null)
		{
			response.getWriter().write("<br>Would expect hits to be: " + (shared_count+1));
			Thread.sleep(4000);
			shared_count++;
			response.getWriter().write("<br>" + shared_count + "hits so far!");
			return;
		}
		
		shared_count = 0;

	}

	private void good1(HttpServletRequest request, HttpServletResponse response)
			throws IOException, InterruptedException 
    {

		synchronized(CWE567_Unsynchronized_Shared_Data__Servlet_01.class) /* FIX: synchronized access to the class */
		{
			if (request.getParameter("inc") != null)
			{
				response.getWriter().write("<br>Would expect hits to be: " + (shared_count+1));
				Thread.sleep(4000);
				shared_count++;
				response.getWriter().write("<br>" + shared_count + "hits so far!");
				return;
			}
			
			shared_count = 0;
		}

	}
    
	public void good(HttpServletRequest request, HttpServletResponse response) throws IOException, InterruptedException 
    {
        good1(request, response);
    }

}
