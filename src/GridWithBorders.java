import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class GridWithBorders extends JPanel {
    private static final int ROW = 6;
    private static final int COLUMN = 5;
    private static final int SIDE_LENGTH = 60;
    private static final int GAP = 3;
    private static final Color BG = Color.BLACK;
    private static final Color CELL_COLOR = Color.WHITE;
    private JPanel[][] grid;

    public GridWithBorders() {
        setBackground(BG);
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new GridLayout(ROW, COLUMN, GAP, GAP));
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        grid = new JPanel[6][5];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = new JPanel(); // creating the cells
            }
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                JPanel cell = grid[ROW][COLUMN];
                cell.setBackground(CELL_COLOR);
                cell.setPreferredSize(prefSize);
                add(cell);
            }
        }
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
    // tasks: have input fill the grid and check 
    


