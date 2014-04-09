package proj2;

public enum Move {

	PLAYER1("x"),
	PLAYER2("o"),
	EMPTY("_");
	
	private String symbol;
	
	Move(String symbol){
		
		this.symbol = symbol;
	}
	
	public String getSymbol(){
		
		return this.symbol;
	}
}
