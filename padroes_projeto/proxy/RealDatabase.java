package br.ufsm.csi.pp.exercicio4_1;

public class RealDatabase implements Database {
    @Override
    public String query(String sql) {
        System.out.println("SQL> " + sql);
        return "";
    }

    @Override
    public void authenticate(String username, String password) {
        System.out.println("SQL> AUTH " + username + "/" + password);
    }
}
