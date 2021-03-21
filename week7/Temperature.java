/**
 * Author: Shengye Zang
 * Date: 3/20/2021
 * Assignment: week 7 discussion
 */

public class Temperature{
    
    public static enum SCALE {
        /**
         * Celsius
         */
        C,
        /**
         * Fahrenheit
         */
        F,
        /**
         * Kelvin
         */
        K};
    
    // Class attributes
    private double temperature;
    private SCALE scale = SCALE.F;

    // constructors
    public Temperature() {}

    public Temperature(double t) {
        setTemperature(t);
    }

    public Temperature(double t, SCALE s) {
        setTemperature(t, s);
    }
    
    // mutators
    public void setTemperature(double t) {
        if(scale == SCALE.F && t >= -100 && t <= 150)
            temperature = t;
        if(scale == SCALE.C && t >= -73 && t <= 65)
            temperature = t;
        if(scale == SCALE.K && t >= 199.817 && t <= 338.706)
            temperature = t;
    }

    public void setScale(SCALE s) {
        if(s == SCALE.F) {
            scale = s;
            temperature = getFahrenheit();
        }
        if(s == SCALE.C) {
            scale = s;
            temperature = getCelsius();
        }
        if(s == SCALE.K) {
            scale = s;
            temperature = getKelvin();
        }   
    }

    public void setTemperature(double t, SCALE s) {
        setTemperature(t);
        setScale(s);
    }

    // accessors
    public double getCelsius() {
        if(scale == SCALE.C)
            return temperature;
        else if(scale == SCALE.F)
            return (temperature - 32) * 5 / 9;
        else
            return temperature - 273;
    }

    public double getFahrenheit() {
        if(scale == SCALE.F)
            return temperature;
        else if(scale == SCALE.C)
            return temperature * 9 / 5 + 32;
        else
            return (temperature - 273) * 9 / 5 + 32;
    }

    public double getKelvin() {
        if(scale == SCALE.K)
            return temperature;
        else if(scale == SCALE.F)
            return (temperature - 32) * 5 / 9 + 273;
        else
            return temperature + 273;
    }

    /**
     * 
     */
    public String toString() {
        if(scale == SCALE.C || scale == SCALE.F)
            return temperature + (char) 248 + " " + scale;
        else
            return temperature + " K";
    }

    /**
     * This method implements a deep comparison between the object that calls this method and the input object
     * @param t
     * @return true if both class attributes are equal, false otherwise
     */
    public boolean equals(Temperature t) {
        return this.temperature == t.temperature && this.scale == t.scale;
    }
}