package org.a4r;

/**
 * Created by brendan on 6/4/17.
 */
public class ExampleA4RClient extends A4RClient {
    @Override
    public void publish(Object message) {

    }

    @Override
    public void handleMessage(Object message) {

    }

    public static void main(String[] args) {
        ExampleA4RClient client = new ExampleA4RClient();
        client.start(args);
    }
}
