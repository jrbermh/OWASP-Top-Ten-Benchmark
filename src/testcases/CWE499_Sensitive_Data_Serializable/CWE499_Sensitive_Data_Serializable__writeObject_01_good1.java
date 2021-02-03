/*
 * @description An object contains sensitive data but does not explicitly
 * prohibit serialization, allowing it to be serialized through another class
 *  
 * This class contains the "good" version, which prohibits serialization by
 * overriding the function writeObject.  
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE499_Sensitive_Data_Serializable;

import java.sql.*;
import java.io.*;
import testcasesupport.*;

public class CWE499_Sensitive_Data_Serializable__writeObject_01_good1 extends AbstractTestCaseClassIssueGood
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

    /* FIX: writeObject() method implemented to deny serialization attempts */
    private final void writeObject(ObjectOutputStream out) throws IOException 
    {
        throw new NotSerializableException();
    }

    private void good1() { }
    
    public void good() 
    {
        good1();
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
