package com.tenshun.app.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileUtils {

    private FileUtils() {
    }

    /**
     * Extract eth addresses from text file
     *
     * @param filePath text file
     * @return List of addresses
     * @throws IOException
     */

    public static List<String> extractAddressesFromFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .flatMap(post -> Arrays.stream(post.split("\\s+")))
                .filter(spl -> isValidAddress(spl, true))
                .collect(Collectors.toList());
    }

    public static boolean isValidAddress(String address, boolean withPrefix) {
        if(withPrefix || address.length() == 42) {
            return Pattern.matches("^0x[a-fA-F0-9]{40}$", address);
        } else return Pattern.matches("^[a-fA-F0-9]{40}$", address);
    }
}
