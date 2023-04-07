import sys
from PyQt5.QtWidgets import QApplication,QWidget,QPushButton,QToolTip,QMainWindow,QAction,qApp,QDesktopWidget,QLabel,QVBoxLayout
from PyQt5.QtCore import QCoreApplication,QDate,Qt,QTime,QDateTime
from PyQt5.QtGui import QIcon,QFont

class MyApp(QWidget):

    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):

        lbl_red = QLabel('Red')
        lbl_green = QLabel('Green')
        lbl_blue = QLabel('Blue')

        lbl_red.setStyleSheet("color:red;"
                              "border-style: solid;"
                              "border-width: 2px;"
                              "border-color: #FA8072;"
                              "border-radius: 3px;")
        lbl_green.setStyleSheet("color:green;"
                                "background-color: #7FFFD4")
        lbl_blue.setStyleSheet("color:blue;"
                               "background-color: #87CEFA;"
                               "border-style: dashed;"
                               "border-width: 3px;"
                               "border-color: #1E90FF")

        vbox = QVBoxLayout()
        vbox.addWidget(lbl_red)
        vbox.addWidget(lbl_green)
        vbox.addWidget(lbl_blue)

        self.setLayout(vbox)

        self.setWindowTitle('Stylesheet')
        self.setGeometry(300,300,300,200)
        self.show()

if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = MyApp()
    sys.exit(app.exec_())








'''
class MyApp(QMainWindow):

    def __init__(self):
        super().__init__()
        self.date = QDate.currentDate()
        self.initUI()

    def initUI(self):
        self.statusBar().showMessage(self.date.toString(Qt.DefaultLocaleLongDate))

        self.setWindowTitle('Date')
        self.setGeometry(300,300,400,200)
        self.show()

if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = MyApp()
    sys.exit(app.exec_()))




now = QDate.currentDate()
print(now.toString('d.M.yy'))
print(now.toString('dd.MM.yyyy'))
print(now.toString('ddd.MMM.yyyy'))
print(now.toString(Qt.ISODate))
print(now.toString(Qt.DefaultLocaleLongDate))

time = QTime.currentTime()
print(time.toString('h.m.s'))
print(time.toString('hh.mm.ss'))
print(time.toString('hhh.mmm.sss'))
print(time.toString(Qt.DefaultLocaleLongDate))
print(time.toString(Qt.DefaultLocaleShortDate))

datetime = QDateTime.currentDateTime()
print(datetime.toString('d.M.yy hh:mm:ss'))
print(datetime.toString('dd.MM.yyyy, hh:mm:ss'))
print(datetime.toString(Qt.DefaultLocaleLongDate))
print(datetime.toString(Qt.DefaultLocaleShortDate))



class MyApp(QMainWindow):
    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        exitAction = QAction(QIcon('exit.png'), 'Exit', self)
        exitAction.setShortcut('Ctrl+Q')
        exitAction.setStatusTip('Exit application')
        exitAction.triggered.connect(qApp.quit)

        self.statusBar()

        self.toolbar = self.addToolBar('Exit')
        self.toolbar.addAction(exitAction)

        self.setWindowTitle('Toolbar')
        self.resize(500,500)
        self.center()
        self.show()

    def center(self):
        qr = self.frameGeometry()
        cp = QDesktopWidget().availableGeometry().center()
        qr.moveCenter(cp)
        self.move(qr.topLeft())

if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = MyApp()
    sys.exit(app.exec_())



class MyApp(QWidget):

    def __init__(self):
        super().__init__()
        self.initUI()

    def Rjwu(self):
        exit()
        
    def initUI(self):
        QToolTip.setFont(QFont('SansSerif', 10))
        self.setToolTip('This is a <b>QWidget</b> widget')

        Tbtn = QPushButton('Button', self)
        Tbtn.setToolTip('This is a <b>QPushButton</b> widget')
        Tbtn.move(150,50)
        Tbtn.resize(Tbtn.sizeHint())
        
        Ebtn = QPushButton('Quit', self)
        Ebtn.move(50,50)
        Ebtn.resize(Ebtn.sizeHint())
        Ebtn.clicked.connect(self.Rjwu)

        self.setWindowTitle('Quit Button')
        self.setWindowIcon(QIcon('YONI.png'))
        self.setGeometry(300,300,300,200)
        self.show()
if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = MyApp()
    sys.exit(app.exec_())'''
