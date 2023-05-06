from threading import Thread
from socket import *
from PyQt5.QtCore import Qt, pyqtSignal, QObject

class ServerSocket(QObject):

    update_signal = pyqtSignal(tuple,bool)
    recv_signal = pyqtSignal(str)

    def __init__(self,parent):
        super().__init__()
        self.parent = parent
        self.bListen = False
        self.clients = []
        self.ip = []
        self.threads = []

        self.update_signal.connect(self.parent.updateClient)
        self.recv_signal.connect(self.parent.updateMsg)

    def __del___(self):
        self.stop()

    def start(self,ip,port):
        self.server = socket(AF_INET, SOCK_STREAM)

        try:
            self.server.bind((ip, port))
        except Exception as e:
            print('Bind Error : ', e)
            return False
        else:
            self.bListen = True
            self.t = Thread(target=self.listen, args=(self.server,))
            self.t.start()
            print('Server.Listening...')

        return True

    def stop(self):
        self.bListen = False
        if hasattr(self,'server'):
            self.server.close()
            print('Server Stop')

    def listen(self, server):
        while self.bListen:
            server.listen(5)
            try:
                client, addr = server.accept()
            except Exception as e:
                print('Accept() Error : ', e)
                break
            else:
                self.clients.append(client)
                self.ip.append(addr)
                self.update_signal.emit(addr, True)
                t = Thread(target=self.receive, args=(addr,client))
                self.threads.append(t)
                t.start()

        self.removeAllClients()
        self.server.close()

    def receive(self, addr, client):
        while True:
            try:
                recv = client.recv(1024)
            except Exception as e:
                print('Recv() Error :', e)
                break
            else:
                if recv[:3] == b'^-^':
                    print(recv.decode())
                else:
                    msg = str(recv, encoding='utf-8')
                    if msg:
                        self.send(msg)
                        self.recv_signal.emit(msg)
                        print('[RECV]:', addr, msg)

        self.removeClient(addr,client)

    def send(self,msg):
        try:
            for c in self.clients:
                c.send(msg.encode())
        except Exception as e:
            print('Send() Error : ', e)

    def removeClient(self, addr, client):
        #find closed client index
        idx = -1
        for k, v in enumerate(self.clients):
            if v == client:
                idx = k
                break

        client.close()
        self.ip.remove(addr)
        self.clients.remove(client)

        del(self.threads[idx])
        self.update_signal.emit(addr,False)
        self.resourceInfo()

    def removeAllClients(self):
        for c in self.clients:
            c.close()

        for addr in self.ip:
            self.update_signal.emit(addr, False)

        self.ip.clear()
        self.clients.clear()
        self.threads.clear()

        self.resourceInfo()

    def resourceInfo(self):
        print('Number of Client ip\t: ', len(self.ip))
        print('Number of Client socket\t: ', len(self.clients))
        print('Number of Client Thread\t: ', len(self.threads))
