package de.andrestefanov.idea.opencomputers.toolwindow;

import de.andrestefanov.idea.opencomputers.discard.DiscardServer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class OCToolWindow {

    private JPanel rootPanel;

    private JTabbedPane tabbedPane1;
    private JTextPane textPane1;

    private DiscardServer server;

    OCToolWindow() {
        server = new DiscardServer(9500, new TcpServerHandler());

        new Thread(() -> {
            try {
                server.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    JPanel getRootPanel() {
        return rootPanel;
    }

    @ChannelHandler.Sharable
    private class TcpServerHandler extends ChannelInboundHandlerAdapter { // (1)

        StyledDocument doc;
        SimpleAttributeSet keyWord;

        TcpServerHandler() {
            doc = textPane1.getStyledDocument();
            keyWord = new SimpleAttributeSet();
            StyleConstants.setForeground(keyWord, Color.GREEN);
//            StyleConstants.setBackground(keyWord, Color.BLACK);
//            StyleConstants.setBold(keyWord, true);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf in = (ByteBuf) msg;
            try {
                byte[] bytes = new byte[in.readableBytes()];
                in.readBytes(bytes);
                doc.insertString(doc.getLength(), new String(bytes), keyWord );
            } finally {
                ReferenceCountUtil.release(msg);
            }
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
            // Close the connection when an exception is raised.
            cause.printStackTrace();
            ctx.close();
        }
    }
}
