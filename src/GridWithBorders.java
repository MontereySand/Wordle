import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GridWithBorders extends JPanel {
    private static final int ROW = 6;
    private static final int COLUMN = 5;
    private static final int SIDE_LENGTH = 60;
    private static final int GAP = 3;
    private static final Color BG = Color.BLACK;
    private static final Color CELL_COLOR = Color.WHITE;
    private JLabel[][] grid;
    private int currentPosition;
    

    public GridWithBorders() {
        setBackground(BG);
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new GridLayout(ROW, COLUMN, GAP, GAP));
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        grid = new JLabel[6][5];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = new JLabel(); // creating the cells
            }
        }
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COLUMN; col++) {
                JLabel cell = grid[row][col];
                cell.setBackground(CELL_COLOR);
                cell.setPreferredSize(prefSize);
                add(cell);
            }
        }
        currentPosition = 0;
    }

    public JLabel[][] getGrid(){
        return grid;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

    public void setCurrentPosition(int newPosition){
        this.currentPosition = newPosition;
    }

    private static void createAndShowGui() {
        GridWithBorders mainPanel = new GridWithBorders();

        JFrame frame = new JFrame("GridWithBorders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class InputPanel extends JPanel implements java.awt.event.ActionListener{

    private JTextField input;
    private JButton submit;
    private GridWithBorders mainPanel;
    private Wordle wordle;

    public InputPanel(GridWithBorders mainPanel, Wordle wordle){
        this.mainPanel = mainPanel;
        this.wordle = wordle;
        input = new JTextField();
        submit = new JButton("Submit");
        submit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String word = input.getText();
        // put each character through the analysis method
        // if letter is match, color it green
        // if letter is not in the range, color it black
        // if letter is in the range but misplaced, color it yellow
    }

}
    // tasks: have input fill the grid and check 
    


