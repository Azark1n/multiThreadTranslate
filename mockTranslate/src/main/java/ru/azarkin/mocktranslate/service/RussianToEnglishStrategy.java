package ru.azarkin.mocktranslate.service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RussianToEnglishStrategy implements TranslateStrategy {
    private static final Map<String, String> RU_TO_EN_MAP = new HashMap<>();

    static {
        RU_TO_EN_MAP.put("А", "A");
        RU_TO_EN_MAP.put("Б", "B");
        RU_TO_EN_MAP.put("В", "V");
        RU_TO_EN_MAP.put("Г", "G");
        RU_TO_EN_MAP.put("Д", "D");
        RU_TO_EN_MAP.put("Е", "E");
        RU_TO_EN_MAP.put("Ё", "E");
        RU_TO_EN_MAP.put("Ж", "Zh");
        RU_TO_EN_MAP.put("З", "Z");
        RU_TO_EN_MAP.put("И", "I");
        RU_TO_EN_MAP.put("Й", "Y");
        RU_TO_EN_MAP.put("К", "K");
        RU_TO_EN_MAP.put("Л", "L");
        RU_TO_EN_MAP.put("М", "M");
        RU_TO_EN_MAP.put("Н", "N");
        RU_TO_EN_MAP.put("О", "O");
        RU_TO_EN_MAP.put("П", "P");
        RU_TO_EN_MAP.put("Р", "R");
        RU_TO_EN_MAP.put("С", "S");
        RU_TO_EN_MAP.put("Т", "T");
        RU_TO_EN_MAP.put("У", "U");
        RU_TO_EN_MAP.put("Ф", "F");
        RU_TO_EN_MAP.put("Х", "H");
        RU_TO_EN_MAP.put("Ц", "Ts");
        RU_TO_EN_MAP.put("Ч", "Ch");
        RU_TO_EN_MAP.put("Ш", "Sh");
        RU_TO_EN_MAP.put("Щ", "Sch");
        RU_TO_EN_MAP.put("Ъ", "");
        RU_TO_EN_MAP.put("Ы", "Y");
        RU_TO_EN_MAP.put("Ь", "");
        RU_TO_EN_MAP.put("Э", "E");
        RU_TO_EN_MAP.put("Ю", "Yu");
        RU_TO_EN_MAP.put("Я", "Ya");
    }

    @Override
    public String Translate(String text) {
        log.info("RussianToEnglish translating...");

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            String substring = text.substring(i, i + 1);
            result.append(RU_TO_EN_MAP.getOrDefault(substring.toUpperCase(), substring));
            i++;
        }
        return result.toString();
    }
}
