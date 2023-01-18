import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    public static void task1() {
        System.out.println("Задание 1:");

        System.out.println("Введите возраст:");

        Scanner myInput = new Scanner(System.in);
        int age = myInput.nextInt();

        while (age <= 0) {
            System.out.println("Возраст введен неправильно, введите повторно");
            myInput = new Scanner(System.in);
            age = myInput.nextInt();
        }

        if (age < 18)
            System.out.println("Ты не можешь водить");
        else if (age >= 18)
            System.out.println("Ты можешь водить");
        System.out.println();
    }

    public static void task2() throws URISyntaxException {
        System.out.println("Задание 2:");

        URI uri = new URI("https://api.weather.yandex.ru/v2/fact/?lat=55.751244&lon=37.618423&lang=ru_RU");
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(uri)
                .header("X-Yandex-API-Key", "9f23e14c-0ed5-4bf6-9c59-93cf82f1dd8a").GET().build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse;
        try {
            getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JSONObject answer = new JSONObject(getResponse.body());
        int currTemp = (int) answer.get("temp");
        int feelsTemp = (int) answer.get("feels_like");
        StringBuilder sb = new StringBuilder("В Москве сейчас: " + currTemp + " ощущается как " + feelsTemp);


        if (currTemp < 5) {
            sb.append(". нужно надеть шапку");
            System.out.println(sb);
        } else {
            sb.append(".  можно идти без шапки");
            System.out.println(sb);
        }
        System.out.println();
    }

    public static void task3() {

        System.out.println("Задание 3:");

        int speed = getRandomNumber(0, 180);
        StringBuilder sb = new StringBuilder("Если скорость " + speed + ", то");

        if (speed <= 60)
            sb.append(" можно ездить спокойно");
        else
            sb.append(" придется заплатить штраф");


        System.out.println(sb);
        System.out.println();
    }

    public static void task4() {
        System.out.println("Задание 4:");

        int age = getRandomNumber(2, 64);
        StringBuilder sb = new StringBuilder("Если возраст человека равен " + age + " лет");
        if (age >= 2 && age <= 6)
            sb.append(", то ему нужно ходить в детский сад.");
        else if (age >= 7 && age < 18)
            sb.append(", то ему нужно ходить в школу.");
        else if (age >= 18 && age < 24)
            sb.append(", то его место в университете.");
        else if (age >= 24)
            sb.append(", то ему пора ходить на работу.");

        System.out.println(sb);
        System.out.println();
    }

    public static void task5() {
        System.out.println("Задание 5:");

        int age = getRandomNumber(2, 21);

        StringBuilder sb = new StringBuilder("Если возраст ребенка равен " + age + ", то ему");

        if (age <= 5)
            sb.append(" нельзя кататься на аттракционе");
        else if (age >= 7 && age < 14)
            sb.append(" можно кататься на аттракционе в сопровождении.");
        else if (age >= 14)
            sb.append(" можно кататься на аттракционе без сопровождения взрослого.");

        System.out.println(sb);
        System.out.println();
    }

    public static void task6() {
        System.out.println("Задание 6:");

        int passengers = getRandomNumber(0, 150);
        System.out.println("Колчиество предпологаеммых пассажиров: " + passengers);
        int capacity = 102;
        int seated = 60;

        StringBuilder sb = new StringBuilder("В вагоне есть ");

        if (passengers < seated) {
            sb.append("сидячие места");
            System.out.println(sb);
        } else if (passengers >= seated && passengers < capacity) {
            sb.append("стоячие места");
            System.out.println(sb);
        } else if (passengers >= capacity)
            System.out.println("В вагоне нет мест");

        System.out.println();
    }

    public static void task7(){

        int one = getRandomNumber(0,100);
        int two = getRandomNumber(0,100);
        int three = getRandomNumber(0,100);

        if (one >= two && one >= three)
            System.out.println("Первое число больше всех");
        if (two >= one && two >= three)
            System.out.println("Второе число больше всех");
        if (three >= two && three >= one)
            System.out.println("Третье число больше всех");

    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}