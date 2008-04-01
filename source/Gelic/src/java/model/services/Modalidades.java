package model.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 * 
 * @author Adriano
 */
public class Modalidades {

    /**
     * Considera-se que o cadastro de modalidades não venha a alterar o tempo
     * todo.  Por isso faz-se um cache na classe servicos.Modalidades.  Para 
     * não ir ao banco desnecessariamente.
     * 
     */
    static ArrayList<model.beans.Modalidade> modalidades = null;

    static public void alterar(String siglaAnterior, String novaSigla,
            String novoNome) throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();
        if (model.daos.Modalidades.alterar(
                siglaAnterior,
                novaSigla,
                novoNome) == 1) {
            gelic.commit();
            /* apaga cache */
            modalidades = null;
        } else {
            gelic.rollback();
        }
        gelic.close();

    }

    static public void incluir(String sigla, String nome)
            throws SQLException, NamingException {
        Connection gelic = model.services.Conexao.getConnection();
        if (model.daos.Modalidades.incluir(sigla, nome) == 1) {
            gelic.commit();
            /* apaga cache */
            modalidades = null;
        } else {
            gelic.rollback();
        }
        gelic.close();
    }

    /**
     * Retorna as modalidades de seleções cadastradas.  
     * 
     * Essa função é executada
     * com cache.  Portanto, se outra aplicação estiver acessando a mesma base, 
     * alterando esta tabela, o cache deverá ser retirado.
     * @return
     * @throws java.sql.SQLException
     * @throws javax.naming.NamingException
     */
    static public ArrayList<model.beans.Modalidade> recuperar()
            throws SQLException, NamingException {
        if (modalidades == null) {
            modalidades = model.daos.Modalidades.recuperar();
        }
        return modalidades;
    }

    static public model.beans.Modalidade recuperar(String sigla)
            throws SQLException, NamingException {
        if (sigla == null) {
            return null;
        }
        recuperar();
        for (model.beans.Modalidade modalidade : modalidades) {
            if (modalidade.getSigla().equals(sigla)) {
                return modalidade;
            }
        }
        return null;
    }
}
