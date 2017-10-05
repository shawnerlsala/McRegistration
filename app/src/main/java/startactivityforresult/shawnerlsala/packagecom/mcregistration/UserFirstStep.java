package startactivityforresult.shawnerlsala.packagecom.mcregistration;

/**
 * Created by ShawnErl on 29/09/2017.
 */

public class UserFirstStep {
    String email;
    String phoneNum;
    String telephoneNum;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public UserFirstStep(String email, String phoneNum, String telephoneNum) {

        this.email = email;
        this.phoneNum = phoneNum;
        this.telephoneNum = telephoneNum;
    }
}
