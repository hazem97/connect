/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import Entity.Staff;
import Entity.User;
import Service.StaffService;
import Service.UserService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class gestion {
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, SQLException {
        // TODO code application logic here
//    DataSource ds=DataSource.getInstance();
//     DataSource ds1=DataSource.getInstance();
//      DataSource ds2=DataSource.getInstance();
//        System.out.println(ds);
//        System.out.println(ds1);
//        System.out.println(ds2);

User u=new User("kalboussi","hazem2","hazem123","admin","kalboussihazem07@gmail.com",25142394);
User u2=new User("hamoudi","bilel","bilel123","agent financier","bilel.57@gmail.com",20250341);

UserService ps=new UserService();
//ps.insert(u);
//ps.Insertps(u2);
//ps.delete(u);
//ps.update(u);
ps.search(8).forEach(System.out::println);
System.out.println(ps.displayAll2());
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
Date date = simpleDateFormat.parse("25/12/2010");
//System.out.println(date);
Date date1 = simpleDateFormat.parse("25/12/2019");

Staff s=new Staff("sami","mhamdi",1250.f,"ouvrier","25dzd6522",200.f,date);
Staff s1=new Staff("salah","aloui",1200.f,"ouvrier","25dzdfd6522",100.f,date1);

StaffService ss=new StaffService();
//ss.insert(s1);
//ss.delete();
System.out.println(ss.search());
System.out.println(ss.displayAll2());
System.out.println(ss.moyenne());
        
    } 
}
    

