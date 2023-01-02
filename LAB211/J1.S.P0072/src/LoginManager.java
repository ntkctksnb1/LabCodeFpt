
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class LoginManager {

    private ArrayList<UserInformation> account = new ArrayList<>();

    public LoginManager() {
    }

    public ArrayList getAccount() {
        return account;
    }

    public int addAccount(String username, String password, String name,
            String phone, String email, String address, String dob) throws Exception {
        account.add(new UserInformation(username, password, name, phone, email, address, dob));
    }

    public void inputAccount() {
        Scanner scan = new Scanner(System.in);
        System.out.println("=============== Add User ===============");
        System.out.print("Account : ");
        String sAccount = scan.next();
        System.out.print("pwd : ");
        String sPwd = scan.next();
        System.out.print("Name : ");
        String sName = scan.next();
        System.out.print("Phone : ");
        String sPhone = scan.next();
        System.out.print("Email : ");
        String sEmail = scan.next();
        System.out.print("Address : ");
        String sAddress = scan.next();
        System.out.print("Date of birth : ");
        String sDoB = scan.next();

        account.add(new UserInformation(sAccount, sPwd, sName,
                sPhone, sEmail, sAddress, sDoB));
    }
}
