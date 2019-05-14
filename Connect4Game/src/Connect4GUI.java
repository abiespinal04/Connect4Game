import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.Scanner;

public class Connect4GUI extends JFrame {

	
	private Connect4Board mainScreen;
	private MainScoreBoard mainScoreBoard;
	private Player playerNum1;
	private Player playerNum2;
	private Player currentPlayer;
	
	private ImageIcon ironMan;
	private ImageIcon alien;

	
	private String player1;
	private String player2;
	
	private int col;
	private int row;
	public static int numRows;
	public static int numColumns;
	private int connect4;
	
	public static final int NOTHING = 0;	
	

	
	public Connect4GUI() {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			try{
				ironMan = new ImageIcon(ImageIO.read(getClass().getResource("img/ironman.jpg"))
					.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
			
				alien = new ImageIcon(ImageIO.read(getClass().getResource("img/alien.jpg"))
					.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		} catch (Exception exception) {
			exception.printStackTrace();
			System.out.println("Exception with the icon");
		}
			
		do {
			
			Component outOfBounds = null;
			player1 = JOptionPane.showInputDialog(null, "Player1 name: ");
			player2 = JOptionPane.showInputDialog(null, "Player2 name: ");
			
			
			connect4 = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Connect4 Game Play,Max is 5"));
			numRows = Integer.parseInt( JOptionPane.showInputDialog(null,
					"how many rows, Max is 10"));
			numColumns = Integer.parseInt( JOptionPane.showInputDialog(null,
					"how many columns, Max is 10"));
			
			}
		while (connect4 <= 0 || connect4 > 5 && numRows<=10 || numColumns > 10);
		
  
		
		this.playerNum1 = new Player(player1, ironMan);
		this.playerNum2 = new Player(player2, alien);
		this.currentPlayer = this.playerNum1;
		
		setLayout(new BorderLayout());
		
		mainScreen = new Connect4Board();
		add(mainScreen, BorderLayout.CENTER);
		
		mainScoreBoard = new MainScoreBoard();
		add(mainScoreBoard, BorderLayout.NORTH);
		
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	
	private class Connect4Board extends JPanel implements ActionListener {
		private JButton[][] board;
		private int rowTile = Connect4GUI.numRows ;
		private int colTile = Connect4GUI.numColumns ;
		int[][] grid = new int[rowTile][colTile];
		private int turnCount;

		public Connect4Board() {
			
			setLayout(new GridLayout(row, colTile));
			showBoard();
			
		}
		
		public void showBoard() {
			this.board = new JButton[rowTile][colTile];
			
			for ( int row = 0 ; row < this.board.length ; row++ ) {
				for ( int col = 0 ; col < this.board[row].length ; col++ ) {
					
					this.board[row][col] = new JButton();
					this.board[row][col].addActionListener(this);
					add(this.board[row][col]); 
				}
			}
		}
				
		public void clear() {
			for ( int row = 0 ; row < this.board.length ; row++ ) {
				for ( int col = 0 ; col < this.board[row].length ; col++ ) {
					this.board[row][col].setText("");
					this.board[row][col].setIcon(null);
					
				}
			}
		}

		
		public void alternateThePlayer() {
			if (currentPlayer.equals(playerNum1)) {
				currentPlayer = playerNum2;
			} else {
				currentPlayer = playerNum1;
			}
			if (currentPlayer.equals(playerNum1)) {
				mainScoreBoard.setCurrentPlayerName(currentPlayer);
			} else {
				mainScoreBoard.setCurrentPlayerName(currentPlayer);
			}
			
		}
		
		public Player checkTurn() {
	        if (this.turnCount % 2 == 0) {
	            return playerNum1;
	            
	        } 
	        else {
	            return playerNum1;
	            
	        }
	    }
		
		public boolean isWinner(ImageIcon icon) {
			checkTurn();
			int counter = 0;

			for ( int col = 0 ; col < this.board[0].length ; col++ ) {
				counter = 0;
				for ( int row = 0 ; row < this.board.length ; row++ ) {
					ImageIcon bText = (ImageIcon) this.board[row][col].getIcon();
					if (icon.equals(bText)) {
						counter++;
						
						if (counter == connect4) {
							return true;
						}
					} else {
						break;
					}
				}
			}
		
						for ( int col = 0 ; col < this.board[0].length ; col++ ) {
							counter = 0;
							for ( int row = 1 ; row < this.board.length ; row++ ) {
								ImageIcon buttonText = (ImageIcon) this.board[row][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
							
									if (counter == connect4) {
										return true;
									}
								} else {
									break;
								}
							}
						}

						for ( int col = 0 ; col < this.board[0].length ; col++ ) {
							counter = 0;
							for ( int row = 2 ; row < this.board.length ; row++ ) {
								ImageIcon buttonText = (ImageIcon) this.board[row][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									
									if (counter == connect4) {
										return true;
									}
								} else {
									break;
								}
							}
						}
					
						for ( int col = 0 ; col < this.board[0].length ; col++ ) {
							counter = 0;
							for ( int row = 3 ; row < this.board.length ; row++ ) {
								ImageIcon buttonText = (ImageIcon) this.board[row][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									
									if (counter == connect4) {
										return true;
									}
								} else {
									break;
								}
							}
						}
						
						for ( int col = 0 ; col < this.board[0].length ; col++ ) {
							counter = 0;
							for ( int row = 4 ; row < this.board.length ; row++ ) {
								ImageIcon buttonText = (ImageIcon) this.board[row][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									
									if (counter == connect4) {
										return true;
									}
								} else {
									break;
								}
							}
						}

						for ( int col = 0 ; col < this.board[0].length ; col++ ) {
							counter = 0;
							for ( int row = 5 ; row < this.board.length ; row++ ) {
								ImageIcon buttonText = (ImageIcon) this.board[row][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									
									if (counter == connect4) {
										return true;
									}
								} else {
									break;
								}
							}
						}
						
						for ( int col = 0 ; col < this.board[0].length ; col++ ) {
							counter = 0;
							for ( int row = 6 ; row < this.board.length ; row++ ) {
								ImageIcon buttonText = (ImageIcon) this.board[row][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									
									if (counter == connect4) {
										return true;
									}
								} else {
									break;
								}
							}
						}

						for ( int col = 0 ; col < this.board[0].length ; col++ ) {
							counter = 0;
							for ( int row = 7 ; row < this.board.length ; row++ ) {
								ImageIcon buttonText = (ImageIcon) this.board[row][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
								
									if (counter == connect4) {
										return true;
									}
								} else {
									break;
								}
							}
						}
			
			
					if(connect4 == 6) {
						for (int i = 0; i<2; i++) {
						
						counter = 0;
							int row = 0;
							int col = 0;
							while (row < this.board.length-1 && col < this.board.length) {
								ImageIcon buttonText = (ImageIcon) this.board[row+i][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									if (counter == connect4) {
										return true;
									}
									row++;
									col++;
								} else {
									break;
								}
							}
						}
							
							
							for (int i = 0; i<2; i++) {
						counter = 0;
							int row = 0;
							int col = 0;
							while (row < this.board.length-1 && col < this.board.length) {
								ImageIcon buttonText = (ImageIcon) this.board[row+i][col+1].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									if (counter == connect4) {
										return true;
									}
									row++;
									col++;
								} else {
									break;
								}
							}
						}
					}
					
					for (int i = 0; i<1; i++) {
				counter = 0;
					int row = 0;
					int col = 0;
					while (row < this.board.length-1 && col < this.board.length) {
						ImageIcon buttonText = (ImageIcon) this.board[row+i][col+1].getIcon();
						if (icon.equals(buttonText)) {
							counter++;
							if (counter == connect4) {
								return true;
							}
							row++;
							col++;
						} else {
							break;
						}
					}
				}
			
					
					if (connect4 == 5) {	
						
						for (int i = 0; i<3; i++) {
							counter = 0;
							int row = 0;
							int col = 0;
							while (row < this.board.length-1 && col < this.board.length) {
								ImageIcon buttonText = (ImageIcon) this.board[row+i][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									if (counter == connect4) {
										return true;
									}
									row++;
									col++;
								} else {
									break;
								}
							}
						}
						
						
						for (int i = 0; i<3; i++) {
							counter = 0;
							int row = 0;
							int col = 0;
							while (row < this.board.length-1 && col < this.board.length) {
								ImageIcon buttonText = (ImageIcon) this.board[row+i][col+1].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									if (counter == connect4) {
										return true;
									}
									row++;
									col++;
								} else {
									break;
								}
							}
						}
						
						
							for (int i = 0; i<3; i++) {
								counter = 0;
								int row = 0;
								int col = 0;
								while (row < this.board.length-1 && col < this.board.length) {
									ImageIcon buttonText = (ImageIcon) this.board[row+i][col+2].getIcon();
									if (icon.equals(buttonText)) {
										counter++;
										if (counter == connect4) {
											return true;
										}
										row++;
										col++;
									} else {
										break;
									}
								}
							}
					}
					
						if (connect4 == 4) {	
						
							for (int i = 0; i<connect4; i++) {
								counter = 0;
								int row = 0;
								int col = 0;
								while (row < this.board.length-1 && col < this.board.length) {
									ImageIcon buttonText = (ImageIcon) this.board[row+i][col].getIcon();
									if (icon.equals(buttonText)) {
										counter++;
										if (counter == connect4) {
											return true;
										}
										row++;
										col++;
									} else {
										break;
									}
								}
							}
							
				
				for (int i = 0; i<7-connect4; i++) {
								counter = 0;
								int row = 0;
								int col = 0;
								while (row < this.board.length-1 && col < this.board.length) {
									ImageIcon buttonText = (ImageIcon) this.board[row+i][col+1].getIcon();
									if (icon.equals(buttonText)) {
										counter++;
										if (counter == connect4) {
											return true;
										}
										row++;
										col++;
									} else {
										break;
									}
								}
							}
							
				
				for (int i = 0; i<7-connect4; i++) {
									counter = 0;
									int row = 0;
									int col = 0;
									while (row < this.board.length-1 && col < this.board.length) {
										ImageIcon buttonText = (ImageIcon) this.board[row+i][col+2].getIcon();
										if (icon.equals(buttonText)) {
											counter++;
											if (counter == connect4) {
												return true;
											}
											row++;
											col++;
										} else {
											break;
										}
									}
								}
								
				
				for (int i = 0; i<7-connect4; i++) {
								counter = 0;
								int row = 0;
								int col = 0;
								while (row < this.board.length-1 && col < this.board.length) {
									ImageIcon buttonText = (ImageIcon) this.board[row+i][col+3].getIcon();
									if (icon.equals(buttonText)) {
										counter++;
										if (counter == connect4) {
											return true;
										}
										row++;
										col++;
									} else {
										break;
									}
								}
							}
						}
						
				if (connect4 == 3) {	
						
								for (int i = 0; i<8-connect4; i++) {
									counter = 0;
									int row = 0;
									int col = 0;
									while (row < this.board.length-1 && col < this.board.length) {
										ImageIcon buttonText = (ImageIcon) this.board[row+i][col].getIcon();
										if (icon.equals(buttonText)) {
											counter++;
											if (counter == connect4) {
												return true;
											}
											row++;
											col++;
										} else {
											break;
										}
									}
								}
								
					
					for (int i = 0; i<8-connect4; i++) {
									counter = 0;
									int row = 0;
									int col = 0;
									while (row < this.board.length-1 && col < this.board.length) {
										ImageIcon buttonText = (ImageIcon) this.board[row+i][col+1].getIcon();
										if (icon.equals(buttonText)) {
											counter++;
											if (counter == connect4) {
												return true;
											}
											row++;
											col++;
										} else {
											break;
										}
									}
								}
								
					
					for (int i = 0; i<8-connect4; i++) {
										counter = 0;
										int row = 0;
										int col = 0;
										while (row < this.board.length-1 && col < this.board.length) {
											ImageIcon buttonText = (ImageIcon) this.board[row+i][col+2].getIcon();
											if (icon.equals(buttonText)) {
												counter++;
												if (counter == connect4) {
													return true;
												}
												row++;
												col++;
											} else {
												break;
											}
										}
									}
									

					for (int i = 0; i<8-connect4; i++) {
									counter = 0;
									int row = 0;
									int col = 0;
									while (row < this.board.length-1 && col < this.board.length) {
										ImageIcon buttonText = (ImageIcon) this.board[row+i][col+3].getIcon();
										if (icon.equals(buttonText)) {
											counter++;
											if (counter == connect4) {
												return true;
											}
											row++;
											col++;
										} else {
											break;
										}
									}
								}
					
					
					for (int i = 0; i<8-connect4; i++) {
						counter = 0;
						int row = 0;
						int col = 0;
						while (row < this.board.length-1 && col < this.board.length) {
							ImageIcon buttonText = (ImageIcon) this.board[row+i][col+4].getIcon();
							if (icon.equals(buttonText)) {
								counter++;
								if (counter == connect4) {
									return true;
								}
								row++;
								col++;
							} else {
								break;
							}
						}
					}
				}
				
				if (connect4== 2) {	
					
						for (int i = 0; i<8-connect4; i++) {
							counter = 0;
							int row = 0;
							int col = 0;
							while (row < this.board.length-1 && col < this.board.length) {
								ImageIcon buttonText = (ImageIcon) this.board[row+i][col].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									if (counter == connect4) {
										return true;
									}
									row++;
									col++;
								} else {
									break;
								}
							}
						}
						
			
			for (int i = 0; i<8-connect4; i++) {
							counter = 0;
							int row = 0;
							int col = 0;
							while (row < this.board.length-1 && col < this.board.length) {
								ImageIcon buttonText = (ImageIcon) this.board[row+i][col+1].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									if (counter == connect4) {
										return true;
									}
									row++;
									col++;
								} else {
									break;
								}
							}
						}
						
			
			for (int i = 0; i<8-connect4; i++) {
								counter = 0;
								int row = 0;
								int col = 0;
								while (row < this.board.length-1 && col < this.board.length) {
									ImageIcon buttonText = (ImageIcon) this.board[row+i][col+2].getIcon();
									if (icon.equals(buttonText)) {
										counter++;
										if (counter == connect4) {
											return true;
										}
										row++;
										col++;
									} else {
										break;
									}
								}
							}
		
			for (int i = 0; i<8-connect4; i++) {
							counter = 0;
							int row = 0;
							int col = 0;
							while (row < this.board.length-1 && col < this.board.length) {
								ImageIcon buttonText = (ImageIcon) this.board[row+i][col+3].getIcon();
								if (icon.equals(buttonText)) {
									counter++;
									if (counter == connect4) {
										return true;
									}
									row++;
									col++;
								} else {
									break;
								}
							}
						}
			

			for (int i = 0; i<8-connect4; i++) {
				counter = 0;
				int row = 0;
				int col = 0;
				while (row < this.board.length-1 && col < this.board.length) {
					ImageIcon buttonText = (ImageIcon) this.board[row+i][col+4].getIcon();
					if (icon.equals(buttonText)) {
						counter++;
						if (counter == connect4) {
							return true;
						}
						row++;
						col++;
					} else {
						break;
					}
				}
			}
			
			for (int i = 0; i<8-connect4; i++) {
				counter = 0;
				int row = 0;
				int col = 0;
				while (row < this.board.length-1 && col < this.board.length) {
					ImageIcon buttonText = (ImageIcon) this.board[row+i][col+5].getIcon();
					if (icon.equals(buttonText)) {
						counter++;
						if (counter == connect4) {
							return true;
						}
						row++;
						col++;
					} else {
						break;
					}
				}
			}
		}
						
						
					
				for (int i = 0; i<connect4; i++) {
					counter = 0;
					int row = this.board.length - 1;
					int col = 0;
					while (row >= 0 && col < this.board.length) {
						ImageIcon buttonText = (ImageIcon) this.board[row-i][col].getIcon();
						if (icon.equals(buttonText)) {
							counter++;
							if (counter == connect4) {
								return true;
							}
							row--;
							col++;
						} else {
							break;
						}
					}
				}
				
				for (int i = 0; i<connect4; i++) {
					counter = 0;
					int row = this.board.length - 1;
					int col = 0;
					while (row >= 0 && col < this.board.length) {
						ImageIcon buttonText = (ImageIcon) this.board[row-i][col+1].getIcon();
						if (icon.equals(buttonText)) {
							counter++;
							if (counter == connect4) {
								return true;
							}
							row--;
							col++;
						} else {
							break;
						}
					}
				}
				
				for (int i = 0; i<connect4; i++) {
					counter = 0;
					int row = this.board.length - 1;
					int col = 0;
					while (row >= 0 && col < this.board.length) {
						ImageIcon buttonText = (ImageIcon) this.board[row-i][col+2].getIcon();
						if (icon.equals(buttonText)) {
							counter++;
							if (counter == connect4) {
								return true;
							}
							row--;
							col++;
						} else {
							break;
						}
					}
				}
				
				for (int i = 0; i<connect4; i++) {
					counter = 0;
					int row = this.board.length - 1;
					int col = 0;
					while (row >= 0 && col < this.board.length) {
						ImageIcon buttonText = (ImageIcon) this.board[row-i][col+3].getIcon();
						if (icon.equals(buttonText)) {
							counter++;
							if (counter == connect4) {
								return true;
							}
							row--;
							col++;
						} else {
							break;
						}
					}
				}
			
			
			return false;
		}
		
		
		public void displayWinner() {
			currentPlayer.totalWins();
			int numWins = currentPlayer.getNumWins();
			
			if (currentPlayer.equals(playerNum1)) { 
				mainScoreBoard.setPlayer1Score(numWins);
			} else {
				mainScoreBoard.setPlayer2Score(numWins);
			}
			
			mainScoreBoard.setLastWinnerName(currentPlayer.getPlayerName());
			
			if (playerNum1.compareTo(playerNum2) > 0) {
				mainScoreBoard.setPlayerName(playerNum1.getPlayerName());
			} else if (playerNum2.compareTo(playerNum1) > 0) {
				mainScoreBoard.setPlayerName(playerNum2.getPlayerName());
			} else {
				mainScoreBoard.setPlayerName("----------");
			}
			
		}
		
		
		public void askToPlayAgain() {
		 	int yesno = JOptionPane.showConfirmDialog(null, "Play Again?", "Yes or No", JOptionPane.YES_NO_OPTION);
			 	if (yesno == JOptionPane.YES_OPTION) {
			 		clear();
			 	} else {
			 		System.exit(EXIT_ON_CLOSE);
		 	}
		}

		
		public boolean boardIsFull() {
			for ( int row = 0 ; row < this.board.length ; row++ ) {
				for ( int col = 0 ; col < this.board[row].length ; col++ ) {
					ImageIcon buttonText = (ImageIcon) this.board[row][col].getIcon();
					if (buttonText == null) {
						return false;
					}
				}
			}
			return true;
		}
		
		
		public int findColumn (JButton button){
			for (row = 0; row < this.board.length; row++){
				for(col = 0; col < this.board[row].length; col++){
					
					if (this.board[row][col].equals(button)){
						return col;
						
					}
				}
			}
			return -1;
		}
		
		public int emptyRow (int col){
			
			for (int row = rowTile-1; row >= 0; row--){
				if(board[row][col].getIcon() == null){
					return row;
				}
			}
			return -1;
		}
		
		
		public int findOpenRow (int col, int row, ActionEvent e){
			JButton clickedButton = (JButton) e.getSource();
			for (row = rowTile-1; row > 0; row--){
				if (row == NOTHING){
					
					clickedButton.setEnabled(true);
					
				}
			}
			return col;
		}
		
	    @Override
		public void actionPerformed(ActionEvent e) {
			
	    	JButton clickedButton = (JButton) e.getSource();
	    	
			col = findColumn(clickedButton);
			row = emptyRow(col);

			this.board[row][col].setIcon(currentPlayer.getPlayerSymbol());
			
		
			
			int click = 0;
			String btn = e.getActionCommand();
			

	
			if(clickedButton.getModel().isPressed())
			 {
				
			    
				for (col = 0; col < this.board.length-1; col++){
					if (clickedButton != this.board[6][col]){
						for (row = 0; row < this.board.length-1; row--){
							
							if (row == NOTHING){
								
								clickedButton = this.board[row][col];
							
							}
							
							
							
						}
					}
				
				
					
				}
			 }

			 
			
			if (isWinner(currentPlayer.getPlayerSymbol())) {
				JOptionPane.showMessageDialog(null, "Winner Is " + currentPlayer.getPlayerName());
				displayWinner();
				askToPlayAgain();
			}
			
			if (boardIsFull()) {
				JOptionPane.showMessageDialog(null, "Game Is A Draw");
				askToPlayAgain();
			}
			
			alternateThePlayer();
			
		}
		
	}
	
	
	private class MainScoreBoard extends JPanel {
		
		private JPanel info;
		private JLabel labelPlayer, playerName , labelCurrentPlayer,CurrentPlayerName;
		private JLabel labelForLastWinner, lastWinnerName;
		
		
		private JPanel playScoreInfo;
		private JLabel labelPlaceHolder, labelForPlayer1Name, labelForPlayer2Name;
		private JLabel labelForPlayerNames, player1Name, player2Name;
		

		private JLabel labelForPlayerScore, player1Score, player2Score;
		
		
		public MainScoreBoard() {
			setLayout(new BorderLayout());
			info = new JPanel(new GridLayout(3, 2));
			info.setBackground(Color.WHITE);
			
			playScoreInfo = new JPanel(new GridLayout(3, 3));
			playScoreInfo.setBackground(Color.YELLOW);
			
			labelPlayer = new JLabel("Player");
			playerName = new JLabel("----------");
			
			labelForLastWinner = new JLabel("Last Winner");
			lastWinnerName = new JLabel("----------");
			labelCurrentPlayer = new JLabel("CurrentPlayer:");
			CurrentPlayerName = new JLabel( "---------");
	         
			
			JLabel[] genLabels = {labelPlayer, playerName, 
									labelForLastWinner,labelCurrentPlayer, lastWinnerName,CurrentPlayerName };
			
			for ( int i = 0 ; i < genLabels.length ; i++ ) {
				genLabels[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
				info.add(genLabels[i]);
			}
			
			
			labelPlaceHolder = new JLabel("          ");
			labelForPlayer1Name = new JLabel("Player 1");
			labelForPlayer2Name = new JLabel("Player 2");
			
			labelForPlayerNames = new JLabel("Name");
			player1Name = new JLabel(playerNum1.getPlayerName());
			player2Name = new JLabel(playerNum2.getPlayerName());
			
			labelForPlayerScore = new JLabel("Score");
			player1Score = new JLabel("----------");
			player2Score = new JLabel("----------");

			JLabel[] playLabels = {labelPlaceHolder, labelForPlayer1Name, labelForPlayer2Name,
									labelForPlayerNames, player1Name, player2Name,
									labelForPlayerScore, player1Score, player2Score};
			
			for ( int i = 0 ; i < playLabels.length ; i++ ) {
				playLabels[i].setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));
				playScoreInfo.add(playLabels[i]);
			}
			
			add(playScoreInfo, BorderLayout.CENTER);
			add(info, BorderLayout.NORTH);
			
		}
		
		
		public void setCurrentPlayerName(Player currentPlayer) {
			this.CurrentPlayerName.setText(String.valueOf(currentPlayer).substring(22,30));	
		}


		private void setPlayerName(String playerName) {
			this.playerName.setText(playerName);
		}
		
		
		private void setLastWinnerName(String lastWinnerName) {
			this.lastWinnerName.setText(lastWinnerName);
		}

		private void setPlayer1Score(int score) {
			this.player1Score.setText(""+score);
		}

		private void setPlayer2Score(int score) {
			this.player2Score.setText(""+score);
		}
		
	}
	
}