/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

/**
 *
 * @author d00195076
 */
//For Question 04
public class UserDetails
{
    private String name;
    private String homePhoneNumber;
    private String mobileNumber;
    private String email;
    private String skype;

    @Override
    public String toString()
    {
        return "UserDetails{" + "name=" + name + "\n homePhoneNumber=" + homePhoneNumber + "\n mobileNumber=" + mobileNumber + "\n email=" + email + "\n skype=" + skype + '}';
    }

    public UserDetails(String name, String homePhoneNumber, String mobileNumber, String email, String skype)
    {
        this.name = name;
        this.homePhoneNumber = homePhoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.skype = skype;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getHomePhoneNumber()
    {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber)
    {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSkype()
    {
        return skype;
    }

    public void setSkype(String skype)
    {
        this.skype = skype;
    }   
}