
public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue(Visitor visitor);
    void printQueue();
    void runOneCycle();
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();

    void sortHistory();

    void printRideHistory();

    void exportRideHistory(String filePath);

    void importRideHistory(String filePath);
}
