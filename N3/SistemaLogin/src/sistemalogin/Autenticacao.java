package sistemalogin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author marcelo.junior
 */
public class Autenticacao {
    Scanner scan = new Scanner(System.in);
    File diretorio;
    File arquivo;
    Usuarios[] usuarios;
    public String usuarioDigitado, senhaDigitada;
    int opc = 0, logado = 0;
    
    public Autenticacao() throws IOException {
        diretorio = new File("C:\\Users\\marcelo.junior\\Documents\\NetBeansProjects\\");
        arquivo = new File(diretorio, "Usuario.txt");
    }
    
    public void AddUsuario() throws FileNotFoundException, IOException {
        Usuarios usuarios = new Usuarios();
        System.out.print("Digite seu nome: ");
        usuarios.Nome = scan.next();
        System.out.print("Digite um nome de usuário: ");
        usuarios.Login = scan.next();
        System.out.print("Digite uma senha de usuário: ");
        usuarios.Senha = scan.next();
        this.EscreveUsuario(usuarios);
    }
    
    public void EscreveUsuario(Usuarios usuarios)
            throws FileNotFoundException, IOException{
        arquivo.createNewFile();
        FileWriter file = new FileWriter(arquivo, true);
        PrintWriter print = new PrintWriter(file);
        print.println(usuarios.Nome + " | "
                    + usuarios.Login + " | "
                    + usuarios.Senha);
        print.flush();
        print.close();
    }
    
    public void ListarUsuarios()
            throws FileNotFoundException, IOException{
        FileReader file = new FileReader(arquivo);
        BufferedReader buffer = new BufferedReader(file);
        String linha = "";
        LineNumberReader ln = 
                new LineNumberReader(new FileReader(arquivo));
        ln.skip(Long.MAX_VALUE);
        int retorno = ln.getLineNumber();
        usuarios = new Usuarios[retorno];
        System.out.println("..:: LISTAR USUARIOS ::..");
        int x = 0;
        while((linha = buffer.readLine() ) != null){
            String[] campo = linha.split("[|]");
            Usuarios users = new Usuarios();
            users.Cod = x + 1;
            users.Nome = campo[0];
            users.Login = campo[1].trim();
            users.Senha = campo[2].trim();
            usuarios[x] = users;
            x++;
            System.out.println(linha);
        }
        System.out.println("..:: FIM ::..");
        file.close();
        buffer.close();
    }
    
    public void Menu() throws IOException{
        
        while (opc != 10){
            System.out.println("....::: Bem Vindo ao Sistema de Login :::....");
            System.out.println("Selecione uma das opções a baixo:");
            System.out.println("1) Adicionar Usuario.");
            System.out.println("2) Listar os usuários existentes.");
            System.out.println("3) Realizar o login.");
            System.out.println("4) Para finalizar o sistema.");
            System.out.print("> ");
            opc = scan.nextInt();
            switch(opc){
                case 1:
                    this.AddUsuario();
                    break;
                case 2:
                    this.ListarUsuarios();
                    break;
                case 3:
                    this.Login();
                    break;
                case 4:
                    opc = 10;
                    break;
                default:
            }
        }
    }
    
    public void Login() throws IOException{
        System.out.print("Usuário: ");
        this.usuarioDigitado = scan.next();
        System.out.print("Senha: ");
        this.senhaDigitada = scan.next();
        this.Auth();
    }
    public void Auth()
            throws FileNotFoundException, IOException{
        FileReader file = new FileReader(arquivo);
        BufferedReader buffer = new BufferedReader(file);
        String linha = "";
        LineNumberReader ln = 
                new LineNumberReader(new FileReader(arquivo));
        ln.skip(Long.MAX_VALUE);
        int retorno = ln.getLineNumber();
        usuarios = new Usuarios[retorno];
        int x = 0;
        while((linha = buffer.readLine() ) != null){
            String[] campo = linha.split("[|]");
            Usuarios users = new Usuarios();
            users.Cod = x + 1;
            users.Nome = campo[0].trim();
            users.Login = campo[1].trim();
            users.Senha = campo[2].trim();
            usuarios[x] = users;
            if(this.usuarioDigitado.equals(users.Login)){
                if(this.senhaDigitada.equals(users.Senha)){
                    logado = 1;
                    break;
                }
            }else{
                logado = 0;
            }
            
            x++;
        }
        if(logado==1){
            System.out.println("Usuário logado com Sucesso!");
        }else{
            System.out.println("Usuário ou Senha digitados não conferem!");
        }
        file.close();
        buffer.close();
        }
    
}

