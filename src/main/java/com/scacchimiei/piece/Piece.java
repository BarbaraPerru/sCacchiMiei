package com.scacchimiei.piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

import com.scacchimiei.Board;
import com.scacchimiei.GamePanel;
import com.scacchimiei.Type;


public class Piece {
    
    public Type type;
    public BufferedImage image;
    public int x, y;
    public int col, row, preCol, preRow;
    public int color;
    public Piece hittingP;
    public boolean moved, twoStepped;

    public Piece(int color, int col, int row) {
        this.col = col;
        this.row = row;
        this.color = color;
        x = getX(col);
        y = getY(row);
        preCol = col;
        preRow = row;
    }

    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
        
    }

    public int getX(int col) {
        return col * Board.SQUARE_SIZE;
    }

    public int getY(int row) {
        return row * Board.SQUARE_SIZE;
    }
    public int getCol(int x) {
        return (x + Board.HALF_SQUARE_SIZE)/ Board.SQUARE_SIZE;
    }
    public int getRow(int y) {
        return (y + Board.HALF_SQUARE_SIZE)/ Board.SQUARE_SIZE;
    }

    public int getIndex(){
        for(int i = 0; i < GamePanel.simPieces.size(); i++) {
            if(GamePanel.simPieces.get(i) == this) {
                return i;
            }
        }
        return 0;
    }
    public void updatePosition() {
        if(type == Type.PAWN) {
            if(Math.abs(row - preRow) == 2) {
                twoStepped = true;
            }
        }

        x = getX(col);
        y = getY(row);
        preCol = getCol(x);
        preRow = getRow(y);
        moved = true;
    }
    public void resetPosition() {
        col = preCol;
        row = preRow;
        x = getX(col);
        y = getY(row);
    }
    public boolean canMove(int targetCol, int targetRow) {
        return false;
    }
    public boolean isWithinBoard(int targetCol, int targetRow) {
        if(targetCol >= 0 && targetCol <= 7  && targetRow >= 0 && targetRow <= 7){ 
            return true;
        }
        return false;
    }
    public boolean isSameSquare(int targetCol, int targetRow) {
        if(targetCol == preCol && targetRow == preRow) {
            return true;
        }
        return false;
    }
    public Piece getHittingP(int targetCol, int targetRow) {
        for(Piece piece : GamePanel.simPieces) {
            if(piece.col == targetCol && piece.row == targetRow && piece != this) {
                return piece;
            }
        }
        return null;
    }
    public boolean isValidSquare(int targetCol, int targetRow) {
        hittingP = getHittingP( targetCol, targetRow);
        if(hittingP == null) {
            return true;
        }
        else{
            if(hittingP.color != this.color) {
                return true;
            }
            else{
                hittingP = null;
            }
        }
        return false;
    }
    public boolean pieceIsOnStraightLine(int targetCol, int targetRow) {
        // turn left
        for(int c = preCol-1; c > targetCol; c--) {
            for(Piece piece : GamePanel.simPieces) {
                if(piece.col == c && piece.row == targetRow) {
                    hittingP = piece;
                    return true;
                }
            }
        }
        // turn right  
        for(int c = preCol+1; c < targetCol; c++) {
            for(Piece piece : GamePanel.simPieces) {
                if(piece.col == c && piece.row == targetRow) {
                    hittingP = piece;
                    return true;
                }
         } 
        }
        // turn up
        for(int r = preRow-1; r > targetRow; r--) {
            for(Piece piece : GamePanel.simPieces) {
                if(piece.col == targetCol && piece.row == r) {
                    hittingP = piece;
                    return true;
                }
            }
        }
        // turn down
        for(int r = preRow+1; r < targetRow; r++) {
            for(Piece piece : GamePanel.simPieces) {
                if(piece.col == targetCol && piece.row == r) {
                    hittingP = piece;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean pieceIsOnDiagonalLine(int targetCol, int targetRow) {
        if(targetRow < preRow){
            // up left
            for(int c = preCol-1; c > targetCol; c--) {
                int diff = Math.abs(c - preCol);
                for(Piece piece : GamePanel.simPieces){
                    if(piece.col == c && piece.row == preRow - diff) {
                        hittingP = piece;
                        return true;
                    }
                }
            }
            // up right
            for(int c = preCol+1; c < targetCol; c++) {
                int diff = Math.abs(c - preCol);
                for(Piece piece : GamePanel.simPieces){
                    if(piece.col == c && piece.row == preRow - diff) {
                        hittingP = piece;
                        return true;
                    }
                }
            }
        
        }
        if(targetRow > preRow){
            // down left
            for(int c = preCol-1; c > targetCol; c--) {
                int diff = Math.abs(c - preCol);
                for(Piece piece : GamePanel.simPieces){
                    if(piece.col == c && piece.row == preRow + diff) {
                        hittingP = piece;
                        return true;
                    }
                }
            }
            // down right
            for(int c = preCol+1; c < targetCol; c++) {
                int diff = Math.abs(c - preCol);
                for(Piece piece : GamePanel.simPieces){
                    if(piece.col == c && piece.row == preRow + diff) {
                        hittingP = piece;
                        return true;
                    }
                }
            }
        }
        

        return false;

    }
    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, Board.SQUARE_SIZE, Board.SQUARE_SIZE, null);
    }
}
