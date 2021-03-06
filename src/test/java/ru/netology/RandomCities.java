package ru.netology;

import java.util.Random;

public class RandomCities {
    public static String getRandomCity() {
        String[] set = {"Москва", "Архангельск", "Астрахань", "Барнаул", "Белгород", "Благовещенск", "Брянск", "Великий Новгород",
                "Владивосток", "Владимир", "Воронеж", "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново", "Ижевск",
                "Казань", "Калуга", "Кемерово", "Киров", "Кострома", "Красноярск", "Курск", "Липецк",
                "Махачкала", "Мурманск", "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Оренбург", "Пенза", "Пермь",
                "Петрозаводск", "Псков", "Ростов-на-Дону", "Рязань", "Саратов", "Саранск", "Смоленск",
                "Ставрополь", "Сыктывкар", "Тверь", "Томск"};
        Random ran  = new Random();
        int randomNumberList = ran.nextInt(set.length);
        return set[randomNumberList];
    }
}
