package com.tenshun.app.core.etherscan;


import com.sun.istack.internal.NotNull;
import com.tenshun.app.core.ether.Transaction;

import java.util.Collections;
import java.util.List;

public class TransactionsAPI {


    private TransactionsAPI() {
    }

    /**
     * todo
     * [BETA] Check Contract Execution Status (if there was an error during contract execution)
     * Note: isError":"0" = Pass , isError":"1" = Error during Contract Execution
     * https://api.etherscan.io/api?module=transaction&action=getstatus&txhash=0x15f8e5ea1079d9a0bb04a4c58ae5fe7654b5b2b4463375ff7ffb490aa0032f3a&apikey=YourApiKeyToken
     */

    public static String checkContractExecution(@NotNull String txHash) {
        return "OK";
    }

    /**
     * todo
     * Get "Internal Transactions" by Transaction Hash
     * https://api.etherscan.io/api?module=account&action=txlistinternal&txhash=0x40eb908387324f2b575b4879cd9d7188f69c8fc9d87c901b9e2daaea4b442170&apikey=YourApiKeyToken
     * (Returned 'isError' values: 0=Ok, 1=Rejected/Cancelled)
     * (Returns up to a maximum of the last 10000 transactions only)
     */

    public static List<Transaction> getListOfInternalTransactionsByTxHash(@NotNull String txHash) {
        return Collections.emptyList();
    }


    /**
     * todo
     * [BETA] Get a list of 'Internal' Transactions by Address
     * <p>
     * [Optional Parameters] startblock: starting blockNo to retrieve results, endblock: ending blockNo to retrieve results
     * <p>
     * http://api.etherscan.io/api?module=account&action=txlistinternal&address=0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3&startblock=0&endblock=2702578&sort=asc&apikey=YourApiKeyToken
     * (Returned 'isError' values: 0=No Error, 1=Got Error)
     * (Returns up to a maximum of the last 10000 transactions only)
     * or
     * https://api.etherscan.io/api?module=account&action=txlistinternal&address=0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3&startblock=0&endblock=2702578&page=1&offset=10&sort=asc&apikey=YourApiKeyToken
     * (To get paginated results use page=<page number> and offset=<max records to return>)
     */

    public static List<Transaction> getListOfInternalTransactionsByAddress(@NotNull String address) {
        return Collections.emptyList();
    }


    /**
     * todo
     * Get a list of 'Normal' Transactions By Address
     * <p>
     * [Optional Parameters] startblock: starting blockNo to retrieve results, endblock: ending blockNo to retrieve results
     * <p>
     * http://api.etherscan.io/api?module=account&action=txlist&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&startblock=0&endblock=99999999&sort=asc&apikey=YourApiKeyToken
     * ([BETA] Returned 'isError' values: 0=No Error, 1=Got Error)
     * (Returns up to a maximum of the last 10000 transactions only)
     * <p>
     * or
     * <p>
     * https://api.etherscan.io/api?module=account&action=txlist&address=0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a&startblock=0&endblock=99999999&page=1&offset=10&sort=asc&apikey=YourApiKeyToken
     * (To get paginated results use page=<page number> and offset=<max records to return>)
     *
     * @param address Ethereum address
     * @return List of 'Normal' transactions
     */


    public static List<String> getListOfNormalTranscationsByAddress(@NotNull String address) {
        return Collections.emptyList();
    }
}
