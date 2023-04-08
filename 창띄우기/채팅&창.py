import sys
import socket
import threading
import os
from PyQt5.QtWidgets import QApplication, QWidget, QLabel, QLineEdit
from PyQt5.QtGui import QIcon

class MyApp(QWidget):
    
    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        self.lbl = QLabel(self)
        self.lbl.move(-3000,-3000)
        
        qle = QLineEdit(self)
        qle.move(60,800)
        qle.textChanged[str].connect(self.onChanged)
        #qle.editingFinished.connect(self.client)

        self.setWindowTitle('Yoni Talk')
        self.setWindowIcon(QIcon('YONI.png'))
        self.setGeometry(500,100,600,900)
        self.show()

    def onChanged(self,text):
        self.lbl.setText(text)
        self.lbl.adjustSize()
        
        '''client_sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
        Host = '127.0.0.1'
        Port = 9000
        
        client_sock.connect((Host,Port))
        print('Connection to', Host, Port)

        client_sock.send(lbl.encode())
        client_sock.recv(1024)'''

        
if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = MyApp()
    sys.exit(app.exec_())

