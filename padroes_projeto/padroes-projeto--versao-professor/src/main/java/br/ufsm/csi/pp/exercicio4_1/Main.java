package br.ufsm.csi.pp.exercicio4_1;

public class Main {

    public static void main(String[] args) {
        RealDatabase database = new RealDatabase();
        SecureDatabase secureDatabase = new SecureDatabase(database);
        database.query("INSERT into usuarios ('lallala', 'lalala');");
        secureDatabase.query("INSERT into usuarios ('lallala', 'lalala');");
        secureDatabase.query("Select * from usuarios;");
        secureDatabase.authenticate("root", "senha");
        secureDatabase.query("INSERT into usuarios ('lallala', 'lalala');");
    }

}
