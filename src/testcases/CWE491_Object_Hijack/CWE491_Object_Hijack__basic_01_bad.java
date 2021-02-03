/*
 * @description An object implements a clone method without declaring it final, allowing the
 * possibility of an object hijack in a subclass.
 *  
 * This class contains the "bad" version of clone().  There is no need to implement
 * the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE491_Object_Hijack;

import java.util.Date;
import testcasesupport.*;

public class CWE491_Object_Hijack__basic_01_bad extends AbstractTestCaseClassIssueBad implements Cloneable 
{
	/* Just to have something to do in clone() other than return super.clone() */
	private Date testdate = new Date();
	
	/* FLAW: clone() method not declared final */
	protected Object clone() throws CloneNotSupportedException 
    {
	  CWE491_Object_Hijack__basic_01_bad obj = (CWE491_Object_Hijack__basic_01_bad) super.clone();	 
	  obj.setDate(new Date(testdate.getTime()));
	  return obj;	  
	}
	
	public void setDate(Date d) 
    {
		testdate = d;
	}
	
	public void bad() {	}
		
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
