/*
 * @description An object contains sensitive data but does not explicitly
 * prohibit serialization, allowing it to be serialized through another class
 *  
 * This class contains the "bad" version, which does not prohibit serialization.  
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE499_Sensitive_Data_Serializable;

import java.sql.*;
import java.io.*;
import testcasesupport.*;

public class CWE499_Sensitive_Data_Serializable__writeObject_01_bad extends AbstractTestCaseClassIssueBad
{

    /* Sensitive fields */
    private int bank_account_number;
    private int account_balance;

    protected void setAccount(int account)
    {
        bank_account_number = account;
    }
	
    protected int getBalance() 
    {
        return account_balance;
    }

    protected void withdraw(String password_hash, float amount) throws SQLException 
    {
        DriverManager.getConnection("192.168.39.10", "sa", password_hash);
        /* etc */
    }
	
    /* FLAW: Because writeObject() is not implemented, this class can be serialized in unexpected ways */
  
    public void bad() { }

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
