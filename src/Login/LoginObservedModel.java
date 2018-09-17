package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

public class LoginObservedModel {
	 private Utente theModel;
	 public LoginObservedModel(Utente m){
		 theModel= m;
		 }

	 public String getID() {
		 String id=theModel.getID();
		 return id;
	 }
	 
	 public String getpassw() {
		 String p=theModel.getpassw();
		 return p;
	 }
	 
	 public void setID(String i) {
		 theModel.setID(i);
	 }
	 public void setpassw(String i) {
		 theModel.setpassw(i);
	 }

}
