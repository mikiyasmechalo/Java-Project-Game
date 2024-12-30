package Project;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                 _____                                                                               _____\s
                ( ___ )-----------------------------------------------------------------------------( ___ )
                 |   |                                                                               |   |\s
                 |   |  ____                                   _        ___                     _    |   |\s
                 |   | |  _ \\  _ __  __ _   __ _   ___   _ __ ( )___   / _ \\  _   _   ___  ___ | |_  |   |\s
                 |   | | | | || '__|/ _` | / _` | / _ \\ | '_ \\|// __| | | | || | | | / _ \\/ __|| __| |   |\s
                 |   | | |_| || |  | (_| || (_| || (_) || | | | \\__ \\ | |_| || |_| ||  __/\\__ \\| |_  |   |\s
                 |   | |____/ |_|   \\__,_| \\__, | \\___/ |_| |_| |___/  \\__\\_\\ \\__,_| \\___||___/ \\__| |   |\s
                 |   |                     |___/                                                     |   |\s
                 |___|                                                                               |___|\s
                (_____)-----------------------------------------------------------------------------(_____)
                """);
        System.out.print("Please Enter your name: ");
        String playerName = GetInput.getSentenceInput();

        GameLoop gameLoop = new GameLoop(playerName);
        gameLoop.run();

        GetInput.closeScanner();
    }
}