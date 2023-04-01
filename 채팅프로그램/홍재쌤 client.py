import socket
import threading
import os

#TCP Client
if __name__ == '__main__':
    client_sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM) #TCP Socket
    Host = 'localhost' #통신할 대상의 IP 주소
    Port = 9000 #통신할 대상의 Port 주소
    client_sock.connect((Host, Port)) #서버로 연결시도
    print('Connectin to', Host, Port)

    file = open('a.txt', 'r',encoding='utf-8')
    data = file.readlines()
    file.close()

    client_sock.send('file'.encode())
    client_sock.recv(1024)
    client_sock.send('a.txt'.encode())
    client_sock.recv(1024)
    for d in data:
        client_sock.send(d.encode())
        client_sock.recv(1024)
    client_sock.send('+.+'.encode())
    client_sock.recv(1024)
    

