/*
Cadastro de usuário, salvar em txt
Login no sistema (buscar os dados no txt)
Exibir mensagem caso logado ou não.

Usuario deve conter
Nome
Login
Senha



*/
package sistemalogin;

import java.io.IOException;

/**
 *
 * @author marcelo.junior
 */
public class SistemaLogin {
    public static void main(String[] args) throws IOException{
        Autenticacao autenticacao = new Autenticacao();
        autenticacao.Menu();
    }
    
}
