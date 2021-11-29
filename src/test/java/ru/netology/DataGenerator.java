package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();

    }
    public static String generatePhoneNumber(){
        Faker faker = new Faker(new Locale("RU"));
        return faker.numerify("+7##########");
    }
    public static String getRandomCiti(){
        return RandomCities.getRandomCity();
    }
}
