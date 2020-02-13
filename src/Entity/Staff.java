/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Staff {
private int id;
private String nom;
private String prenom ;
private String path;
private float salary;
private String rib;
private String post;
private float prime;
private int statut;
private Date date;

    public Staff(int id, String nom, String prenom, String path, float salary, String rib, String post, float prime, int statut, Date date) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.path = path;
        this.salary = salary;
        this.rib = rib;
        this.post = post;
        this.prime = prime;
        this.statut = statut;
        this.date = date;
    }

    public Staff(String nom, String prenom, String path, float salary, String rib, String post, float prime, int statut, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.path = path;
        this.salary = salary;
        this.rib = rib;
        this.post = post;
        this.prime = prime;
        this.statut = statut;
        this.date = date;
    }

    public Staff(String nom, String prenom, float salary, String rib, String post, float prime, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.salary = salary;
        this.rib = rib;
        this.post = post;
        this.prime = prime;
        this.date = date;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public float getPrime() {
        return prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", path=" + path + ", salary=" + salary + ", rib=" + rib + ", post=" + post + ", prime=" + prime + ", statut=" + statut + ", date=" + date + '}';
    }



}
