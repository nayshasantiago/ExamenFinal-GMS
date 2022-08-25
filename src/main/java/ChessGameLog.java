import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.Date;
// -------------------------------------------------------------------------
/**
 * Un área de texto desplazable que representa el registro del juego. (es decir, movimientos realizados por cada
 * jugador)
 * 
 * @version 2010.11.17
 */
public class ChessGameLog
    extends JScrollPane{
    private JTextArea textArea;
    // ----------------------------------------------------------
    /**
     * 
     * Cree un nuevo objeto ChessGameLog.
     */
    public ChessGameLog(){
        super(
            new JTextArea( "", 5, 30 ),
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        textArea = ( (JTextArea)this.getViewport().getView() );
    }
    // ----------------------------------------------------------
    /**
     * Agrega una nueva línea de texto al registro.     * 
     * @param s
     *            the line of text to add
     */
    public void addToLog( String s ){
        if ( textArea.getText().length() > 0 ){
            textArea.setText( textArea.getText() + "\n" + new Date() + " - "
                + s );
        }
        else
        {
            textArea.setText( new Date() + " - " + s );
        }
    }
    /**
     * Clears the log.
     */
    public void clearLog(){
        textArea.setText( "" );
    }
    // ----------------------------------------------------------
    /**
     * Obtiene la declaración más reciente agregada al registro.
     * 
     * @return String the most recent log statement
     */
    public String getLastLog(){
        int indexOfLastNewLine = textArea.getText().lastIndexOf( "\n" );
        if ( indexOfLastNewLine < 0 ){
            return textArea.getText();
        }
        return textArea.getText().substring( indexOfLastNewLine + 1 );
    }
}
