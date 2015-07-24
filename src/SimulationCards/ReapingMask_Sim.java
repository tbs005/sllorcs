package SimulationCards;

import java.util.ArrayList;

import BattleStuff.AttackType;
import BattleStuff.Board;
import BattleStuff.DamageType;
import BattleStuff.Kind;
import BattleStuff.UColor;
import BattleStuff.Minion;
import BattleStuff.UPosition;
import BattleStuff.tileSelector;

public class ReapingMask_Sim extends Simtemplate 
{

	//"id":319,"name":"Reaping Mask","description":"Enchanted unit gets +3 Attack and +3 Health. When enchanted unit destroys a creature, draw a creature scroll."
	
	public tileSelector getTileSelectorForFirstSelection()
	{
		return tileSelector.all_units;
	}
	
	public void onCardPlay(Board b, UColor player , ArrayList<UPosition> targets, Minion playedCard)
    {
		Minion target = b.getMinionOnPosition(targets.get(0));
		target.buffMinionWithoutMessage(3, 3, 0, b);//status update is done in add card as enchantment
		target.addCardAsEnchantment("ENCHANTMENT", "Reaping Mask", playedCard.card.cardDescription, playedCard, b);
        return;
    }
	
	public  void onMinionDiedTrigger(Board b, Minion triggerEffectMinion, Minion diedMinion, Minion attacker, AttackType attackType, DamageType dmgtype)
    {
		
		
		if(diedMinion != triggerEffectMinion.owner && attacker == triggerEffectMinion.owner && diedMinion.cardType == Kind.CREATURE)
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
			
        return;
    }
	
}
