package kr.co.tjoeun.intent_20201025

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant

class MainActivity : AppCompatActivity() {

//    클래스 정의부분 바로 빝에 적는(만드는) 변수 : 멤버변수
//    fun 안에서 적는(만드는) 변수 : 지역변수 - Local변수

//
    val REQ_FOR_DATA = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToOtherActivityBtn.setOnClickListener {

//            다른 화면 (마이퍼스트엑티비티) 으로 이동

            val myIntent = Intent(this, MyFirstActivity::class.java)
            startActivity(myIntent)

        }

        sendDataBtn.setOnClickListener {

//            다른 화면 (마이세컨드엑티비티) 으로 이동
//            가는길에 데이터 (입력한 내용)를 들고 이동.

            val inputcontent = contentEdt.text.toString()

            val myIntent = Intent(this, MySecondActivity::class.java)
            myIntent.putExtra("content", inputcontent)
            startActivity(myIntent)

        }

        changeTextBtn.setOnClickListener {
            val myIntent = Intent(this, EditDataActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_DATA)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_DATA) {

            if (resultCode == Activity.RESULT_OK) {

                val newInputData = data?.getStringExtra("newData")
                dataTxt.text = newInputData

            }

        }
    }

}