/* note on servlets - when a new Servlet is created, it must be listed in the web.xml
 * file in order to run.  The easy way to do this is in Eclipse:
 *   - right click on testcases in package explorer
 *   - select New->Servlet
 *   - Check the box that says use an existing Servlet class or JSP
 *   - Click browse and select the new Servlet class you have created
 *   - Click OK, Next, then Finish  
 *   - You should now be able to test the servlet by clicking Run in eclipse  
 */

package testcasesupport;

import java.io.IOException;
import javax.servlet.http.*;

public abstract class AbstractTestCaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L; /* needed since Servlets are serializable */
	
	public abstract void bad(HttpServletRequest request,
			HttpServletResponse response) throws Throwable;

	public abstract void good(HttpServletRequest request,
			HttpServletResponse response) throws Throwable;

	/* from a static method like main(), there is not an easy way to get the current
	 * classes's name.  We do a trick here to make it work so that we don't have
	 * to edit the main for each test case or use a string member to contain the class
	 * name
	 */
	public static void mainFromParent(String[] args)
		throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		StackTraceElement e[] = Thread.currentThread().getStackTrace();
	
		String myClassName = e[e.length -1].getClassName();
	
		Class<?> myClass = Class.forName(myClassName);
	
		AbstractTestCase myObject = (AbstractTestCase) myClass.newInstance();
		
		myObject.runTest(myClassName);
	}

	/* this method runs a test on its own, creating a full HTML document
	 * it is called from doGet and doPost in this file
	 */
	public void runTestSolo(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		
		response.getWriter().println("<html><body>");
		
		runTest(request, response);

		response.getWriter().println("</body></html>");
	
	}
	 
	/* this method runs the tests, but assumes that the html document has already
	 * been started.  It is called by runTestSolo and by ServletMain
	 */
	public void runTest(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String className = this.getClass().getName();
		
		int lastDotInClassName = className.lastIndexOf('.');
		
		String servletName = className.substring(lastDotInClassName+1); /* request.getServletPath().substring(1); */

		response.getWriter().println(
				"<br><br>Starting tests for Servlet " + servletName);

		try {
			good(request, response);
	
			response.getWriter().println(
					"<br>Completed good() without Throwable for Servlet " + servletName);
		} catch (Throwable t) {

			response.getWriter().println(
					"<br>Caught thowable from good() in Servlet " + servletName);

			response.getWriter().println("<br>Throwable's message = " + t.getMessage());
			
			response.getWriter().println("<br><br>Stack trace below");

			/* TODO - t.message or t.name or something */

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {

				response.getWriter().println("<br>" + ste.toString());

			} 

		} 

		try {
			bad(request, response);
			response.getWriter().println(
					"<br>Completed bad() without Throwable in Servlet "
							+ servletName);

		} catch (Throwable t) {

			response.getWriter().println(
					"<br>Caught thowable from bad() in Servlet " + servletName);

			response.getWriter().println("<br>Throwable's message = " + t.getMessage());
			
			response.getWriter().println("<br><br>Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {

				response.getWriter().println("<br>" + ste.toString());

			} 

		} 


	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {

			runTestSolo(request, response);

		} catch (Throwable t) {

			IO.writeLine("Caught a throwable from runTest()");

			/* t.message? */

			StackTraceElement stes[] = t.getStackTrace();

			IO.writeLine("Stack trace below");

			for (StackTraceElement ste : stes) {

				IO.writeLine(ste.toString());

			} 

		} 

	}

} 
