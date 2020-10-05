import com.company.RequestFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SimpleBotTests {
    private RequestFactory factory;

    @Before
    public void setUp() {
        factory = new RequestFactory();
    }

    @Test
    public void checkHelpCommand() {
        String expected = "Бот для забав!";
        Assert.assertEquals(expected, factory.getJoke("/help"));
    }

    @Test
    public void checkUnknownCommand() {
        String expected = "Не знаю такой команды.";
        String[] commands = {"a", "123", "/.,]", "пврывап"};
        for (String e : commands)
            Assert.assertEquals(expected, factory.getJoke(e));

    }

    @Test
    public void checkFuncCommand() {
        String expected = "Не знаю такой команды.";
        String[] commands = {"/joke","/quote","/aphorisms"};
        for (String e : commands)
            Assert.assertNotEquals(expected, factory.getJoke(e));
    }
}
