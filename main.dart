import 'package:flutter/material.dart';

void main() => runApp(new MyApp());    // 앱 실행

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: '상세페이지',
      home: NoticeHeader(),
    );
  } 
}

class NoticeHeader extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        toolbarHeight: 100,
        title: Text(
          '게시판',
          style: TextStyle(
            fontSize: 50,
            fontWeight: FontWeight.bold,
          ),
        ),
        centerTitle: true,
        backgroundColor: Color(0xff4EAAFF),
        elevation: 0.0,
        leading: Image.asset('image/ohsunggo.png',),
        leadingWidth: 200,
      ),
    );
  }
}