/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

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
public class UserService  implements IService<User> {
private Connection cnx;
private Statement st;
private PreparedStatement pst;
private ResultSet rs;
    public UserService(){
        cnx=DataSource.getInstance().getCon();
        
    }



public void Insertps(User u)
{
     image img=new image();
img.filen();
String pth=img.getp();
if(pth==null)
{
    System.out.println("qsf");
}
else
{
    u.setPhoto(pth);
}
      String req="insert into user (FirstName_U,LastName_U,Password,UserType,Email,Photo,Phone_Number) values (?,?,?,?,?,?,?)";   
          try
    {
        pst=cnx.prepareStatement(req);
        pst.setString(1, u.getPrenom());
        pst.setString(2, u.getNom());
        pst.setString(3, u.getPassword());
        pst.setString(4, u.getType());
        pst.setString(5, u.getMail());
        pst.setString(6, u.getPhoto());
        pst.setInt(7, u.getPhone());
        pst.executeUpdate();
            }
        
       catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
        }


    @Override
    public boolean update(User t) {
String req="UPDATE user SET LastName_U='"+t.getNom()+"' WHERE FirstName_U='"+t.getPrenom()+"' ";
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
    public boolean delete(User t) {
      String req="DELETE FROM user WHERE FirstName_U='"+t.getPrenom()+"' ";
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
    public List<User> displayAll() {
    String red="select * from user";
    List<User> list=new ArrayList<>();
    try {
        st=cnx.createStatement();
        rs=st.executeQuery(red);
        while(rs.next()){
            list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }

    @Override
    public Map<Integer, List<User>> displayAll2() {
     return displayAll().stream().collect(Collectors.groupingBy(e->e.getId()));
    }

    @Override
    public void insert(User u) {
        image img=new image();
img.filen();
String pth=img.getp();
if(pth==null)
{
    System.out.println("qsf");
}
else
{
    u.setPhoto(pth);

          String req="insert into user (FirstName_U,LastName_U,Password,UserType,Email,Photo,Phone_Number) values ('"+u.getPrenom()+"','"+u.getNom()+"','"+u.getPassword()+"','"+u.getType()+"','"+u.getMail()+"','"+u.getPhoto()+"','"+u.getPhone()+"')";
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
    public List<User> search(int t) {
     String req="select * from user where IDU='"+t+"'";
     List<User> list=new ArrayList<>();
     try {
        st=cnx.createStatement();
        rs=st.executeQuery(req);
         while (rs.next()) {
            list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
        }
     }catch(Exception e)
     {
                 Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);

     }
return list;
    }
}
