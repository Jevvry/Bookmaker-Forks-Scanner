import com.company.bot_command_handler.AllCommandHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AllCommandHandlerTests {
	private AllCommandHandler allCommandHandler;

	@Before
	public void setUp() {
		allCommandHandler = new AllCommandHandler();
	}

	@Test
	public void test_executeCommand() {
		String command1 = "Hello";
		String command2 = "/get";
		Assert.assertEquals("Не известная комманда: Hello",
				allCommandHandler.executeCommand(command1, 1L).message);
		Assert.assertNotNull(allCommandHandler.executeCommand(command2, 1L));
	}
}
