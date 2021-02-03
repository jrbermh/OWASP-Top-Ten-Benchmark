/*
 * @description uncontrolled recursion due to missing base or exit case

 * */

package testcases.CWE674_Uncontrolled_Recursion;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE674_Uncontrolled_Recursion__Servlet_01 extends AbstractTestCaseServlet 
{
	private static final long serialVersionUID = 1L;

	private static long recursion_bad(long n)
	{
		/* FLAW: Missing base case */
		long ret = n + recursion_bad(n-1);
		return ret;
	}
	
	public void bad(HttpServletRequest request, HttpServletResponse response)
			throws IOException 
    {
		
		if (request.getParameter("num") == null)
        {
			return;
        }
		
		long result = recursion_bad(Long.parseLong(request.getParameter("num")));
		response.getWriter().write(Long.toString(result));
	}

	private static long recursion_good(long n)
	{
		/* FIX: add a case for termination */
		if (n < 0)
        {
			return 0;
        }
		
		long ret = n + recursion_good(n-1);
		return ret;
	}
	
	private void good1(HttpServletRequest request, HttpServletResponse response)
			throws IOException 
    {

		if (request.getParameter("num") == null)
        {
			return;
        }
		
		long result = recursion_good(Long.parseLong(request.getParameter("num")));
		response.getWriter().write(Long.toString(result));
	}
    
    public void good(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        good1(request, response);
    }

}
