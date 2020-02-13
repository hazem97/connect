/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author HP
 */
public class User {
    private int id;
    private String nom;
    private String prenom;
    private String password;
    private String type;
    private String mail;
    private String photo;
    private int phone;

    public User(int id, String prenom,String nom, String password, String type, String mail, String photo, int phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.type = type;
        this.mail = mail;
        this.photo = photo;
        this.phone = phone;
    }

    public User(String prenom,String nom, String password, String type, String mail,int phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.type = type;
        this.mail = mail;
        this.phone = phone;
    }

    public User() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", type=" + type + ", mail=" + mail + ", photo=" + photo + ", phone=" + phone + '}';
    }  
}
