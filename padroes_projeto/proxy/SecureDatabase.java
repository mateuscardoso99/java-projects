package br.ufsm.csi.pp.exercicio4_1;

public class SecureDatabase implements Database {

    private RealDatabase database;
    private boolean autenticado = false;

    public SecureDatabase(RealDatabase database) {
        this.database = database;
    }

    @Override
    public String query(String sql) {
        if (autenticado || sql.trim().toLowerCase().startsWith("select")) {
            System.out.println(sql + " AUTORIZADO");
            return database.query(sql);
        } else {
            System.out.println(sql + "SQL> NAO AUTORIZADO");
            return null;
        }
    }

    @Override
    public void authenticate(String username, String password) {
        if (username.equals("root") && password.equals("senha")) {
            autenticado = true;
        } else {
            autenticado = false;
        }
        database.authenticate(username, password);
    }
}
