import sys
import socket
import threading
import os
from PyQt5.QtWidgets import QApplication, QWidget, QLabel, QLineEdit, QPushButton
from PyQt5.QtGui import QIcon

class MyApp(QWidget):
    
    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        #창
        self.setWindowTitle('Yoni Talk')
        self.setWindowIcon(QIcon('YONI.png'))
        self.setGeometry(500,100,500,500)


        #글쓰기칸
        self.line = QLineEdit(self) #글쓰기칸 설정
        self.line.move(60,400)

        self.text_lbl = QLabel(self)#버튼 클릭으로 가져온 text를 보여주는 역할
        self.text_lbl.move(60,300)
        self.text_lbl.setText('hello world')

        self.button = QPushButton(self)#line에서 입력된 text를 가져오는 역할
        self.button.move(220,398)
        self.button.setText('전송')
        self.button.clicked.connect(self.button_event)

        self.enter_button = QPushButton(self)
        self.enter_button.move(300,398)
        self.enter_button.setText('서버접속')
        self.enter_button.clicked.connect(self.enter_button_event)

        self.show()

    def button_event(self):
        text = self.line.text() #line의 text값 가져오기
        self.text_lbl.setText(text)#lbl에 text설정하기
        self.text_lbl.adjustSize()
        print(text)
        self.client_Sock.send(b'123123')
        
    def enter_button_event(self):
        self.client_sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
        Host = '127.0.0.1'
        Port = 9000
        
        self.client_sock.connect((Host,Port))
        print('Connection to', Host, Port)

        
        

        
if __name__ == '__main__':

    
    app = QApplication(sys.argv)
    ex = MyApp()

    sys.exit(app.exec_())


    #qle = QLineEdit(self)
        #qle.move(60,800)
        #qle.textChanged[str].connect(self.onChanged)
'''
    def onChanged(self,text):
        print(text)
        self.lbl.setText(text)
        self.lbl.adjustSize()
        

    def check(self):
        print(self.initUI.a)'''
'''
        #버튼
        self.button1 = QPushButton('버튼', self)
        self.button1.setCheckable(True)
        #self.button1.toggle()
        self.button1.move(220,798)
        self.button1.clicked.connect(self.check)
        #self.button1.clicked.connect(self.check2)'''
