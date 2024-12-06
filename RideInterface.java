public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    
    void removeVisitorFromQueue();
    
    void printQueue();
    
    void runOneCycle();
    
    void addVisitorToHistory(Visitor visitor);
    
    boolean checkVisitorFromHistory(Visitor visitor);
    
    int numberOfVisitors();
    
    void printRideHistory();
}
