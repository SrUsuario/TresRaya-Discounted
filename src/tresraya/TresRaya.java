/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tresraya;

import java.util.Scanner;

/**
 *
 * @author Raúl Parada de la Fuente
 */
public class TresRaya {

    private char[][] board;
    private boolean[][] flagBoard;

    public TresRaya() {
        board = new char[3][3];
        flagBoard = new boolean[3][3];
    }

    public void fill() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '!';
            }
        }
    }

    public void show() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("\t" + board[i][j]);
            }
            System.out.println("");
        }
    }

    public boolean coordsValid(int posX, int posY) {
        if ((posX > 3 || posX < 0) || (posY > 3 || posY < 0)) {
            System.out.println("Error en la fila o columna");
            return true;
        }

        return false;
    }

    public void input() {
        Scanner scan = new Scanner(System.in);

        int posX = 0;
        int posY = 0;

        do {
            System.out.println("Di a fila");
            posX = scan.nextInt() - 1;
            System.out.println("Di a columna");
            posY = scan.nextInt() - 1;
        } while (coordsValid(posX, posY));

        System.out.println("Option");
        char option;
        option = scan.next().toLowerCase().charAt(0);

        board[posX][posY] = option;
        flagBoard[posX][posY] = true;
    }

    public boolean gameOver() {
        if (maxSizeBoard()) {
            return true;
        }
        return false;
    }

    public boolean maxSizeBoard() {
        for (int i = 0; i < flagBoard.length; i++) {
            for (int j = 0; j < flagBoard.length; j++) {
                if (flagBoard[i][j] == false) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TresRaya board = new TresRaya();

        board.fill();

        System.out.println("Bienvenido al Tres en Raya");

        do {
            board.show();

            board.input();
        } while (!board.gameOver());

    }

}
