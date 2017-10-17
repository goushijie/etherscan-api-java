package com.tenshun.app.core;

import com.tenshun.app.utils.Constants;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class WalletParser {

    private OkHttpClient client = new OkHttpClient();

    /**
     * Get Ether Balance for multiple Addresses in a single call
     * https://api.etherscan.io/api?module=account&action=balancemulti&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a,0x63a9975ba31b0b9626b34300f7f627147df1f526,0x198ef1ec325a96cc354c7266a038be8b5c558f67&tag=latest&apikey=YourApiKeyToken
     * Separate addresses by comma, up to a maxium of 20 accounts in a single batch
     *
     * @param addresses eth wallet addresses
     * @return Object HashMap<WalletHash, WalletData>
     * <p>
     * <p>
     * RESPONSE:
     * {"status":"1",
     * "message":"OK",
     * "result":[
     * {"account":"0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a","balance":"40807168564070000000000"},
     * {"account":"0x63a9975ba31b0b9626b34300f7f627147df1f526","balance":"332567136222827062478"},
     * {"account":"0x198ef1ec325a96cc354c7266a038be8b5c558f67","balance":"413626250239783867852"}]
     * }
     */


    public static Map<String, WalletData> getWalletBalancesByAddresses(List<String> addresses) {
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
        Map<String, WalletData> result = new HashMap<>();

        return result;
    }

    public static List<String> getListOfTransactions(List<String> addresses) {
        return Collections.emptyList(); //mock
    }


    public static List<String> extractWalletIdsFromFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .flatMap(post -> Arrays.stream(post.split("\\s+")))
                .filter(splitted -> splitted.contains("0x") && splitted.length() == 42)
                .collect(Collectors.toList());
    }


    /**
     * Concatenation of chunk ethereum addresses in one single ready for call URL
     *
     * @param addresses List of ethereum addresses
     * @return URL https://api.etherscan.io/api?module=account&action=balancemulti&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a,0x63a9975ba31b0b9626b34300f7f627147df1f526,0x198ef1ec325a96cc354c7266a038be8b5c558f67&tag=latest&apikey=YourApiKeyToken
     */
    private static String buildEthBalanceURL(List<String> addresses) {
        StringBuilder sb = new StringBuilder("https://api.etherscan.io/api?module=account&action=balancemulti&");
        for (String currentAddress : addresses) {
            sb.append(currentAddress);
            sb.append(",");
        }
        return sb.append("&tag=latest&apikey=")
                .append(Constants.API_KEY).toString();
    }

}
