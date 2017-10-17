package com.tenshun.app;

import com.google.common.collect.Lists;
import com.tenshun.app.core.WalletParser;
import com.tenshun.app.core.WalletData;
import com.tenshun.app.utils.Constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    /**
     * @param args arg[0] - path to txt file. Only one param currently supported
     * @throws IOException if file not found, or typo
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            String filePath = Constants.RESOURCE_PATH + args[0];
            List<String> walletsIDs = WalletParser.extractWalletIdsFromFile(filePath);
            Map<String, WalletData> result = new HashMap<>();
            List<List<String>> chunks = Lists.partition(walletsIDs, 20);

            //make ~13 parallel HTTP calls (20 addresses in each call) instead of 270 calls
            chunks.parallelStream().forEach(chunk -> {
                Map<String, WalletData> chunkResult = WalletParser.getWalletBalancesByAddresses(chunk);
                //result.

            });
        }

    }
}
