/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DangNhap;

/**
 *
 * @author ADMIN
 */
public class account {
    private String email, ho, ten, password;

    public account(String email, String ho, String ten, String password) {
        this.email = email;
        this.ho = ho;
        this.ten = ten;
        this.password = password;
    }
    
    public account() {
        this.email = new String();
        this.ho = new String();
        this.ten = new String();
        this.password = new String();
    }

    public String getEmail() {
        return email;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void information(){
        System.out.println("Email: "+email);
        System.out.println(ho+" "+ten);
    }

    @Override
    public String toString() {
        return "account " + "email: " + email + ", Ho: " + ho + ", Ten: " + ten + ", password=" + password;
    }
    
}
