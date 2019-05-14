import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Player implements Comparable<Player> {
	
	private String pName;
	private ImageIcon playerIcon;
	private int totalWins;

	public Player() {
		playerIcon = new ImageIcon(getClass().getResource(""));
		pName = "";
	}
	
	public Player(ImageIcon playerIcon) {
		this("Default", playerIcon);
	}
	
	public Player(String playerName, ImageIcon playerSymbol) {
		this.pName = playerName;
		this.playerIcon = playerSymbol;
		this.totalWins = 0;
	}
	
	public void totalWins() {
		this.totalWins++;
	}

	public String getPlayerName() {
		return pName;
	}

	public void setPlayerName(String playerName) {
		this.pName = playerName;
	}

	public ImageIcon getPlayerSymbol() {
		return playerIcon;
	}

	public void setPlayerSymbol(ImageIcon playerSymbol) {
		this.playerIcon = playerSymbol;
	}

	public int getNumWins() {
		return totalWins;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Player) {
			Player otherPlayer = (Player) obj;
			if (this.pName.equals(otherPlayer.getPlayerName())) {
				if (this.playerIcon.equals(otherPlayer.getPlayerSymbol())) {
					if (this.totalWins == otherPlayer.getNumWins()) {
						return true; 
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Player [ playerName = " + this.pName +
						"                  , playerSymbol = " + this.playerIcon +
						", numWins = " + this.totalWins + "]";
	}

	@Override
	public int compareTo(Player o) {
		if (this.totalWins > o.getNumWins()) {
			return 1;
		} else if (this.totalWins == o.getNumWins()) {
			return 0;
		} else {
			return -1;
		}
	}

	

}
