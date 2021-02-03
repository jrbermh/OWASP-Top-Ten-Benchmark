/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Access_Through_SQL_Primary__Servlet_03.java
Label Definition File: CWE566_Access_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sinks-03.tmpl.java
*/
/*
* @description
* CWE: 566 Access through SQL primary
* BadSource:  user id taken from url parameter
* GoodSource: hardcoded user id
* Sinks: writeConsole
*    GoodSink: user permissions checked
*    BadSink : user authorization not checked
* Flow Variant: 03 Control flow: if(5==5) and if(5!=5)
*
* */

package testcases.CWE566_Access_Through_SQL_Primary;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.security.*;

public class CWE566_Access_Through_SQL_Primary__Servlet_03 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(5==5)
        {
            data = request.getParameter("id");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "10";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(5==5)
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
        }
        else {
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

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first 5==5 to 5!=5 */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(5!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = request.getParameter("id");
        }
        else {

            data = "10";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(5==5)
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
        }
        else {
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

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(5==5)
        {
            data = "10";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = request.getParameter("id");

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(5==5)
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
        }
        else {
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

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second 5==5 to 5!=5 */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(5==5)
        {
            data = request.getParameter("id");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "10";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(5!=5)
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
        }
        else {

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

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(5==5)
        {
            data = request.getParameter("id");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            data = "10";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(5==5)
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
        }
        else {
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
