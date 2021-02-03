/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE367_TOC_TOU__basic_19.java
Label Definition File: CWE367_TOC_TOU__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 367 Time of Check, Time of Use
* Sinks:
*    GoodSink: open without access check
*    BadSink : access check before open
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE367_TOC_TOU;

import testcasesupport.*;

import java.io.*;

public class CWE367_TOC_TOU__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            java.util.logging.Logger log_bsnk = java.util.logging.Logger.getLogger("local-logger");

            File f = new File("testcases/CWE367_TOC_TOU/test_bad.txt"); /* may need to be adjusted depending on script */

            if (!f.canRead())
            {
                IO.writeLine("No permission to read the file!");
                return;
            }

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            FileInputStream finstr2 = null;

            String line = "";
            try
            {
                finstr2 = new FileInputStream(f);
                inread2 = new InputStreamReader(finstr2);
                bufread2 = new BufferedReader(inread2);

                /*
                * Instructions: see the TOCTOU effect
                * During delay, swap the "test_evil.txt" and "test_bad.txt" files (or contents).
                */
                /* POSSIBLE FLAW: Delay between file access check and file read */
                IO.writeLine("Intentional delay. Hit return to continue.");
                bufread2.readLine();

                while((line = bufread2.readLine()) != null)
                {
                    IO.writeLine(line);
                }
            }
            catch(IOException e)
            {
                log_bsnk.warning("Error reading from console");
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
                    log_bsnk.warning("Error closing bufread2");
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
                        log_bsnk.warning("Error closing inread2");
                    }
                    finally
                    {
                        try
                        {
                            if( finstr2 != null )
                            {
                                finstr2.close();
                            }
                        }
                        catch( IOException e )
                        {
                            log_bsnk.warning("Error closing finstr2");
                        }
                    }
                }
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            java.util.logging.Logger log_gsnk = java.util.logging.Logger.getLogger("local-logger");

            File f = new File("testcases/CWE367_TOC_TOU/test_good.txt"); /* may need to be adjusted depending on script */

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            FileInputStream finstr2 = null;

            String line = "";
            try
            {
                /* FIX: Remove delay */
                finstr2 = new FileInputStream(f);
                inread2 = new InputStreamReader(finstr2);
                bufread2 = new BufferedReader(inread2);

                while((line = bufread2.readLine()) != null)
                {
                    IO.writeLine(line);
                }
            }
            catch(IOException e)
            {
                log_gsnk.warning("Error reading from console");
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
                    log_gsnk.warning("Error closing bufread2");
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
                        log_gsnk.warning("Error closing inread2");
                    }
                    finally
                    {
                        try
                        {
                            if( finstr2 != null )
                            {
                                finstr2.close();
                            }
                        }
                        catch( IOException e )
                        {
                            log_gsnk.warning("Error closing finstr2");
                        }
                    }
                }
            }

        }
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
        {

            java.util.logging.Logger log_gsnk = java.util.logging.Logger.getLogger("local-logger");

            File f = new File("testcases/CWE367_TOC_TOU/test_good.txt"); /* may need to be adjusted depending on script */

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            FileInputStream finstr2 = null;

            String line = "";
            try
            {
                /* FIX: Remove delay */
                finstr2 = new FileInputStream(f);
                inread2 = new InputStreamReader(finstr2);
                bufread2 = new BufferedReader(inread2);

                while((line = bufread2.readLine()) != null)
                {
                    IO.writeLine(line);
                }
            }
            catch(IOException e)
            {
                log_gsnk.warning("Error reading from console");
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
                    log_gsnk.warning("Error closing bufread2");
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
                        log_gsnk.warning("Error closing inread2");
                    }
                    finally
                    {
                        try
                        {
                            if( finstr2 != null )
                            {
                                finstr2.close();
                            }
                        }
                        catch( IOException e )
                        {
                            log_gsnk.warning("Error closing finstr2");
                        }
                    }
                }
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            java.util.logging.Logger log_bsnk = java.util.logging.Logger.getLogger("local-logger");

            File f = new File("testcases/CWE367_TOC_TOU/test_bad.txt"); /* may need to be adjusted depending on script */

            if (!f.canRead())
            {
                IO.writeLine("No permission to read the file!");
                return;
            }

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            FileInputStream finstr2 = null;

            String line = "";
            try
            {
                finstr2 = new FileInputStream(f);
                inread2 = new InputStreamReader(finstr2);
                bufread2 = new BufferedReader(inread2);

                /*
                * Instructions: see the TOCTOU effect
                * During delay, swap the "test_evil.txt" and "test_bad.txt" files (or contents).
                */
                /* POSSIBLE FLAW: Delay between file access check and file read */
                IO.writeLine("Intentional delay. Hit return to continue.");
                bufread2.readLine();

                while((line = bufread2.readLine()) != null)
                {
                    IO.writeLine(line);
                }
            }
            catch(IOException e)
            {
                log_bsnk.warning("Error reading from console");
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
                    log_bsnk.warning("Error closing bufread2");
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
                        log_bsnk.warning("Error closing inread2");
                    }
                    finally
                    {
                        try
                        {
                            if( finstr2 != null )
                            {
                                finstr2.close();
                            }
                        }
                        catch( IOException e )
                        {
                            log_bsnk.warning("Error closing finstr2");
                        }
                    }
                }
            }

        }
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

