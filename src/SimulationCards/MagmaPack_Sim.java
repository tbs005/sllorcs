package SimulationCards;

import java.util.ArrayList;

import BattleStuff.Board;
import BattleStuff.UColor;
import BattleStuff.DamageType;
import BattleStuff.Minion;
import BattleStuff.UPosition;
import BattleStuff.tileSelector;

public class MagmaPack_Sim extends Simtemplate
{
	//"id":85,"name":"Magma Pack","description":"When Magma Pack comes into play, enchanted unit's Attack is doubled. Enchanted unit is destroyed after attacking."

	public tileSelector getTileSelectorForFirstSelection()
	{
		return tileSelector.all_units;
	}
	
	public void onCardPlay(Board b, UColor player , ArrayList<UPosition> targets, Minion playedCard)
    {
		Minion target = b.getMinionOnPosition(targets.get(0));
		int abuff = target.getAttack();
		target.buffMinionWithoutMessage(abuff, 0, 0, b);
		target.addCardAsEnchantment("ENCHANTMENT", "Magma Pack", playedCard.card.cardDescription, playedCard, b);
        return;
    }
	
	public void onAttackDone(Board b , Minion m, Minion self)
    {

		b.destroyMinion(m, self);
    	return;
    }
	
}
