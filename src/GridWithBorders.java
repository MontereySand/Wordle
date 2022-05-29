import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.BorderLayout;

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
    
    /*
JPanel panel = new JPanel(new GridLayout(10,10));
panel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

for (int i =0; i<(10*10); i++){
    final JLabel label = new JLabel("Label");
    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    panel.add(label);
}
    */

    public GridWithBorders() {
        //setBackground(BG);
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new GridLayout(ROW, COLUMN, GAP, GAP));
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
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
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
        InputPanel inputPanel = new InputPanel(mainPanel);
        JFrame frame = new JFrame("GridWithBorders");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
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
    private String gameanswer;
    private ArrayList <String> possibleGuesses;

    public InputPanel(GridWithBorders mainPanel){
        this.mainPanel = mainPanel;
        input = new JTextField(20);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        gameanswer = wordExtractor();
        possibleGuesses = guesses();
        add(input);
        add(submit);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String word = input.getText();
        input.setText("");
        if(word.length() != 5){
            JOptionPane.showMessageDialog(null, 
            "Word length should be 5");
            return;
        }

        boolean valid = validateInput(word);
        if(!valid){
            JOptionPane.showMessageDialog(null, 
            "Only letters of the alphabets allowed");
            return;
        }
        
        boolean validGuess = validateWord(word);
        if(!validGuess){
            JOptionPane.showMessageDialog(null, 
            "Only valid English words allowed");
            return;
        }
        

        Color[] colors = resolve(word);
        // get the current Row to be filled from mainPanel
        int currentRow = mainPanel.getCurrentPosition();
        // check if currentRow is out of bounds
        if(currentRow >= 6){
            JOptionPane.showMessageDialog(null, 
            "No more words allowed");
            return;
        }
        // get the Jlabel array for that row
        JLabel[] labelRow = mainPanel.getGrid()[currentRow];
        //manipulate the color and font for each JLabel
        for (int i = 0; i < labelRow.length; i++) {
            String letter = "" + word.charAt(i);
            letter = letter.toUpperCase();
            labelRow[i].setText(letter);
            labelRow[i].setForeground(colors[i]);
            labelRow[i].setHorizontalAlignment(JLabel.CENTER);
            labelRow[i].setVerticalAlignment(JLabel.CENTER);
            
        }
        // tell mainPanel to repaint itself
        mainPanel.setCurrentPosition(currentRow + 1);
        mainPanel.repaint();
        if(word.equalsIgnoreCase(gameanswer)){
            JOptionPane.showMessageDialog(null, 
            "Hurray, you got the correct word!!");
            // reset the game answer
            gameanswer = wordExtractor();
            // reset the labels
            JLabel[][] grid = mainPanel.getGrid();
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[row].length; col++) {
                    grid[row][col].setText("");
                }
            }
            mainPanel.setCurrentPosition(0);
            mainPanel.repaint();
        }
    }

    private boolean validateWord(String word) {
            for (int i = 0; i < possibleGuesses.size(); i++) {
                if (word.equals(possibleGuesses.get(i))) {
                    return true;
                }
            }
            return false;
        }

    private boolean validateInput(String word) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
           if( Character.isLetter(letters[i]) == false){
               return  false;
           }
        }
        return true;
    }

    /**
     * put each character through the analysis method
         if letter is match, color it green
         if letter is not in the range, color it black
         if letter is in the range but misplaced, color it yellow
     * @param word
     * @return
     */
    public Color[] resolve(String word){
        Color[] colors = new Color[word.length()];
        String answer = gameanswer.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i + 1).equals(answer.substring(i, i + 1))) {
                colors[i] = Color.GREEN;
            } else if (answer.contains(word.substring(i, i + 1))) {
                colors[i] = Color.YELLOW;
            } else if (!answer.contains(word.substring(i, i + 1))) {
                colors[i] = Color.BLACK;
            }
        }
        return colors;
    }

    public String wordExtractor() {
        ArrayList<String> words = new ArrayList<String>();
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("lib/dict.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str;
        while (sc.hasNext()) {
            str = sc.next();
            words.add(str);
        }
        String word = words.get((int) (Math.random() * words.size()));
        return word;
    }

    public ArrayList<String> guesses() {
        ArrayList<String> guess = new ArrayList<String>();
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("lib/possibleguesses.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str;
        while (sc.hasNext()) {
            str = sc.next();
            guess.add(str);
        }
        return guess;
    }
}
    // tasks: have input fill the grid and check 
    


