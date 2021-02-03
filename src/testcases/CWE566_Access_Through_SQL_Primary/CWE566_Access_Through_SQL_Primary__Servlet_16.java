/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Access_Through_SQL_Primary__Servlet_16.java
Label Definition File: CWE566_Access_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 566 Access through SQL primary
* BadSource:  user id taken from url parameter
* GoodSource: hardcoded user id
* Sinks: writeConsole
*    GoodSink: user permissions checked
*    BadSink : user authorization not checked
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE566_Access_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.security.*;

public class CWE566_Access_Through_SQL_Primary__Servlet_16 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = "10";
            break;
        }

        while(true)
        {
            data = request.getParameter("id");
            break;
        }

        while(true)
        {
            Connection conn2 = IO.getDBConnection();
            PreparedStatement statement = conn2.prepareStatement("select * from invoices where uid=?");
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }
            statement.setInt(1, id);
            try
            {
                ResultSet rs = statement.executeQuery();
                /* FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
            }
            statement.close();
            conn2.close();
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Connection conn2 = IO.getDBConnection();
            Permissions perms = new Permissions();
            /* setup permissions for all users */
            int allowed_invoices[] = new int[] {1, 2, 3, 10, 15, 100};
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }
            try
            {
                boolean hasPriv = false;
                for( int i = 0; i < allowed_invoices.length; ++i )
                {
                    if( allowed_invoices[i] == id )
                    {
                        hasPriv = true;
                    }
                }
                /* FIX: check to see whether the user has privileges to view the data */
                if( !hasPriv )
                {
                    IO.writeString("good() - you are not privileged to see that invoice");
                    return;
                }
                PreparedStatement statement = conn2.prepareStatement("select * from invoices where uid=?");
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                statement.close();
                conn2.close();
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
                return;
            }
            IO.writeString("good() - result requested: " + data +"\n");
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
            data = "10";
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = request.getParameter("id");
            break;
        }

        while(true)
        {
            Connection conn2 = IO.getDBConnection();
            PreparedStatement statement = conn2.prepareStatement("select * from invoices where uid=?");
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }
            statement.setInt(1, id);
            try
            {
                ResultSet rs = statement.executeQuery();
                /* FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
            }
            statement.close();
            conn2.close();
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Connection conn2 = IO.getDBConnection();
            Permissions perms = new Permissions();
            /* setup permissions for all users */
            int allowed_invoices[] = new int[] {1, 2, 3, 10, 15, 100};
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }
            try
            {
                boolean hasPriv = false;
                for( int i = 0; i < allowed_invoices.length; ++i )
                {
                    if( allowed_invoices[i] == id )
                    {
                        hasPriv = true;
                    }
                }
                /* FIX: check to see whether the user has privileges to view the data */
                if( !hasPriv )
                {
                    IO.writeString("good() - you are not privileged to see that invoice");
                    return;
                }
                PreparedStatement statement = conn2.prepareStatement("select * from invoices where uid=?");
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                statement.close();
                conn2.close();
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
                return;
            }
            IO.writeString("good() - result requested: " + data +"\n");
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = "10";
            break;
        }

        while(true)
        {
            data = request.getParameter("id");
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Connection conn2 = IO.getDBConnection();
            PreparedStatement statement = conn2.prepareStatement("select * from invoices where uid=?");
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }
            statement.setInt(1, id);
            try
            {
                ResultSet rs = statement.executeQuery();
                /* FLAW: no check to see whether the user has privileges to view the data */
                IO.writeString("bad() - result requested: " + data +"\n");
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
            }
            statement.close();
            conn2.close();
            break;
        }

        while(true)
        {
            Connection conn2 = IO.getDBConnection();
            Permissions perms = new Permissions();
            /* setup permissions for all users */
            int allowed_invoices[] = new int[] {1, 2, 3, 10, 15, 100};
            int id = 0;
            try
            {
                id = Integer.parseInt(data);
            }
            catch( NumberFormatException nfx )
            {
                id = -1; /* Assuming this id does not exist */
            }
            try
            {
                boolean hasPriv = false;
                for( int i = 0; i < allowed_invoices.length; ++i )
                {
                    if( allowed_invoices[i] == id )
                    {
                        hasPriv = true;
                    }
                }
                /* FIX: check to see whether the user has privileges to view the data */
                if( !hasPriv )
                {
                    IO.writeString("good() - you are not privileged to see that invoice");
                    return;
                }
                PreparedStatement statement = conn2.prepareStatement("select * from invoices where uid=?");
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                statement.close();
                conn2.close();
            }
            catch( SQLException sx )
            {
                IO.writeLine("Error executing query()");
                return;
            }
            IO.writeString("good() - result requested: " + data +"\n");
            break;
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
