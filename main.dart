import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
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
        title: Text('단팥빵'),
        centerTitle: true,
        backgroundColor: Colors.orange,
        elevation: 0.0,
      ),
      body: Padding(
        padding: EdgeInsets.fromLTRB(30, 40, 0, 0),
        child: Column(
          
          children: <Widget> [
            Center(
              child: CircleAvatar(
                backgroundImage: AssetImage('assets/단팥.jpg'),
                radius: 200.0,
              ),
            ),
            Divider(
              height: 60,
              color: Colors.grey[850],
              thickness: 0.5,
              endIndent: 30,
            ),
            SizedBox(
              height: 10,
            ),
            Text('단팥빵',
            style: TextStyle(
              letterSpacing: 2.0,
              fontSize: 50,
              fontWeight: FontWeight.bold
            ),
            )
          ],
        ),
      ),
    );
  }
}