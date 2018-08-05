package com.sky.code.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class SocketReadHandler implements Runnable {
    private SocketChannel socketChannel;

    public SocketReadHandler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);

        SelectionKey selectionKey = socketChannel.register(selector, 0);

        // ?SelectionKey????Handler ????????????????run???
        // ??dispatch(SelectionKey key)
        selectionKey.attach(this);

        // ???SelectionKey???????????
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    /**
     * ??????
     */
    @Override
    public void run() {
        ByteBuffer inputBuffer = ByteBuffer.allocate(1024);
        inputBuffer.clear();
        try {
            socketChannel.read(inputBuffer);
            // ????? ????request
            // requestHandle(new Request(socket,btt));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}