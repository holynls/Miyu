package Miyu.cards;

import Miyu.DefaultMod;
import Miyu.actions.CoverSelectAction;
import Miyu.actions.DummyCoverSelectAction;
import Miyu.characters.TheDefault;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Miyu.DefaultMod.makeCardPath;

public class Dummy extends AbstractDynamicCard {

	// TEXT DECLARATION

	public static final String ID = DefaultMod.makeID(Dummy.class.getSimpleName());
	public static final String IMG = makeCardPath("Dummy.png");

	// /TEXT DECLARATION/

	// STAT DECLARATION

	private static final CardRarity RARITY = CardRarity.RARE;
	private static final CardTarget TARGET = CardTarget.SELF;
	private static final CardType TYPE = CardType.SKILL;
	public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

	private static final int COST = 1;
	private static final int UPGRADE_COST = 0;
	private static final int BLOCK = 0;

	// /STAT DECLARATION/

	public Dummy() {
		super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
	}

	// Actions the card should do.
	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		AbstractDungeon.actionManager.addToTop(new DummyCoverSelectAction(p, 1));

	}

	// Upgraded stats.
	@Override
	public void upgrade() {
		if (!upgraded) {
			upgradeName();
			upgradeBaseCost(UPGRADE_COST);
			initializeDescription();
		}
	}
}
