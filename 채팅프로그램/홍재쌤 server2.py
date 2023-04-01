import socket
from _thread import *

client_sockets = [] # 서버에 접속한 클라이언트 목록

# 서버 IP 및 열어줄 포트
HOST = '127.0.0.1'
PORT = 9000

# 서버 소켓 생성
print('>> Server Start')
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
server_socket.bind((HOST, PORT))
server_socket.listen()

try:
    while True:
        print('>> Wait')

        client_socket, addr = server_socket.accept()

        file_check = 0 
        while True:
            data = client_socket.recv(1024)
            data = data.decode()
            
            if data == 'file':
                file_check = 1
            elif data =='+.+':
                file_check = 0
                file.close()
            elif file_check == 1:
                file = open('1'+data, 'w', encoding='utf-8')
                file_check =2   
            elif file_check == 2:
                file.write(data)


            print(data)
            client_socket.send(b'1')
        
    
        
except Exception as e :
    print ('에러는? : ',e)

finally:
    server_socket.close()



