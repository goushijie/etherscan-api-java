import com.tenshun.app.core.etherscan.AccountsAPI;
import com.tenshun.app.utils.Constants;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class AccountsAPITest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testBuildMultipleAddresses() {
        List<String> addrList = Arrays.asList("1", "2", "3");
        String resultURL = AccountsAPI.buildEthBalanceURL(addrList);
        String testString = "https://api.etherscan.io/api?module=account&action=balancemulti&address=1,2,3&tag=latest&apikey=" + Constants.API_KEY;
        Assert.assertEquals(testString, resultURL);
    }

    @Test()
    public void testThatThrowsInvalidArgumentIfMoreThanTwelve () {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Empty addresses list, must be at least 1 and less or equal than 20");
        List<String> addrList = new ArrayList<>();
        IntStream.range(0, 100).forEach(n -> addrList.add(String.valueOf(n)));
        String resultURL = AccountsAPI.buildEthBalanceURL(addrList);
    }

    @Test
    public void testBuildSingleAddress() {
        List<String> addrList = Arrays.asList("1");
        String resultURL = AccountsAPI.buildEthBalanceURL(addrList);
        String testString = "https://api.etherscan.io/api?module=account&action=balancemulti&address=1&tag=latest&apikey=" + Constants.API_KEY;
        Assert.assertEquals(testString, resultURL);
    }
}
