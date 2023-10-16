package br.com.njf.demofix;

import quickfix.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ConectorFix {


    public void connect () throws FileNotFoundException, ConfigError {

        Application application = new FooApplication();

        SessionSettings settings = new SessionSettings(new FileInputStream("fileName"));

        MessageStoreFactory storeFactory = new FileStoreFactory(settings);
        LogFactory logFactory = new FileLogFactory(settings);
        MessageFactory messageFactory = new DefaultMessageFactory();
        Acceptor acceptor = new SocketAcceptor
                (application, storeFactory, settings, logFactory, messageFactory);
        acceptor.start();
        // while(condition == true) { do something; }
        acceptor.stop();

    }
}
