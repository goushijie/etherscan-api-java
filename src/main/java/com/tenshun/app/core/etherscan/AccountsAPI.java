package com.tenshun.app.core.etherscan;


import com.sun.istack.internal.NotNull;
import com.tenshun.app.core.ether.Account;
import com.tenshun.app.utils.Constants;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class AccountsAPI {

    private AccountsAPI() {
    }

    private OkHttpClient client = new OkHttpClient();

    /**
     * Get Ether Balance for multiple Addresses in a single call
     * https://api.etherscan.io/api?module=account&action=balancemulti&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a,0x63a9975ba31b0b9626b34300f7f627147df1f526,0x198ef1ec325a96cc354c7266a038be8b5c558f67&tag=latest&apikey=YourApiKeyToken
     * Separate addresses by comma, up to a maxium of 20 accounts in a single batch
     *
     * @param addresses eth wallet addresses
     * @return Empty Map if list of addresses is also empty, or List of Balances otherwise todo
     * @throws InvalidEthereumAddressException if one of the addresses is invalid todo
     */

    public static Map<String, Account> getEtherBalancesFromMultipleAddresses(@NotNull List<String> addresses) {
        if (!addresses.isEmpty()) {
            String finalURL = buildEthBalanceURL(addresses);
            HttpUrl.Builder urlBuilder = HttpUrl.parse(finalURL).newBuilder();
            urlBuilder.addQueryParameter("v", "1.0");
            urlBuilder.addQueryParameter("user", "vogella");
            String url = urlBuilder.build().toString();


            Request requestBalance = new Request.Builder()
                    .url(url)
                    .build();
            //todo make HTTP call to finalURL
            //todo parse json with jackson
            //todo convert result to HashMap as efficient as possible
            Map<String, Account> result = new HashMap<>();

            return result;
        } else return Collections.emptyMap();
    }

    /**
     * Get Ether Balance for a single Address
     * <p>
     * https://api.etherscan.io/api?module=account&action=balance&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&tag=latest&apikey=YourApiKeyToken
     *
     * @param address Ether address
     * @return Account balance
     */

    public static BigDecimal getEtherBalanceForASingleAddress(@NotNull String address) {
        return BigDecimal.valueOf(0.0);
    }


    /** todo
     * Get list of Blocks Mined by Address
     * https://api.etherscan.io/api?module=account&action=getminedblocks&address=0x9dd134d14d1e65f84b706d6f205cd5b1cd03a46b&blocktype=blocks&apikey=YourApiKeyToken
     * or
     * https://api.etherscan.io/api?module=account&action=getminedblocks&address=0x9dd134d14d1e65f84b706d6f205cd5b1cd03a46b&blocktype=blocks&page=1&offset=10&apikey=YourApiKeyToken
     * (To get paginated results use page=<page number> and offset=<max records to return>)
     * * type = blocks (full blocks only) or uncles (uncle blocks only)
     */


    /**
     * Concatenation of chunk ethereum addresses in one single ready for call URL
     * <p>
     * Constraints:
     * - size > 0 && size <= 20
     *
     * @param addresses List of ethereum addresses
     * @return URL https://api.etherscan.io/api?module=account&action=balancemulti&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a,0x63a9975ba31b0b9626b34300f7f627147df1f526,0x198ef1ec325a96cc354c7266a038be8b5c558f67&tag=latest&apikey=YourApiKeyToken
     */
    public static String buildEthBalanceURL(@NotNull List<String> addresses) {
        if (addresses.isEmpty()) {
            throw new IllegalArgumentException("Empty addresses list, must be at least 1");
        }
        if (addresses.size() > 20) {
            throw new IllegalArgumentException("Maximum size of addresses list is 20");
        }
        StringBuilder sb = new StringBuilder("https://api.etherscan.io/api?module=account&action=balancemulti&address=");
        sb.append(String.join(",", addresses));
        return sb.append("&tag=latest&apikey=").append(Constants.API_KEY).toString();
    }
}
