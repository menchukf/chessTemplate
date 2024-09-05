package workspace.resources;
/*
 /*
 *Luis Siancas
 * The rook moves vertically and horizontally
 * Up and down or to the side
 */

 import java.awt.Graphics;
 import java.awt.Image;
 import java.awt.image.BufferedImage;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;
 
 import javax.imageio.ImageIO;
 
 //you will need to implement two functions in this file.
     public class Rook extends Piece{
     public Rook(boolean w, String i) {
         super(w, i);
     }
     
 
    
    
     // TO BE IMPLEMENTED!
     // legal moves for a piece have to be properly and correctly initialized
     //return a list of every square that is "controlled" by this piece. A square is controlled
     //if the piece could move there legally.
     public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
         int row = start.getY();
         int col = start.getX();
         ArrayList<Square> controlledSquares = new ArrayList<Square>();
         
         int limit = 7;
         
 while(col < limit) {
             
             if(board[row][col+1].isOccupied()) {
                 controlledSquares.add(board[row][col+1]);
                 limit = 0;
             } else {
                 controlledSquares.add(board[row][col+1]);
             }
             col++;
         }
         
         //GOING DOWN
         col = start.getXNum();
         limit = 0;
         while(col > limit) {
                     
                     if(board[row][col-1].isOccupied()) {
                         controlledSquares.add(board[row][col-1]);
                         limit = 100;
                         
                     } else {
                         controlledSquares.add(board[row][col-1]);
                     }
                     col--;
                 }
         //GOING RIGHT
         col = start.getXNum();
         limit = 7;
         while(row < limit) {
                     
                     if(board[row+1][col].isOccupied()) {
                         controlledSquares.add(board[row+1][col]);
                         limit = 0;
                         
                     } else {
                         controlledSquares.add(board[row+1][col]);
                     }
                     row++;
                 }
         //GOING LEFT
         row = start.getYNum();
         limit = 0;
         while(row > limit) {
             
             if(board[row-1][col].isOccupied()) {
                     controlledSquares.add(board[row-1][col]);
                     limit = 100;
             } else {
                 controlledSquares.add(board[row-1][col]);
             }
             row--;
         }
         return controlledSquares;
     }
     
 
     //TO BE IMPLEMENTED!
     //A piece has to be correctly initialized to the corresponding piece
     //This returns an ArrayList of squares which are legal to move
     public ArrayList<Square> getLegalMoves(Board b, Square start){
         Square[][] board = b.getSquareArray();
         int row = start.getYNum();
         int col = start.getXNum();
         int limit = 7;
         ArrayList<Square> legalMoves = new ArrayList<Square>();
         //GOING UP
         while(col < limit) {
             
             if(board[row][col+1].isOccupied()) {
                 if(board[row][col+1].getOccupyingPiece().getColor() == super.getColor()) {
                     limit = 0;
                     
                 }else {
                     legalMoves.add(board[row][col+1]);
                     limit = 0;
                 }
             } else {
                 legalMoves.add(board[row][col+1]);
             }
             col++;
         }
         
         //GOING DOWN
         col = start.getXNum();
         limit = 0;
         while(col > limit) {
                     
                     if(board[row][col-1].isOccupied()) {
                         if(board[row][col-1].getOccupyingPiece().getColor() == super.getColor()) {
                             limit = 100;
                             
                         }else {
                             legalMoves.add(board[row][col-1]);
                             limit = 100;
                         }
                     } else {
                         legalMoves.add(board[row][col-1]);
                     }
                     col--;
                 }
         //GOING RIGHT
         col = start.getXNum();
         limit = 7;
         while(row < limit) {
                     
                     if(board[row+1][col].isOccupied()) {
                         if(board[row+1][col].getOccupyingPiece().getColor() == super.getColor()) {
                             limit = 0;
                             
                         }else {
                             legalMoves.add(board[row+1][col]);
                             limit = 0;
                         }
                     } else {
                         legalMoves.add(board[row+1][col]);
                     }
                     row++;
                 }
         //GOING LEFT
         row = start.getYNum();
         limit = 0;
         while(row > limit) {
             
             if(board[row-1][col].isOccupied()) {
                 if(board[row-1][col].getOccupyingPiece().getColor() == super.getColor()) {
                     limit = 100;
                     
                 }else {
                     legalMoves.add(board[row-1][col]);
                     limit = 100;
                 }	
             } else {
                 legalMoves.add(board[row-1][col]);
             }
             row--;
         }
         return legalMoves;
     }
     /*
      * Rook has to be initialized with a color
      * returns "A " (rook's 
      */
     public String toString() {
         return "A " + super.getColor() + " rook";
     }
 }
 
 