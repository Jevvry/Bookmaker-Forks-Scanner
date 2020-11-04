import com.company.betting_math.ForksFinder;
import com.company.bettings_parser.MarathonBet;
import com.company.bot_command_handler.GetForksHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetForksHandlerTests {

	private GetForksHandler getForksHandler;
	private ForksFinder forksFinder;

	@Before
	public void setUp() {
		MarathonBet marathonBet = new MarathonBet();
		forksFinder = new ForksFinder(marathonBet.getBetOffice());
		getForksHandler = new GetForksHandler(forksFinder);
		// upload forks
		getForksHandler.executeCommand("/get", 1L);
	}

	@Test
	public void testGetNextPage() {
		Integer expIndex = 1;
		boolean second_circle = false;
		String command = "Next";
		Long chatId = 1L;
		while (!second_circle) {
			if (expIndex == 0) {
				second_circle = true;
			}
			Assert.assertEquals(expIndex, getForksHandler.getNextPage(chatId, command));
			expIndex++;
			if (expIndex == forksFinder.getForksCount()) {
				expIndex = 0;
			}
		}
	}

	@Test
	public void testGetPrevPage() {
		Integer expIndex = forksFinder.getForksCount() - 1;
		boolean second_circle = false;
		String command = "Previous";
		Long chatId = 1L;
		while (true) {
			Assert.assertEquals(expIndex, getForksHandler.getNextPage(chatId, command));
			System.out.println(expIndex);
			expIndex--;
			if (expIndex < 0) {
				expIndex = forksFinder.getForksCount() - 1;
			}
			if (expIndex == forksFinder.getForksCount() - 1 && second_circle) {
				break;
			}
			if (expIndex == forksFinder.getForksCount() - 1) {
				second_circle = true;
			}
		}
	}
}
