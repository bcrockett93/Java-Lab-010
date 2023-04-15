class StatisticsDisplay implements Display {
    private WeatherStation ws;
    private float temperatureMin;
    private float temperatureMax;
    private float temperatureTotal;
    private int numReadings;

    public StatisticsDisplay(WeatherStation ws) {
        this.ws = ws;
        ws.registerDisplay(this);
    }

    public void update() {
        float currentTemperature = ws.getTemperature();
        temperatureTotal += currentTemperature;
        numReadings++;

        if (numReadings == 1) {
            temperatureMin = currentTemperature;
            temperatureMax = currentTemperature;
        } else {
            if (currentTemperature < temperatureMin) {
                temperatureMin = currentTemperature;
            }

            if (currentTemperature > temperatureMax) {
                temperatureMax = currentTemperature;
            }
        }

        display();
    }
    public void display() {
        System.out.println("Temperature statistics:");
        System.out.println("Min: " + temperatureMin + "°F");
        System.out.println("Max: " + temperatureMax + "°F");
        System.out.println("Avg: " + (temperatureTotal / numReadings) + "°F");
    }
}