package br.ufsm.csi.pp.exercicio4_1;

public interface Database {
    String query(String sql);
    void authenticate(String username, String password);
}
