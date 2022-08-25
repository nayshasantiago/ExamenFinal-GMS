import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// -------------------------------------------------------------------------
/**
 * Represents a la pieza torre
 */
 
public class Rook extends ChessGamePiece{
	protected Map<Integer, String> icons_map;
	// private ArrayList<String> possibleMoves;
	// ----------------------------------------------------------
	/**
	 * Cree un nuevo objeto Torre.
	 *
	 * @param board
	 *            El tablero para crear la torre
	 * @param row
	 *            Fila para crear la torre
	 * @param col
	 *            La columna para crear la torre
	 * @param color
	 *            ya sea GamePiece.BLANCO, NEGRO o SIN ASIGNAR
	 */
	public Rook( ChessGameBoard board, int row, int col, int color ){
		super( board, row, col, color );
	}
	/**
	 * Calcula los posibles movimientos de esta Torre.
	 */
	@Override
	protected ArrayList<String> calculatePossibleMoves( ChessGameBoard board ){
			ArrayList<String> northMoves = calculateNorthMoves( board, 8 );
			ArrayList<String> southMoves = calculateSouthMoves( board, 8 );
			ArrayList<String> westMoves = calculateWestMoves( board, 8 );
			ArrayList<String> eastMoves = calculateEastMoves( board, 8 );
			ArrayList<String> allMoves = new ArrayList<String>();
			allMoves.addAll( northMoves );
			allMoves.addAll( southMoves );
			allMoves.addAll( westMoves );
			allMoves.addAll( eastMoves );
			return allMoves;
	}
	/**
	 Crea un ícono para esta pieza dependiendo del color de la pieza.
	 */
	@Override
	public ImageIcon createImageByPieceType() {
		icons_map = new HashMap<Integer, String>();

		icons_map.put(-1, "chessImages/default-Unassigned.gif");
		icons_map.put(ChessGamePiece.BLACK, "chessImages/BlackRook.gif");
		icons_map.put(ChessGamePiece.WHITE, "chessImages/WhiteRook.gif");
		
		return new ImageIcon(getClass().getResource(this.icons_map.get(getColorOfPiece())));
	}
}
