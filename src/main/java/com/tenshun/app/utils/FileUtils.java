package com.tenshun.app.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
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
                .filter(splitted -> splitted.contains("0x") && splitted.length() == 42)
                .collect(Collectors.toList());
    }
}
