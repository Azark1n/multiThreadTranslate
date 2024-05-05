package ru.azarkin.mocktranslate.service;

import ru.azarkin.mocktranslate.model.LanguageCode;

public class TranslateStrategyFactory {
    public static TranslateStrategy getTranslateStrategy(LanguageCode sourceLanguageCode, LanguageCode targetLanguageCode) {
        if (LanguageCode.ru.equals(sourceLanguageCode) && LanguageCode.en.equals(targetLanguageCode)) {
            return new RussianToEnglishStrategy();
        } else if (LanguageCode.en.equals(sourceLanguageCode) && LanguageCode.ru.equals(targetLanguageCode)) {
            return new EnglishToRussianStrategy();
        } else {
            throw new IllegalArgumentException("Unsupported language pair: " + sourceLanguageCode + " to " + targetLanguageCode);
        }
    }
}
