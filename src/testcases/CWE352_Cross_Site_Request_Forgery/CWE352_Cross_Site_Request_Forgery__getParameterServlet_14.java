/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE352_Cross_Site_Request_Forgery__getParameterServlet_14.java
Label Definition File: CWE352_Cross_Site_Request_Forgery.label.xml
Template File: sources-sinks-14.tmpl.java
*/
/*
* @description
* CWE: 352 Cross Site Request Forgery
* BadSource: getParameterServlet Read data from a querystring using getParameter
* GoodSource: A hardcoded string
* Sinks:
*    GoodSink: using CSRF prevention nonce
*    BadSink : no CSRF prevention token
* Flow Variant: 14 Control flow: if(IO.static_five==5) and if(IO.static_five!=5)
*
* */

package testcases.CWE352_Cross_Site_Request_Forgery;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE352_Cross_Site_Request_Forgery__getParameterServlet_14 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_five==5)
        {
            /* FLAW: untrusted input with CSRF prevention mechanism */
            response.getWriter().write(data);
        }
        else {
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

    /* goodG2B1() - use goodsource and badsink by changing first IO.static_five==5 to IO.static_five!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_five==5)
        {
            /* FLAW: untrusted input with CSRF prevention mechanism */
            response.getWriter().write(data);
        }
        else {
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

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from request */
            data = request.getParameter("name");

        }
        if(IO.static_five==5)
        {
            /* FLAW: untrusted input with CSRF prevention mechanism */
            response.getWriter().write(data);
        }
        else {
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

    /* goodB2G1() - use badsource and goodsink by changing second IO.static_five==5 to IO.static_five!=5 */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: untrusted input with CSRF prevention mechanism */
            response.getWriter().write(data);
        }
        else {

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

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        if(IO.static_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        if(IO.static_five==5)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: untrusted input with CSRF prevention mechanism */
            response.getWriter().write(data);

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
