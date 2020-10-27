import com.company.betting_description.Bet;
import com.company.betting_math.ForksFinder;
import com.company.bettings_parser.MarathonBet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ForksFinderTests {

	private MarathonBet marathonBet;
	private ForksFinder forksFinder;

	@Before
	public void setUp() {
		marathonBet = new MarathonBet();
		forksFinder = new ForksFinder(marathonBet.betOffice);
	}

	@Test
	public void testFindForksOneOffice() {
		forksFinder.findForksOneOffice();
		Assert.assertNotNull(forksFinder.getForks());
		Assert.assertNotEquals(forksFinder.getForks().size(), 0);
	}

	@Test
	public void testIsFork() {
		Bet bet = new Bet(
				"Латвия", "Мальта",
				"1.7", "5.6", marathonBet.betOffice);
		Assert.assertTrue(forksFinder.isFork(bet));
	}
}
