/**
 * Author: Shengye Zang
 * Date: 3/20/2021
 * Assignment: week 7 discussion
 */

public class TemperatureDriver {
    public static void main(String[] args) {
        Temperature[] temperatures = new Temperature[10];

        temperatures[0] = new Temperature();
        temperatures[0].setTemperature(-100);
        temperatures[1] = new Temperature(150);
        temperatures[2] = new Temperature(102.3);
        temperatures[3] = new Temperature(-73,Temperature.SCALE.C);
        temperatures[4] = new Temperature(65, Temperature.SCALE.C);
        temperatures[5] = new Temperature(23.103, Temperature.SCALE.C);
        temperatures[6] = new Temperature(199.817, Temperature.SCALE.K);
        temperatures[7] = new Temperature(338.706, Temperature.SCALE.K);
        temperatures[8] = new Temperature(-100, Temperature.SCALE.F);
        temperatures[9] = new Temperature(150, Temperature.SCALE.F);

        for(Temperature temperature: temperatures)
            System.out.println(temperature.toString());

        System.out.println(temperatures[0].equals(temperatures[1]));
        System.out.println(temperatures[0].equals(temperatures[3]));
        System.out.println(temperatures[0].equals(temperatures[0]));
        System.out.println(temperatures[0].getCelsius());
        System.out.println(temperatures[0].getFahrenheit());
        System.out.println(temperatures[0].getKelvin());
        System.out.println(temperatures[3].equals(temperatures[3]));
        System.out.println(temperatures[3].getCelsius());
        System.out.println(temperatures[3].getFahrenheit());
        System.out.println(temperatures[3].getKelvin());
        System.out.println(temperatures[6].equals(temperatures[6]));
        System.out.println(temperatures[6].getCelsius());
        System.out.println(temperatures[6].getFahrenheit());
        System.out.println(temperatures[6].getKelvin());
        temperatures[0].setScale(Temperature.SCALE.C);
        System.out.println(temperatures[0].getCelsius());
        System.out.println(temperatures[0].getFahrenheit());
        System.out.println(temperatures[0].getKelvin());
        temperatures[0].setScale(Temperature.SCALE.K);
        System.out.println(temperatures[0].getCelsius());
        System.out.println(temperatures[0].getFahrenheit());
        System.out.println(temperatures[0].getKelvin());
    }
}
