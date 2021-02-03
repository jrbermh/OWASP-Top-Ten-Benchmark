/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE603_Client_Side_Authentication__Servlet_08.java
Label Definition File: CWE603_Client_Side_Authentication__Servlet.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 603 Use of client-side authentication
* Sinks:
*    GoodSink: perform the authentication on the server side
*    BadSink : authentication is performed in JavaScript
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE603_Client_Side_Authentication;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE603_Client_Side_Authentication__Servlet_08 extends AbstractTestCaseServlet
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_returns_t())
        {
            StringBuilder authnScript = new StringBuilder("<script type=\"text/javascript\">");
            authnScript.append("function passWord() {");
            authnScript.append("var pass1 = prompt('Please Enter Your Password',' ');");
            authnScript.append("while (1) {");
            authnScript.append("if (!pass1)");
            authnScript.append("history.go(-1);");
            authnScript.append("if (pass1 == \"I am 4 sUp3r 53cr37 password\") {"); /* FLAW: Authentication performed in JavaScript */
            authnScript.append("window.open('admin.html');");
            authnScript.append("break;");
            authnScript.append("}");
            authnScript.append("var pass1 =");
            authnScript.append("prompt('Access Denied - Password Incorrect, Please Try Again.','Give Me The Password');");
            authnScript.append("}");
            authnScript.append("if (pass1.toLowerCase()!=\"password\" & testV == 3)");
            authnScript.append("history.go(-1);");
            authnScript.append("return \" \";");
            authnScript.append("}");
            authnScript.append("</script>");
            PrintWriter out = response.getWriter();
            out.println(authnScript.toString());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String passwd = request.getParameter("password");

            if( (passwd == null) )
            {
                response.sendRedirect("login.html");
                return;
            }
            /* FIX: Authentication performed on the server side */
            if( (passwd.equals("I am 4 sUp3r 53cr37 password")) )
            {
                response.sendRedirect("admin.html");
            }
            else
            {
                response.sendError(1, "You have entered an incorrect password.");
                response.sendRedirect("login.html");
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            StringBuilder authnScript = new StringBuilder("<script type=\"text/javascript\">");
            authnScript.append("function passWord() {");
            authnScript.append("var pass1 = prompt('Please Enter Your Password',' ');");
            authnScript.append("while (1) {");
            authnScript.append("if (!pass1)");
            authnScript.append("history.go(-1);");
            authnScript.append("if (pass1 == \"I am 4 sUp3r 53cr37 password\") {"); /* FLAW: Authentication performed in JavaScript */
            authnScript.append("window.open('admin.html');");
            authnScript.append("break;");
            authnScript.append("}");
            authnScript.append("var pass1 =");
            authnScript.append("prompt('Access Denied - Password Incorrect, Please Try Again.','Give Me The Password');");
            authnScript.append("}");
            authnScript.append("if (pass1.toLowerCase()!=\"password\" & testV == 3)");
            authnScript.append("history.go(-1);");
            authnScript.append("return \" \";");
            authnScript.append("}");
            authnScript.append("</script>");
            PrintWriter out = response.getWriter();
            out.println(authnScript.toString());
        }
        else {

            String passwd = request.getParameter("password");

            if( (passwd == null) )
            {
                response.sendRedirect("login.html");
                return;
            }
            /* FIX: Authentication performed on the server side */
            if( (passwd.equals("I am 4 sUp3r 53cr37 password")) )
            {
                response.sendRedirect("admin.html");
            }
            else
            {
                response.sendError(1, "You have entered an incorrect password.");
                response.sendRedirect("login.html");
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_returns_t())
        {
            String passwd = request.getParameter("password");
            if( (passwd == null) )
            {
                response.sendRedirect("login.html");
                return;
            }
            /* FIX: Authentication performed on the server side */
            if( (passwd.equals("I am 4 sUp3r 53cr37 password")) )
            {
                response.sendRedirect("admin.html");
            }
            else
            {
                response.sendError(1, "You have entered an incorrect password.");
                response.sendRedirect("login.html");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            StringBuilder authnScript = new StringBuilder("<script type=\"text/javascript\">");
            authnScript.append("function passWord() {");
            authnScript.append("var pass1 = prompt('Please Enter Your Password',' ');");
            authnScript.append("while (1) {");
            authnScript.append("if (!pass1)");
            authnScript.append("history.go(-1);");
            authnScript.append("if (pass1 == \"I am 4 sUp3r 53cr37 password\") {"); /* FLAW: Authentication performed in JavaScript */
            authnScript.append("window.open('admin.html');");
            authnScript.append("break;");
            authnScript.append("}");
            authnScript.append("var pass1 =");
            authnScript.append("prompt('Access Denied - Password Incorrect, Please Try Again.','Give Me The Password');");
            authnScript.append("}");
            authnScript.append("if (pass1.toLowerCase()!=\"password\" & testV == 3)");
            authnScript.append("history.go(-1);");
            authnScript.append("return \" \";");
            authnScript.append("}");
            authnScript.append("</script>");

            PrintWriter out = response.getWriter();
            out.println(authnScript.toString());

        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
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
