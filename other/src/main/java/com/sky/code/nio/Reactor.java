package com.sky.code.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * ????? ?????????????
 */
public class Reactor implements Runnable {
    public final Selector selector;
    public final ServerSocketChannel serverSocketChannel;

    public Reactor(int port) throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), port);
        serverSocketChannel.socket().bind(inetSocketAddress);
        serverSocketChannel.configureBlocking(false);

        // ?selector???channel
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // ??selectionKey?attache????Acceptor ????????Acceptor
        selectionKey.attach(new Acceptor(this));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                // Selector????channel?OP_ACCEPT?READ??????????????
                while (it.hasNext()) {
                    // ????? ???????accepter???SocketReadHandler
                    SelectionKey selectionKey = it.next();
                    dispatch(selectionKey);
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ??Acceptor?SocketReadHandler
     *
     * @param key
     */
    void dispatch(SelectionKey key) {
        Runnable r = (Runnable) (key.attachment());
        if (r != null) {
            r.run();
        }
    }

}