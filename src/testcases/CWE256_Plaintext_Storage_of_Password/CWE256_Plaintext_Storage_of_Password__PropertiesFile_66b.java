/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__PropertiesFile_66b.java
Label Definition File: CWE256_Plaintext_Storage_of_Password.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
 * BadSource: PropertiesFile Read data from a .properties file (from the property named data)
 * GoodSource: Read data from the console using readLine
 * Sinks: basic
 *    GoodSink: Use decrypted data as password to connect to DB
 *    BadSink : Use data as password to connect to DB
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE256_Plaintext_Storage_of_Password;

import testcasesupport.*;

import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.SQLException;

public class CWE256_Plaintext_Storage_of_Password__PropertiesFile_66b
{

    public void bad_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        /* POTENTIAL FLAW: direct retrieval of plaintext password */
        Connection conn2 = null;
        try
        {
            conn2 = DriverManager.getConnection("192.168.105.23", "sa", data);
        }
        catch(SQLException se)
        {
            log2.warning("error getting database connection");
        }
        finally
        {
            try
            {
                if( conn2 != null )
                {
                    conn2.close();
                }
            }
            catch( SQLException se )
            {
                log2.warning("error closing conn2");
            }
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        /* POTENTIAL FLAW: direct retrieval of plaintext password */
        Connection conn2 = null;
        try
        {
            conn2 = DriverManager.getConnection("192.168.105.23", "sa", data);
        }
        catch(SQLException se)
        {
            log2.warning("error getting database connection");
        }
        finally
        {
            try
            {
                if( conn2 != null )
                {
                    conn2.close();
                }
            }
            catch( SQLException se )
            {
                log2.warning("error closing conn2");
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        InputStreamReader inread2 = null;
        BufferedReader bufread2 = null;
        Connection conn2 = null;

        try
        {
            /* Get encrypted password and decrypt it using key read from the console */
            /* Assume pw was encrypted using a secret passphrase and AES */
            inread2 = new InputStreamReader(System.in);
            bufread2 = new BufferedReader(inread2);
            String sKey = bufread2.readLine();
            SecretKeySpec key = new SecretKeySpec(sKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");

            cipher.init(Cipher.DECRYPT_MODE, key);

            /* FIX: password is stored encrypted */
            String pw = new String(cipher.doFinal(data.getBytes()));

            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", pw);
            }
            catch(SQLException se)
            {
                log2.warning("error getting database connection");
            }
            finally
            {
                try
                {
                    if( conn2 != null )
                    {
                        conn2.close();
                    }
                }
                catch( SQLException se )
                {
                    log2.warning("error closing conn2");
                }
            }
        }
        catch( IOException e )
        {
            log2.warning("Error reading streams");
        }
        finally
        {
            try
            {
                if( bufread2 != null )
                {
                    bufread2.close();
                }
            }
            catch( IOException e )
            {
                log2.warning("Error closing bufread2");
            }
            finally
            {
                try
                {
                    if( inread2 != null )
                    {
                        inread2.close();
                    }
                }
                catch( IOException e )
                {
                    log2.warning("Error closing inread2");
                }
            }
        }

    }
}
