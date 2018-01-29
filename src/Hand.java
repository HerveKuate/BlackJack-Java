import java.util.*;

public class Hand {
private LinkedList <Card> cardList=new LinkedList <Card>();

Hand()
{
this.cardList=new LinkedList <Card>();
}
public String toString() {
	StringBuilder s= new StringBuilder();
	s.append("[");
	for(int i = 0 ; i < this.cardList.size() ; i ++)
			{
			      s.append(this.cardList.get(i)+", ");
			}
	s.append("] ");
	return s.toString();
}

public void add(Card card)
{
	this.cardList.add(card);
}

public void clear()
{
	this.cardList.clear();
}

public LinkedList<Card> getHand()
{
	return this.cardList;
}

public List<Integer> count()
{
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.add(0);
	int number=0;
	int boucle=list.size();
	for(int i = 0 ; i < this.cardList.size(); i ++) {
		for(int j=0;j<boucle;j++)
		{
			
			if(this.cardList.get(i).getPoints()==1)
		{
			number=list.get(j);
			list.set(j, number+1);
			list.add(11+number);
			
		}
			else
				list.set(j, list.get(j)+this.cardList.get(i).getPoints());
				
		}
		boucle=list.size();
	}	
	return list;
}

public int best()
{
	List<Integer> list = this.count();
	int min=0;
	for(int i = 0 ; i < list.size() ; i ++) {
	if(min<list.get(i) && list.get(i)<21)
		min=list.get(i);
	}
	if(min==0) {
		min=list.get(0);
		for(int i = 0 ; i < list.size() ; i ++) {
			if(min>list.get(i))
				min=list.get(i);
			}
	}
		
	return min;
	
}

public int highestScore()
{
	List<Integer> list = this.count();
	int min=0;
	for(int i = 0 ; i < list.size() ; i ++) {
	if(min<list.get(i))
		min=list.get(i);
	}
	return min;
	
}

public List<Card> getCardList() {
	return this.cardList;
}


public static void main(String[] args) {
{
	System.out.println("Welcome to the BlackJack table. Let's play !");
	Deck deck = new Deck(2);
	Hand hand = new Hand();
	System.out.println("Your hand is currently : "+ hand);
	for(int i = 0 ; i < 3 ; i ++) {
	try {
	hand.add(deck.draw());
	} catch (EmptyDeckException ex) {
	System.err.println(ex.getMessage());
	System.exit(-1);
	}
	}
	
	System.out.println("Your hand is currently : "+ hand+" "+hand.count()+"");
	System.out.println("The best score is "+hand.best());
	hand.clear();
	System.out.println("Your hand is currently : "+ hand);
	
}


}
}