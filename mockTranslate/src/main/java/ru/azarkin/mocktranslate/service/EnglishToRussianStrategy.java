package ru.azarkin.mocktranslate.service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class EnglishToRussianStrategy implements TranslateStrategy {
    private static final Map<String, Character> EN_TO_RU_MAP = new HashMap<>();

    static {
        EN_TO_RU_MAP.put("A", 'А');
        EN_TO_RU_MAP.put("B", 'Б');
        EN_TO_RU_MAP.put("V", 'В');
        EN_TO_RU_MAP.put("G", 'Г');
        EN_TO_RU_MAP.put("D", 'Д');
        EN_TO_RU_MAP.put("E", 'Е');
        EN_TO_RU_MAP.put("YO", 'Ё');
        EN_TO_RU_MAP.put("ZH", 'Ж');
        EN_TO_RU_MAP.put("Z", 'З');
        EN_TO_RU_MAP.put("I", 'И');
        EN_TO_RU_MAP.put("Y", 'Й');
        EN_TO_RU_MAP.put("K", 'К');
        EN_TO_RU_MAP.put("L", 'Л');
        EN_TO_RU_MAP.put("M", 'М');
        EN_TO_RU_MAP.put("N", 'Н');
        EN_TO_RU_MAP.put("O", 'О');
        EN_TO_RU_MAP.put("P", 'П');
        EN_TO_RU_MAP.put("R", 'Р');
        EN_TO_RU_MAP.put("S", 'С');
        EN_TO_RU_MAP.put("T", 'Т');
        EN_TO_RU_MAP.put("U", 'У');
        EN_TO_RU_MAP.put("F", 'Ф');
        EN_TO_RU_MAP.put("H", 'Х');
        EN_TO_RU_MAP.put("TS", 'Ц');
        EN_TO_RU_MAP.put("CH", 'Ч');
        EN_TO_RU_MAP.put("SH", 'Ш');
        EN_TO_RU_MAP.put("SCH", 'Щ');
        EN_TO_RU_MAP.put("Y", 'Ы');
        EN_TO_RU_MAP.put("E", 'Э');
        EN_TO_RU_MAP.put("YU", 'Ю');
        EN_TO_RU_MAP.put("YA", 'Я');
        EN_TO_RU_MAP.put("J", 'Ж');
    }

    @Override
    public String Translate(String text) {
        log.info("EnglishToRussian translating...");

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i + 2 < text.length() && EN_TO_RU_MAP.containsKey(text.substring(i, i + 3).toUpperCase())) {
                result.append(EN_TO_RU_MAP.get(text.substring(i, i + 3).toUpperCase()));
                i += 3;
            } else if (i + 1 < text.length() && EN_TO_RU_MAP.containsKey(text.substring(i, i + 2).toUpperCase())) {
                result.append(EN_TO_RU_MAP.get(text.substring(i, i + 2).toUpperCase()));
                i += 2;
            } else {
                result.append(EN_TO_RU_MAP.getOrDefault(text.substring(i, i + 1).toUpperCase(), text.charAt(i)));
                i++;
            }
        }
        return result.toString();
    }

}
