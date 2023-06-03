from threading import *
from socket import *
from PyQt5.QtCore import Qt, pyqtSignal, QObject
import os
class Signal(QObject):
    recv_signal =  pyqtSignal(str)
    disconn_signal = pyqtSignal()

class ClientSocket:

    def __init__(self,parent):
        self.parent = parent

        self.recv = Signal()
        self.recv.recv_signal.connect(self.parent.updateMsg)
        self.disconn = Signal()
        self.disconn.disconn_signal.connect(self.parent.updateDisconnect)

        self.bConnect = False
        
    def __del__(self):
        self.stop()

    def connectServer(self,ip,port):
        self.client = socket(AF_INET, SOCK_STREAM)

        try:
            self.client.connect( (ip, port) )
        except Exception as e:
            print('Connect Error : ',e)
            return False
        else:
            self.bConnect = True
            self.t = Thread(target=self.receive, args=(self.client,))
            self.t.start()
            print('Connected')

        return True

    def stop(self):
        self.bConnect = False
        if hasattr(self, 'client'):
            self.client.close()
            del(self.client)
            print('Client Stop')
            self.disconn.disconn_signal.emit()

    def receive(self, client):
        while self.bConnect:
            try:
                recv = client.recv(1024)
                recv_transferred = 0
            except Exception as e:
                print('Recv() Error :', e)
                break
            else:
                if recv[:3] == '^-^':
                    filename = str(recv, encoding = 'utf-8') - '^-^'
                    nowdir = os.getcwd()
                    with open(nowdir+'\\'+filename, 'wb') as f:
                        try:
                            while recv:
                                f.write(recv)
                                data_transferred += len(recv)
                                recv = clientSock.recv(1024)
                        except Exception as e:
                            print(e)
                else:
                    msg = str(recv, encoding = 'utf-8')
                    if msg:
                        self.recv.recv_signal.emit(msg)
                        print('[RECV]: ', msg)

        self.stop()

    def send(self, msg):
        if not self.bConnect:
            return

        try:
            self.client.send(msg.encode())
        except Exception as e:
            print('Send() Error : ', e)

    def sendfile(self, filename):
        if not self.bConnect:
            return

        try:
            file_name_data = '^-^' + filename
            f = file_name_data.encode('utf-8')
            self.client.send(f)
            with open(filename, 'rb') as f:
                while True:
                    data = f.read(1021)
                    if not data:
                        a = b'*-*'
                        self.client.send(a)
                        break
                    data = b'^b^' + data
                    print(type(data))
                    self.client.send(data)
            
        except Exception as e:
            print('Send() Error : ', e)
