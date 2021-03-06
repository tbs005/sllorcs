package SimulationCards;

import java.util.ArrayList;

import BattleStuff.AttackType;
import BattleStuff.Board;
import BattleStuff.Card;
import BattleStuff.CardDB;
import BattleStuff.UColor;
import BattleStuff.DamageType;
import BattleStuff.Kind;
import BattleStuff.Minion;
import BattleStuff.UPosition;
import BattleStuff.SubType;
import BattleStuff.tileSelector;

public class FaithChains_Sim extends Simtemplate {
	//"id":103,"name":"Faith Chains","description":"When enchanted creature is destroyed, Faith Chains deals 1 damage to opponent idols."
	
	public tileSelector getTileSelectorForFirstSelection()
	{
		return tileSelector.all_creatures;
	}
	
	public void onCardPlay(Board b, UColor player , ArrayList<UPosition> targets, Minion playedCard)
    {
		Minion target = b.getMinionOnPosition(targets.get(0));
		target.addCardAsEnchantment("ENCHANTMENT", "Faith Chains", "", playedCard, b);
        return;
    }
	
	public  void onMinionDiedTrigger(Board b, Minion triggerEffectMinion, Minion diedMinion, Minion attacker, AttackType attackType, DamageType dmgtype)
    {
		//unbuff wolf if a wolf dies
		if(triggerEffectMinion.owner != null && triggerEffectMinion.owner == diedMinion)
		{
			UColor opp = Board.getOpposingColor(diedMinion.position.color);
			ArrayList<Minion> idols = new ArrayList<Minion>();
			for(Minion m : b.getPlayerIdols(opp))
			{
				if(m.Hp>=1)
				{
					m.aoeDmgToDo=1;
				}
			}
			
			b.doDmg(idols, triggerEffectMinion, -100, AttackType.UNDEFINED, DamageType.MAGICAL);//dmg=-100 => aoedmg :D
		}
			
        return;
    }
	
	public  void onDeathrattle(Board b, Minion m, Minion attacker, AttackType attacktype, DamageType dmgtype)
    {
	 	if(m.owner== null) return;
        return;
    }
	
	
}
