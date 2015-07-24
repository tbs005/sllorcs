package SimulationCards;

import java.util.ArrayList;

import BattleStuff.Board;
import BattleStuff.UColor;
import BattleStuff.Kind;
import BattleStuff.Minion;
import BattleStuff.UPosition;
import BattleStuff.SubType;
import BattleStuff.tileSelector;

public class EyeOfEagle_Sim extends Simtemplate {
	//id":89,"name":"Eye of Eagle","description":"Draw 1 creature scroll."
	
	
	public tileSelector getTileSelectorForFirstSelection()
	{
		return tileSelector.None;
	}
	
	public void onCardPlay(Board b, UColor player , ArrayList<UPosition> targets, Minion playedCard)
    {
		
		//draw creature scroll
		ArrayList<Minion> deck = new ArrayList<Minion>(b.currentDeck);
		Boolean found = false;
		for(int i=0; i<deck.size(); i++)
		{
			Minion m= deck.get(i);
			if(m.card.cardKind == Kind.CREATURE)
			{
				found=true;
				b.currentHand.add(m);
				deck.remove(i);
				b.shuffleList(b.currentDeck);
				break;
			}
		}
		
		//look into graveyard
		if(!found)
		{
			deck.clear();
			deck.addAll(b.currentGrave);
			for(int i=0; i<deck.size(); i++)
			{
				Minion m= deck.get(i);
				if(m.card.cardKind == Kind.CREATURE)
				{	
					found=true;
					b.currentHand.add(m);
					deck.remove(i);
					b.shuffleList(b.currentGrave);
					break;
				}
			}
		}
		
		if(found)
		{
			//hand+ cardstack update
			b.addMessageToPlayer(b.activePlayerColor, b.getHandUpdateMessage(b.activePlayerColor));
			b.addMessageToBothPlayers(b.getCardStackUpdate(b.activePlayerColor));
		}
		
        return;
    }
	
}
