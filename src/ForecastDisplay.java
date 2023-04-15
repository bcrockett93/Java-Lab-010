class ForecastDisplay implements Display {
    private WeatherStation ws;
    private float currentPressure;
    private float lastPressure;

    public ForecastDisplay(WeatherStation ws) {
        this.ws = ws;
        ws.registerDisplay(this);
    }

    public void update() {
        lastPressure = currentPressure;
        currentPressure = ws.getPressure();
        display();
    }

    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}