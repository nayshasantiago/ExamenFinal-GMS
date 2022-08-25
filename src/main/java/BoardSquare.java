import javax.swing.JLabel;
import javax.swing.JPanel;
// -------------------------------------------------------------------------
/**

 *Representa una celda en el tablero de ajedrez. Sostiene una pieza de juego.
 * @version 2010.11.17
 */
public class BoardSquare
    extends JPanel{
    private int            row;
    private int            col;
    private ChessGamePiece piece;
    private JLabel         imageLabel;
    // ----------------------------------------------------------
    /**
     * Create a new BoardSquare object.
     *
     * @param row
     *           fila
     * @param col
     *           columna
     * @param piece
     *           Piezas del juego
     */
    public BoardSquare( int row, int col, ChessGamePiece piece ){
        super();
        this.row = row;
        this.col = col;
        this.piece = piece;
        updateImage();
    }
    /**
     * Updates the image for this BoardSquare.
     */
    private void updateImage(){
        if ( imageLabel != null ){
            removeAll();
        }
        if ( piece != null ){
            imageLabel = new JLabel();
            imageLabel.setIcon( piece.getImage() );
            add( imageLabel );     
        }
        revalidate(); // repaint wasn't working, gotta force the window manager
        // to redraw...
    }
    // ----------------------------------------------------------
    /**
     * Gets the row number.
     *
     * @return int the row number
     */
    public int getRow(){
        return row;
    }

    /**
     * Obtiene la columna del numero
     *
     * @return int the column number
     */
    public int getColumn(){
        return col;
    }

    /**
     * Gets the piece on this square
     *
     * @return GamePiece the piece
     */
    public ChessGamePiece getPieceOnSquare(){
        return piece;
    }
 
    /**
     * Coloca la pieza en este cuadrado
     *
     * @param p
     *           
     */
    public void setPieceOnSquare( ChessGamePiece p ){
        piece = p;
        updateImage();
    }
    // ----------------------------------------------------------
    /**
     * Limpia esta casilla, eliminando el icono y la pieza.
     */
    public void clearSquare(){
        piece = null;
        removeAll();
    }
}
