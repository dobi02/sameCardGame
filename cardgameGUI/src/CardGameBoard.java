import java.util.*;

public class CardGameBoard {
    private Card[][] board;
    private boolean game_on = false;
    private int[] first = null;
    private int[] second = null;
    private int score = 0;

    /** Constructor - SlidePuzzleBoard 珥덇린 �띁利� 蹂대뱶 �꽕�젙 - 媛먯냼�븯�뒗 �닚�쑝濡� �굹�뿴
     */
    public CardGameBoard() {
        board = new Card[2][8];
        // 移대뱶 1~8瑜� 蹂대뱶�뿉 �뿭�닚�쑝濡� �겮�슦湲�
        int[] numbers = generateRandomPermutation(8);
        int number = 0;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Card("A".concat(Integer.toString(numbers[number])));
                number += 1;
            }
            number = 0;
        }
    }

    public boolean gameOn() {
        return game_on;
    }

    public Card getCard(int row, int col) {
        return board[row][col];
    }

    public void createCardGameBoard() {
        int[] numbers = generateRandomPermutation(8);
        int number = 0;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Card("A".concat(Integer.toString(numbers[number])));
                number += 1;
            }
            number = 0;
        }
        game_on = true;
        // temp
        for (int i=0; i<2; i++) {
            for (int j=0; j<8; j++) {
                System.out.println(board[i][j].getFaceValue());
            }
        }
    }

    private int[] generateRandomPermutation(int n) {
        Random random = new Random();
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            int d = random.nextInt(i+1);
            permutation[i] = permutation[d];
            permutation[d] = i;
        }
        return permutation;
    }

    // �옱�옉�꽦 �븘�슂
    private boolean gameOver() {
        if (score == 8) {
        	return true;
        }else {
        	return false;
        }
    }

    /** found - board[row][col]�뿉 �띁利� 議곌컖 v媛� �엳�뒗吏� �솗�씤  */
    private boolean found(String value, int row, int col) {
        if (row >= 0 && row <= 3 && col >= 0 && col <= 3)
            return Objects.equals(board[row][col].getFaceValue(), value);
        else
            return false;
    }

    public boolean saveRowCol(int row, int col) {
        boolean result;
        if (first == null) {
            first = new int[]{row, col};
            return true;		
        } else {
            second = new int[] {row, col};
            result = compare(first, second);
            first = null;
            second = null;
            return result;
        }
    }

    public boolean compare(int[] fir, int[]sec) {
        if (!board[fir[0]][fir[1]].getFaceValue().equals(board[sec[0]][sec[1]].getFaceValue())) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
        score += 1;
        if(gameOver()) {
        	
        }
        
        return true;
    }
    
    public int[] getFirst() {
        int[] a = new int[] {first[0], first[1]};
        first = null;
        return a;
    }
}
