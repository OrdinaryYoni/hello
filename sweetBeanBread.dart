import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: '상세페이지',
      home: MyHomePage(),
    );
  } 
}

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        
        title: Text('오성 매점'),
        centerTitle: true,
        backgroundColor: Colors.orange,
        elevation: 0.0,
        leading: IconButton(
          icon: Icon(Icons.exit_to_app),
          onPressed: (){
            print('앱 바 버튼 눌림'); //아마 상세페이지 나가는 버튼
          },
        ),
      ),
      body: Padding(
        padding: EdgeInsets.fromLTRB(0, 10, 0, 0),
        child: Column(
          children: <Widget> [
            Text('단팥빵',
            style: TextStyle(
              letterSpacing: 2.0,
              fontSize: 50,
              fontWeight: FontWeight.bold,
            ),
            ),
             SizedBox(
              height: 30,
            ),
            Center(
              child: CircleAvatar(
                backgroundImage: AssetImage('assets/단팥.jpg'),
                radius: 200.0,
              ),
            ),
            Divider(
              height: 60,
              color: Colors.grey[850],
              thickness: 1,
            ),
            Text('가격: 1100원',
            style: TextStyle(
              letterSpacing: 2.0,
              fontSize: 50,
              fontWeight: FontWeight.normal
            ),
            ),
            SizedBox(
              height: 40,
            ),
            TextButton(
              onPressed: (){
                print('구매 버튼 눌림');//여기가 그 아마 구매했을 때 그 카드 연결하는 코드 쓰는 곳
              },
              child: Text(
                '구매하기',
                style: TextStyle(fontSize: 70),
              ),
              style: TextButton.styleFrom(
                primary: Colors.white,
                backgroundColor: Colors.orange,
              ),
            ),
          ],
        ),
      ),
    );
  }
}