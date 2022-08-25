import java.util.ArrayList;
import javax.swing.ImageIcon;
// -------------------------------------------------------------------------
/**
 * Clase para representar la pieza del Alfil.
 * 
 * @version 2010.11.17
 */
public class Bishop extends ChessGamePiece{
    /**
     * Crea un nuevo alfil
     * 
     */
    public Bishop( ChessGameBoard board, int row, int col, int color ){
        super( board, row, col, color );
    }
    /**
     * Calcula los posibles movimientos de esta pieza. Estos son TODOS los posibles
     * movimientos, incluidos los movimientos ilegales (pero al mismo tiempo válidos).
     * 
     * @param board
     *            the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
        //se puede refactorizar
        /*ArrayList<String> northEastMoves = calculateNorthEastMoves( board, 8 );
        ArrayList<String> northWestMoves = calculateNorthWestMoves( board, 8 );
        ArrayList<String> southEastMoves = calculateSouthEastMoves( board, 8 );
        ArrayList<String> southWestMoves = calculateSouthWestMoves( board, 8 );*/

        //Se emplea un Método para calcular todos los posibles movimientos
        ArrayList<String> allMoves = MovimientosCalculados(board);
        //ArrayList<String> allMoves = new ArrayList<String>();
        //allMoves.addAll( calcularMoves );
        return allMoves;
    }

    public ArrayList<String> MovimientosCalculados (ChessGameBoard board){
        ArrayList<String> northEastMoves = calculateNorthEastMoves( board, 8 );
        ArrayList<String> northWestMoves = calculateNorthWestMoves( board, 8 );
        ArrayList<String> southEastMoves = calculateSouthEastMoves( board, 8 );
        ArrayList<String> southWestMoves = calculateSouthWestMoves( board, 8 );
        ArrayList<String> resultMocves = new ArrayList<String>();
        resultMocves.addAll(northEastMoves);
        resultMocves.addAll(northWestMoves);
        resultMocves.addAll(southEastMoves);
        resultMocves.addAll(southWestMoves);
        return resultMocves;
    } 
    /**
     * Crea un ícono para esta pieza dependiendo del color de la pieza.
     * 
     * @return ImageIcon la representación ImageIcon de esta pieza.
     */
    @Override
    public ImageIcon createImageByPieceType(){
        if ( getColorOfPiece() == ChessGamePiece.WHITE ){
            return new ImageIcon(
                getClass().getResource("ChessImages/WhiteBishop.gif")
            );            
        }
        else if ( getColorOfPiece() == ChessGamePiece.BLACK ){
            return new ImageIcon(
                getClass().getResource("ChessImages/BlackBishop.gif")
            );
        }
        else{
            return new ImageIcon(
                getClass().getResource("ChessImages/BlackBishop.gif")
            );
        }
    }
}
