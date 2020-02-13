/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Staff;
import Entity.User;
import connexion.DataSource;
import connexion.image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author HP
 */
public class StaffService implements IService<Staff>{
    
private Connection cnx;
private Statement st;
private PreparedStatement pst;
private ResultSet rs;
    public StaffService() {
    cnx=DataSource.getInstance().getCon();
    }

    @Override
    public void insert(Staff t) {
        image img=new image();
img.filen();
String pth=img.getp();
if(pth==null)
{
    System.out.println("qsf");
}
else
{
    t.setPath(pth);
    java.sql.Date date_sql = new java.sql.Date(t.getDate().getTime());
         String req="insert into staff (firstname,lastname,pathImg,salary,post,rib,prime,statut,Date_deb_trav) values ('"+t.getPrenom()+"','"+t.getNom()+"','"+t.getPath()+"','"+t.getSalary()+"','"+t.getPost()+"','"+t.getRib()+"','"+t.getPrime()+"',1,'"+date_sql+"')";
    try
    {
        st=cnx.createStatement();
        st.executeUpdate(req);
            }
        
       catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
       }
}
    }

    @Override
    public boolean update(Staff t) {
    String req="UPDATE staff SET statut='"+t.getStatut()+"' WHERE firstname='"+t.getPrenom()+"' and lastname='"+t.getNom()+"'";
try
    {
        st=cnx.createStatement();
        st.executeUpdate(req);
       return true;       
    }
        
       catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
return false;
    }

    
    public boolean delete() {
    String req="DELETE FROM staff WHERE year(NOW())-year(Date_deb_trav) <= 3";
try
    {
        st=cnx.createStatement();
        st.executeUpdate(req);
       return true;       
    }
        
       catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
return false;
    }

    @Override
    public List<Staff> displayAll() {
String red="select * from staff";
    List<Staff> list=new ArrayList<>();
    try {
        st=cnx.createStatement();
        rs=st.executeQuery(red);
        while(rs.next()){
           list.add(new Staff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getFloat(8),rs.getInt(9),rs.getDate(10)));
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }

    @Override
    public Map<Integer, List<Staff>> displayAll2() {
     return displayAll().stream().collect(Collectors.groupingBy(e->e.getId()));
    }

    
    public List<Staff> search() {
 String req="select * from staff where year(NOW())-year(Date_deb_trav) <= 3";
     List<Staff> list=new ArrayList<>();
     try {
        st=cnx.createStatement();
        rs=st.executeQuery(req);
         while (rs.next()) {
            list.add(new Staff(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6),rs.getString(7),rs.getFloat(8),rs.getInt(9),rs.getDate(10)));
        }
     }catch(Exception e)
     {
                 Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);

     }
return list;
    }

    @Override
    public List<Staff> search(int t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Staff t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public ResultSet moyenne()
{
    try {
        String req="select AVG(salary) from staff ";
        st=cnx.createStatement();
        rs=st.executeQuery(req);
    } catch (SQLException ex) {
        Logger.getLogger(StaffService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return rs;
    
}
}