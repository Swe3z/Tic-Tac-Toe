import java.util.Scanner;

public class Main {
    
    static Scanner choice1 = new Scanner(System.in);
    static Scanner choice2 = new Scanner(System.in); 
    static int iterator;
    static int gameagain;
    static int mouvement1;
    static int mouvement2;

    static String [][] Board= {{"-","-","-"},{"-","-","-"},{"-","-","-"}};

    //Creer le tableau
    static void createBoard()
    {   
        for (int i = 0; i < Board.length; ++i) {
            for(int j = 0; j < Board[i].length; ++j) {
              
                Board[i][j] ="-";
            } 
    }
    };
    //check if someone's won and will return true or false
    static Boolean Checkwinner()
    {  
        if( 
            Board[0][0].equals(Board[0][1]) && Board[0][1].equals(Board[0][2]) && !Board[0][0].equals("-") ||

            Board[1][0].equals(Board[1][1]) && Board[1][1].equals(Board[1][2]) && !Board[1][0].equals("-") ||

            Board[2][0].equals(Board[2][1]) && Board[2][1].equals(Board[2][2]) && !Board[2][0].equals("-") ||

            Board[0][0].equals(Board[1][0]) && Board[1][0].equals(Board[2][0]) && !Board[0][0].equals("-") ||

            Board[0][1].equals(Board[1][1]) && Board[1][1].equals(Board[2][1]) && !Board[0][1].equals("-") ||

            Board[0][2].equals(Board[1][2]) && Board[1][2].equals(Board[2][2]) && !Board[0][2].equals("-") ||

            Board[0][0].equals(Board[1][1]) && Board[1][1].equals(Board[2][2]) && !Board[0][0].equals("-") ||

            Board[0][2].equals(Board[1][1]) && Board[1][1].equals(Board[2][0]) && !Board[0][2].equals("-")
        )
        {
            return true;
        }
        return false;
    };

    //Faire jouer le joueur
    static void Player(){
        
        System.out.println("Choose a position 1-3 for lines 1-3 for columns");
        
        do{
            System.out.println("Choose a position 1-3 for lines");
            mouvement1 = choice1.nextInt();
         
            System.out.println("Choose a position 1-3 for columns");
            mouvement2 = choice2.nextInt();
            
        }
        while(Board[mouvement1][mouvement2]!="-");
        
        Board[mouvement1][mouvement2]="X";
    };

    //faire jouer l'ordinateur avec des nombres aleatoires
    public static void computer(){

        System.out.println("L'ordinateur Choisi");
        
        do{
            
            mouvement1 = (int) (Math.random() * (2 - 0 + 1) + 0);
            mouvement2 = (int) (Math.random() * (2 - 0 + 1) + 0);
        }
        while(Board[mouvement1][mouvement2]!="-");
        Board[mouvement1][mouvement2]="O";
    
    };
    //Montrer le tableau
    static void ShowBoard(){

            System.out.println("["+Board[0][0]+"]|["+Board[1][0]+"]|["+Board[2][0]+"]");
            System.out.println("___ ___ ___");
            System.out.println("["+Board[0][1]+"]|["+Board[1][1]+"]|["+Board[2][1]+"]");
            System.out.println("___ ___ ___");
            System.out.println("["+Board[0][2]+"]|["+Board[1][2]+"]|["+Board[2][2]+"]");
    };
    //Verifier si match nul
    static Boolean checkDraw(){
        iterator = 0;
        for (int i = 0; i < Board.length; ++i) {
            for(int j = 0; j < Board[i].length; ++j) {
              
                if(!Board[i][j].equals("-"))
              {
                iterator +=1;
              }
              
            }
          }
          if( iterator == 9)
          {
           return true;
          }
          return false;
    };
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome player! ");
       
        do{ 
 
            System.out.println("Let's GOOOOOOOO");
            
            do{

                ShowBoard();
                System.out.println("<-------------------------------------------------------->");
                Player();

                if(Checkwinner()==true)
                {                    
                    System.out.println("Le joueur est vainqueur!!!");
                    break;
                };

                if(checkDraw()==true)
                {
                    System.out.println("Match nul");
                    break;
                };
                ShowBoard();

                System.out.println("<-------------------------------------------------------->");
                
                computer();
                if(Checkwinner()==true)
                {    
                    System.out.println("L'ordinateur est vainqueur!!!");
                    break;
                };

                if(checkDraw()==true)
                {
                    System.out.println("Match nul");
                    break;
                };

            } while(true);

            ShowBoard();
            do{
                System.out.println("Wanna play again? Choose a number: 1-Yes 2-No");
            
                gameagain = choice1.nextInt();
            
            }while(gameagain!=1 && gameagain!=2);
            
            createBoard();

        } while(gameagain == 1);

        System.out.println("Thanks for Playing");
    };
};
