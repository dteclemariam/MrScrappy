public class UserInterface {
    //method for printing separator
    private void printSeparator() {
        System.out.println("---------------------------------------------------------------------------------------");
    }

    void initializing(){
        System.out.println("The application i starting...");
        printSeparator();
    }

    //method for closing game
    public void exit() {
        System.out.print("The application is exiting");
    }
}
