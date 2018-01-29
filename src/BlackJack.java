import java.util.List;

public class BlackJack {

	private Deck deck=new Deck(1);
	private Hand playerHand=new Hand();
	private Hand bankHand=new Hand();
	public Boolean gameFinished=false;
	
	public BlackJack() throws EmptyDeckException
	{
		reset();
	}
	
	public void reset() throws EmptyDeckException{
		this.deck=new Deck(1);
		this.playerHand=new Hand();
		this.bankHand=new Hand();
	}
	
	public String getPlayerHandString() {
		return this.playerHand.toString();
	}
	
	public String getBankHand() {
		return this.bankHand.toString();
	}
	
	public int getPlayerBest() {
		return this.playerHand.best();
	}
	
	public int getBankBest() {
		return this.bankHand.best();
	}
	
	public boolean isPlayerWinner() {
		if(this.playerHand.best()>this.bankHand.best())
		{
			{if(this.gameFinished==true && this.playerHand.best()<=21)
			return true;
			}
		}
		if(this.bankHand.best()>21)return true;
		return false;
	}
	
	public boolean isBankWinner() {
		if(this.playerHand.best()<this.bankHand.best())
		{
			{if(this.gameFinished==true && this.bankHand.best()<=21)
			return true;
			}
		}
		if(this.playerHand.best()>21)return true;
		
		return false;
	}
	
	public boolean isgamefinished() {
		if(this.playerHand.best()>21||this.bankHand.best()>21)
			return true;
		
		return false;
		
	}
	
	public void playerDrawAnotherCard() throws EmptyDeckException {
		if(this.gameFinished==false)
		{
			this.playerHand.add(this.deck.draw());
			if(this.playerHand.best()>21)
				{this.gameFinished=true;}
		} 
	}
	
	public void bankLastTurn() throws EmptyDeckException {
		if(this.gameFinished==false) {
			while(this.bankHand.best()<=21) {
				this.bankHand.add(this.deck.draw());
				if(this.bankHand.best()>this.playerHand.best() && this.bankHand.best()<21)
				{
					this.gameFinished=true;
				
				break;
				}
				if(this.bankHand.best()>21)
				{this.gameFinished=true;
				break;}
				
			}
			this.gameFinished=true;
		}
	}
	
	List<Card> getPlayerCardList(){
		return this.playerHand.getHand();
	}
	
	List<Card> getBankCardList(){
		return this.bankHand.getHand();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
