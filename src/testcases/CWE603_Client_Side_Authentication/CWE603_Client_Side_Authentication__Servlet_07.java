/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE603_Client_Side_Authentication__Servlet_07.java
Label Definition File: CWE603_Client_Side_Authentication__Servlet.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 603 Use of client-side authentication
* Sinks:
*    GoodSink: perform the authentication on the server side
*    BadSink : authentication is performed in JavaScript
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE603_Client_Side_Authentication;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE603_Client_Side_Authentication__Servlet_07 extends AbstractTestCaseServlet
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_five==5)
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

    /* good1() changes private_five==5 to private_five!=5 */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_five!=5)
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
        if(private_five==5)
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
