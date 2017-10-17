package com.tenshun.app.core.etherscan;


public class BlocksAPI {

    private BlocksAPI() {
    }

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo

     https://api.etherscan.io/api?module=block&action=getblockreward&blockno=2165403&apikey=YourApiKeyToken
     */

    @Deprecated //proof of stake?
    public static String getBlockAndUncleRewardsByBlockNo(int blockNo) {
        return "";
    }
}
