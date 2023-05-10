public class Places {
    private String name;
    private double distanceFromStart;
    private boolean startPoint;

    public Places(String _name) {
        name = _name;
        startPoint = true;
        distanceFromStart = 0;
    }

    public Places(String _name, double _distanceFromStart){
        name = _name;
        distanceFromStart = _distanceFromStart;
        startPoint = false;
    }

    public String getName() {
        return name;
    }

    public double getDistanceFromStart() {
        return distanceFromStart;
    }

    public boolean isStartPoint() {
        return startPoint;
    }
}
