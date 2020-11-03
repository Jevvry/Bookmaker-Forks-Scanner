import com.company.betting_math.ForksFinder;
import com.company.bettings_parser.MarathonBet;
import com.company.bot_command_handler.GetForksHandler;
import com.company.bot_command_handler.ReplyMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetForksHandlerTests {

	private GetForksHandler getForksHandler;
	private ForksFinder forksFinder;

	@Before
	public void setUp() {
		MarathonBet marathonBet = new MarathonBet();
		forksFinder = new ForksFinder(marathonBet.betOffice);
		getForksHandler = new GetForksHandler(forksFinder);
		// upload forks
		getForksHandler.executeCommand("/get", 1L);
	}

	@Test
	public void testGetNextPage() {
		Integer exp_i = 1;
		boolean second_circle = false;
		String command = "Next";
		Long chatId = 1L;
		while (!second_circle) {
			if (exp_i == 0) {
				second_circle = true;
			}
			Assert.assertEquals(exp_i, getForksHandler.getNextPage(chatId, command));
			exp_i++;
			if (exp_i == forksFinder.getForksCount()) {
				exp_i = 0;
			}
		}
	}

	@Test
	public void testGetPrevPage() {
		Integer exp_i = 0;
		boolean second_circle = false;
		String command = "Previous";
		Long chatId = 1L;
		while (!second_circle) {
			Assert.assertEquals(exp_i, getForksHandler.getNextPage(chatId, command));
			exp_i--;
			if (exp_i < 0) {
				exp_i = forksFinder.getForksCount() - 1;
			}
			if (exp_i == forksFinder.getForksCount() - 2) {
				second_circle = true;
			}
		}
	}
}
