from socket import *
from _thread import *

client_sockets = []

HOST = '127.0.0.1'
PORT = 9000

serverSock = socket(AF_INET, SOCK_STREAM)
serverSock.bind((HOST,PORT))
serverSock.listen()

print('accept 대기중')
clientSocket, addr = serverSock.accept()

print('accept 끝나서 recv대기중')

data = clientSocket.recv(1024)
print('받은 데이터 :', data.decode('utf-8'))

#clientSocket.send('hello~'.encode('utf-8'))
