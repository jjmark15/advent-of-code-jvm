package uk.chaoticgoose.adventofcode.twentyfive.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static uk.chaoticgoose.jresult.ResultUtils.catching;

public class TestInputLoader {

    public List<String> load(int day, InputDataModifier modifier) {
        var fileName = "/data/%s_%s.txt".formatted(day, modifier.value());
        Path filePath = Path.of(requireNonNull(getClass().getResource(fileName)).getPath());
        return catching(() -> Files.readAllLines(filePath)).mapFailure(RuntimeException::new).valueOrThrow();
    }

    public record InputDataModifier(String value) {
        public static InputDataModifier SHORT = new InputDataModifier("short");
        public static InputDataModifier LONG = new InputDataModifier("long");
    }
}
