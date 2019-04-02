/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

/**
 *
 * @author Computer
 */
public class Sentencies {
    public static String AddAccured="INSERT INTO Person("
                           +"PeopleRegistrationID,"
                           +"FullNamePerson,"
                           +"TypePerson,"
                            +"crimecaseno)"
                           +"VALUES (?,?,?,?)";
    
    public static String ListAccured="Select * FROM Person";
    public static String Update="UPDATE Person set";
    private String fullname;
    private String PeopleRegistrationID;
    private String Age;
    private String TypePerson;
    private String FullNamePerson;
    private String crimecaseno;

    public String getCrimecaseno() {
        return crimecaseno;
    }

    public void setCrimecaseno(String crimecaseno) {
        this.crimecaseno = crimecaseno;
    }
    
    public String getFullNamePerson() {
        return FullNamePerson;
    }

    public void setFullNamePerson(String FullNamePerson) {
        this.FullNamePerson = FullNamePerson;
    }
    
    public String getTypePerson() {
        return TypePerson;
    }

    public void setTypePerson(String TypePerson) {
        this.TypePerson = TypePerson;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPeopleRegistrationID() {
        return PeopleRegistrationID;
    }

    public void setPeopleRegistrationID(String PeopleRegistrationID) {
        this.PeopleRegistrationID = PeopleRegistrationID;
    }
    
    
}
