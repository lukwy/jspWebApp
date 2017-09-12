package pl.imsi;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		Connect c = new Connect();		
		c.InsertUser("test", "test", "test", "test");
	}
}
