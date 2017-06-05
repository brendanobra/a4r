package org.a4r;

/**
 * Created by brendan on 6/4/17.
 *
 * This is a thin java wrapper to facilitate
 * a less noisy interface to Akka for clients
 *
 * This will expose both publish and subscribe interfaces
 */
public abstract class A4RClient implements A4RSubscriber,AR4Publisher{
    public void start(String[] args) {

        ClientMain.main(args);

    }
    public static void main(String[] args) {

    }

}
