/*
* @description Helper IO class
* 
* */
package testcasesupport;

import java.io.*;
import java.sql.*;
import java.util.regex.*;

public class IO { 
	
	/* fill in these parameters if you want to be able to actually connect
	* to a database
	*/
	private static final String dbUrl = "";
	private static final String dbUsername = "";
	private static final String dbPassword = "";
	
	public static void writeString(String s) {
		System.out.print(s);
	}

	public static void writeLine(String s) {
		System.out.println(s);
	}

	public static void writeLine(int i) {
		writeLine(String.format("%02d", i));
	}

	public static void writeLine(long l) {
		writeLine(String.format("%02d", l));
	}

	public static void writeLine(double d) {
		writeLine(String.format("%02f", d));
	}

	public static void writeLine(float f) {
		writeLine(String.format("%02f", f));
	}

	public static void writeLine(byte b) {
		writeLine(String.format("%02x", b));
	}
	
	/* use this method to get a database connection for use in SQL 
	* Injection and other test cases that use a database.
	*/
	public static Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, dbUsername, dbPassword); 
	}
	
	/* The variables below are declared "final", so a tool doing whole
	program analysis should be able to identify that reads of these 
	will always return their initialized values. */
	public static final boolean static_final_t = true;
	public static final boolean static_final_f = false;
	public static final int static_final_five = 5;
	
	/* The variables below are not defined as "final", but are never
	assigned any other value, so a tool doing whole program analysis
	should be able to identify that reads of these will always return 
	their initialized values. */
	public static boolean static_t = true;
	public static boolean static_f = false;
	public static int static_five = 5;
	
	public static boolean static_returns_t() {
		return true;
	}
	
	public static boolean static_returns_f() {
		return false;
	}
	
	public static boolean static_returns_t_or_f() {
		return (new java.util.Random()).nextBoolean();
	}

	/* Turns array of bytes into string.  Taken from:
	http://java.sun.com/developer/technicalArticles/Security/AES/AES_v1.html */
	public static String toHex (byte buf[]) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		int i;

		for (i = 0; i < buf.length; i++) {
			if (((int) buf[i] & 0xff) < 0x10)
			strbuf.append("0");

			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}

		return strbuf.toString();
	}
}
