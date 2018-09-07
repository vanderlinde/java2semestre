
package nummarcelo;

import java.util.Scanner;

public class NUmMarcelo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int menu = 0, opc = 0;
        System.out.println("Quantos números deseja cadastrar?");
        Objeto obj = new Objeto(scan.nextInt());
        while (menu == 0){
            obj.Menu();
            opc = scan.nextInt();
            switch (opc){
                case 1: 
                    obj.AdicionarNovoValor();
                    
                break;
                case 2: obj.VerificaMaior();
                break;
                case 3: obj.VerificaMenor();
                break;
                case 4: obj.VerificaMedia();
                break;
                case 5: menu = 1;
                break;
                 
                default:System.out.println("Digite uma opção Válida!");
                break;
                    
            }
        }
    }
    
}
