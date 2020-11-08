package com.example.ws.io;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Future;

public class AioTest {
    public static void main(String[] args) throws Exception{
        Path file = Paths.get("D:/desktop/text.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);
        ByteBuffer buffer = ByteBuffer.allocate(100_000);
        Future<Integer> result = channel.read(buffer, 0);
        while (!result.isDone()) {
            ProfitCalculator.calculateTax();
        }
        Integer bytesRead = result.get();
        System.out.println("Bytes read [" + bytesRead + "]");
    }
}


