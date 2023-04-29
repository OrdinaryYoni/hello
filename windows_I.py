from PyQt5.QtGui import *
from PyQt5.QtCore import *
from PyQt5.QtWidgets import *
import sys
import socket
import server_I

QApplication.setAttribute(Qt.AA_EnableHighDpiScaling, True)

port = 3040

class CWidget(QWidget):
    def __init__(self):
        super().__init__()

        self.s = server_I.ServerSocket(self)

        self.initUI()

    def initUI(self):
        self.setWindowTitle('서버')

        #서버 설정 부분
        ipbox = QHBoxLayout()

        gb = QGroupBox('서버 설정')
        ipbox.addWidget(gb)

        box = QHBoxLayout()

        label = QLabel('Server IP')
        self.ip = QLineEdit(socket.gethostbyname(socket.gethostname()))
        box.addWidget(label)
        box.addWidget(self.ip)

        label = QLabel('Server Port')
        self.port = QLineEdit(str(port))
        box.addWidget(label)
        box.addWidget(self.port)

        self.btn = QPushButton('서버 실행')
        self.btn.setCheckable(True)
        self.btn.toggled.connect(self.toggleButton)
        box.addWidget(self.btn)

        gb.setLayout(box)

        #접속자 정보 부분
        infobox = QHBoxLayout()
        gb = QGroupBox('접속자 정보')
        infobox.addWidget(gb)

        box = QHBoxLayout()

        self.guest = QTableWidget()
        self.guest.setColumnCount(2)
        self.guest.setHorizontalHeaderItem(0, QTableWidgetItem('ip'))
        self.guest.setHorizontalHeaderItem(1, QTableWidgetItem('port'))

        box.addWidget(self.guest)
        gb.setLayout(box)

        #채팅창 부분
        gb = QGroupBox('메세지')
        infobox.addWidget(gb)

        box = QVBoxLayout()

        label = QLabel('받은 메세지')
        box.addWidget(label)

        self.msg = QListWidget()
        box.addWidget(self.msg)

        label = QLabel('보낼 메세지')
        box.addWidget(label)

        self.sendmsg = QLineEdit()
        box.addWidget(self.sendmsg)

        hbox = QHBoxLayout()

        self.sendbtn = QPushButton('보내기')
        self.sendbtn.clicked.connect(self.sendMsg)
        hbox.addWidget(self.sendbtn)
        
        self.clearbtn = QPushButton('채팅창 지움')
        self.clearbtn.clicked.connect(self.clearMsg)
        hbox.addWidget(self.clearbtn)

        box. addLayout(hbox)

        gb.setLayout(box)

        #전체 배치
        vbox = QVBoxLayout()
        vbox.addLayout(ipbox)
        vbox.addLayout(infobox)
        self.setLayout(vbox)

        self.show()

    def toggleButton(self, state):
        if state:
            ip = self.ip.text()
            port = self.port.text()
            print(ip, port)
            if self.s.start(ip, int(port)):
                print('실행중')
                self.btn.setText('서버 종료')
            print('실행끝')
        else:
            self.s.stop()
            self.msg.clear()
            self.btn.setText('서버 실행')

    def updateClient(self, addr, isConnect = False):
        row = self.guest.rowCount()
        if isConnect:
            self.guest.setRowCount(row+1)
            self.guest.setItem(row, 0, QTableWidgetItem(addr[0]))
            self.guest.setItem(row, 1, QTableWidgetItem(str(addr[1])))
        else:
            for r in range(row):
                ip = self.guest.item(r,0).text() #ip
                port = self.guest.item(r,1).text() #port
                if addr[0]==ip and str(addr[1])==port:
                    self.guest.removeRow(r)
                    break

    def updateMsg(self,msg):
        self.msg.addItem(QListWidgetItem(msg))
        self.msg.setCurrentRow(self.msg.count()-1)

    def sendMsg(self):
        if not self.s.bListen:
            self.sendmsg.clear()
            return
        sendmsg = self.sendmsg.text()
        self.updateMsg(sendmsg)
        print(sendmsg)
        self.s.send(sendmsg)
        self.sending.clear()

    def clearMsg(self):
        self.msg.clear()

    def closeEvent(self, e):
        self.s.stop()

if __name__ == '__main__':
    app = QApplication(sys.argv)
    w = CWidget()
    sys.exit(app.exec_())
