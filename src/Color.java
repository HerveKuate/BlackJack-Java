
public enum Color {
HEART("♥"),
SPADE("♠"), 
CLUB("♣"),
DIAMOND("♦");

private String symbole;

Color (String symbole)
{
	this.symbole=symbole;
}
public String getSymbole()
{
	return this.symbole;
}
	
}
