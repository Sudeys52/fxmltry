/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campanyreg;

/**
 *
 * @author wku-cslab1
 */
public class NewClass {
   private String C_Name;
 private String Country;
 private String E_Mail;
 private int C_No;
 private String Address;

    public void setC_Name(String C_Name) {
        this.C_Name = C_Name;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setE_Mail(String E_Mail) {
        this.E_Mail = E_Mail;
    }

    public void setC_No(int C_No) {
        this.C_No = C_No;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getC_Name() {
        return C_Name;
    }

    public String getCountry() {
        return Country;
    }

    public String getE_Mail() {
        return E_Mail;
    }

    public int getC_No() {
        return C_No;
    }

    public String getAddress() {
        return Address;
    }

    public NewClass(String C_Name, String Country, String E_Mail, int C_No, String Address) {
        this.C_Name = C_Name;
        this.Country = Country;
        this.E_Mail = E_Mail;
        this.C_No = C_No;
        this.Address = Address;
    }  
        
}
