class CurrentConditions implements Display {
    private WeatherStation ws;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditions(WeatherStation ws) {
        this.ws = ws;
        ws.registerDisplay(this);
    }

    public void update() {
        temperature = ws.getTemperature();
        humidity = ws.getHumidity();
        pressure = ws.getPressure();
        display();
    }

    public void display() {
        System.out.println("Current conditions:");
        System.out.println("Temperature: " + temperature + "°F");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Pressure: " + pressure + " inHg");
    }
}