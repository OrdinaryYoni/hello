from socket import *
from _thread import *

client_sockets = []

HOST = '127.0.0.1'
PORT = 9000

serverSock = socket(AF_INET, SOCK_STREAM)
serverSock.bind((HOST,PORT))
serverSock.listen()

clientSocket, addr = serverSock.accept()

print(str(addr),'가 접속함')

data = clientSocket.recv(1024)
print('받은 데이터 :', data.decode('utf-8'))

clientSock.send('hello~'.encode('utf-8'))
