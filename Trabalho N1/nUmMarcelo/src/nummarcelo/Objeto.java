package nummarcelo;

import java.util.Scanner;

public class Objeto {
    public int count = 0, total = 0, menor = 0, maior = 0;
    public int[] valor;
    

    public Objeto(int tamanho) {
        valor = new int[tamanho];
    }
    
    Scanner scan = new Scanner(System.in);
    
    public void Menu(){
        System.out.println("========= Menu =========");
        System.out.println("1) Adicionar um valor;");
        System.out.println("2) Verificar maior valor;");
        System.out.println("3) Verificar menor valor;");
        System.out.println("4) Verificar valor médio;");
        System.out.println("5) Sair do Software.");
    }
    
    public void VerificaMaior(){
        System.out.print("Digite o valor desejado: ");
    }
    
    public void VerificaMenor(){
        System.out.println("Verifica Menor");
    }
    
    public void VerificaMedia(){
        System.out.println(this.total/(count+1));
    }
    
    public void AdicionarNovoValor(){
        if (this.valor.length != count){
            System.out.print("Digite o valor desejado: ");
            this.valor[count] = scan.nextInt();
//            System.out.println(this.valor[count]);
            this.total = this.total + this.valor[this.count];
            for(int x=0;count <= x;x++){
                if (this.valor[x] > this.maior){
                    this.maior = this.valor[x];
                }else{
                }
                if (this.valor[x] < this.menor){
                    this.maior = this.valor[x];
                }else{
                }
            }
            count++;
        }else{
            System.out.println("Vai se foder!");
        }
    }
    
}
