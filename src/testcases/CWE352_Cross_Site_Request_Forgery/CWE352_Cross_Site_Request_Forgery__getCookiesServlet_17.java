/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE352_Cross_Site_Request_Forgery__getCookiesServlet_17.java
Label Definition File: CWE352_Cross_Site_Request_Forgery.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 352 Cross Site Request Forgery
* BadSource: getCookiesServlet Read data from the first cookie
* GoodSource: A hardcoded string
* Sinks:
*    GoodSink: using CSRF prevention nonce
*    BadSink : no CSRF prevention token
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE352_Cross_Site_Request_Forgery;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE352_Cross_Site_Request_Forgery__getCookiesServlet_17 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            data = cookieSources[0].getValue();
        }
        else
        {
            data = null;
        }

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* FLAW: untrusted input with CSRF prevention mechanism */
            response.getWriter().write(data);
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* Assuming the presence of a session variable called "token" that contains
                 * the nonce value to prevent CSRF */
            /* This testcase is dependent on several others to be a valid weakness:
             *	346 - Origin Validation Error
             *	441 - Unintended Proxy/Intermediary
             *	613 - Insufficient Session Expiration */
            HttpSession session = request.getSession(true);
            String trustedToken = session.getAttribute("token").toString();
            /* FIX: test the value of the request's "token" vs. the session "token" */
            if( request.getParameter("token") == null ||
                    !request.getParameter("token").equals(trustedToken) )
            {
                return;
            }
            response.getWriter().write(data);
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statements with the one in the first for statement */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from cookie */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue();
            }
            else
            {
                data = null;
            }
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* FLAW: untrusted input with CSRF prevention mechanism */
            response.getWriter().write(data);
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* Assuming the presence of a session variable called "token" that contains
                 * the nonce value to prevent CSRF */
            /* This testcase is dependent on several others to be a valid weakness:
             *	346 - Origin Validation Error
             *	441 - Unintended Proxy/Intermediary
             *	613 - Insufficient Session Expiration */
            HttpSession session = request.getSession(true);
            String trustedToken = session.getAttribute("token").toString();
            /* FIX: test the value of the request's "token" vs. the session "token" */
            if( request.getParameter("token") == null ||
            !request.getParameter("token").equals(trustedToken) )
            {
                return;
            }
            response.getWriter().write(data);
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the second and third for statements */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            data = cookieSources[0].getValue();
        }
        else
        {
            data = null;
        }

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: untrusted input with CSRF prevention mechanism */
            response.getWriter().write(data);
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            /* Assuming the presence of a session variable called "token" that contains
                 * the nonce value to prevent CSRF */
            /* This testcase is dependent on several others to be a valid weakness:
             *	346 - Origin Validation Error
             *	441 - Unintended Proxy/Intermediary
             *	613 - Insufficient Session Expiration */
            HttpSession session = request.getSession(true);
            String trustedToken = session.getAttribute("token").toString();
            /* FIX: test the value of the request's "token" vs. the session "token" */
            if( request.getParameter("token") == null ||
                    !request.getParameter("token").equals(trustedToken) )
            {
                return;
            }
            response.getWriter().write(data);
        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
