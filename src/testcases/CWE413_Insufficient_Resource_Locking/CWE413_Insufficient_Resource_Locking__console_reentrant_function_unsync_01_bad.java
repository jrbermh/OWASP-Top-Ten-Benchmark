/*
 * @description bad does not check lock status before acting on shared resource.
 * 
 * */

package testcases.CWE413_Insufficient_Resource_Locking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import testcasesupport.AbstractTestCaseClassIssueBad;
import testcasesupport.IO;

import java.util.concurrent.locks.ReentrantLock;

public class CWE413_Insufficient_Resource_Locking__console_reentrant_function_unsync_01_bad
		extends AbstractTestCaseClassIssueBad 
{
	int test = 0;
	private final ReentrantLock lock = new ReentrantLock();

	private int bad_reentrant(int inte) /* FLAW: does not check status of lock attempt */
	{
        lock.tryLock();
		test = inte * 2;
        lock.unlock();
		return test;
	}
	
	public void bad() throws Throwable 
	{
        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;
        String convertme = "";
        
        try
        {
            inread2 = new InputStreamReader(System.in);
            bufread2 = new BufferedReader(inread2);
            convertme = bufread2.readLine();
	    }
        catch(Exception e)
        {
            log2.warning("Error reading console");
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
        
	    int integer = 0;
	    try
	    {
	    	integer = Integer.parseInt(convertme);
	    }
	    catch(Exception e)
	    {
	    	IO.writeLine("Error, thats not a number");
	    	return;
	    }
	    
		IO.writeLine("" + bad_reentrant(integer));
	}

	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		mainFromParent(args);
	}

}
