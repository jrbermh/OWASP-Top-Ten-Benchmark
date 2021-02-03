/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE760_Predictable_Salt_One_Way_Hash__Environment_67b.java
Label Definition File: CWE760_Predictable_Salt_One_Way_Hash.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 760 Use of one-way hash with a predictable salt
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks:
 *    GoodSink: use a sufficiently random salt
 *    BadSink : SHA512 with a predictable salt
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE760_Predictable_Salt_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.servlet.http.*;

public class CWE760_Predictable_Salt_One_Way_Hash__Environment_67b
{

    public void bad_sink(CWE760_Predictable_Salt_One_Way_Hash__Environment_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        MessageDigest hash = MessageDigest.getInstance("SHA-512");
        hash.update(data.getBytes());  /* FLAW: SHA512 with a predictable salt */
        byte[] hashv = hash.digest("hash me".getBytes());

        IO.writeLine(IO.toHex(hashv));

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE760_Predictable_Salt_One_Way_Hash__Environment_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        MessageDigest hash = MessageDigest.getInstance("SHA-512");
        hash.update(data.getBytes());  /* FLAW: SHA512 with a predictable salt */
        byte[] hashv = hash.digest("hash me".getBytes());

        IO.writeLine(IO.toHex(hashv));

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE760_Predictable_Salt_One_Way_Hash__Environment_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        SecureRandom r = new SecureRandom();

        MessageDigest hash = MessageDigest.getInstance("SHA-512");
        hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
        byte[] hashv = hash.digest("hash me".getBytes());

        IO.writeLine(IO.toHex(hashv));

    }
}
