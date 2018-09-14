package aula6;

import java.util.Scanner;

public class Menu {
    public int OpcMenu;
    public Produto produto;
    public Produto[] ListaProduto;
    Scanner scan = new Scanner(System.in);
    
    public void CriarMenu(){
        System.out.println("Digite uma das opções"
                + "\n 1) - Cadastrar Novo"
                + "\n 2) - Listar"
                + "\n 3) - Buscar"
                + "\n 4) - Editar"
                + "\n 0) - Sair"
                + "\n =>");
        OpcMenu = scan.nextInt();
        GetExecucao();
    }
    public void GetExecucao(){
        switch (OpcMenu){
            case 1:
                Cadastrar();
                break;
            case 2:
                Listar();
                this.CriarMenu();
                break;
            case 3:
                produto = Buscar();
                if (produto == null){
                    System.out.println("Produto n existe");
                } else{
                    this.ImprimirProduto();
                }
                this.CriarMenu();
                break;
            case 4:
                Editar();
                break;
            case 0:
                System.out.println("O sistema sera fechado");
                this.CriarMenu();
                break;
            
        }
    }
    public void Cadastrar(){
        System.out.println("Quantos Produtos Deseja Cadastrar? ");
        int qtde = scan.nextInt();
        ListaProdutos = new Produto[qtde];
        for(int x = 0; x < qtde; x++){
            ListaProdutos[x] = InformacoesProduto (x + 1);
        }
        this.CriarMenu();
    }
    public void ImprimirProduto(){
            System.out.println(
                    "\nCod: " + produto.Cod +
                    "\nDescrição: " + produto.Descricao +
                    "\nValor: " + produto.Valor +
                    "\nQuantidade: " + produto.Quantidade
            );
    }
}
