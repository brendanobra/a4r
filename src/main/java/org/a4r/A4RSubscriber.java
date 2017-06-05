package org.a4r;

/**
 * Created by brendan on 6/4/17.
 * Interface to allow java clients to be called back
 */
public interface A4RSubscriber {
     void handleMessage(Object message);
}
