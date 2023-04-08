import socket
import threading
from queue import Queue

def Send(group, send_queue):
    print('Thread Send Start')
    while True:
        try:
            recv = send_queue.get()
            if recv == 'Group Changed':
                print('Group Changed')
                break

            for conn in group:
                msg = 'Client' + str(recv[2]) + '>>' + str(recv[0])
                if recv[1] != conn:
                    conn.send(bytes(msg.encode()))
                else:
                    pass
            except:
                pass

def Recv(conn, count, send_queue):
    print('스레드 recv'+str(count)+'시작')
    
    
