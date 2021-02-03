/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Unsafe_Treatment_of_XPath_Input__getQueryStringServlet_68b.java
Label Definition File: CWE643_Unsafe_Treatment_of_XPath_Input.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 643 Unsafe Treatment of XPath Input
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded string
 * Sinks: unvalidatedXPath
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE643_Unsafe_Treatment_of_XPath_Input;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.io.*;
import javax.xml.xpath.*;
import javax.servlet.http.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

public class CWE643_Unsafe_Treatment_of_XPath_Input__getQueryStringServlet_68b
{

    public void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE643_Unsafe_Treatment_of_XPath_Input__getQueryStringServlet_68a.data;

        final String xmldoc = "\\src\\testcases\\CWE643_Unsafe_Treatment_of_XPath_Input\\console_to_evaluate\\CWE643_Unsafe_Treatment_of_XPath_Input__helper.xml";

        /* assume username||password as source */
        String [] tokens = data.split("||");
        if( tokens.length < 2 )
        {
            return;
        }
        String uname = tokens[0];
        String pword = tokens[1];

        /* build xpath */
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource inxml = new InputSource(xmldoc);
        /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
         * 	The user input should be canonicalized before validation.
         */
        /* FLAW: user input is used without validate */
        String query = "//users/user[name/text()='" + uname +
        "' and pass/text()='" + pword + "']" +
        "/secret/text()";
        String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE643_Unsafe_Treatment_of_XPath_Input__getQueryStringServlet_68a.data;

        final String xmldoc = "\\src\\testcases\\CWE643_Unsafe_Treatment_of_XPath_Input\\console_to_evaluate\\CWE643_Unsafe_Treatment_of_XPath_Input__helper.xml";

        /* assume username||password as source */
        String [] tokens = data.split("||");
        if( tokens.length < 2 )
        {
            return;
        }
        String uname = tokens[0];
        String pword = tokens[1];

        /* build xpath */
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource inxml = new InputSource(xmldoc);
        /* INCIDENTAL: CWE180 Incorrect Behavior Order: Validate Before Canonicalize
         * 	The user input should be canonicalized before validation.
         */
        /* FLAW: user input is used without validate */
        String query = "//users/user[name/text()='" + uname +
        "' and pass/text()='" + pword + "']" +
        "/secret/text()";
        String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE643_Unsafe_Treatment_of_XPath_Input__getQueryStringServlet_68a.data;

        final String xmldoc = "\\src\\testcases\\CWE643_Unsafe_Treatment_of_XPath_Input\\console_to_evaluate\\CWE643_Unsafe_Treatment_of_XPath_Input__helper.xml";

        /* assume username||password as source */
        String [] tokens = data.split("||");
        if( tokens.length < 2 )
        {
            return;
        }

        /* FIX: validate input using StringEscapeUtils */
        String uname = StringEscapeUtils.escapeXml(tokens[0]);
        String pword = StringEscapeUtils.escapeXml(tokens[1]);

        /* build xpath */
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource inxml = new InputSource(xmldoc);

        String query = "//users/user[name/text()='" + uname +
        "' and pass/text()='" + pword + "']" +
        "/secret/text()";
        String secret = (String)xp.evaluate(query, inxml, XPathConstants.STRING);

    }
}
