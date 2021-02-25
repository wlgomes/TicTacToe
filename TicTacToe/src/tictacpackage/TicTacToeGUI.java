package tictacpackage;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TicTacToeGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container pane; // what holds game
	private String currentPlayer; // whos turn is it
	private JButton[][] board;
	private boolean hasWinner;
	private JMenuBar menuBar;
	private JMenuItem quit;
	private JMenuItem newGame;
	private JMenu menu;
	private int counterI;

	public TicTacToeGUI() {
		super();
		// Container pane = new JPanel();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		setTitle("TicTacToe");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		currentPlayer = "X";
		board = new JButton[3][3];
		hasWinner = false;
		initializeBoard();
		initializeMenuBar();
	}
	private void initializeMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("Main menu");
		// menuBar.add(new JLabel ("\t \t \t Current player: " + currentPlayer));
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
		});
		quit = new JMenuItem("Exit TicTacToe");
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	private void togglePlayer() {
		if (currentPlayer.equals("X")) {
			currentPlayer = "O";
		} else {
			currentPlayer = "X";
		}
	}
	private void resetBoard() {
		counterI = 0;
		currentPlayer = "X";
		hasWinner = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j].setText("");
			}
		}
	}
	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton btn = new JButton();
				btn.setFont(new Font(currentPlayer, Font.BOLD, 40));
				board[i][j] = btn;
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (((JButton) e.getSource()).getText().equals("") && hasWinner == false) {
							btn.setText(currentPlayer);
							hasWinner();
							togglePlayer();
						}
					}
				});
				pane.add(btn);
			}
		}
	}
	private void hasWinner() {
		if (board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer)
				&& board[2][0].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, currentPlayer + " won!");
			hasWinner = true;// prevent user updating further the GUI (game finished)
			resetBoard();
		}
		if (board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][1].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, currentPlayer + " won!");
			hasWinner = true;
			resetBoard();
		}
		if (board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, currentPlayer + " won!");
			hasWinner = true;
			resetBoard();
		}
		if (board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, currentPlayer + " won!");
			hasWinner = true;
			resetBoard();
		}
		if (board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[2][0].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, currentPlayer + " won!");
			hasWinner = true;
			resetBoard();
		}
		if (board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer)
				&& board[0][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, currentPlayer + " won!");
			hasWinner = true;
			resetBoard();
		}
		if (board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer)
				&& board[1][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, currentPlayer + " won!");
			hasWinner = true;
			resetBoard();
		}
		if (board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)
				&& board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, currentPlayer + " won!");
			hasWinner = true;
			resetBoard();
		} else {
			counterI++;
			if (counterI == 9) {
				tieGame();
			}
		}
	}
	private void tieGame() {
		if (hasWinner = false) {
			return;
		} else {
			JOptionPane.showMessageDialog(null, "Draw!");
			resetBoard();
		}
	}
}
