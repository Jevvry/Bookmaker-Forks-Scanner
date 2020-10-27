import com.company.bettings_parser.MarathonBet;
import org.junit.Assert;
import org.junit.Test;


public class MarathonBetTests {

	@Test
	public void testInit() {
		MarathonBet marathonBets = new MarathonBet();
		Assert.assertNotNull(marathonBets.betOffice);
		Assert.assertNotEquals(marathonBets.betOffice.getBettings().size(), 0);
		Assert.assertEquals(marathonBets.betOffice.getOfficeName(), "MarathonBet");
	}
}