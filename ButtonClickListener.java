import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {
    private final XandO game;

    public ButtonClickListener(XandO game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (buttonClicked.getText().equals("")) {
            buttonClicked.setText(game.currentPlayer);
            buttonClicked.setBackground(game.currentPlayer.equals("X") ? Color.ORANGE : Color.GRAY);
            buttonClicked.setOpaque(true);
            buttonClicked.setBorderPainted(false);
            if (game.checkForWin()) {
                if (game.currentPlayer.equals("X")) {
                    game.xScore++;
                } else {
                    game.oScore++;
                }
                JOptionPane.showMessageDialog(game.tictac, game.currentPlayer + " wins!");
                game.resetBoard();
            } else if (game.checkForDraw()) {
                JOptionPane.showMessageDialog(game.tictac, "Draw!");
                game.resetBoard();
            } else {
                game.currentPlayer = game.currentPlayer.equals("X") ? "O" : "X";
            }
            game.updateScoreLabel();
        }
    }
}
