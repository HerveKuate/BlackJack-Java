import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class Deck
{
private LinkedList <Card> deck = new LinkedList <Card>();
		

Deck (int numberOfDeck)
{
	for(int i=0;i<numberOfDeck;i++)
	{
	this.deck.add(new Card(Value.AS, Color.HEART));
	this.deck.add(new Card(Value.AS, Color.SPADE));
	this.deck.add(new Card(Value.AS, Color.CLUB));
	this.deck.add(new Card(Value.AS, Color.DIAMOND));
			
	this.deck.add(new Card(Value.TWO, Color.HEART));
	this.deck.add(new Card(Value.TWO, Color.SPADE));
	this.deck.add(new Card(Value.TWO, Color.CLUB));
	this.deck.add(new Card(Value.TWO, Color.DIAMOND));
			
	this.deck.add(new Card(Value.THREE, Color.HEART));
	this.deck.add(new Card(Value.THREE, Color.SPADE));
	this.deck.add(new Card(Value.THREE, Color.CLUB));
	this.deck.add(new Card(Value.THREE, Color.DIAMOND));
			
	this.deck.add(new Card(Value.FOUR, Color.HEART));
	this.deck.add(new Card(Value.FOUR, Color.SPADE));
	this.deck.add(new Card(Value.FOUR, Color.CLUB));
	this.deck.add(new Card(Value.FOUR, Color.DIAMOND));
			
	this.deck.add(new Card(Value.FIVE, Color.HEART));
	this.deck.add(new Card(Value.FIVE, Color.SPADE));
	this.deck.add(new Card(Value.FIVE, Color.CLUB));
	this.deck.add(new Card(Value.FIVE, Color.DIAMOND));
			
	this.deck.add(new Card(Value.SIX, Color.HEART));
	this.deck.add(new Card(Value.SIX, Color.SPADE));
	this.deck.add(new Card(Value.SIX, Color.CLUB));
	this.deck.add(new Card(Value.SIX, Color.DIAMOND));
			
	this.deck.add(new Card(Value.SEVEN, Color.HEART));
	this.deck.add(new Card(Value.SEVEN, Color.SPADE));
	this.deck.add(new Card(Value.SEVEN, Color.CLUB));
	this.deck.add(new Card(Value.SEVEN, Color.DIAMOND));
			
	this.deck.add(new Card(Value.EIGHT, Color.HEART));
	this.deck.add(new Card(Value.EIGHT, Color.SPADE));
	this.deck.add(new Card(Value.EIGHT, Color.CLUB));
	this.deck.add(new Card(Value.EIGHT, Color.DIAMOND));
			
	this.deck.add(new Card(Value.NINE, Color.HEART));
	this.deck.add(new Card(Value.NINE, Color.SPADE));
	this.deck.add(new Card(Value.NINE, Color.CLUB));
	this.deck.add(new Card(Value.NINE, Color.DIAMOND));
			
	this.deck.add(new Card(Value.TEN, Color.HEART));
	this.deck.add(new Card(Value.TEN, Color.SPADE));
	this.deck.add(new Card(Value.TEN, Color.CLUB));
	this.deck.add(new Card(Value.TEN, Color.DIAMOND));
			
	this.deck.add(new Card(Value.JACK, Color.HEART));
	this.deck.add(new Card(Value.JACK, Color.SPADE));
	this.deck.add(new Card(Value.JACK, Color.CLUB));
	this.deck.add(new Card(Value.JACK, Color.DIAMOND));
			
	this.deck.add(new Card(Value.QUEEN, Color.HEART));
	this.deck.add(new Card(Value.QUEEN, Color.SPADE));
	this.deck.add(new Card(Value.QUEEN, Color.CLUB));
	this.deck.add(new Card(Value.QUEEN, Color.DIAMOND));
			
	this.deck.add(new Card(Value.KING, Color.HEART));
	this.deck.add(new Card(Value.KING, Color.SPADE));
	this.deck.add(new Card(Value.KING, Color.CLUB));
	this.deck.add(new Card(Value.KING, Color.DIAMOND));
	
	Collections.shuffle(deck);;
	}
}

public LinkedList<Card> getDeck()
{
	return this.deck;
}
public Card draw() throws EmptyDeckException
{
	return this.deck.pollFirst();
}


@Override
public String toString() {
	StringBuilder s= new StringBuilder();
	s.append("[");
	   		for(int i = 0; i < this.deck.size()-1; i++)
			{
			      s.append(this.deck.get(i)+", ");
			}
			s.append(this.deck.getLast()+"] ");
	return s.toString();
}


}
