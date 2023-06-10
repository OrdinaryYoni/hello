import turtle as t

t.shape('turtle')
t.pensize(10)
t.speed(3)
t.color('black')

s = t.Screen()
s.setup(1000,1000)

go = 100
ag = 205

t.up()
t.goto(-40,0)
t.right(90)
t.fd(100)
t.right(90)
t.fd(300)
for i in range(3):
    if i > 0:
        go += 200
        ag += 200
    t.right(55)
    t.down()
    t.begin_fill()
    t.fd(go)
    t.right(90)
    t.fd(150)
    t.right(90)
    t.fd(ag)
    t.right(125)
    t.fd(180)
    t.end_fill()
    t.up()
    t.fd(-270)
t.left(90)
t.fd(260)
t.right(90)
t.fd(20)
t.write('adidas',align='right',font=('Consolas',200))
