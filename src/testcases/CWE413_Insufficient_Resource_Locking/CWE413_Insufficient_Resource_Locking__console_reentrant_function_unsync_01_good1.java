/*
 * @description good checks for lock status before acting on shared resource.
 * 
 * */

package testcases.CWE413_Insufficient_Resource_Locking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCaseClassIssueGood;
import testcasesupport.IO;

public class CWE413_Insufficient_Resource_Locking__console_reentrant_function_unsync_01_good1
		extends AbstractTestCaseClassIssueGood 
{
	int test = 0;
	private final ReentrantLock lock = new ReentrantLock();
	
	private int good_reentrant(int inte)
	{
		/* FIX: locking done properly */
        if( lock.tryLock() ) 
        {
            try
            {
                test = inte *2;
            }
            catch(Exception e)
            {
                IO.writeLine("An error occurred when assigning test");
            }
            finally
            {
                lock.unlock();
            }
        }
		
		return test;
	}
	
	public void good() throws Throwable 
	{
		good1();
	}
	
	private void good1() throws IOException
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
	    
		IO.writeLine("" + good_reentrant(integer));
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
