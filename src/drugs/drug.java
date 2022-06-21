/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugs;

import java.util.logging.Logger;

public class drug {
 private String  P_Name;
 private String p_Category;
 private int P_Quantity;

    public String getP_Name() {
        return P_Name;
    }

    public String getP_Category() {
        return p_Category;
    }

    public int getP_Quantity() {
        return P_Quantity;
    }

    public void setP_Name(String P_Name) {
        this.P_Name = P_Name;
    }

    public void setP_Category(String p_Category) {
        this.p_Category = p_Category;
    }

    public void setP_Quantity(int P_Quantity) {
        this.P_Quantity = P_Quantity;
    }

    public drug(String P_Name, String p_Category, int P_Quantity) {
        this.P_Name = P_Name;
        this.p_Category = p_Category;
        this.P_Quantity = P_Quantity;
    }
    

   
}
