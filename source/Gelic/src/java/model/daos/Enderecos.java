/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.naming.NamingException;

/**
 *
 * @author Adriano
 */
public class Enderecos {

    public static ArrayList<model.beans.TipoLogradouro> recuperar() throws NamingException, SQLException {
        final String sqlRecuperaTipos = "select TIPO from TIPOSLOGRADOUROS";
        final String sqlContaTipos = "select count(*) from TIPOSLOGRADOUROS";

        Connection gelic = model.services.Conexao.getPool().getConnection();
        PreparedStatement pstmt = gelic.prepareStatement(sqlContaTipos);
        ResultSet rs = pstmt.executeQuery();
        int quantidadeTipos = 0;
        if (rs != null && rs.next()){
            quantidadeTipos = rs.getInt(1);
            rs.close();
        }
        pstmt.close();
        if( quantidadeTipos < 1 ){
            gelic.close();
            return null;
        }
        pstmt = gelic.prepareStatement(sqlRecuperaTipos);
        rs = pstmt.executeQuery();
        ArrayList<model.beans.TipoLogradouro> tipos = 
                new ArrayList<model.beans.TipoLogradouro>( quantidadeTipos );
        while( rs.next()){
            tipos.add(cria(rs.getString(1))); 
        }
        return tipos;
    }
    static private model.beans.TipoLogradouro cria( String nome ){
        model.beans.TipoLogradouro tipo = new model.beans.TipoLogradouro();
        tipo.setNome(nome);
        return tipo;
    }
    public static void recuperar(ArrayList<model.beans.Empresa> empresas)
            throws NamingException, SQLException {

        final String sqlRecuperaEnderecosEmpresas =
                "select CNPJ, TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, " +
                "MUNICIPIO, UF, CEP, SITE, EMAIL " +
                "from ENDERECOS inner join EMPRESAS " +
                "on (EMPRESAS.ENDERECO = ENDERECOS.ID)";

        HashMap<String, model.beans.Empresa> map =
                new HashMap<String, model.beans.Empresa>();
        for (model.beans.Empresa empresa : empresas) {
            map.put(empresa.getCnpj(), empresa);
        }

        Connection gelic = model.services.Conexao.getPool().getConnection();
        PreparedStatement pstmt = gelic.prepareStatement(
                sqlRecuperaEnderecosEmpresas);
        ResultSet rs = pstmt.executeQuery();

        model.beans.Empresa empresa;





        while (rs != null && rs.next()) {
            String cnpj = rs.getString("CNPJ");
            empresa = map.get(cnpj);
            if (empresa != null) {
                empresa.setEndereco(cria(
                        rs.getString("TIPO"),
                        rs.getString("LOGRADOURO"),
                        rs.getString("NUMERO"),
                        rs.getString("COMPLEMENTO"),
                        rs.getString("BAIRRO"),
                        rs.getString("MUNICIPIO"),
                        rs.getString("UF"),
                        rs.getString("CEP"),
                        rs.getString("SITE"),
                        rs.getString("EMAIL")));
            }
        }
        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         */

        rs.close();

        pstmt.close();

        gelic.close();
    }
    private static final String sqlRecuperaEnderecoEmpresa =
            "select TIPO, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO, " +
            "UF, CEP, SITE, EMAIL from enderecos where id = " +
            "(select endereco from empresas where cnpj=? )";

    public static void recuperar(model.beans.Empresa empresa)
            throws NamingException, SQLException {
        Connection gelic = model.services.Conexao.getPool().getConnection();
        PreparedStatement pstmt = gelic.prepareStatement(
                sqlRecuperaEnderecoEmpresa);
        pstmt.setString(1, empresa.getCnpj());
        ResultSet rs = pstmt.executeQuery();
        if (rs != null && rs.next()) {
            empresa.setEndereco(cria(
                    rs.getString("TIPO"),
                    rs.getString("LOGRADOURO"),
                    rs.getString("NUMERO"),
                    rs.getString("COMPLEMENTO"),
                    rs.getString("BAIRRO"),
                    rs.getString("MUNICIPIO"),
                    rs.getString("UF"),
                    rs.getString("CEP"),
                    rs.getString("SITE"),
                    rs.getString("EMAIL")));
        }
        /*
         * Para aproveitar a conexão no pool é necessário fechar tudo...
         */

        rs.close();
        pstmt.close();
        gelic.close();
    }

    private static model.beans.TipoEndereco cria(String tipo,
            String logradouro, String numero, String complemento, String bairro,
            String municipio, String uf, String cep, String site, String email) {
        model.beans.TipoEndereco endereco = new model.beans.TipoEndereco();

        endereco.setCep(cep);
        endereco.setCidade(municipio);
        endereco.setComplemento(complemento);
        endereco.setEmail(email);
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setSite(site);
        endereco.setUf(uf);
        endereco.setBairro(bairro);
        endereco.setTipo(tipo);

        return endereco;
    }
}
