import socket
from _thread import *
def threaded(client_socket, addr):
    print('>> Connected by :', addr[0], ':', addr[1])
    file_check = 0
    # 클라이언트가 접속을 끊을 때 까지 반복합니다.
    while True:

        try:

            # 데이터가 수신되면 클라이언트에 다시 전송합니다.(에코)
            data = client_socket.recv(1024)
                
            if not data:
                print('>> Disconnected by ' + addr[0], ':', addr[1])
                break

            data = data.decode()
            if data == 'file':
                file_check = 1

            if file_check == 1:
                file = open('1'+data, 'w', encoding='utf-8')
                file_check =2

            if data =='+.+':
                file_check = 0
                file.close()
                
            if file_check == 2:
                file.write(data)
            
            print('>> Received from ' + addr[0], ':', addr[1], data)

            # 서버에 접속한 클라이언트들에게 채팅 보내기
            # 메세지를 보낸 본인을 제외한 서버에 접속한 클라이언트에게 메세지 보내기
            for client in client_sockets :
                if client != client_socket :
                    client.send(data)

        except ConnectionResetError as e:
            print('>> Disconnected by ' + addr[0], ':', addr[1])
            break

    if client_socket in client_sockets :
        client_sockets.remove(client_socket)
        print('remove client list : ',len(client_sockets))

    client_socket.close()
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
        client_sockets.append(client_socket)
        start_new_thread(threaded, (client_socket, addr))
        print("참가자 수 : ", len(client_sockets))
        
except Exception as e :
    print ('에러는? : ',e)

finally:
    server_socket.close()



