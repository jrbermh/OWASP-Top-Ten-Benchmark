/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__connect_tcp_execute_07.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-07.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded string
* Sinks: execute
*    GoodSink: prepared sqlstatement, single
*    BadSink : untrusted parameter value to raw insert sqlstatement
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__connect_tcp_execute_07 extends AbstractTestCase
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);
                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: value of "name" taken directly from an untrusted source and inserted into a command string executed against a SQL interpreter */
                Boolean bResult = sqlstatement.execute("insert into users (status) values ('updated') where name='"+data+"'");
                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;

            try {
                /* FIX: use prepared sqlstatements */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);

                Boolean bResult = sqlstatement.execute();

                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_five==5 to private_five!=5 */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);
                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: value of "name" taken directly from an untrusted source and inserted into a command string executed against a SQL interpreter */
                Boolean bResult = sqlstatement.execute("insert into users (status) values ('updated') where name='"+data+"'");
                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;

            try {
                /* FIX: use prepared sqlstatements */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);

                Boolean bResult = sqlstatement.execute();

                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            data = ""; /* init data */

            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);

                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);

                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: value of "name" taken directly from an untrusted source and inserted into a command string executed against a SQL interpreter */
                Boolean bResult = sqlstatement.execute("insert into users (status) values ('updated') where name='"+data+"'");
                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;

            try {
                /* FIX: use prepared sqlstatements */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);

                Boolean bResult = sqlstatement.execute();

                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_five==5 to private_five!=5 */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);
                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: value of "name" taken directly from an untrusted source and inserted into a command string executed against a SQL interpreter */
                Boolean bResult = sqlstatement.execute("insert into users (status) values ('updated') where name='"+data+"'");
                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;

            try {
                /* FIX: use prepared sqlstatements */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);

                Boolean bResult = sqlstatement.execute();

                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            Socket sock = null;
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* Read data using an outbound tcp connection */
                sock = new Socket("host.example.org", 39544);
                /* read input from socket */
                instrread = new InputStreamReader(sock.getInputStream());
                buffread = new BufferedReader(instrread);
                data = buffread.readLine();
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }

                /* clean up socket objects */
                try {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing sock");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_five==5)
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            try
            {
                /* FIX: use prepared sqlstatements */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
                sqlstatement.setString(1, data);
                Boolean bResult = sqlstatement.execute();
                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            Statement sqlstatement = null;

            try {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();

                /* POTENTIAL FLAW: value of "name" taken directly from an untrusted source and inserted into a command string executed against a SQL interpreter */
                Boolean bResult = sqlstatement.execute("insert into users (status) values ('updated') where name='"+data+"'");

                if( bResult )
                {
                    IO.writeString("Name, " + data + ", updated successfully");
                }
                else
                {
                    IO.writeString("Unable to update records for user: " + data);
                }
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
