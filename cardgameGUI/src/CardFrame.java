import javax.swing.*;
import java.awt.*;

public class CardFrame  extends JFrame {
    private CardGameBoard board;
    private CardButton[][] button_board;

    public CardFrame(CardGameBoard b) {
        board = b;
        button_board = new CardButton[2][8];
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel p1 = new JPanel(new FlowLayout());
        JButton start = new StartButton(board, this);
        p1.add(start);

        JPanel p2 = new JPanel(new GridLayout(2, 8));
        for (int row = 0; row<button_board.length;row++){
            for(int col = 0; col<button_board[row].length;col++) {
                button_board[row][col] = new CardButton(board, this, row, col);
                p2.add(button_board[row][col]);
            }
        }
        cp.add(p1, BorderLayout.NORTH);
        cp.add(p2, BorderLayout.CENTER);

        setAllCardInvisible();
        setTitle("Card Game");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setAllCardInvisible() {
        for (int row = 0; row<button_board.length;row++){
            for(int col = 0; col<button_board[0].length;col++) {
                button_board[row][col].setText("?");
            }
        }
    }

    public void update() {
        Card pp;
        for (int row = 0; row<button_board.length;row++){
            for(int col = 0; col<button_board[0].length;col++) {
                pp = board.getCard(row, col);
                button_board[row][col].setText(pp.getFaceValue());
            }
        }
    }


    public void setCardText(int row, int col, String text) {
        button_board[row][col].setText(text);
    }
}
