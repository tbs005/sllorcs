package SimulationCards;

import java.util.ArrayList;

import BattleStuff.AttackType;
import BattleStuff.Board;
import BattleStuff.Card;
import BattleStuff.ResourceName;
import BattleStuff.UColor;
import BattleStuff.DamageType;
import BattleStuff.Minion;
import BattleStuff.UPosition;
import BattleStuff.SubType;
import BattleStuff.TargetAreaGroup;
import BattleStuff.tileSelector;

public class Simtemplate {
	//#############
	//the basis class for all simulation-stuff
	
	public int getGrowthCost(Board b ,Minion m)
    {
    	return m.card.costGrowth;
    }
	
	public int getOrderCost(Board b ,Minion m)
    {
    	return m.card.costOrder;
    }
	
	public int getEnergyCost(Board b ,Minion m)
    {
    	return m.card.costEnergy;
    }
	
	public int getDecayCost(Board b ,Minion m)
    {
    	return m.card.costDecay;
    }

	//only used for Spells and enchantments... units + structures automatically select all free tiles of your side
	public tileSelector getTileSelectorForFirstSelection()
	{
		return tileSelector.None;
	}
	
	//only few cards uses a second target (like transposition) 
	//if none is replaced, there is no second selection in this case we just return "tileSets":[[ ... ]]
	//if something other then none is returned, we return "tileSets":[[...],[...]]
	public tileSelector getTileSelectorForSecondSelection()
	{
		return tileSelector.None;
	}
	
	public TargetAreaGroup getTargetAreaGroup()
	{
		return TargetAreaGroup.None;
	}
	
	//spell is played
    public void onCardPlay(Board b, UColor player , ArrayList<UPosition> targets, Minion playedCard)
    {
        return;
    }

    //minion is played on field
    public  void getBattlecryEffect(Board b, Minion own, Minion target)
    {
        return;
    }
    
    
    
    //a new Minion is summoned and got the buff this minion (which is allready on board) provides
    //"comes into play"-effects
    public  void onMinionIsSummoned(Board b, Minion triggerEffectMinion, Minion summonedMinion)
    {
        return;
    }
    
    public  void onEnergyChanged(Board b, Minion triggerEffectMinion, UColor player, ResourceName ressi)
    {
        return;
    }
    
    public  void onMinionMoved(Board b, Minion triggerEffectMinion, Minion movedMinion)
    {
        return;
    }

    //NOT CALLED on Metamorphosis
    //TODO call this if minion died, or replayed to hand, or destroyed (same as died?)
    public  void onMinionLeavesBattleField(Board b, Minion auraendminion)
    {
        return;
    }

    //return true for special attack like ether pump + charge coil
    public  boolean hasSpecialAttack()
    {
        return false;
    }
    
  //minion is doing special attack
    public  void doSpecialAttack(Board b, Minion own)
    {
        return;
    }
    
    //return false if unit doesnt attack, (like automaton)
    public  boolean doesAttack(Board b, Minion m)
    {
        return true;
    }
    
    public int doesCountDown(Board b, Minion m)
    {
        return -1; //-1 per round is default -> 0= dont count down, 1=count up (Fulmination Conduit)
    }
    
    
    //for: hellspliter mortal target (random tile)
    public boolean hasSpecialAttackTarget()
    {
    	return false;
    }
    
    //for hellspliter choose random tile here!
    public ArrayList<UPosition> getSpecialAttackTarget(Board b, Minion m)
    {
    	ArrayList<UPosition> posis = new ArrayList<UPosition>();
    	
    	return posis;
    }

    //for stuff like clock library
    //TODO implement this trigger
    public void onCountdownReachesZero(Board b , Minion m)
    {
    	return;
    }
    
    //possible with caravans of the Expanse! (minion has to check it himself)
    //activated even if minion has not/losed the dominion effect allready
    public void onDominonGoesAway(Board b , Minion triggerEffectMinion)
    {
    	return;
    }
    //activated, even if dominion effect is allready active! (minion has to check it himself)
    public void onDominonOccours(Board b , Minion triggerEffectMinion)
    {
		
    	return;
    }
    
    
    //for effects like aging knight + Automaton forge + the other forge :D are done this way
    public void onAttackDone(Board b , Minion m, Minion self)
    {
    	
    	return;
    }
    
    public int getLingerDuration(Board b ,Minion m)
    {
    	return 0;
    }

    // returns the spiky damage for the unit or the enchantment that is providing the dmg or the linger-spell
    public int getSpikyDamage(Board b ,Minion m, Minion defender)
    {
    	return 0;
    }
    
    public int getArmor(Board b ,Minion triggerEffectMinion, Minion minion)
    {
    	return 0;
    }
    
    public int getMagicResistance(Board b ,Minion triggerEffectMinion, Minion minion)
    {
    	return 0;
    }
    
    public int getPoisonBonus(Board b ,Minion m)
    {
    	return 0;
    }
    
    public int getIdolDamageBonus(Board b ,Minion m, AttackType attackType, DamageType damageType)
    {
    	return 0;
    }
    
    public boolean hasWard(Board b ,Minion m)
    {
    	return false;
    }
    
    public boolean hasPiercing(Board b ,Minion m)
    {
    	return false;
    }
    
    public void onSubTypeAdded(Board b, Minion triggerEffectMinion, Minion m, SubType subt )
    {
    	return;
    }
    
    public void onSubTypeDeleted(Board b, Minion triggerEffectMinion, Minion m, SubType subt )
    {
    	return;
    }
    
    //triggered AFTER a spell was played (like resonance (for resonance please check if its your turn))
    //for ressonance.. the unit counts.. not the owner of the spell!!!
    public void onPlayerPlayASpell(Board b ,Minion triggerEffectMinion, Minion spell)
    {
    	return;
    }
    
    //triggered right after onplayerplayaspell
    public void onPlayerPlayASpellOrEnchantment(Board b ,Minion triggerEffectMinion, Minion spell)
    {
    	return;
    }
    
    
    // returns if unit or the enchantment is poisonous
    public boolean isPoisonous(Board b ,Minion m)
    {
    	return false;
    }
    
 // returns if unit or the enchantment is poisonous
    public boolean isRelentless(Board b ,Minion m)
    {
    	return false;
    }
    
    public boolean reduceDmgToOne(Board b ,Minion m)
    {
    	return false;
    }
    
    public boolean isImuneToDmg(Board b, Minion triggerEffectMinion, Minion m, Minion attacker, AttackType attackType, DamageType damageType)
    {
    	return false;
    }
    
    //unit takes dmg trigger (like bloodboil)
    // IS ALSO CALLED IF DMG WAS 0!
    public  void onMinionGotDmgTrigger(Board b, Minion triggerEffectMinion, Minion damagedMinion, int dmg, Minion attacker)
    {
        return;
    }
    
    //unit did dmg trigger (like arthritis)
    public  void onMinionDidDmgTrigger(Board b, Minion triggerEffectMinion, Minion damagedMinion, Minion attacker, int dmgdone, AttackType attackType, DamageType dmgtype)
    {
        return;
    }
    
    //for effects like elan vital or other heal effects
    public  void onTurnStartTrigger(Board b, Minion triggerEffectMinion, UColor turnStartColor)
    {
        return;
    }
    
  //for effects like that order soldier that triggers if a enemy unit died in combat or buffs that lasts till end of turn
    //last parameter could be null if its not a attached card
    //returns true if it is deleted (current used in minion turnEndingDebuffing)
    //triggerEffectMinion = minion that triggers the effect himself
    
    //maybe another function for enchantments? (cause kinfolk has a enchantment, but is a minion so his enchantment remove is called when he dies :D)
    public  Boolean onTurnEndsTrigger(Board b, Minion triggerEffectMinion, UColor turnEndColor)
    {
        return false;
    }
    
    //minion died (only itself)
    public  void onDeathrattle(Board b, Minion m, Minion attacker, AttackType attacktype, DamageType dmgtype)
    {
        return;
    }
    
    // a minion died (not itself) // unstable too, only triggered, when minion with trigger effect is allive!

    public  void onMinionDiedTrigger(Board b, Minion triggerEffectMinion, Minion diedMinion, Minion attacker, AttackType attackType, DamageType dmgtype)
    {
        return;
    }
    
    //need to delete effect of Enchantment
    public  void onEffectIsRemoved(Board b, Minion triggerEffectMinion)
    {
        return;
    }
    
    
    //the field changed (like unit moved, died, new summoned)
    public void onFieldChanged(Board b, Minion triggerEffectMinion)
    {
    	return;
    }
    
    //ability is activated
    public  void onAbilityIsActivated(Board b, Minion triggerEffectMinion, ArrayList<UPosition> targets )
    {
        return;
    }
    
    //like ember bonds
    public  void onUnitIsGoingToAttack(Board b, Minion triggerEffectMinion, Minion attacker )
    {
        return;
    }
    
    //for cards like earthborn mystic
    public  void onUnitGotEnchantment(Board b, Minion triggerEffectMinion, Minion minion, boolean isItsFirstEnchantment )
    {
        return;
    }
    
    public  void onUnitLoseEnchantment(Board b, Minion triggerEffectMinion, Minion minion, boolean isLastOne)
    {
        return;
    }
    
    //is Effect
    public Boolean isEffect(Minion m)
    {
        return false;
    }
    
    //TODO add function that rebuffs the minion (effects only) for deleting the enchantments-effects: create new minion and redo its effects
    
    
    
    public static Simtemplate intToSimtemplate(int id)//only called once per card on carddbcreation
    {
    	
    	
    	//order set 1 and 2
    	if(id == 15) return new CrownOfStrength_Sim();
    	if(id == 19) return new Metempsychosis_Sim();
    	if(id == 20) return new ThoughtTrap_Sim();
    	if(id == 23) return new Callback_Sim();
    	if(id == 36) return new Flip_Sim();
    	if(id == 37) return new FrostWind_Sim();
    	if(id == 48) return new Pushback_Sim();
    	if(id == 52) return new SinmarkedZealot_Sim();
    	if(id == 54) return new RoyalVanguard_Sim();
    	if(id == 55) return new Speed_Sim();
    	if(id == 57) return new Pother_Sim();
    	if(id == 61) return new WakingStones_Sim();
    	if(id == 71) return new Focus_Sim();
    	if(id == 73) return new NewOrders_Sim();
    	if(id == 86) return new PlateArmor_Sim();
    	
    	if(id == 93) return new FaithBlessing_Sim();
    	if(id == 97) return new VengeanceVeil_Sim();
    	if(id == 99) return new Purification_Sim();
    	if(id == 101) return new HornOfAges_Sim();
    	if(id == 103) return new FaithChains_Sim();
    	if(id == 109) return new DesertMemorial_Sim();
    	if(id == 111) return new WoodlandMemorial_Sim();
    	if(id == 119) return new KnightScholar_Sim();
    	if(id == 120) return new Obelisk_Sim();
    	if(id == 124) return new ResonantHelm_Sim();
    	if(id == 125) return new Crossbowman_Sim();
    	if(id == 126) return new RoyalInfantryman_Sim();
    	if(id == 127) return new RoyalSkirmisher_Sim();
    	if(id == 128) return new RoyalSpearman_Sim();
    	if(id == 158) return new DivineMark_Sim();
    	
    	//order set 3
    	if(id == 50) return new Kabonk_Sim();
    	if(id == 51) return new Shrine_Sim();
    	if(id == 62) return new Transposition_Sim();
    	if(id == 64) return new BlessingOfHaste_Sim();
    	if(id == 74) return new HonorableGeneral_Sim();
    	if(id == 92) return new Heritage_Sim();
    	if(id == 95) return new Powerbound_Sim();
    	if(id == 105) return new Summons_Sim();
    	if(id == 116) return new Decimation_Sim();
    	if(id == 121) return new DucalInfantryman_Sim();
    	if(id == 122) return new DucalSkirmisher_Sim();
    	if(id == 123) return new DucalSpearman_Sim();
    	if(id == 155) return new Mangonel_Sim();
    	if(id == 157) return new ImperialResources_Sim();
    	if(id == 193) return new RoastedBeanPotion_Sim();
    	
    	
    	//energy set 1 and 2 
    	if(id == 24) return new CatapultOfGoo_Sim();
    	if(id == 27) return new Burn_Sim();
    	if(id == 35) return new InfernoBlast_Sim();
    	if(id == 39) return new IronOgre_Sim();
    	if(id == 47) return new PotionOfResistance_Sim();
    	if(id == 66) return new CopperAutomaton_Sim();
    	if(id == 68) return new CannonAutomaton_Sim();
    	if(id == 70) return new ViolentDispersal_Sim();
    	if(id == 79) return new MachinePriest_Sim();
    	if(id == 80) return new EmberBonds_Sim();
    	if(id == 83) return new GolemSkin_Sim();
    	if(id == 85) return new MagmaPack_Sim();
    	if(id == 87) return new TickBomb_Sim();
    	if(id == 90) return new ProximityCharge_Sim();
    	
    	if(id == 96) return new GunAutomaton_Sim();
    	if(id == 98) return new UselessContraption_Sim();
    	if(id == 108) return new LawMemorial_Sim();
    	if(id == 110) return new TribalMemorial_Sim();
    	if(id == 118) return new HellspitterMortar_Sim();
    	if(id == 140) return new Overdrive_Sim();
    	if(id == 141) return new Plating_Sim();
    	if(id == 142) return new IronWhip_Sim();
    	if(id == 143) return new Incendiaries_Sim();
    	if(id == 147) return new BlindRage_Sim();
    	if(id == 148) return new MachinationMindset_Sim();
    	if(id == 149) return new ConcentrateFire_Sim();
    	if(id == 150) return new ToolInitiate_Sim();
    	if(id == 151) return new MetalHeart_Sim();
    	if(id == 152) return new Bombard_Sim();
    	if(id == 153) return new ClockLibrary_Sim();
    	
    	//engery set 3
    	if(id == 1) return new GravelockElder_Sim();
    	if(id == 2) return new GravelockRaider_Sim();
    	if(id == 25) return new ThunderSurge_Sim();
    	if(id == 32) return new Destroyer_Sim();
    	if(id == 67) return new Spark_Sim();
    	if(id == 77) return new Fury_Sim();
    	if(id == 81) return new EndOfReason_Sim();
    	if(id == 82) return new EtherPump_Sim();
    	if(id == 107) return new Scattergunner_Sim();
    	if(id == 130) return new GravelockOutcast_Sim();
    	if(id == 138) return new BlastStrike_Sim();
    	if(id == 139) return new Rigged_Sim();
    	if(id == 145) return new Redesign_Sim();
    	if(id == 146) return new Desperation_Sim();
    	if(id == 160) return new ChargeCoil_Sim();
    	
    	//growth set 1 and 2:
    	
    	if(id == 4) return new Gravehawk_Sim();
    	if(id == 13) return new ElanVital_Sim();
    	if(id == 16) return new BearPaw_Sim();
    	if(id == 17) return new BindingRoot_Sim();
    	if(id == 18) return new Hymn_Sim();
    	if(id == 29) return new FertileSoil_Sim();
    	if(id == 34) return new Quake_Sim();
    	if(id == 38) return new GreatWolf_Sim();
    	if(id == 40) return new Junkyard_Sim();
    	if(id == 41) return new KinfolkBrave_Sim();
    	if(id == 43) return new LeechingRing_Sim();
    	if(id == 44) return new MangyWolf_Sim();
    	if(id == 49) return new RaggedWolf_Sim();
    	if(id == 56) return new EssenceFeast_Sim();
    	if(id == 60) return new EternalStatue_Sim();
    	
    	if(id == 63) return new VitalityWell_Sim();
    	if(id == 76) return new Rumble_Sim();
    	if(id == 84) return new FrostGale_Sim();
    	if(id == 88) return new VitriolAura_Sim();
    	if(id == 89) return new EyeOfEagle_Sim();
    	if(id == 91) return new Frostbeard_Sim();
    	if(id == 94) return new Nutrition_Sim();
    	if(id == 100) return new RangersBane_Sim();
    	if(id == 112) return new SandPactMemorial_Sim();
    	if(id == 113) return new StonePactMemorial_Sim();
    	if(id == 114) return new IllthornSeed_Sim();
    	if(id == 115) return new Illthorn_Sim();
    	if(id == 129) return new Bunny_Sim();
    	if(id == 154) return new Wildling_Sim();
    	if(id == 189) return new BeastRat_Sim();
    	
    	//growth set 3:
    	
    	if(id == 21) return new Rallying_Sim();
    	if(id == 22) return new BrotherOfTheWolf_Sim();
    	if(id == 26) return new ChampionRing_Sim();
    	if(id == 30) return new DeathCapBerserk_Sim();
    	if(id == 33) return new DruidBurialGround_Sim();
    	if(id == 42) return new KinfolkJarl_Sim();
    	if(id == 45) return new DryadicPower_Sim();
    	if(id == 53) return new SisterOfTheFox_Sim();
    	if(id == 58) return new UnleashInnerPower_Sim();
    	if(id == 65) return new AncestralTotem_Sim();
    	if(id == 75) return new KinfolkVeteran_Sim();
    	if(id == 78) return new CrimsonBull_Sim();
    	if(id == 104) return new Bloodboil_Sim();
    	if(id == 117) return new GodHand_Sim();
    	if(id == 156) return new VaettrOfTheWild_Sim();
    	
    	//decay set 1 and 2
    	if(id == 59) return new Lifestealer_Sim();
    	if(id == 69) return new BitterRoot_Sim();
    	if(id == 102) return new MireCurse_Sim();
    	if(id == 131) return new TetheredRecruit_Sim();
    	if(id == 137) return new ReturnToNature_Sim();
    	if(id == 159) return new Unbind_Sim();
    	if(id == 162) return new LoyalDarkling_Sim();
    	if(id == 164) return new MireShambler_Sim();
    	if(id == 165) return new MangyRat_Sim();
    	if(id == 168) return new Blightbearer_Sim();
    	if(id == 169) return new PuppetSoldier_Sim();
    	if(id == 170) return new PillarOfDisease_Sim();
    	if(id == 171) return new Animovore_Sim();
    	if(id == 172) return new Harvester_Sim();
    	if(id == 174) return new SoulScrounger_Sim();
    	
    	if(id == 176) return new Arthritis_Sim();
    	if(id == 177) return new RestlessBones_Sim();
    	if(id == 180) return new DamningCurse_Sim();
    	if(id == 181) return new Languid_Sim();
    	if(id == 182) return new EnergySiphon_Sim();
    	if(id == 184) return new SearingShackles_Sim();
    	if(id == 185) return new MiasmaWell_Sim();
    	if(id == 190) return new SoulSteal_Sim();
    	if(id == 191) return new Regeniture_Sim();
    	if(id == 194) return new OblivionSeeker_Sim();
    	if(id == 195) return new IlmireRotEater_Sim();
    	if(id == 197) return new ScavengerConstruct_Sim();
    	if(id == 198) return new Atrophy_Sim();
    	if(id == 199) return new ClusterHex_Sim();
    	if(id == 202) return new HexMarks_Sim();
    	
    	//decay set 3
    	if(id == 3) return new InfectedGravelock_Sim();
    	if(id == 161) return new VisceraSage_Sim();
    	if(id == 163) return new Husk_Sim();
    	if(id == 166) return new IlmireWitchDoctor_Sim();
    	if(id == 173) return new TotemOfSuffering_Sim();
    	if(id == 175) return new GrislyGraft_Sim();
    	if(id == 179) return new ShroudOfUnlife_Sim();
    	if(id == 183) return new BrainLice_Sim();
    	if(id == 186) return new PillarOfFatigue_Sim();
    	if(id == 187) return new InfectiousBlight_Sim();
    	if(id == 188) return new Necrogeddon_Sim();
    	if(id == 192) return new DrainingMist_Sim();
    	if(id == 196) return new IlmireHunter_Sim();
    	if(id == 200) return new Cursemonger_Sim();
    	if(id == 201) return new Pestis_Sim();
    	
    	
    	//growth set 4
    	if(id == 135) return new Erode_Sim();
    	if(id == 203) return new Noaidi_Sim();
    	if(id == 208) return new StagHeart_Sim();
    	if(id == 211) return new Crone_Sim();
    	if(id == 212) return new Breaker_Sim();
    	if(id == 213) return new OakBlood_Sim();
    	if(id == 214) return new Breaker_Sim();
    	if(id == 215) return new RatKing_Sim();
    	if(id == 216) return new Appurtenance_Sim();
    	if(id == 217) return new Berserker_Sim();
    	if(id == 218) return new SisterOfTheBear_Sim();
    	if(id == 219) return new KinfolkRanger_Sim();
    	if(id == 221) return new Owl_Sim();
    	if(id == 222) return new SisterOfTheOwl_Sim();
    	if(id == 257) return new Untainted_Sim();
    	
    	
    	//decay set 4
    	if(id == 239) return new WickedBeing_Sim();
    	if(id == 242) return new Ripper_Sim();
    	if(id == 243) return new UnforeseenOnslaught_Sim();
    	if(id == 244) return new IlmireTribesman_Sim();
    	if(id == 245) return new PestDissimulator_Sim();
    	if(id == 246) return new MonstrousBrood_Sim();
    	if(id == 247) return new Monstrosity_Sim();
    	if(id == 248) return new Fungify_Sim();
    	if(id == 249) return new IreAndBile_Sim();
    	if(id == 250) return new SickeningFumes_Sim();
    	if(id == 251) return new UneasyAlliance_Sim();
    	if(id == 252) return new BloodlineTaint_Sim();
    	if(id == 253) return new Watcher_Sim();
    	if(id == 255) return new EagerScryer_Sim();
    	if(id == 259) return new BeetleStone_Sim();
    	
    	//energy set 4
    	if(id == 133) return new Darkstrike_Sim();
    	if(id == 204) return new SolemnGiant_Sim();
    	if(id == 205) return new DustRunner_Sim();
    	if(id == 207) return new AutomataForge_Sim();
    	if(id == 210) return new MetalWonder_Sim();
    	if(id == 223) return new StormRunner_Sim();
    	if(id == 224) return new StateMachine_Sim();
    	if(id == 225) return new Supercharged_Sim();
    	if(id == 226) return new MachineChant_Sim();
    	if(id == 227) return new ScoutAutomaton_Sim();
    	if(id == 235) return new Machinated_Sim();
    	if(id == 236) return new Corrode_Sim();
    	if(id == 241) return new SiegeCracker_Sim();
    	if(id == 256) return new Cannonetta_Sim();
    	if(id == 258) return new MachineDivinator_Sim();
    	
    	//order set 4
    	if(id == 134) return new Efficiency_Sim();
    	if(id == 178) return new TempoTheft_Sim();
    	if(id == 206) return new WingsShield_Sim();
    	if(id == 209) return new FaithDuty_Sim();
    	if(id == 228) return new Magnetizer_Sim();
    	if(id == 229) return new MysticAltar_Sim();
    	if(id == 230) return new Redeploy_Sim();
    	if(id == 231) return new CallersBane_Sim();
    	if(id == 232) return new AgingKnight_Sim();
    	if(id == 233) return new RoyalBanner_Sim();
    	if(id == 234) return new Fleetness_Sim();
    	if(id == 237) return new WingsSoldier_Sim();
    	if(id == 238) return new VigorExtraction_Sim();
    	if(id == 240) return new RefinedStrategy_Sim();
    	if(id == 254) return new WingsCaptain_Sim();
    	
    	//growth set 5
    	if(id == 261) return new AncestralPact_Sim();
    	if(id == 289) return new OutcastRebel_Sim();
    	if(id == 290) return new CullingTheFlock_Sim();
    	if(id == 291) return new EarthenTestament_Sim();
    	if(id == 292) return new VengefulVaettr_Sim();
    	if(id == 293) return new BountifulTimes_Sim();
    	if(id == 294) return new VerdantVeil_Sim();
    	if(id == 295) return new UnderdogsSpite_Sim();
    	if(id == 296) return new WetlandRanger_Sim();
    	if(id == 297) return new JarlUrhald_Sim();
    	if(id == 302) return new EarthbornMystic_Sim();
    	if(id == 303) return new Earthbond_Sim();
    	if(id == 304) return new SeedOfInsurgency_Sim();
    	if(id == 307) return new StripedFangbear_Sim();
    	if(id == 310) return new Unground_Sim();
    	
    	//order set 5
    	if(id == 263) return new StifledAdvance_Sim();
    	if(id == 273) return new SoldiersBond_Sim();
    	if(id == 274) return new PilgrimsFeet_Sim();
    	if(id == 275) return new Reversal_Sim();
    	if(id == 280) return new GallantDefender_Sim();
    	if(id == 298) return new WingsWarder_Sim();
    	if(id == 305) return new WingsSpear_Sim();
    	if(id == 306) return new WingsCleaver_Sim();
    	if(id == 308) return new RighteousPartisan_Sim();
    	if(id == 311) return new WingsCharger_Sim();
    	if(id == 312) return new Infiltrate_Sim();
    	if(id == 313) return new Ruse_Sim();
    	if(id == 314) return new CayRoyalEnvoy_Sim();
    	if(id == 315) return new WardingStone_Sim();
    	if(id == 316) return new PrisonersOfWar_Sim();
    	
    	//decay set 5
    	if(id == 260) return new Eclipse_Sim();
    	if(id == 264) return new Blightseed_Sim();
    	if(id == 265) return new MorbidCuriosity_Sim();
    	if(id == 266) return new Stitcher_Sim();
    	if(id == 267) return new ArhartsDisciple_Sim();
    	if(id == 268) return new BladeHusk_Sim();
    	if(id == 269) return new BogHound_Sim();
    	if(id == 270) return new FesteringFreak_Sim();
    	if(id == 271) return new CorpusCollector_Sim();
    	if(id == 272) return new BalefulWitch_Sim();
    	if(id == 276) return new CursedPresence_Sim();
    	if(id == 278) return new NuruFleshSeamstress_Sim();
    	if(id == 279) return new MalevolentGaze_Sim();
    	if(id == 309) return new NurusNeedle_Sim();
    	if(id == 319) return new ReapingMask_Sim();
    	
    	//energy set 5
    	if(id == 262) return new PiercingProjectile_Sim();
    	if(id == 277) return new FulminationConduit_Sim();
    	if(id == 281) return new HiredSmuggler_Sim();
    	if(id == 282) return new PowerTrip_Sim();
    	if(id == 283) return new AshRunner_Sim();
    	if(id == 284) return new Echomaton_Sim();
    	if(id == 285) return new BoomReaver_Sim();
    	if(id == 286) return new IroncladReaver_Sim();
    	if(id == 287) return new Replicaton_Sim();
    	if(id == 288) return new SuddenEruption_Sim();
    	if(id == 299) return new TempestReaver_Sim();
    	if(id == 300) return new HiredMarksman_Sim();
    	if(id == 301) return new ViciousStrike_Sim();
    	if(id == 317) return new Electrify_Sim();
    	if(id == 318) return new TopReaverThea_Sim();
    	
    	
    	//decay set 6 :D
    	if(id == 332) return new VoidGate_Sim();
    	if(id == 342) return new SanctuaryOfTheLost_Sim();
    	if(id == 343) return new HallsOfOumLasa_Sim();
    	if(id == 344) return new ForbiddenRuins_Sim();
    	if(id == 345) return new InvocationSentry_Sim();
    	if(id == 349) return new Revenant_Sim();
    	if(id == 350) return new SlayerVestige_Sim();
    	if(id == 351) return new MudoFighter_Sim();
    	if(id == 352) return new FleshAnimator_Sim();
    	if(id == 353) return new AnimaConduit_Sim();
    	if(id == 362) return new RattleHymn_Sim();
    	if(id == 380) return new SlitheringForm_Sim();
    	if(id == 381) return new OumLasaHighGuard_Sim();
    	if(id == 382) return new IrvaVoiceOfTheDead_Sim();
    	if(id == 540) return new OmenOfDamnation_Sim();

    	//energy set 6 :D
    	if(id == 322) return new OculusCannon_Sim();
    	if(id == 339) return new GravelockBurrows_Sim();
    	if(id == 340) return new FodderPit_Sim();
    	if(id == 341) return new SkullShrine_Sim();
    	if(id == 347) return new StoneEnigma_Sim();
    	if(id == 363) return new UhuLongnose_Sim();
    	if(id == 364) return new GravelockFreak_Sim();
    	if(id == 365) return new GravelockGuard_Sim();
    	if(id == 366) return new LocklingBrood_Sim();
    	if(id == 367) return new Snargl_Sim();
    	if(id == 368) return new GraveGruel_Sim();
    	if(id == 369) return new SnarglBrain_Sim();
    	if(id == 379) return new SnarglHunter_Sim();
    	if(id == 383) return new SnarglOmelette_Sim();
    	if(id == 385) return new FeedbackJolt_Sim();
    	
    	
    	//order set 6
    	if(id == 320) return new EternalSword_Sim();
    	if(id == 333) return new FieldsOfStrife_Sim();
    	if(id == 337) return new GroundsOfTheFallen_Sim();
    	if(id == 338) return new CaravansOfTheExpanse_Sim();
    	if(id == 346) return new BannerOfOrdinance_Sim();
    	if(id == 354) return new RelorasLordKnight_Sim();
    	if(id == 355) return new KnightSergeant_Sim();
    	if(id == 356) return new Stormknight_Sim();
    	if(id == 357) return new Arbalestier_Sim();
    	if(id == 358) return new Squire_Sim();
    	if(id == 359) return new RoyalInspiration_Sim();
    	if(id == 360) return new WingsSorceress_Sim();
    	if(id == 361) return new EffigyOfTheQueen_Sim();
    	if(id == 384) return new AdvantageousOutlook_Sim();
    	if(id == 541) return new AescalonSpires_Sim();
    	
    	
    	//growth set 6
    	if(id == 321) return new Skythorn_Sim();
    	if(id == 334) return new FjordsOfVigor_Sim();
    	if(id == 335) return new BuddingRetreat_Sim();
    	if(id == 336) return new ClandestineOrchard_Sim();
    	if(id == 348) return new RekindledSpirit_Sim();
    	if(id == 370) return new VildaTheVerdant_Sim();
    	if(id == 371) return new Nog_Sim();
    	if(id == 372) return new EarthbornKeeper_Sim();
    	if(id == 373) return new GustyIzulr_Sim();
    	if(id == 374) return new TerreneBrute_Sim();
    	if(id == 375) return new BuddingVaettr_Sim();
    	if(id == 376) return new EarthenMirth_Sim();
    	if(id == 377) return new EarthenMirth_Sim();
    	if(id == 378) return new NogNest_Sim();
    	if(id == 542) return new NogNest_Sim();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	return new Simtemplate();
    }
}
