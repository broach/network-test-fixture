package net.mostlyharmless.test.network.fixture;

import java.io.IOException;

public class App 
{
    private final static int startingPort = 5000;
    
    public static void main( String[] args ) throws IOException, InterruptedException 
    {
        NetworkTestFixture fixture = new NetworkTestFixture(startingPort);
        Thread t = new Thread(fixture);
        t.start();
        t.join();
    }
}
