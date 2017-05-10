/* 
 * Copyright (c) 2017, Sergio
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package anadiapp.model;

import anadiapp.ui.AppUi;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 * Created by skimi on 25/04/2017.
 */
public class Connection {

    private final ConnectData data;
    private final InetSocketAddress socketAdd;
    private boolean connected;
    Socket sock;
    private AppUi AppUi = null;


    public Connection(AppUi AppUi, ConnectData data) {
        this.data = data;
        this.connected = false;
        this.sock = null;
        this.socketAdd= new InetSocketAddress(data.getAddress(),data.getPort());
        this.AppUi = AppUi;
    }

    public boolean connected(){
        //int timeout  = this.data.getTimeoutMilli();
        int timeout  = this.data.getTimeout();
        try{
            sock = new Socket();
            sock.connect(socketAdd,timeout);
            connected = sock.isConnected();
        } catch (IOException e) {
            AppUi.setText("Falha de " + data.getNode() + ", tipo - " + e.getMessage() +"\n");
            connected = false;
            //e.printStackTrace();
        }
        return connected;
    }

}
