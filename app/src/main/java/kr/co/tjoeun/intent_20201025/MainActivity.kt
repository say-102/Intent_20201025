package kr.co.tjoeun.intent_20201025

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant

class MainActivity : AppCompatActivity() {
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
            startActivityForResult(myIntent, 1000)

        }

    }
}