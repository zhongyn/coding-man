import java.util.Random;
import java.util.Scanner;
import java.io.*;
class Player
{
    private int score;
    private String name;
    Player()
    {
        name="Unknown";
        score=0;
    }
    Player(String name)
    {
        this.name=name;
        score=0;
    }
    public void addScore(int add)
    {
        score+=add;
    }
    public int getScore()
    {
        return score;
    }
    public String getName()
    {
        return name;
    }
}
class Board
{
    private final int size=3;
    private boolean gameOver;
    private boolean win;
    private int noOfMoves;
    private char[][] matrix=new char[size][size];
    Board()
    {
        int i,j;
        for(i=0;i<size;i++)
            for(j=0;j<size;j++)
                matrix[i][j]='.';
        gameOver=false;
        win=false;
        noOfMoves=0;
    }
    public void show()
    {
        int i,j;
        for(i=0;i<size;i++)
        {
            for(j=0;j<size;j++)
                System.out.print(" "+matrix[i][j]);         
            System.out.println();
        }
        System.out.println();
    }
    public boolean isGameOver()
    {
        return gameOver;
    }
    public boolean won()
    {
        return win;
    }
    public int playerMove(int x,int y)//1 player game against Computer
    {
        if(x<0 || y<0 ||x>=size || y>=size)
            return -1;//invalid move;
        if(matrix[x][y]=='O' || matrix[x][y]=='X')
            return -1;//invalid move
        matrix[x][y]='X';
        noOfMoves++;
        return 0;
    }
    public void computerMove()//1 player game against Computer
    {   //random move
        Random rand=new Random();
        int x,y;
        x=rand.nextInt(size);
        y=rand.nextInt(size);
        while(matrix[x][y]=='X' || matrix[x][y]=='O')
        {
            x=rand.nextInt(size);
            y=rand.nextInt(size);
        }
        matrix[x][y]='O';
        noOfMoves++;
    }
    public void setWon(char c)
    {
        if(c=='.')
            return;
        if(c=='X')
            win=true;
        else
            win=false;
        gameOver=true;
    }
    public void check()
    {
        int i,j;
        boolean f;
        for(i=0;i<size;i++)
        {
            j=1;
            if(matrix[i][0]!='.')
                for(;j<size;j++)//ith row check
                    if(matrix[i][j]!=matrix[i][j-1])
                        break;
            if(j==size)
            {
                System.out.println("row "+i+" crossed");
                setWon(matrix[i][0]);
                return;
            }
            j=1;
            if(matrix[0][i]!='.')
                for(;j<size;j++)//ith column check
                    if(matrix[j][i]!=matrix[j-1][i])
                        break;
            if(j==size)
            {
                System.out.println("col "+i+" crossed");
                setWon(matrix[0][i]);
                return;
            }
        }
        //diagonals
        i=1;
        if(matrix[0][0]!='.')
        for(;i<size;i++)
            if(matrix[i][i]!=matrix[i-1][i-1])
                break;
        if(i==size)
        {
            System.out.println("first diagonal "+i+" crossed");
            setWon(matrix[0][0]);
            return;
        }
        i=1;
        if(matrix[0][size-1]!='.')
        for(;i<size;i++)
            if(matrix[i][size-1-i]!=matrix[i-1][size-i])
                break;
        if(i==size)
        {
            System.out.println("second diagonal "+i+" crossed");
            setWon(matrix[0][size-1]);
            return;
        }
        if(noOfMoves>=size*size)
        {
            gameOver=true;
            win=false;
        }
        return;
    }
}
class TTT
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Board board=new Board();
        Player player=new Player();
        int x,y;
        while(!board.isGameOver())
        {
            board.show();
            x=sc.nextInt();
            y=sc.nextInt();
            while(board.playerMove(x,y)==-1)
            {
                System.out.println("Invalid input. Enter again!");
                x=sc.nextInt();
                y=sc.nextInt();     
            }
            board.check();
            if(!board.isGameOver())
            {
                board.computerMove();
                board.check();
            }
        }
        board.show();
        if(board.won())
            System.out.println("Congrats! You won!!!!");
        else
            System.out.println("You lose! Go practice some more.");
    }
}