package decorator;

public class DatabaseService{
    public String getMailFromUsername(String username) {
        return username + "@Mail";
    }

    public String getPhoneNbrFromUsername(String username) {
        return username + "@Phone";
    }

    public String getFBNameFromUsername(String username) {
        return username + "@Facebook";
    }
}