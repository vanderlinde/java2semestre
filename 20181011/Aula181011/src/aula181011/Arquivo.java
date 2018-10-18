package aula181011;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Arquivo {
    Scanner scan = new Scanner(System.in);
    File diretorio;
    File arquivo;
    public Arquivo() throws IOException {
        //this.arq = new FileWriter("C:\\Users\\Marcelo Jr\\Documents\\NetBeansProjects\\banco.txt");
        diretorio = new File("C:\\Users\\Marcelo Jr\\Documents\\NetBeansProjects\\");
        arquivo = new File(diretorio, "Produto.txt");
    }
    
    public void AddProduto() throws FileNotFoundException,
            IOException {
        Produto produto = new Produto();
        System.out.print("Digite o nome: ");
        produto.Descricao = scan.next();
        System.out.print("Digite a Quantidade: ");
        produto.Quantidade = scan.nextInt();
        System.out.print("Digite o Valor: ");
        produto.Valor = scan.nextDouble();
        this.EscreveProduto(produto);
    }
    
    public void EscreveProduto(Produto produto)
            throws FileNotFoundException, IOException{
        arquivo.createNewFile();
        FileWriter file = new FileWriter(arquivo, true);
        PrintWriter print = new PrintWriter(file);
        print.print(produto.Descricao + " | "
                    + produto.Quantidade + " | "
                    + produto.Valor);
        print.flush();
        print.close();
    }
}
